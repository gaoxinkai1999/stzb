package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.数值冲突类.基础属性变化类.谋略降低;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 威震北疆 extends 主动战法 {
    {
        this.name="威震北疆";
        this.发动几率=35;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 4, 2);
        发动一次攻击.一次特殊谋略攻击("恐慌",敌方目标,this,0.4622,0.004,2);
        for (Hero hero : 敌方目标) {
            谋略降低 bean = beanFactory.getBean(谋略降低.class);
            bean.init(this,hero,14.44,2);
        }



    }
}
