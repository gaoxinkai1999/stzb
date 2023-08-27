package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.控制状态类.犹豫;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 反计 extends 主动战法 {
    {
        this.name="反计";
        发动几率=30;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 3, 1);
        for (Hero hero : 敌方目标) {
            犹豫 bean = beanFactory.getBean(犹豫.class);
            bean.init(this,hero,2);
        }
    }
}
