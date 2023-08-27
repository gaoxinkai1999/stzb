package com.Service.Fight.tactic.主动战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.延迟伤害类.延迟攻击伤害;
import com.Service.Fight.state.延迟伤害类.延迟谋略伤害;
import com.Service.Fight.state.数值冲突类.基础属性变化类.谋略降低;
import com.Service.Fight.state.数值冲突类.基础属性变化类.防御降低;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 道行险阻 extends 主动战法 {
    {
        this.name="道行险阻";
        this.发动几率=40;
        准备战法=false;
    }

    @Override
    public void 战法逻辑() {
      double 防御降低数值=50+(携带者.攻击-80)*0.3;
      double 谋略降低数值=50+(携带者.谋略-80)*0.3;
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 4, 1);
        for (Hero hero : 敌方目标) {
            防御降低 bean = beanFactory.getBean(防御降低.class);
            bean.init(this,hero,防御降低数值,1);
            谋略降低 bean1 = beanFactory.getBean(谋略降低.class);
            bean1.init(this,hero,谋略降低数值,1);
        }
        发动一次攻击.一次延迟攻击伤害(敌方目标,this,携带者,1.5);
        发动一次攻击.一次延迟谋略伤害(敌方目标,this,携带者,1.5,0.01575);


    }
}
