package com.Service.Fight.tactic;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.制造伤害类.造成单次攻击伤害;
import com.Service.Fight.state.特殊状态类.分兵;
import com.Service.Fight.state.特殊状态类.反击;
import com.Service.Fight.tactic.tool.TacticType;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tactic.tool.追击战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 普通攻击 extends Tactic {
    /**
     * 检查连击 分兵 反击  追击
     *
     */ {
         this.name="普通攻击";
        this.type = TacticType.普通攻击;
    }

    public boolean 该回合已连击 = false;
    public double 分兵伤害率;
    public Hero 普攻目标;
    @Override
    public void start() {

        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 携带者.攻击距离, 1);
        if (敌方目标.isEmpty()) {

            战报工具.demo(携带者.fighting, 携带者, "由于射程不足,无法进行攻击");
            return;
        } else {
            Hero 目标 = 判断援护(敌方目标.get(0));
            普攻目标=目标;
            战报工具.demo(携带者.fighting, 携带者, "对", 目标, "发动普通攻击");

            ArrayList<造成单次攻击伤害> 一次物理攻击 = 发动一次攻击.一次物理攻击(敌方目标, this, 携带者, 1);
            for (造成单次攻击伤害  攻击伤害: 一次物理攻击) {
                if (!攻击伤害.是否被规避) {
                    //造成普通伤害后时间点
                    for (int i = 0; i < 携带者.states.size(); i++) {
                        State state =  携带者.states.get(i);
                        state.start(TimePoint.造成普通攻击伤害后);
                    }
                    检查反击(目标);
                }

            }


            执行分兵(目标);

            //发动普通攻击后时间点
            for (int i = 0; i < 携带者.states.size(); i++) {
                State state =  携带者.states.get(i);
                state.start(TimePoint.发动普通攻击后);
            }
            //发动追击战法
            for (Tactic tactic : 携带者.tactics) {
                if (tactic instanceof 追击战法) {
                    tactic.start();
                }
            }

        }
        if (检查连击() && !该回合已连击) {
            该回合已连击 = true;
            战报工具.demo(携带者.fighting, 携带者, "执行两次攻击");
            start();
        }


    }

    public void 执行分兵(Hero 普攻对象) {
        if (分兵伤害率 > 0) {
            ArrayList<Hero> 分兵目标 = 选择目标.分兵目标判断(普攻对象);
            for (Hero hero : 分兵目标) {
                造成单次攻击伤害 bean = beanFactory.getBean(造成单次攻击伤害.class);
                bean.init(this, 携带者, hero, 分兵伤害率);
                战报工具.demo(普攻对象.fighting, 携带者, "执行分兵");
                bean.start();
            }
            分兵伤害率 = 0;
        }
    }

    public void 检查反击(Hero 目标) {
        for (int i = 0; i < 目标.states.size(); i++) {
            State state = 目标.states.get(i);
            if (state.type == StateType.反击 && !state.isDie) {
                ((反击) state).目标=this.携带者;
                ((反击) state).执行反击();
            }
        }
    }

    public boolean 检查连击() {
        for (State state : 携带者.states) {
            if (!state.isDie && state.type == StateType.连击) {
                return true;
            }
        }
        return false;
    }

    public Hero 判断援护(Hero 被攻击者) {
        for (State state : 被攻击者.states) {
            if (!state.isDie && state.type == StateType.援护) {
                战报工具.demo(携带者.fighting, 被攻击者, "由于被援护,转移攻击");
                return state.所在战法.携带者;
            }
        }
        return 被攻击者;
    }
}
