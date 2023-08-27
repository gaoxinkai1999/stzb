package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.数值冲突类.特殊伤害类.特殊攻击伤害类.动摇;
import com.Service.Fight.tactic.tool.追击战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
@Scope("prototype")
public class 万夫之勇 extends 追击战法 {
    {
        this.name="万夫之勇";
        this.发动几率=25;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 5, 5);

        ArrayList<Hero>可选择目标=new ArrayList<>();
        for (Hero hero : 敌方目标) {
            if (hero.位置.equals("大营")||hero.位置.equals("中军")){
                可选择目标.add(hero);
            }
        }
        Random random = new Random();
        int i = random.nextInt(可选择目标.size());
        ArrayList<Hero> 目标 = new ArrayList<>();
        目标.add(可选择目标.get(i));
        发动一次攻击.一次物理攻击(目标,this,携带者,0.8+(0.8/9)*(战法等级-1));
        发动一次攻击.一次动摇(目标,this,0.4+(0.4/9)*(战法等级-1),2);



    }
}
