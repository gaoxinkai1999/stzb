package com.Service.Fight.state.特殊状态类;

import com.Service.Fight.TimePoint;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.状态冲突.冲突类型;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 援护 extends State {
    {
        this.type= StateType.援护;
        冲突= 冲突类型.任意类型不叠加;
        this.结算时间点= TimePoint.回合结束;
    }
}
