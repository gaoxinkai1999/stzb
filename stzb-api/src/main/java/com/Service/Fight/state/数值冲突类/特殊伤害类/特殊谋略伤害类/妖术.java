package com.Service.Fight.state.数值冲突类.特殊伤害类.特殊谋略伤害类;

import com.Service.Fight.state.StateType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 妖术 extends 特殊谋略伤害{
    {
        this.type= StateType.妖术;
    }
}
