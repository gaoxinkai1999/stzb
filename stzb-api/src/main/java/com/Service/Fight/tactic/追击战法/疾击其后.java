package com.Service.Fight.tactic.追击战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.tactic.tool.追击战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 疾击其后 extends 追击战法 {
    {
        this.name="疾击其后";
        发动几率=35;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 5, 1);
        发动一次攻击.一次物理攻击(敌方目标,this,携带者,0.6+(0.6/9)*(战法等级-1));
        ArrayList<Hero> 敌方目标1 = 选择目标.敌方目标(携带者, 5, 1);
        发动一次攻击.一次物理攻击(敌方目标1,this,携带者,0.6+(0.6/9)*(战法等级-1));
    }
}
