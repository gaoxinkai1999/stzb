package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.特殊状态类.规避;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tactic.tool.指挥战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 空城 extends 指挥战法 {
    {
        this.name="空城";
    }

    @Override
    public void 战法逻辑() {
        空城效果 bean = beanFactory.getBean(空城效果.class);
        bean.init(this,携带者);
    }
}
@Component
@Scope("prototype")
class 空城效果 extends State{
    {
        this.type= StateType.空城;
        this.生效时间点= TimePoint.即将受到伤害时;
        this.持续时间=2;
        this.结算时间点=TimePoint.回合结束;
    }

    @Override
    public void 执行状态逻辑() {
        if (所在战法.判断效果是否发动((int) (40+(30.0/9)*(所在战法.战法等级-1)))){
            规避 bean = beanFactory.getBean(规避.class);
            bean.init(所在战法,作用者,1);
        }

    }
}
