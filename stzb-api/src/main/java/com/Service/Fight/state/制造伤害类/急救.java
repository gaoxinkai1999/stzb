package com.Service.Fight.state.制造伤害类;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.状态冲突.冲突类型;
import com.Service.Fight.tactic.Tactic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 急救 extends State {
    int 恢复量;
    double 基础恢复率;
    double 恢复率增长率;
    {
        this.type=StateType.立即型急救;
        this.冲突= 冲突类型.任意类型不冲突;
    }

    private double 恢复效果计算() {
        return 0;
    }

    public void 计算恢复量() {
        double 恢复率 = 基础恢复率 + 恢复率增长率 * (this.所在战法.携带者.谋略 - 80);

        恢复量 = (int) (300 * this.所在战法.携带者.兵力 * 恢复率 * (1 + 恢复效果计算()) / (3500 + this.所在战法.携带者.兵力));

    }

    public void 结算() {
//        判断禁疗
        for (State state : 作用者.states) {
            if (state.type == StateType.围困) {
                战报工具.demo(所在战法.携带者.fighting,作用者,"无法恢复兵力");
                return;
            }
        }
        if (作用者.伤兵 >= 恢复量) {
            作用者.兵力 += 恢复量;
            作用者.伤兵 -= 恢复量;
            战报工具.demo(所在战法.携带者.fighting,作用者,"恢复了",恢复量,"兵力(" , 作用者.兵力 , ")");

            所在战法.治疗+=恢复量;
        } else {
            作用者.兵力 += 作用者.伤兵;
            战报工具.demo(所在战法.携带者.fighting,作用者,"恢复了",作用者.伤兵,"兵力(" , 作用者.兵力 , ")");
            所在战法.治疗+=作用者.伤兵;
            作用者.伤兵 = 0;
        }

    }

    public void init(Tactic 所在战法, Hero 作用者, double 基础恢复率, double 恢复率增长率) {
        super.init(所在战法, 作用者);
        this.基础恢复率 = 基础恢复率;
        this.恢复率增长率 = 恢复率增长率;
    }



    public void start() {
        计算恢复量();
        结算();
    }
}
