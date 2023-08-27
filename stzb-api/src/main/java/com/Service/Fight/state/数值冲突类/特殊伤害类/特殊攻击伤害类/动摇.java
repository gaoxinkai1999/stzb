package com.Service.Fight.state.数值冲突类.特殊伤害类.特殊攻击伤害类;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.制造伤害类.造成单次攻击伤害;
import com.Service.Fight.state.制造伤害类.造成单次谋略伤害;
import com.Service.Fight.state.数值冲突类.数值冲突;
import com.Service.Fight.tactic.Tactic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 动摇 extends 数值冲突 {
    {
        this.type= StateType.动摇;
        有害效果=true;
        this.生效时间点=TimePoint.自身回合前;
        this.结算时间点=TimePoint.自身回合前;
    }
    造成单次攻击伤害 攻击伤害;

    @Override
    public void 执行状态逻辑() {
        攻击伤害.执行伤害();
    }

    public void init(Tactic 所在战法, Hero 作用者, double 伤害率,int 持续时间) {
        super.init(所在战法, 作用者);
        this.持续时间=持续时间;
        攻击伤害 = beanFactory.getBean(造成单次攻击伤害.class);
        攻击伤害.init(所在战法,所在战法.携带者,作用者,伤害率);
        攻击伤害.是否为特殊伤害=true;
        this.数值=伤害率;
        攻击伤害.计算伤害();
        战报工具.demo(所在战法.携带者.fighting,作用者,"的=",type.name(),"效果已施加");
    }
}
