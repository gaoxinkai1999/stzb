package com.Service.Fight.state.特殊状态类;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.制造伤害类.制造伤害父类;
import com.Service.Fight.state.状态冲突.冲突类型;
import com.Service.Fight.tactic.Tactic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 规避 extends State {
    public int 次数;

    {
        this.type = StateType.规避;
        冲突 = 冲突类型.任意类型不叠加;
    }

    @Override
    public void start(TimePoint timePoint) {

    }


    public void init(Tactic 所在战法, Hero 作用者, int 次数) {
        super.init(所在战法, 作用者);
        this.次数 = 次数;
    }

    public void start(制造伤害父类 伤害) {


        伤害.是否被规避 = true;
        战报工具.demo(作用者.fighting, 作用者, "进入规避状态");
        战报工具.demo(作用者.fighting, 作用者, "由于处于规避状态,伤害无效");


        this.次数 -= 1;
        if (次数 == 0) {
            isDie = true;
            战报工具.demo(作用者.fighting, 作用者, "来自", this.所在战法.name, "的", type.name(), "效果消失了");
        }
    }
}
