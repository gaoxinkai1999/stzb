package com.Service.Fight.state.预备效果;

import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.特殊状态类.围困;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 围困预备 extends 预备效果{
    {
        this.type= StateType.围困预备;
        this.stateClass= 围困.class;
        有害效果=true;
    }
}
