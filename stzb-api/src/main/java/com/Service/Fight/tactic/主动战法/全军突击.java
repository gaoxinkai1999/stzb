package com.Service.Fight.tactic.主动战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.伤害计算变化类.造成的攻击伤害增加;
import com.Service.Fight.state.制造伤害类.造成单次攻击伤害;
import com.Service.Fight.state.特殊状态类.镇静;
import com.Service.Fight.tactic.tool.TacticType;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.一次攻击;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 全军突击 extends 主动战法 {
    {
        this.name="全军突击";
        准备战法=false;
        this.发动几率=35;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 我方目标 = 选择目标.我方目标(携带者, 5, 3);
        for (Hero hero : 我方目标) {
            镇静 bean = beanFactory.getBean(镇静.class);
            bean.start(hero, new TacticType[]{TacticType.主动战法, TacticType.追击战法});
        }
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 4, 1);
        发动一次攻击.一次物理攻击(敌方目标,this,携带者,1.45);
        for (Hero hero : 我方目标) {
            造成的攻击伤害增加 bean = beanFactory.getBean(造成的攻击伤害增加.class);
            bean.init(this,hero,1,0.28+(携带者.谋略-80)*0.001);
            bean.结算时间点= TimePoint.造成一次攻击后;
        }


    }
}
