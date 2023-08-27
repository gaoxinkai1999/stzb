package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.数值冲突类.特殊伤害类.特殊谋略伤害类.特殊谋略伤害;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 火烧连营 extends 主动战法 {
    {
        this.name="火烧连营";
        发动几率=35;
        准备战法=true;
        准备回合=1;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 5, 3);
        发动一次攻击.一次谋略攻击(敌方目标,this,携带者,0.46+(0.46/9)*(战法等级-1),0.00575);
        if (this.判断效果是否发动((int) (35+(15.0/9)*(战法等级-1)))){
            发动一次攻击.一次谋略攻击(敌方目标,this,携带者,0.665+(0.665/9)*(战法等级-1),0.006);
            ArrayList<特殊谋略伤害> 燃烧 = 发动一次攻击.一次特殊谋略攻击("燃烧", 敌方目标, this, 0.38 + (0.38 / 9) * (战法等级 - 1), 0.00475, 2);
            for (特殊谋略伤害 特殊谋略伤害 : 燃烧) {
                特殊谋略伤害.生效几率=(int) (35+(15.0/9)*(战法等级-1));
            }
        }
    }
}
