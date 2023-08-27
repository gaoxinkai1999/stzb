package com.Service.Fight.state.数值冲突类.基础属性变化类;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.StateType;
import com.Service.Fight.tactic.Tactic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 攻击提高 extends 基础属性变化{
    {
        this.type= StateType.攻击值提高;
    }

    @Override
    public void 执行() {
        作用者.攻击+=数值;
    }

    @Override
    public void 恢复() {
        作用者.攻击-=数值;
    }
}
