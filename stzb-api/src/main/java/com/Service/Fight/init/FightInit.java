package com.Service.Fight.init;

import com.Service.Fight.Fighting;
import com.Service.Fight.hero.Hero;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class FightInit {
    @Autowired
    BeanFactory beanFactory;
    public void init(String fight){
        Fighting fighting = beanFactory.getBean(Fighting.class);

        JSONObject jsonObject = JSONObject.parseObject(fight);

        JSONObject 攻方 = jsonObject.getJSONObject("攻方");

        Hero 大营 = 攻方.getObject("大营", Hero.class);
        大营.init("攻击方",fighting,1);

        Hero 中军 = 攻方.getObject("中军", Hero.class);
        中军.init("攻击方",fighting,2);

        Hero 前锋 = 攻方.getObject("前锋", Hero.class);
        前锋.init("攻击方",fighting,3);

        JSONObject 守方 = jsonObject.getJSONObject("守方");

        Hero 大营1 = 守方.getObject("大营", Hero.class);
        大营1.init("防守方",fighting,6);

        Hero 中军1 = 守方.getObject("中军", Hero.class);
        中军1.init("防守方",fighting,5);

        Hero 前锋1 = 守方.getObject("前锋", Hero.class);
        前锋1.init("防守方",fighting,4);
        System.out.println(fighting.heroes);


    }
}

