package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.控制状态类.怯战;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 明妃 extends 主动战法 {
    {
        this.name="明妃";
        发动几率=35;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 5, 2);

        敌方目标.add(携带者);
        for (Hero hero : 敌方目标) {
            怯战 bean = beanFactory.getBean(怯战.class);
            bean.init(this,hero,2);
        }
    }
}
