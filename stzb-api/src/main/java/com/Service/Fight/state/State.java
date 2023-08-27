package com.Service.Fight.state;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.状态冲突.冲突类型;
import com.Service.Fight.state.状态冲突.检查冲突;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tools.一次攻击;
import com.Service.Fight.tools.战报;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 各种状态父类
 */
@Scope("prototype")
@Component
public abstract class State {
    @Autowired
    public BeanFactory beanFactory;
    @Autowired
    public 战报 战报工具;
    @Autowired
    public 一次攻击 发动一次攻击;
    @Autowired
    public 检查冲突 检查;
    public StateType type;
    public boolean isDie = false;
    public Tactic 所在战法;
    public Hero 作用者;
    public 冲突类型 冲突;


    //如果持续时间为次，需修改结算时间点

    public int 持续时间 = 0;


    //控制结算和生效时间点，默认都为自身回合前

    public TimePoint 结算时间点;
    public TimePoint 结算时间点_;
    public TimePoint 生效时间点;
    public TimePoint 生效时间点_;
    public TimePoint 生效时间点__;

    public int 开始生效回合;

    public double 生效几率;


    public boolean 有害效果 = false;

    public void start(TimePoint timePoint) {
        //判断是否失效
        if (isDie) {
            return;
        }
        //判断生效回合
        if (开始生效回合 == 0 || 所在战法.携带者.fighting.回合 >= 开始生效回合) {
            //回合递减
            if (timePoint == 结算时间点||timePoint==结算时间点_) {
                if (持续时间 > 0) {
                    持续时间 -= 1;
                    结算时回调();
                } else {
                    失效();
                    return;
                }
            }
            //执行状态
            if (timePoint == 生效时间点 || timePoint == 生效时间点_||timePoint==生效时间点__) {
                //判断生效几率
                if (生效几率 != 0) {
                    if (!所在战法.判断效果是否发动(生效几率)) {
                        战报工具.demo(所在战法.携带者.fighting, 作用者, "来自", 所在战法.携带者, 所在战法.name, "的", type.name(), "效果没有生效");
                        没有生效回调();
                        return;
                    }

                }
                生效描述();

                执行状态逻辑();

            }
        }


    }

    public void init(Tactic 所在战法, Hero 作用者) {
        this.所在战法 = 所在战法;
        this.作用者 = 作用者;
        if (检查.check(this, 作用者)) {
            if (type == StateType.立即型急救 || type == StateType.造成单次策略伤害 || type == StateType.造成单次攻击伤害) {
                return;
            }
            施加描述();
        }
    }


    public void 执行状态逻辑() {

    }
    public void 没有生效回调(){

    }
    public void 生效描述() {
        战报工具.demo(所在战法.携带者.fighting, 作用者, "来自", 所在战法.携带者, 所在战法.name, "的", type.name(), "效果生效了");
    }

    public void 施加描述() {
        战报工具.demo(所在战法.携带者.fighting, 作用者, "的", type.name(), "效果已施加");
    }

    public void 失效前回调() {

    }

    public void 结算时回调() {

    }

    public void 失效() {
        战报工具.demo(所在战法.携带者.fighting, 作用者, "来自", 所在战法.携带者, 所在战法.name, "的", type.name(), "效果消失了");
        //将状态设置为失效
        失效前回调();
        isDie = true;
    }

    @Override
    public String toString() {
        return "State{" +
                "type=" + type +
                ", isDie=" + isDie +
                ", 所在战法=" + 所在战法.name +
                ", 作用者=" + 作用者.name +
                ", 持续时间=" + 持续时间 +
                ", 结算时间点=" + 结算时间点 +
                ", 生效时间点=" + 生效时间点 +
                ", 生效时间点_=" + 生效时间点_ +
                ", 开始生效回合=" + 开始生效回合 +
                ", 生效几率=" + 生效几率 +
                '}';
    }
}
