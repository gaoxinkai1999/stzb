package com.Service.Fight.state.伤害计算变化类;

import com.Service.Fight.state.StateType;
import com.Service.Fight.state.制造伤害类.制造伤害父类;
import com.Service.Fight.tactic.tool.主动战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 受到的主动战法伤害增加 extends 伤害计算变化父类{
    {
        this.type= StateType.受到的主动战法伤害增加;
        有害效果=true;
    }
    @Override
    public void 改变伤害(制造伤害父类 伤害) {
        if (this.作用者 == 伤害.作用者 && 伤害.所在战法 instanceof 主动战法) {
            伤害.增减伤 += this.数值;
        }
    }

}
