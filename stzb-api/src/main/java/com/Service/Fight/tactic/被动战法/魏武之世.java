package com.Service.Fight.tactic.被动战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.数值冲突类.基础属性变化类.*;
import com.Service.Fight.tactic.tool.被动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 魏武之世 extends 被动战法 {
    {
        this.name="魏武之世";
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(this.携带者, 5, 3);
        double 效果 = 0.15+(携带者.谋略-80)*0.00045;
        for (Hero hero : 敌方目标) {
            攻击降低 bean = beanFactory.getBean(攻击降低.class);
            bean.init(this,hero,效果*hero.基础攻击,10);
            防御降低 bean1 = beanFactory.getBean(防御降低.class);
            bean1.init(this,hero,效果*hero.基础防御,10);
            谋略降低 bean2 = beanFactory.getBean(谋略降低.class);
            bean2.init(this,hero,效果*hero.基础谋略,10);
            速度降低 bean3 = beanFactory.getBean(速度降低.class);
            bean3.init(this,hero,效果*hero.基础速度,10);
        }
        ArrayList<Hero> 我方目标 = 选择目标.我方目标(携带者, 5, 3);
        for (Hero hero : 我方目标) {
            攻击距离提高 bean = beanFactory.getBean(攻击距离提高.class);
            bean.init(this,hero,1,10);
        }
    }
}
