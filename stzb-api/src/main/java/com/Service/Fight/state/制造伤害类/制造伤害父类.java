package com.Service.Fight.state.制造伤害类;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.伤害计算变化类.伤害计算变化父类;
import com.Service.Fight.state.特殊状态类.规避;
import com.Service.Fight.state.状态冲突.冲突类型;
import com.Service.Fight.tactic.普通攻击;
import com.Service.Fight.tactic.被动战法.京观垒冢.京观垒冢效果;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public abstract class 制造伤害父类 extends State {
    public int 伤害;
    public double 增减伤;
    public Hero 攻击者;
    public boolean 是否为特殊伤害 = false;
    public boolean 是否被规避 = false;
    public boolean 无视规避 = false;
    {
        this.冲突= 冲突类型.任意类型不冲突;
    }

    private void 判断规避() {
        if (!无视规避) {
            for (State state : 作用者.states) {
                if (!state.isDie&&state.type == StateType.规避) {
                    ((规避) state).start(this);
                }
            }
        }

    }

    void 增减伤计算() {
        for (State state : this.攻击者.states) {
            if (state instanceof 伤害计算变化父类&&!state.isDie) {
                ((伤害计算变化父类) state).改变伤害(this);
            }
        }
        for (State state : this.作用者.states) {
            if (state instanceof 伤害计算变化父类&&!state.isDie) {
                ((伤害计算变化父类) state).改变伤害(this);
            }
        }
    }


    public void 计算伤害() {
    }

    @Override
    public void 执行状态逻辑() {
        战报工具.demo(所在战法.携带者.fighting,作用者,"来自",所在战法.携带者,所在战法.name,"的伤害效果执行*******************************");
        执行伤害();
    }

    public void 执行伤害() {
        判断规避();
        if (是否被规避) {
            return;
        }
        if (作用者.兵力 > 伤害) {
            作用者.伤兵 += (伤害 * 0.95);
            作用者.兵力 -= 伤害;
            所在战法.伤害+=伤害;
            战报工具.demo(攻击者.fighting, 作用者, "损失了", 伤害, "兵力", "(", 作用者.兵力, ")");
            //受到伤害后执行效果
            for (int i = 0; i < 作用者.states.size(); i++) {
                State state = 作用者.states.get(i);
                state.start(TimePoint.受到伤害时);

            }
            //受到普通攻击伤害后
            if (this.所在战法 instanceof 普通攻击){
                for (int i = 0; i < 作用者.states.size(); i++) {
                    State state = 作用者.states.get(i);
                    state.start(TimePoint.受到普通攻击伤害后);
                }
            }

            //造成伤害后执行效果
            for (int i = 0; i < 攻击者.states.size(); i++) {
                State state = 攻击者.states.get(i);
                if (state.type==StateType.京观垒冢){
                    ((京观垒冢效果)state).伤害=this;
                }
                state.start(TimePoint.造成伤害后);

            }
        } else {
            //武将阵亡

            战报工具.demo(攻击者.fighting, 作用者, "损失了", 作用者.兵力, "兵力", "(0)");
            所在战法.伤害+=作用者.兵力;
            作用者.兵力 = 0;
            作用者.isDie=true;

            if (作用者.位置.equals("大营")) {
                if (!作用者.fighting.gameover){
                    作用者.fighting.over();
                }



            } else {
                战报工具.demo(攻击者.fighting, 作用者, "无法再战");
            }
        }

    }

    public void start() {
        计算伤害();
        执行伤害();
    }

}
