package com.Service.Fight.state.数值冲突类.基础属性变化类;

import com.Service.Fight.state.StateType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 谋略降低 extends 基础属性变化{
    {
        this.type= StateType.谋略值降低;
        有害效果=true;
    }
    @Override
    public void 执行() {
        if (作用者.谋略>=数值){
            作用者.谋略-=数值;
        }else {
            实际数值=作用者.谋略;
            作用者.谋略=0;
        }

    }

    @Override
    public void 恢复() {
        if (实际数值!=0){
            作用者.谋略+=实际数值;
        }else {
            作用者.谋略+=数值;
        }

    }
}
