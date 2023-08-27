package com.Service.Fight.state.控制状态类;

import com.Service.Fight.TimePoint;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 犹豫 extends 控制 {
    {
        this.type= StateType.犹豫;
    }
}
