package com.Service.Fight.state.控制状态类;

import com.Service.Fight.state.StateType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 暴走 extends 控制{
    {
        this.type= StateType.暴走;
    }
}
