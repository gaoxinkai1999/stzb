package com.Service.Fight.state.数值冲突类.特殊伤害类.特殊谋略伤害类;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.制造伤害类.造成单次谋略伤害;
import com.Service.Fight.state.数值冲突类.数值冲突;
import com.Service.Fight.tactic.Tactic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 恐慌 extends 特殊谋略伤害 {
    {
        this.type= StateType.恐慌;
    }

}
