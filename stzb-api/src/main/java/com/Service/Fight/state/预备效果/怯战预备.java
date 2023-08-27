package com.Service.Fight.state.预备效果;

import com.Service.Fight.TimePoint;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.控制状态类.怯战;
import com.Service.Fight.tactic.Tactic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 怯战预备 extends 预备效果 {
    {
        this.type = StateType.怯战预备;
        this.stateClass= 怯战.class;
        有害效果=true;
    }


}
