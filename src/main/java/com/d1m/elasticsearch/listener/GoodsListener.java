package com.d1m.elasticsearch.listener;


import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class GoodsListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "estore.create.index.queue",durable = "true"),
            exchange = @Exchange(
                    value = "estore.product.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC),
            key = {"product.create"}))
    public void listenCreate(byte[] body) {
        System.out.println("body = " + new String(body));
    }
}
