package com.Service.Fight.tactic.被动战法.京观垒冢;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.制造伤害类.制造伤害父类;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tools.一次攻击;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 京观垒冢效果 extends State {
    {
        this.type = StateType.京观垒冢;
        this.生效时间点 = TimePoint.造成伤害后;
        this.生效几率 = 70;
    }

    public 制造伤害父类 伤害;

    @Override
    public void 执行状态逻辑() {
        if (伤害.所在战法 != 所在战法) {
            ArrayList<Hero> heroes = new ArrayList<>();
            heroes.add(伤害.作用者);
            if (所在战法.判断效果是否发动(50)) {
                发动一次攻击.一次物理攻击(heroes, 所在战法, 作用者, 1+(1.0/9)*(所在战法.战法等级-1));

            } else {
                发动一次攻击.一次谋略攻击(heroes, 所在战法, 作用者, 1+(1.0/9)*(所在战法.战法等级-1), 0);
            }

        }
    }
}
