package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.预备效果.先手预备;
import com.Service.Fight.tactic.tool.指挥战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 节镇关东 extends 指挥战法 {
    {
        this.name="节镇关东";
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 我方目标 = 选择目标.我方目标(携带者, 5, 2);
        for (Hero hero : 我方目标) {
            先手预备 bean = beanFactory.getBean(先手预备.class);
            bean.init(this,hero,100,2,1);
        }
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 5, 2);
        发动一次攻击.一次动摇(敌方目标,this,0.6+(0.6/9)*(战法等级-1),2);
    }
}
