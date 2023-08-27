package com.Service.Fight.tactic.指挥战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.伤害计算变化类.造成的策略伤害增加;
import com.Service.Fight.state.控制状态类.怯战;
import com.Service.Fight.tactic.tool.指挥战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 不攻 extends 指挥战法 {
    {
        this.name="不攻";
    }

    @Override
    public void 战法逻辑() {
        怯战 bean = beanFactory.getBean(怯战.class);
        bean.init(this,携带者,100);
        造成的策略伤害增加 bean1 = beanFactory.getBean(造成的策略伤害增加.class);
        bean1.init(this,携带者,100,0.125+(0.125/9)*(战法等级-1));

    }
}
@Component
@Scope("prototype")
class 不攻效果 extends State{
    {
        this.type= StateType.不攻;
        this.生效时间点= TimePoint.自身回合前;
        this.持续时间=100;
    }

    @Override
    public void 执行状态逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(作用者, 5, 1);
        发动一次攻击.一次谋略攻击(敌方目标,所在战法,作用者,0.415+(0.415/9)*(所在战法.战法等级-1),0.00725);
    }
}
