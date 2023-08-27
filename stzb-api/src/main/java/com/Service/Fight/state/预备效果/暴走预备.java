package com.Service.Fight.state.预备效果;

import com.Service.Fight.state.StateType;
import com.Service.Fight.state.控制状态类.暴走;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 暴走预备 extends 预备效果{
    {
        this.type= StateType.暴走预备;
        this.stateClass= 暴走.class;
        有害效果=true;
    }
}
