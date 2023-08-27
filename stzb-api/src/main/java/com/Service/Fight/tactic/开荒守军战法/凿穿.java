package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 凿穿 extends 主动战法 {
    {
        this.name="凿穿";
        发动几率=25;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 2, 1);
        发动一次攻击.一次物理攻击(敌方目标,this,携带者,0.675+(0.675/9)*(战法等级-1));
    }
}
