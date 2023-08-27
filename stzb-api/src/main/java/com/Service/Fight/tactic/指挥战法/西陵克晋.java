package com.Service.Fight.tactic.指挥战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.制造伤害类.急救;
import com.Service.Fight.tactic.tool.指挥战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 西陵克晋 extends 指挥战法 {
    {
        this.name="西陵克晋";
    }

    @Override
    public void 战法逻辑() {
        西陵克晋自身效果 bean = beanFactory.getBean(西陵克晋自身效果.class);
        bean.init(this,携带者);
    }
}
@Component
@Scope("prototype")
class 西陵克晋自身效果 extends State {
    {
        this.type= StateType.西陵克晋;
        生效时间点= TimePoint.回合开始;
    }

    @Override
    public void 执行状态逻辑() {
        ArrayList<Hero> 我方目标 = 选择目标.我方目标(作用者, 5, 6);
        Hero 攻击最高= 我方目标.get(0);
        for (Hero hero : 我方目标) {
            if (hero.攻击>攻击最高.攻击){
                攻击最高=hero;
            }
        }
        西陵克晋攻击效果 bean = beanFactory.getBean(西陵克晋攻击效果.class);
        bean.init(所在战法,攻击最高);
        Hero 谋略最高= 我方目标.get(0);
        for (Hero hero : 我方目标) {
            if (hero.谋略>攻击最高.谋略){
                谋略最高=hero;
            }
        }
        西陵克晋谋略效果 bean1 = beanFactory.getBean(西陵克晋谋略效果.class);
        bean1.init(所在战法,谋略最高);


    }
}
@Component
@Scope("prototype")
class 西陵克晋攻击效果 extends State {
    {
        this.type= StateType.西陵克晋;
        生效时间点=TimePoint.自身回合前;
        结算时间点=TimePoint.回合结束;
        持续时间=0;
        生效几率=50;
    }

    @Override
    public void 执行状态逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(所在战法.携带者, 4, 1);
        发动一次攻击.一次物理攻击(敌方目标,所在战法,作用者,1.5);
        急救 bean = beanFactory.getBean(急救.class);
        bean.init(所在战法,作用者,1.75,0);
        bean.start();
    }
}
@Component
@Scope("prototype")
class 西陵克晋谋略效果 extends State {
    {
        this.type= StateType.西陵克晋;
        生效时间点=TimePoint.自身回合前;
        结算时间点=TimePoint.回合结束;
        持续时间=0;
        生效几率=50;
    }
    @Override
    public void 执行状态逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(所在战法.携带者, 4, 1);
        发动一次攻击.一次谋略攻击(敌方目标,所在战法,作用者,1.5,0.0125);
        急救 bean = beanFactory.getBean(急救.class);
        bean.init(所在战法,作用者,1.75,0);
        bean.start();
    }
}