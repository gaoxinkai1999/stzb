package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.tactic.tool.被动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 借刀斩叛 extends 被动战法 {
    {
        this.name="借刀斩叛";
    }

    @Override
    public void 战法逻辑() {
        借刀斩叛效果 bean = beanFactory.getBean(借刀斩叛效果.class);
        bean.init(this,携带者);
    }
}
@Component
@Scope("prototype")
class 借刀斩叛效果 extends State{
    {
        this.type= StateType.借刀斩叛;
        this.生效时间点= TimePoint.回合开始;
        持续时间=100;
        生效几率= 25;
    }

    @Override
    public void 执行状态逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(作用者, 3, 1);
        发动一次攻击.一次物理攻击(敌方目标,所在战法,作用者,1.5+(1.5/9)*(所在战法.战法等级-1));
    }
}
