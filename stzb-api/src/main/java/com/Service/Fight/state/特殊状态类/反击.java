package com.Service.Fight.state.特殊状态类;


import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.制造伤害类.造成单次攻击伤害;
import com.Service.Fight.state.状态冲突.冲突类型;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 反击 extends State {

    public double 伤害率;

    public Hero 目标;

    public boolean 是否生效;

    {
        this.type = StateType.反击;
        冲突 = 冲突类型.任意类型不叠加;
        结算时间点 = TimePoint.回合结束;
        生效时间点=TimePoint.回合开始;
    }

    @Override
    public void 执行状态逻辑() {
        是否生效 = true;
        战报工具.demo(作用者.fighting, 作用者, "获得反击能力");
    }

    public void 执行反击() {
        if (是否生效) {
            if (是否可以反击()) {
                战报工具.demo(目标.fighting, 作用者, "进行反击");
                造成单次攻击伤害 bean = beanFactory.getBean(造成单次攻击伤害.class);
                bean.init(作用者.普攻, 作用者, 目标, 伤害率);
                bean.start();
            } else {
                战报工具.demo(目标.fighting, 作用者, "无法进行反击");
            }
        }
    }


    public void init(Tactic 所在战法, Hero 作用者, double 伤害率) {
        super.init(所在战法, 作用者);
        this.伤害率 = 伤害率;
    }

    /**
     * 在混乱和怯战状态下，无法进行反击
     * 判断攻击距离
     *
     * @return
     */
    public boolean 是否可以反击() {
        return !作用者.判断怯战() && !作用者.判断混乱() && 选择目标.反击判断(作用者, 目标);
    }

    @Override
    public void 结算时回调() {
        是否生效 = false;
    }
}
