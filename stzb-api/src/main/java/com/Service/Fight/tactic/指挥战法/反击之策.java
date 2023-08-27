package com.Service.Fight.tactic.指挥战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.特殊状态类.反击;
import com.Service.Fight.tactic.tool.指挥战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 反击之策 extends 指挥战法 {
    {
        this.name="反击之策";
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 我方目标 = 选择目标.我方目标(携带者, 3, 2);
        for (Hero hero : 我方目标) {
            反击 bean = beanFactory.getBean(反击.class);
            bean.init(this,hero,1);
            bean.生效几率=75;
            bean.持续时间=3;
        }
    }
}
