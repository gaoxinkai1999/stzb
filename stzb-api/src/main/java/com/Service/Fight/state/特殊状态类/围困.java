package com.Service.Fight.state.特殊状态类;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.状态冲突.冲突类型;
import com.Service.Fight.tactic.Tactic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 围困 extends State {
    {
        this.type= StateType.围困;
        this.冲突= 冲突类型.任意类型不叠加;
        this.结算时间点=TimePoint.自身回合前;
        有害效果=true;
    }

}
