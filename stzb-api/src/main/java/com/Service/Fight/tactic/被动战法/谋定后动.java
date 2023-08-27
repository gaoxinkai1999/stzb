package com.Service.Fight.tactic.被动战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.数值冲突类.基础属性变化类.攻击提高;
import com.Service.Fight.state.数值冲突类.基础属性变化类.谋略提高;
import com.Service.Fight.state.数值冲突类.基础属性变化类.防御提高;
import com.Service.Fight.state.特殊状态类.洞察;
import com.Service.Fight.tactic.tool.被动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Stack;

@Component
@Scope("prototype")
public class 谋定后动 extends 被动战法 {
    {
        this.name="谋定后动";
    }

    @Override
    public void 战法逻辑() {
        谋定后动效果一 bean = beanFactory.getBean(谋定后动效果一.class);
        bean.init(this,携带者);
        谋定后动效果二 bean1 = beanFactory.getBean(谋定后动效果二.class);
        bean1.init(this,携带者);
    }
}
@Component
@Scope("prototype")
class 谋定后动效果一 extends State{
    {
        this.type= StateType.谋定后动;
        this.生效时间点= TimePoint.发动准备战法前;
    }

    @Override
    public void 执行状态逻辑() {
        洞察 bean = beanFactory.getBean(洞察.class);
        bean.init(所在战法,作用者,2);
    }
}
@Component
@Scope("prototype")
class 谋定后动效果二 extends State{
    {
        this.type= StateType.谋定后动;
        this.生效时间点=TimePoint.发动主动战法后;
    }

    @Override
    public void 执行状态逻辑() {
        ArrayList<Hero> 我方目标 = 选择目标.我方目标(作用者, 2, 2);
        for (Hero hero : 我方目标) {
            攻击提高 bean = beanFactory.getBean(攻击提高.class);
            bean.init(所在战法,hero,55,2);
            防御提高 bean1 = beanFactory.getBean(防御提高.class);
            bean1.init(所在战法,hero,55,2);
            谋略提高 bean2 = beanFactory.getBean(谋略提高.class);
            bean2.init(所在战法,hero,55,2);
        }

    }
}
