package com.Service.Fight.tactic.指挥战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.控制状态类.怯战;
import com.Service.Fight.state.预备效果.怯战预备;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tactic.tool.指挥战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 战必断金 extends 指挥战法 {
    {
        this.name="战必断金";
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(this.携带者, 4, 2);
        for (Hero hero : 敌方目标) {
            怯战预备 bean = beanFactory.getBean(怯战预备.class);
            bean.init(this,hero,45+(45/9)*(战法等级-1),3,1);
        }
    }
}
