package com.Service.Fight.tactic.指挥战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.伤害计算变化类.受到的攻击伤害减少;
import com.Service.Fight.state.伤害计算变化类.受到的策略伤害减少;
import com.Service.Fight.state.特殊状态类.规避;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tactic.tool.指挥战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 磐阵善守 extends 指挥战法 {
    {
        this.name = "磐阵善守";
    }

    @Override
    public void 战法逻辑() {
        磐阵善守效果 bean = beanFactory.getBean(磐阵善守效果.class);
        bean.init(this, 携带者);
    }
}

@Component
@Scope("prototype")
class 磐阵善守效果 extends State {
    {
        this.type = StateType.磐阵善守;
        this.生效时间点 = TimePoint.回合开始;
        结算时间点=TimePoint.回合结束;
        持续时间 = 4;
    }

    @Override
    public void 执行状态逻辑() {

        Hero 我军兵力最低 = 选择目标.我军兵力最低(作用者);
        受到的策略伤害减少 bean = beanFactory.getBean(受到的策略伤害减少.class);
        bean.init(所在战法, 我军兵力最低, 0, 2);
        bean.结算时间点 = TimePoint.受到伤害时;
        受到的攻击伤害减少 bean1 = beanFactory.getBean(受到的攻击伤害减少.class);
        bean1.init(所在战法, 我军兵力最低, 0, 2);
        bean1.结算时间点 = TimePoint.受到伤害时;
        if (所在战法.判断效果是否发动(50+(50.0/9)* (所在战法.战法等级-1))){
            ArrayList<Hero> 我方目标 = 选择目标.我方目标(作用者, 2, 1);
            for (Hero hero : 我方目标) {
                规避 bean2 = beanFactory.getBean(规避.class);
                bean2.init(所在战法, hero, 1);
            }
        }

    }

}

