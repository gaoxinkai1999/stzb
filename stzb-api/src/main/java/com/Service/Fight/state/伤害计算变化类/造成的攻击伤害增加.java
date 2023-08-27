package com.Service.Fight.state.伤害计算变化类;

import com.Service.Fight.TimePoint;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.制造伤害类.制造伤害父类;
import com.Service.Fight.state.制造伤害类.造成单次攻击伤害;
import com.Service.Fight.tactic.Tactic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 造成的攻击伤害增加 extends 伤害计算变化父类 {

    {
        this.type= StateType.造成的攻击伤害增加;
    }

    @Override
    public void 改变伤害(制造伤害父类 伤害) {
        if (this.作用者==伤害.所在战法.携带者&&伤害 instanceof 造成单次攻击伤害){
            伤害.增减伤+=this.数值;
        }
    }
}
