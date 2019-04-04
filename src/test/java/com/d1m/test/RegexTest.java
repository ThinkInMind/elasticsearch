package com.d1m.test;


import com.d1m.elasticsearch.ElasticsearchApplication;
import com.d1m.elasticsearch.common.multitenancy.TenantContext;
import com.d1m.elasticsearch.domain.entity.EstoreProduct;
import com.d1m.elasticsearch.domain.index.ProductSpec;
import com.d1m.elasticsearch.repository.EstoreProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ElasticsearchApplication.class)
public class RegexTest {

//
//    @Autowired
//    private GoodsRepository goodsRepository;

    @Autowired
    private EstoreProductRepository estoreProductRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @Test
    public void regexTest() {
        String str = "迪丽热巴,郑爽";
        String[] array = str.split(",");
        Pattern pattern = Pattern.compile(array[0]);
        String senstence = "Dear 迪丽热巴是我的Angel";
        if (pattern.matcher(senstence).find()) {
            System.out.println("array = " + array[0]);
        }else {
            System.out.println("senstence = " + senstence);
        }
    }

    @Test
    public void CreateIndex(){
        elasticsearchTemplate.putMapping(ProductSpec.class);
//        System.out.println(new Date(1572278400*1000));
    }
    @Test
    public void goodsInsert(){
        TenantContext.setCurrentTenant(41);
//        List<EstoreProduct> all = estoreProductRepository.findAll();
        EstoreProduct byNameAndCode = estoreProductRepository.findo("鱼子精华琼贵眼霜", "SPU01");
        System.out.println("byNameAndCode = " + byNameAndCode);
    }

    @Test
    public void query(){
//        goodsRepository.findAll();
    }

    public static void main(String[] args) {
        System.out.println(new Date(1572278400*1000L));
    }

}
