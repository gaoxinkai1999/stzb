package com.Service.Fight.state.数值冲突类.特殊恢复类;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.制造伤害类.急救;
import com.Service.Fight.state.数值冲突类.数值冲突;
import com.Service.Fight.tactic.Tactic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 持续性急救效果，再满足一定条件下生效，所以必须修改生效时间点
 */
@Component
@Scope("prototype")
public class 持续型急救 extends 数值冲突 {
    public 急救 aid;
    {
        this.type= StateType.持续型急救;
        this.结算时间点=TimePoint.自身回合前;
    }

    @Override
    public void 执行状态逻辑() {
        aid.结算();
    }

    public void init(Tactic 所在战法, Hero 作用者, double 基础恢复率, double 恢复率成长率) {
        super.init(所在战法, 作用者);
        aid = beanFactory.getBean(急救.class);
        aid.init(所在战法,作用者,基础恢复率,恢复率成长率);
        aid.计算恢复量();

    }
}
