package com.Service.Fight.state.数值冲突类.无视属性;

import com.Service.Fight.TimePoint;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.数值冲突类.数值冲突;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 无视防御 extends 数值冲突 {
    {
        this.type= StateType.无视防御;
        this.结算时间点= TimePoint.自身回合前;
    }
}
