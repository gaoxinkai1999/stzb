package com.Service.Fight.tactic.指挥战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.伤害计算变化类.受到的攻击伤害减少;
import com.Service.Fight.state.伤害计算变化类.受到的策略伤害减少;
import com.Service.Fight.state.数值冲突类.特殊恢复类.持续型急救;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tactic.tool.指挥战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 金匮要略 extends 指挥战法 {
    {
        this.name="金匮要略";
    }

    @Override
    public void 战法逻辑() {
        double 减伤数值= 0.204+(携带者.谋略-80)*0.0013;
        ArrayList<Hero> 我方目标 = 选择目标.我方目标(携带者, 5, 3);
        for (Hero hero : 我方目标) {
            受到的攻击伤害减少 bean = beanFactory.getBean(受到的攻击伤害减少.class);
            bean.init(this,hero,3,减伤数值);
        }
        for (Hero hero : 我方目标) {
            受到的策略伤害减少 bean = beanFactory.getBean(受到的策略伤害减少.class);
            bean.init(this,hero,3,减伤数值);
        }
        for (Hero hero : 我方目标) {
            持续型急救 bean = beanFactory.getBean(持续型急救.class);
            bean.init(this,hero,0.8,0.0075);
            bean.生效时间点=TimePoint.受到伤害时;
            bean.持续时间=3;
            bean.生效几率=50;
        }

    }
}
