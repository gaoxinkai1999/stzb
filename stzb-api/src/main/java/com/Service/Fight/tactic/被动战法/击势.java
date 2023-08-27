package com.Service.Fight.tactic.被动战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.伤害计算变化类.造成的攻击伤害增加;
import com.Service.Fight.state.数值冲突类.无视属性.无视防御;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tactic.tool.被动战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 击势 extends 被动战法 {
    {
        this.name="击势";
    }

    @Override
    public void 战法逻辑() {
        击势效果 bean = beanFactory.getBean(击势效果.class);
        bean.init(this,携带者);
    }
}
@Component
@Scope("prototype")
class 击势效果 extends State{
    {
        this.type= StateType.击势;
        this.生效时间点= TimePoint.自身回合前;
    }

    @Override
    public void 执行状态逻辑() {
        if (所在战法.判断效果是否发动(65)){
            造成的攻击伤害增加 bean = beanFactory.getBean(造成的攻击伤害增加.class);
            bean.init(所在战法,作用者,1,0.5);
        }
        if (所在战法.判断效果是否发动(65)){
            无视防御 bean = beanFactory.getBean(无视防御.class);
            bean.init(所在战法,作用者);
            bean.数值=0.6;
            bean.持续时间=1;
        }
    }
}
