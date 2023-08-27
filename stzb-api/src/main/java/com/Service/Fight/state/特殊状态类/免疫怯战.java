package com.Service.Fight.state.特殊状态类;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.tactic.Tactic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 免疫怯战 extends State {

    {
        this.type= StateType.免疫怯战;
    }


    public void init(Tactic 所在战法, Hero 作用者, int 持续时间) {
        super.init(所在战法, 作用者);
        this.持续时间=持续时间;
    }
}
