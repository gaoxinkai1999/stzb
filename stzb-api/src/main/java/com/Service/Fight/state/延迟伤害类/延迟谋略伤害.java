package com.Service.Fight.state.延迟伤害类;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.制造伤害类.造成单次谋略伤害;
import com.Service.Fight.tactic.Tactic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 延迟谋略伤害 extends 延迟伤害 {
    public 造成单次谋略伤害 策略伤害;

    {
        this.type = StateType.策略攻击伤害;
    }
    @Override
    public void 执行状态逻辑() {
        策略伤害.执行伤害();
        失效();
    }
    public void init(Tactic 所在战法, Hero 作用者, double 基础伤害率, double 伤害率增长率) {
        策略伤害=beanFactory.getBean(造成单次谋略伤害.class);
        策略伤害.init(所在战法, 所在战法.携带者,作用者,基础伤害率,伤害率增长率);
        策略伤害.计算伤害();
        super.init(所在战法, 作用者);
    }
}
