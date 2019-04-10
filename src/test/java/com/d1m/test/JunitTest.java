package com.d1m.test;

import org.junit.Test;

public class JunitTest {



    @Test
    public void test001(){
        String[] locations = {"classpath*:com/d1m/elasticsearch/repository/*.xml"};
        for (String location : locations) {
            System.out.println("location = " + location);
        }
    }
}
