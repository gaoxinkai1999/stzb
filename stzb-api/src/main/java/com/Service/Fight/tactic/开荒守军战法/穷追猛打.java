package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.预备效果.连击预备;
import com.Service.Fight.tactic.tool.指挥战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 穷追猛打 extends 指挥战法 {
    {
        this.name="穷追猛打";
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 我方目标 = 选择目标.我方目标(携带者, 3, 2);
        for (Hero hero : 我方目标) {
            连击预备 bean = beanFactory.getBean(连击预备.class);
            bean.init(this,hero, (int) (35+(25.0/9)*(战法等级-1)),4,4);
        }

    }
}
