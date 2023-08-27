package com.Service.Fight.state.数值冲突类.基础属性变化类;

import com.Service.Fight.state.StateType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 速度降低 extends 基础属性变化{
    {
        this.type= StateType.速度值降低;
        有害效果=true;
    }
    @Override
    public void 执行() {
        if (作用者.速度>=数值){
            作用者.速度-=数值;
        }else {
            实际数值=作用者.速度;
            作用者.速度=0;
        }

    }

    @Override
    public void 恢复() {
        if (实际数值!=0){
            作用者.速度+=实际数值;
        }else {
            作用者.速度+=数值;
        }

    }
}
