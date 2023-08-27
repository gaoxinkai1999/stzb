package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.数值冲突类.基础属性变化类.攻击降低;
import com.Service.Fight.state.数值冲突类.基础属性变化类.谋略降低;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 伐谋 extends 主动战法 {
    {
        this.name="伐谋";
        发动几率=40;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 3, 1);
        发动一次攻击.一次谋略攻击(敌方目标,this,携带者,1.04+(1.04/9)*(战法等级-1),0.02175);

        double 属性降低值= (22.5+(22.5/9)*(战法等级-1))+(携带者.谋略-80)*0.25;

        for (Hero hero : 敌方目标) {
            攻击降低 bean = beanFactory.getBean(攻击降低.class);
            bean.init(this,hero,属性降低值,2);
            谋略降低 bean1 = beanFactory.getBean(谋略降低.class);
            bean1.init(this,hero,属性降低值,2);
        }

    }
}
