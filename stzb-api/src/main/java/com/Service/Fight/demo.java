package com.Service.Fight;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.tools.战斗结算;
import com.Service.Fight.tools.战法初始化模板;
import com.Service.Fight.tools.数据统计;
import com.Service.Fight.tools.武将初始化模板;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class demo {
    @Autowired
    BeanFactory beanFactory;

    public Fighting 一次战斗() {
        Fighting fighting = beanFactory.getBean(Fighting.class);


        Hero bean1 = beanFactory.getBean(Hero.class);
        bean1.init("皇甫嵩", 171, 275, 157, 150, 10000,
                "攻击方", 3, "魏", fighting, new String[]{"京观垒冢", "狼烟"}, 1, "大营", "步兵");
        Hero bean2 = beanFactory.getBean(Hero.class);
        bean2.init("陆抗", 159, 225, 190, 92, 10000,
                "攻击方", 3, "魏", fighting, new String[]{"西陵克晋"}, 2, "中军", "步兵");
        Hero bean3 = beanFactory.getBean(Hero.class);
        bean3.init("曹操", 137, 231, 239, 144, 10000,
                "攻击方", 2, "魏", fighting, new String[]{"神兵天降", "大赏三军"}, 3, "前锋", "骑兵");
        Hero bean4 = beanFactory.getBean(Hero.class);
        bean4.init("马岱", 243, 114, 165, 151, 10000,
                "防守方", 3, "魏", fighting, new String[]{}, 6, "大营", "骑兵");
        Hero bean5 = beanFactory.getBean(Hero.class);
        bean5.init("关羽", 256, 131, 161, 176, 10000,
                "防守方", 2, "魏", fighting, new String[]{"三军之众"}, 5, "中军", "骑兵");
        Hero bean6 = beanFactory.getBean(Hero.class);
        bean6.init("张绣", 255, 103, 162, 168, 10000,
                "防守方", 1, "魏", fighting, new String[]{}, 4, "前锋", "骑兵");
        fighting.heroes.add(bean1);
        fighting.heroes.add(bean2);
        fighting.heroes.add(bean3);
        fighting.heroes.add(bean4);
        fighting.heroes.add(bean5);
        fighting.heroes.add(bean6);

        fighting.start();
        System.out.println(fighting.战斗信息);
        return fighting;
    }

    public 战斗结算 一次战斗demo(ArrayList<武将初始化模板>heroes) {



        数据统计 bean = beanFactory.getBean(数据统计.class);
        bean.init(heroes);
        bean.result.战斗次数=100;
        for (int i = 0; i < 100; i++) {

            Fighting fighting = beanFactory.getBean(Fighting.class);
            fighting.统计=bean;
            for (武将初始化模板 武将初始化模板 : heroes) {
                fighting.heroes.add(武将初始化模板.init(fighting,beanFactory));
            }
            fighting.start();
//        System.out.println(fighting.战斗信息);

        }
        bean.结算();

        return bean.result;



    }

}
