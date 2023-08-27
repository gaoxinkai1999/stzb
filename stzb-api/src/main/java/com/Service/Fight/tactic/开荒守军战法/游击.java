package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 游击 extends 主动战法 {
    {
        this.name="游击";
        发动几率=30;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 4, 1);
        发动一次攻击.一次动摇(敌方目标,this,0.625+(0.625/9)*(战法等级-1),2);
    }
}
