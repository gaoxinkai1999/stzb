package com.Service.Fight.state.数值冲突类.基础属性变化类;

import com.Service.Fight.state.StateType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 防御提高 extends 基础属性变化{
    {
        this.type= StateType.防御值提高;
    }
    @Override
    public void 执行() {
        作用者.防御+=数值;
    }

    @Override
    public void 恢复() {
        作用者.防御-=数值;
    }

}
