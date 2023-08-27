package com.Service.Fight.tactic.主动战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.伤害计算变化类.受到的攻击伤害增加;
import com.Service.Fight.state.伤害计算变化类.受到的策略伤害增加;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 银龙冲阵 extends 主动战法 {
    {
        this.name="银龙冲阵";
        发动几率=50;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 5, 1);
        发动一次攻击.一次物理攻击(敌方目标,this,携带者,0.75+(0.75/9)*(战法等级-1));
        for (Hero hero : 敌方目标) {
            double 数值=(0.1+(0.1/9)*(战法等级-1))+(携带者.攻击-80)*0.00075;
            受到的攻击伤害增加 bean = beanFactory.getBean(受到的攻击伤害增加.class);
            bean.init(this,hero,2,数值);
            受到的策略伤害增加 bean1 = beanFactory.getBean(受到的策略伤害增加.class);
            bean1.init(this,hero,2,数值);
        }
        ArrayList<Hero> 敌方目标1 = 选择目标.敌方目标(携带者, 5, 1);
        发动一次攻击.一次物理攻击(敌方目标1,this,携带者,0.75+(0.75/9)*(战法等级-1));
    }
}
