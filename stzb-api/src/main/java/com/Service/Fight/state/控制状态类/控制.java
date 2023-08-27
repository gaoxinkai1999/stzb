package com.Service.Fight.state.控制状态类;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.状态冲突.冲突类型;
import com.Service.Fight.tactic.Tactic;

public class 控制 extends State {

    {
        this.冲突= 冲突类型.任意类型不叠加;
        有害效果=true;
        this.结算时间点=TimePoint.自身回合前;
    }

    public  void init(Tactic 所在战法, Hero 作用者, int 持续时间){
        super.init(所在战法,作用者);
        this.持续时间=持续时间;


    }


}
