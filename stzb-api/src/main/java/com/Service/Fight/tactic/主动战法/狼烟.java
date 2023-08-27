package com.Service.Fight.tactic.主动战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 狼烟 extends 主动战法 {
    {
        this.name="狼烟";
        发动几率=45;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 4, 2);
        发动一次攻击.一次特殊谋略攻击("恐慌",敌方目标,this,0.238+(0.238/9)*(战法等级-1),0.005,2);
    }
}
