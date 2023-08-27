package com.Service.Fight.state.数值冲突类.基础属性变化类;

import com.Service.Fight.state.StateType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 防御降低 extends 基础属性变化{
    {
        this.type= StateType.防御值降低;
        有害效果=true;
    }
    @Override
    public void 执行() {
        if (作用者.防御>=数值){
            作用者.防御-=数值;
        }else {
            实际数值=作用者.防御;
            作用者.防御=0;
        }

    }

    @Override
    public void 恢复() {
        if (实际数值!=0){
            作用者.防御+=实际数值;
        }else {
            作用者.防御+=数值;
        }

    }
}
