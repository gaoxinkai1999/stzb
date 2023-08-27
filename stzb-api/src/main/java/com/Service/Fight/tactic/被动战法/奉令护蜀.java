package com.Service.Fight.tactic.被动战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.伤害计算变化类.受到的攻击伤害减少;
import com.Service.Fight.state.伤害计算变化类.受到的策略伤害减少;
import com.Service.Fight.state.伤害计算变化类.造成的普通攻击伤害增加;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tactic.tool.指挥战法;
import com.Service.Fight.tactic.tool.被动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 奉令护蜀 extends 被动战法 {
    {
        this.name = "奉令护蜀";
    }


    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 友方目标 = 选择目标.友方目标(携带者, 3, 2);
        for (Hero hero : 友方目标) {
            奉令护蜀友军效果 bean = beanFactory.getBean(奉令护蜀友军效果.class);
            bean.init(this,hero);
        }
        奉令护蜀自身效果 bean = beanFactory.getBean(奉令护蜀自身效果.class);
        bean.init(this,携带者);

    }
}

@Component
@Scope("prototype")
class 奉令护蜀友军效果 extends State {
    {
        this.type = StateType.奉令护蜀;
        this.生效时间点 = TimePoint.发动主动战法后;
        this.生效时间点_ = TimePoint.发动普通攻击后;
        this.生效时间点__ = TimePoint.发动追击战法后;
    }

    @Override
    public void 执行状态逻辑() {
        for (int i = 0; i < 所在战法.携带者.states.size(); i++) {
            State state = 所在战法.携带者.states.get(i);
            if (state.type==StateType.奉令护蜀){
                ((奉令护蜀自身效果) state).执行效果();
            }

        }
    }

}

@Component
@Scope("prototype")
class 奉令护蜀自身效果 extends State {
    {
        this.type = StateType.奉令护蜀;
    }

    public int 增伤次数;
    public int 减伤次数;
    public 造成的普通攻击伤害增加 伤害增加;
    public 受到的攻击伤害减少 受到的攻击减少;
    public 受到的策略伤害减少 受到的策略减少;
    public void 执行效果(){
        //增伤效果
        if (伤害增加==null){
            伤害增加 = beanFactory.getBean(造成的普通攻击伤害增加.class);
            伤害增加.init(所在战法,作用者,0,0.35 + (所在战法.携带者.攻击 - 80) * 0.002);
            伤害增加.结算时间点=TimePoint.造成普通攻击伤害后;
            增伤次数=1;
        }else {
            if (伤害增加.isDie){
                伤害增加 = beanFactory.getBean(造成的普通攻击伤害增加.class);
                伤害增加.init(所在战法,作用者,0,0.35 + (所在战法.携带者.攻击 - 80) * 0.002);
                伤害增加.结算时间点=TimePoint.造成普通攻击伤害后;
                增伤次数=1;
            }else {
                //刷新状态
                if (增伤次数<5){
                    伤害增加.数值+=0.35 + (所在战法.携带者.攻击 - 80) * 0.002;
                    战报工具.demo(作用者.fighting, "奉令护蜀的普通攻击伤害提高效果刷新了,数值为：", 伤害增加.数值*100,"%");
                    增伤次数+=1;
                }else {
                    战报工具.demo(作用者.fighting, "奉令护蜀的普通攻击伤害提高效果已到最大值");
                }

            }
        }
        //减伤伤效果
        if (受到的攻击减少==null){
            受到的攻击减少 = beanFactory.getBean(受到的攻击伤害减少.class);
            受到的攻击减少.init(所在战法,作用者,0,0.2 + (所在战法.携带者.防御 - 80) * 0.002);
            受到的攻击减少.结算时间点=TimePoint.受到伤害时;
            受到的策略减少=beanFactory.getBean(受到的策略伤害减少.class);
            受到的策略减少.init(所在战法,作用者,0,0.2 + (所在战法.携带者.防御 - 80) * 0.002);
            受到的策略减少.结算时间点=TimePoint.受到伤害时;
            减伤次数=1;
        }else {
            if (受到的攻击减少.isDie){
                受到的攻击减少 = beanFactory.getBean(受到的攻击伤害减少.class);
                受到的攻击减少.init(所在战法,作用者,0,0.2 + (所在战法.携带者.防御 - 80) * 0.002);
                受到的攻击减少.结算时间点=TimePoint.受到伤害时;
                受到的策略减少=beanFactory.getBean(受到的策略伤害减少.class);
                受到的策略减少.init(所在战法,作用者,0,0.2 + (所在战法.携带者.防御 - 80) * 0.002);
                受到的策略减少.结算时间点=TimePoint.受到伤害时;
                减伤次数=1;
            }else {
                //刷新状态
                if (减伤次数<5){
                    受到的攻击减少.数值+=0.2 + (所在战法.携带者.防御 - 80) * 0.002;
                    战报工具.demo(作用者.fighting, "奉令护蜀的受到的攻击伤害减少效果刷新了,数值为：", 受到的攻击减少.数值*100,"%");
                    受到的策略减少.数值+=0.2 + (所在战法.携带者.防御 - 80) * 0.002;
                    战报工具.demo(作用者.fighting, "奉令护蜀的受到的攻击伤害减少效果刷新了,数值为：", 受到的策略减少.数值*100,"%");
                    减伤次数+=1;
                }else {
                    战报工具.demo(作用者.fighting, "奉令护蜀减伤效果已到最大值");
                }

            }
        }
    }

}