package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 毒泉 extends 主动战法 {
    {
        this.name="毒泉";
        this.准备战法=true;
        this.发动几率=50;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者,5,  2);
        发动一次攻击.一次特殊谋略攻击("恐慌",敌方目标,this,
                0.425+(0.425/9)*(this.战法等级-1),0.00875,2);
    }
}
