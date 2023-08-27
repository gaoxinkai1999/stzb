package com.Service.Fight.tactic.指挥战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.伤害计算变化类.造成的策略伤害增加;
import com.Service.Fight.state.制造伤害类.造成单次谋略伤害;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tactic.tool.指挥战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 众谋不懈 extends 指挥战法 {
    {
        this.name="众谋不懈";
    }

    @Override
    public void 战法逻辑() {
        众谋不懈效果 bean = beanFactory.getBean(众谋不懈效果.class);
        bean.init(this,携带者);
    }
}
@Component
@Scope("prototype")
class 众谋不懈效果 extends State{
    {
        this.type= StateType.众谋不懈;
        this.生效时间点= TimePoint.试图发动主动战法;
        this.生效时间点_=TimePoint.试图发动追击战法;
        this.生效几率=40;

    }

    @Override
    public void 执行状态逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(作用者, 5, 1);
        发动一次攻击.一次谋略攻击(敌方目标,所在战法, 作用者,1.94,0.01925);
    }
}