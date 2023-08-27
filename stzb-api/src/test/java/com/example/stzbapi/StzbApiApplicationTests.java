package com.example.stzbapi;

import com.Service.Fight.Fighting;
import com.Service.Fight.demo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@SpringBootTest
class StzbApiApplicationTests {
    @Autowired
    demo demo;

    @Test
    void contextLoads() {
//        demo.一次战斗();
//        demo.一次战斗demo();
//        demo.多次战斗();
    }

}
