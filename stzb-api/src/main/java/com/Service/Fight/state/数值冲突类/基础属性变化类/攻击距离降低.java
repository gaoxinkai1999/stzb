package com.Service.Fight.state.数值冲突类.基础属性变化类;

import com.Service.Fight.state.StateType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Scope("prototype")
public class 攻击距离降低 extends 基础属性变化{
    {
        this.type= StateType.减小攻击距离;
        有害效果=true;
    }
    @Override
    public void 执行() {
        if (作用者.攻击距离>=数值){
            作用者.攻击距离-=数值;
        }else {
            实际数值=作用者.攻击距离;
            作用者.攻击距离=0;
        }

    }

    @Override
    public void 恢复() {
        if (实际数值!=0){
            作用者.攻击距离+=实际数值;
        }else {
            作用者.攻击距离+=数值;
        }

    }
}
