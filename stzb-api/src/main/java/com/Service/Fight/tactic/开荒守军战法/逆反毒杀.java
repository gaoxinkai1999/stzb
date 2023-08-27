package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.控制状态类.怯战;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 逆反毒杀 extends 主动战法 {
    {
        this.name="逆反毒杀";
        发动几率=35;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero>目标;
        if (this.判断效果是否发动(50)){
            目标=选择目标.敌方目标(携带者,4,1);
        }else {
            目标=选择目标.敌方目标(携带者,4,2);
        }
        发动一次攻击.一次特殊谋略攻击("恐慌",目标,this,0.415+(0.415/9)*(战法等级-1),0.005,2);
        for (Hero hero : 目标) {
            怯战 bean = beanFactory.getBean(怯战.class);
            bean.init(this,hero,2);
        }
    }
}
