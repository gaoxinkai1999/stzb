package com.Service.Fight.state.特殊状态类;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.制造伤害类.造成单次攻击伤害;
import com.Service.Fight.state.状态冲突.冲突类型;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 分兵 extends State {
    double 伤害率;
    {
        this.type= StateType.分兵;
        this.冲突= 冲突类型.任意类型不叠加;
        this.结算时间点=TimePoint.回合结束;
    }




    public void init(Tactic 所在战法, Hero 作用者,double 伤害率,int 持续时间) {
        super.init(所在战法, 作用者);
        this.伤害率=伤害率;
        this.持续时间=持续时间;

    }
    @Override
    public void 执行状态逻辑() {
            作用者.普攻.分兵伤害率=伤害率;
    }
}
