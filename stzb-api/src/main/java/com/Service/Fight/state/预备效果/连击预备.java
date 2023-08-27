package com.Service.Fight.state.预备效果;

import com.Service.Fight.TimePoint;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.特殊状态类.连击;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 连击预备 extends 预备效果{
    {
        this.type= StateType.连击预备;
        this.stateClass= 连击.class;
        this.生效时间点= TimePoint.回合开始;
        this.结算时间点=TimePoint.回合结束;
    }
}
