package com.d1m.elasticsearch.listener;


import com.d1m.elasticsearch.service.ElasticsearchService;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GoodsListener {

    @Autowired
    private ElasticsearchService elasticsearchService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "estore.create.index.queue",durable = "true"),
            exchange = @Exchange(
                    value = "estore.product.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC),
            key = {"product.create"}))
    public void listenCreate(String str) {
        System.out.println("body = " + str);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "estore.update.index.queue",durable = "true"),
            exchange = @Exchange(
                    value = "estore.product.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC),
            key = {"product.update"}))
    public void listenUpdate(Long id) throws IOException {
        if (id == null){
            return;
        }
        System.out.println("id = " + id);
        this.elasticsearchService.update(id);
    }


}
