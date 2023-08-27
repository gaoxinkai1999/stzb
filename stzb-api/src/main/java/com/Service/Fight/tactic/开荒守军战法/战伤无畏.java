package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.伤害计算变化类.受到的攻击伤害减少;
import com.Service.Fight.state.伤害计算变化类.受到的策略伤害减少;
import com.Service.Fight.state.特殊状态类.反击;
import com.Service.Fight.tactic.tool.被动战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 战伤无畏 extends 被动战法 {
    {
        this.name="战伤无畏";
    }

    @Override
    public void 战法逻辑() {
        反击 bean = beanFactory.getBean(反击.class);
        bean.init(this,携带者,0.35+(0.35/9)*(战法等级-1));
        bean.持续时间=100;
        战伤无畏效果 bean1 = beanFactory.getBean(战伤无畏效果.class);
        bean1.init(this,携带者);
    }
}
@Component
@Scope("prototype")
class 战伤无畏效果 extends State{
    {
        this.type= StateType.战伤无畏;
        this.生效几率=30;
        this.持续时间=100;
        this.生效时间点= TimePoint.即将受到伤害时;
    }

    @Override
    public void 执行状态逻辑() {
        受到的策略伤害减少 bean = beanFactory.getBean(受到的策略伤害减少.class);
        bean.init(所在战法,作用者,0,0.25+(0.25/9)*(所在战法.战法等级-1));
        bean.结算时间点=TimePoint.受到伤害时;
        受到的攻击伤害减少 bean1 = beanFactory.getBean(受到的攻击伤害减少.class);
        bean1.init(所在战法,作用者,0,0.25+(0.25/9)*(所在战法.战法等级-1));
        bean1.结算时间点=TimePoint.受到伤害时;
    }
}
