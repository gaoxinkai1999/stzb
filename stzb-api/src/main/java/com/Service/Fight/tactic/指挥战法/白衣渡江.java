package com.Service.Fight.tactic.指挥战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.制造伤害类.造成单次谋略伤害;
import com.Service.Fight.state.延迟伤害类.延迟谋略伤害;
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
public class 白衣渡江 extends 指挥战法 {
    {
        this.name="白衣渡江";
    }
    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(this.携带者, 5, 2);
        for (Hero hero : 敌方目标) {
            怯战预备 bean = beanFactory.getBean(怯战预备.class);
            bean.init(this,hero,100,2,1);
        }
        ArrayList<Hero> 敌方目标1 = 选择目标.敌方目标(this.携带者, 5, 3);
        ArrayList<延迟谋略伤害> 一次延迟谋略伤害 = 发动一次攻击.一次延迟谋略伤害(敌方目标1, this, 携带者, 2.15, 0.0225);
        for (延迟谋略伤害 延迟谋略伤害 : 一次延迟谋略伤害) {
            延迟谋略伤害.开始生效回合=3;
        }
    }
}