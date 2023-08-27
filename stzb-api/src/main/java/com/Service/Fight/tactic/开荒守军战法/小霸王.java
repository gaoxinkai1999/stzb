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
public class 小霸王 extends 主动战法 {
    {
        this.name="小霸王";
        发动几率=25;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 3, 2);
        发动一次攻击.一次物理攻击(敌方目标,this,携带者,0.675+(0.675/9)*(战法等级-1));
        if (this.判断效果是否发动(40)){
            发动一次攻击.一次物理攻击(敌方目标,this,携带者,1+(1.0/9)*(战法等级-1));
        }
    }
}
