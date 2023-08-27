package com.Service.Fight.state.延迟伤害类;

import com.Service.Fight.TimePoint;
import com.Service.Fight.state.State;
import com.Service.Fight.state.状态冲突.冲突类型;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 延迟伤害 extends State {
    {
        有害效果=true;
        this.冲突 = 冲突类型.任意类型不冲突;
        this.生效时间点= TimePoint.自身回合前;
    }

}
