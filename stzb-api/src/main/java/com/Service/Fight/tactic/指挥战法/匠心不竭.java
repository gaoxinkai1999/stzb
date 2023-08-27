package com.Service.Fight.tactic.指挥战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.数值冲突类.特殊伤害类.特殊谋略伤害类.特殊谋略伤害;
import com.Service.Fight.tactic.tool.指挥战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 匠心不竭 extends 指挥战法 {
    {
        this.name="匠心不竭";
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 5, 3);
        ArrayList<特殊谋略伤害> 恐慌 = 发动一次攻击.一次特殊谋略攻击("恐慌", 敌方目标, this, 0.17+(0.17/9)*(战法等级-1), 0.001, 100);

        ArrayList<特殊谋略伤害> 燃烧 = 发动一次攻击.一次特殊谋略攻击("燃烧", 敌方目标, this, 0.205+(0.205/9)*(战法等级-1), 0.00125, 100);
        for (特殊谋略伤害 特殊谋略伤害 : 燃烧) {
            特殊谋略伤害.开始生效回合=3;
        }
        ArrayList<特殊谋略伤害> 妖术 = 发动一次攻击.一次特殊谋略攻击("妖术", 敌方目标, this, 0.22+(0.22/9)*(战法等级-1), 0.0015, 100);
        for (特殊谋略伤害 特殊谋略伤害 : 妖术) {
            特殊谋略伤害.开始生效回合=5
            ;
        }
    }
}
