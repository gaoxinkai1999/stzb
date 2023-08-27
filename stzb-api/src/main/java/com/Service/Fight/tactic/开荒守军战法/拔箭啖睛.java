package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.数值冲突类.基础属性变化类.攻击提高;
import com.Service.Fight.state.数值冲突类.基础属性变化类.防御提高;
import com.Service.Fight.tactic.tool.指挥战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 拔箭啖睛 extends 指挥战法 {
    {
        this.name="拔箭啖睛";
    }

    @Override
    public void 战法逻辑() {
        拔箭啖睛效果 bean = beanFactory.getBean(拔箭啖睛效果.class);
        bean.init(this,携带者);
    }
}
@Component
@Scope("prototype")
class 拔箭啖睛效果 extends State {
    int 次数=0;
    攻击提高 攻击;
    防御提高 防御;
    {
        this.type= StateType.拔箭啖睛;
        this.生效时间点= TimePoint.受到伤害时;
        持续时间=100;
    }

    @Override
    public void 执行状态逻辑() {
        if (次数==0){
            攻击 = beanFactory.getBean(攻击提高.class);
            攻击.init(所在战法,作用者,3.5+(3.5/9)*(所在战法.战法等级)-1,100);
            防御=beanFactory.getBean(防御提高.class);
            防御.init(所在战法,作用者,3.5+(3.5/9)*(所在战法.战法等级)-1,100);
        }else if (次数<=15){
            战报工具.demo(作用者.fighting,"拔箭啖睛效果刷新");
            攻击.数值+=3.5+(3.5/9)*(所在战法.战法等级)-1;
            防御.数值+=3.5+(3.5/9)*(所在战法.战法等级)-1;
        }
    }
}
