package com.Service.Fight.tactic.指挥战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.伤害计算变化类.造成的攻击伤害增加;
import com.Service.Fight.state.伤害计算变化类.造成的策略伤害增加;
import com.Service.Fight.state.状态冲突.冲突类型;
import com.Service.Fight.tactic.tool.指挥战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 始计 extends 指挥战法 {
    {
        this.name="始计";
    }

    @Override
    public void 战法逻辑() {
        始计状态 bean = beanFactory.getBean(始计状态.class);
        bean.init(this,携带者);
    }
}
@Component
@Scope("prototype")
class 始计状态 extends State{
    {
        this.type= StateType.始计;
        this.冲突=冲突类型.任意类型不冲突;
        this.生效时间点=TimePoint.自身回合前;
    }

    @Override
    public void 执行状态逻辑() {
        战报工具.demo(作用者.fighting,"始计效果执行");
        造成的攻击伤害增加 bean = beanFactory.getBean(造成的攻击伤害增加.class);
        bean.结算时间点= TimePoint.造成一次攻击后;
        bean.init(所在战法,作用者,0,0.2+(所在战法.携带者.谋略-80)*0.0015);
        造成的策略伤害增加 bean1 = beanFactory.getBean(造成的策略伤害增加.class);
        bean1.结算时间点= TimePoint.造成一次攻击后;
        bean1.init(所在战法,作用者,0,0.2+(所在战法.携带者.谋略-80)*0.0015);
    }
}