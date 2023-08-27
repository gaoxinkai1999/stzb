package com.Service.Fight.tactic.追击战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.tactic.tool.追击战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
@Scope("prototype")
public class 宣威再战 extends 追击战法 {
    {
        this.name="宣威再战";
        发动几率=100;
    }

    @Override
    public void 战法逻辑() {
        if (携带者.fighting.回合<=3){
            ArrayList<Hero> heroes = new ArrayList<>();
            heroes.add(携带者.普攻.普攻目标);
            发动一次攻击.一次物理攻击(heroes,this,携带者,1.5);
        }else {
            Random random = new Random();
            int i = random.nextInt(3)+1;
            for (int j = 0; j < i; j++) {
                ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 5, 1);
                发动一次攻击.一次物理攻击(敌方目标,this,携带者,1.5);
            }
        }

    }
}
