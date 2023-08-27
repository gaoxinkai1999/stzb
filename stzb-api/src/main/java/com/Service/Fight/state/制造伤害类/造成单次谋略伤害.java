package com.Service.Fight.state.制造伤害类;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.数值冲突类.无视属性.无视谋略;
import com.Service.Fight.state.数值冲突类.无视属性.无视防御;
import com.Service.Fight.state.状态冲突.冲突类型;
import com.Service.Fight.tactic.Tactic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class 造成单次谋略伤害 extends 制造伤害父类 {
    private double 基础伤害率;
    private double 伤害率增长率;

    public double 伤害率;
    {
        this.type= StateType.造成单次策略伤害;
        this.冲突= 冲突类型.任意类型不冲突;
    }

    @Override
    public void 计算伤害() {
        //即将受到伤害时间点
        for (int i = 0; i < 作用者.states.size(); i++) {
            State state = 作用者.states.get(i);
            state.start(TimePoint.即将受到伤害时);
        }
        增减伤计算();
        // 伤害率受属性影响
        // 伤害率 = 基础伤害率 + 伤害率增长率 *（谋略属性-80）
        double 目标谋略影响 = 0;
        //
        double 目标谋略=作用者.谋略*(1-无视谋略计算());
        // 目标谋略影响
        // 目标谋略影响（当目标谋略>50） = 1-（75-9375/（75+目标谋略））/100
        if (目标谋略 >= 50) {
            目标谋略影响 = 1 - (75 - 9375 / (75 + 目标谋略)) / 100;
        }
        // 目标谋略影响（当目标谋略<50)  =  1
        else {
            目标谋略影响 = 1;
        }
        // 兵力基础伤害（普通） = 178*兵力/6459 +兵力
        double 兵力基础伤害 = 178 * 攻击者.兵力 / (6459 + 攻击者.兵力);
        // 兵力基础伤害（燃烧、恐慌、妖术） = 兵力基础伤害（普通）/ 3

        // 谋略基础伤害（普通） = 谋略属性 * 0.5 *max（0.1，1+Σ增减伤）* 目标谋略影响
        double 谋略伤害 = 攻击者.谋略 * 0.5 * Math.max(0.1, 1 + 增减伤) * 目标谋略影响;
        // 谋略基础伤害（燃烧、恐慌、妖术） = 谋略属性 * 0.25 *max（0.1，1+Σ增减伤）* 目标谋略影响
        if (是否为特殊伤害){
            兵力基础伤害=兵力基础伤害/3;
            谋略伤害=谋略伤害/3;
        }

        // 主要伤害 = 300*兵力/3500+兵力  *伤害率*max（0.1，1+Σ增减伤）* 目标谋略影响
        double 主要伤害 = 300 * 攻击者.兵力 / (3500 + 攻击者.兵力) * 伤害率 * Math.max(0.1, 1 + 增减伤) * 目标谋略影响;
        // 策略伤害 =兵力基础伤害 + 谋略基础伤害 +主要伤害
        伤害 = (int) Math.round(兵力基础伤害 + 谋略伤害 + 主要伤害);

    }

    private double 无视谋略计算(){
        for (int i = 0; i < 攻击者.states.size(); i++) {
            State state = 攻击者.states.get(i);
            if (!state.isDie&&state.type==StateType.无视谋略){
                return ((无视谋略)state).数值;
            }
        }
        return 0;
    }


    public void init(Tactic 所在战法,Hero 攻击者, Hero 作用者, double 基础伤害率, double 伤害率增长率) {
        super.init(所在战法, 作用者);
        this.基础伤害率 = 基础伤害率;
        this.伤害率增长率 = 伤害率增长率;
        this.攻击者=攻击者;
        计算伤害率();
    }

    private void 计算伤害率(){
        伤害率 = 基础伤害率 + 伤害率增长率 * (攻击者.谋略 - 80);
    }
}
