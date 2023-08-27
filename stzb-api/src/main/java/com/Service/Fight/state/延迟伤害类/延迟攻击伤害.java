package com.Service.Fight.state.延迟伤害类;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.制造伤害类.造成单次攻击伤害;
import com.Service.Fight.tactic.Tactic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 延迟攻击伤害 extends 延迟伤害{
    public 造成单次攻击伤害 攻击;
    {
        this.type= StateType.攻击伤害;
    }

    @Override
    public void 执行状态逻辑() {
        攻击.执行伤害();
        失效();
    }

    public void init(Tactic 所在战法, Hero 作用者, double 伤害率) {
        super.init(所在战法, 作用者);
        攻击=beanFactory.getBean(造成单次攻击伤害.class);
        攻击.init(所在战法, 所在战法.携带者,作用者,伤害率);
        攻击.计算伤害();
    }
}
