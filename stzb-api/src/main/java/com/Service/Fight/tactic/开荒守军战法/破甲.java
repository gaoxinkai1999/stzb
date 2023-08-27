package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.数值冲突类.基础属性变化类.防御降低;
import com.Service.Fight.tactic.tool.追击战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 破甲 extends 追击战法 {
    {
        this.name="破甲";
        发动几率=30;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(携带者.普攻.普攻目标);
        发动一次攻击.一次物理攻击(heroes,this,携带者,0.825+(0.825/9)*(战法等级-1));
        for (Hero hero : heroes) {
            防御降低 bean = beanFactory.getBean(防御降低.class);
            bean.init(this,hero,12.5+(12.5/9)*(战法等级-1),2);
        }
    }
}
