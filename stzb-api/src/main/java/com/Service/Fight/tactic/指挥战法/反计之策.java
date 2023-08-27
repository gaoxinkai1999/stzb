package com.Service.Fight.tactic.指挥战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.伤害计算变化类.造成的主动战法伤害减少;
import com.Service.Fight.state.预备效果.怯战预备;
import com.Service.Fight.state.预备效果.犹豫预备;
import com.Service.Fight.tactic.tool.指挥战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 反计之策 extends 指挥战法 {
    {
        this.name="反计之策";
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(this.携带者, 4, 2);
        for (Hero hero : 敌方目标) {
            犹豫预备 bean = beanFactory.getBean(犹豫预备.class);
            bean.init(this,hero,100,1,1);
            造成的主动战法伤害减少 bean1 = beanFactory.getBean(造成的主动战法伤害减少.class);
            bean1.init(this,hero,3,3);
        }

    }
}
