package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 声东击西 extends 主动战法 {
    {
        this.name="声东击西";
        发动几率=50;
        准备战法=true;
        准备回合=1;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero>目标;
        if (this.判断效果是否发动(50)){
            目标=选择目标.敌方目标(携带者,5,1);
        }else {
            目标=选择目标.敌方目标(携带者,5,2);
        }
        发动一次攻击.一次谋略攻击(目标,this,携带者,1.155+(1.155/9)*(战法等级-1),0.0245);

    }
}
