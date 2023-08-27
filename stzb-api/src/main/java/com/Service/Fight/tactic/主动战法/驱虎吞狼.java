package com.Service.Fight.tactic.主动战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.制造伤害类.造成单次谋略伤害;
import com.Service.Fight.state.特殊状态类.围困;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Scope("prototype")
@Component
public class 驱虎吞狼 extends 主动战法 {
    {
        this.准备战法=false;
        this.name = "驱虎吞狼";
        this.发动几率 = 30;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 5, 3);

        for (Hero hero : 敌方目标) {
            围困 bean = beanFactory.getBean(围困.class);
            bean.init(this,hero);
            bean.持续时间=2;
        }
        发动一次攻击.一次谋略攻击(敌方目标,this,携带者,1.53,0.0185);
    }
}
