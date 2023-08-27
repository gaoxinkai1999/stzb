package com.Service.Fight.state.预备效果;

import com.Service.Fight.state.StateType;
import com.Service.Fight.state.特殊状态类.洞察;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 洞察预备 extends 预备效果{
    {
        this.type= StateType.洞察预备;
        this.stateClass= 洞察.class;
    }
}
