package com.Service.Fight.state.制造伤害类;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.数值冲突类.无视属性.无视防御;
import com.Service.Fight.state.状态冲突.冲突类型;
import com.Service.Fight.tactic.Tactic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public  class 造成单次攻击伤害 extends 制造伤害父类 {
   public StateType name = StateType.造成单次攻击伤害;
   public double 伤害率;
    {
        this.type=StateType.造成单次攻击伤害;
        this.冲突= 冲突类型.任意类型不冲突;
    }
    @Override
    public void 计算伤害() {
        //即将受到伤害时间点
        for (int i = 0; i < 作用者.states.size(); i++) {
            State state = 作用者.states.get(i);
            state.start(TimePoint.即将受到伤害时);
        }
        //增减伤计算
        增减伤计算();
        double 攻防差影响;
        double 无视防御 = 0;
        // 攻防差 = 攻击属性 - 目标防御属性*（1-Σ无视防御效果）
        double 攻防差 = 攻击者.攻击 - 作用者.防御 * (1 - 无视防御计算());
        // 攻防差影响（当攻防差>=0） =3-500/（250+攻防差 ）
        if (攻防差 >= 0) {
            攻防差影响 = 3 - 500 / (250 + 攻防差);
        }
        // 攻防差影响（当攻防差<0） = 100/（100-攻防差）
        else {
            攻防差影响 = 100 / (100 - 攻防差);
        }
        // 兵力基础伤害（普通）= 373*兵力/（7700+兵力）
        double 兵力基础伤害 = 373 * 攻击者.兵力 / (7700 + 攻击者.兵力);
        // 兵力基础伤害（动摇）= 兵力基础伤害（普通）/3
        // 攻击基础伤害（普通）= 攻击属性 * 随机数 * 伤害率 * max（0.1，1+Σ增减伤）
        double a = 0;
        while (true) {
            a = Math.random();
            if (a <= 0.39 && a >= 0.3) {
                break;
            }
        }

        double 攻击伤害 = 攻击者.攻击 * a * 伤害率 * Math.max(0.1, 1 + 增减伤);
        // 随机数 = （0.30,0.31,.....,0.39）
        // 攻击基础伤害（动摇）= 攻击属性 * 0.4 * 伤害率 * max（0.1，1+Σ增减伤）
        //
        //
        if (是否为特殊伤害){
            兵力基础伤害=兵力基础伤害/3;
            攻击伤害=攻击者.攻击 * 0.4 * 伤害率 * Math.max(0.1, 1 + 增减伤);
        }
        // 主要伤害 = 300*兵力/（3500+兵力） * 伤害率 * max（10%，1+Σ增减伤）* 攻防差影响
        double 主要伤害 = 300 * 攻击者.兵力 / (3500 + 攻击者.兵力) * 伤害率 * Math.max(0.1, 1 + 增减伤) * 攻防差影响;
        // 物理伤害 = 兵力基础伤害 + 攻击基础伤害 +主要伤害
        伤害=  (int) Math.round(兵力基础伤害 + 攻击伤害 + 主要伤害);

    }




    private double 无视防御计算(){
        for (int i = 0; i < 攻击者.states.size(); i++) {
            State state = 攻击者.states.get(i);
            if (!state.isDie&&state.type==StateType.无视防御){
                return ((无视防御)state).数值;
            }
        }
        return 0;
    }

    public void init(Tactic 所在战法, Hero 攻击者,Hero 作用者,double 伤害率) {
        super.init(所在战法,作用者);
        this.伤害率=伤害率;
        this.攻击者=攻击者;
    }
}
