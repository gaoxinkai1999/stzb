package com.Service.Fight.tactic.指挥战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.制造伤害类.造成单次攻击伤害;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tactic.tool.指挥战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
@Scope("prototype")
public class 奇兵拒北 extends 指挥战法 {
    {
        this.name="奇兵拒北";
    }

    @Override
    public void 战法逻辑() {
        奇兵拒北效果 bean = beanFactory.getBean(奇兵拒北效果.class);
        bean.init(this,携带者);
    }
}
@Component
@Scope("prototype")
class 奇兵拒北效果 extends State {
    {
        this.type= StateType.奇兵拒北;
        生效时间点=TimePoint.自身回合前;
        生效几率=30;
    }

    @Override
    public void 执行状态逻辑() {
        ArrayList<Hero> 敌方大营和中军 = 选择目标.敌方大营和中军(this.作用者);
        发动一次攻击.一次物理攻击(敌方大营和中军,所在战法,作用者,0.9+(0.9/9)*(所在战法.战法等级-1));

        Hero 友军速度最高 = 选择目标.友军速度最高(this.作用者);
        发动一次攻击.一次物理攻击(敌方大营和中军,所在战法,友军速度最高,0.9+(0.9/9)*(所在战法.战法等级-1));
        生效几率=30;
        战报工具.demo(作用者.fighting,作用者,"执行[奇兵拒北]的几率重置为30%");
    }


    @Override
    public void 没有生效回调() {
        生效几率+=5;
        战报工具.demo(作用者.fighting,作用者,"执行[奇兵拒北]的几率提高5%(",生效几率,"%)");
    }
}
