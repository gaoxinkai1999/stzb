package com.Service.Fight.tactic.主动战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.制造伤害类.造成单次攻击伤害;
import com.Service.Fight.state.控制状态类.犹豫;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 樊渊泅囚 extends 主动战法 {
    {
        准备战法=true;
        this.发动几率 = 40;
        this.准备回合 = 1;
        this.name = "樊渊泅囚";
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 5, 3);
        发动一次攻击.一次物理攻击(敌方目标,this,携带者,1.9);
        for (Hero hero : 敌方目标) {
            犹豫 bean1 = beanFactory.getBean(犹豫.class);
            bean1.init(this,hero,1);
        }
    }
}
