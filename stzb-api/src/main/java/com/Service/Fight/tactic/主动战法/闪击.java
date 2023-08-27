package com.Service.Fight.tactic.主动战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.伤害计算变化类.造成的攻击伤害减少;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 闪击 extends 主动战法 {
    {
        this.name="闪击";
        发动几率=50;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 4, 2);
        发动一次攻击.一次物理攻击(敌方目标,this,携带者,0.25+(0.25/9)*(战法等级-1));

        ArrayList<Hero> 敌方目标1 = 选择目标.敌方目标(携带者, 4, 1);
        for (Hero hero : 敌方目标1) {
            造成的攻击伤害减少 bean = beanFactory.getBean(造成的攻击伤害减少.class);
            bean.init(this,hero,0,1.5);
            bean.结算时间点= TimePoint.造成一次攻击后;
        }

    }
}
