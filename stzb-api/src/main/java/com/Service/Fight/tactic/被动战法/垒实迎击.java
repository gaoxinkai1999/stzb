package com.Service.Fight.tactic.被动战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.制造伤害类.急救;
import com.Service.Fight.state.特殊状态类.援护;
import com.Service.Fight.state.特殊状态类.规避;
import com.Service.Fight.state.特殊状态类.镇静;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tactic.tool.TacticType;
import com.Service.Fight.tactic.tool.被动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 垒实迎击 extends 被动战法 {
    {
        this.name = "垒实迎击";
    }

    @Override
    public void 战法逻辑() {
        垒实迎击受到普通攻击伤害后效果 bean = beanFactory.getBean(垒实迎击受到普通攻击伤害后效果.class);
        bean.init(this, 携带者);
        垒实迎击援护效果 bean1 = beanFactory.getBean(垒实迎击援护效果.class);
        bean1.init(this,携带者);
    }
}

@Component
@Scope("prototype")
class 垒实迎击受到普通攻击伤害后效果 extends State {
    {
        this.type = StateType.垒实迎击;
        this.持续时间 = 100;
        this.生效时间点 = TimePoint.受到普通攻击伤害后;
    }

    @Override
    public void 执行状态逻辑() {
        int 几率 = (int) (25 + (25.0 / 9) * (所在战法.战法等级 - 1));
        if (所在战法.判断效果是否发动(几率)) {
            急救 bean = beanFactory.getBean(急救.class);
            bean.init(所在战法,作用者,1+(1.0/9)*(所在战法.战法等级-1),0);
            bean.start();
        }
        if (所在战法.判断效果是否发动(几率)) {
            镇静 bean = beanFactory.getBean(镇静.class);
            bean.start(作用者,new TacticType[]{TacticType.主动战法,TacticType.追击战法});
        }
        if (所在战法.判断效果是否发动(几率)) {
            规避 bean = beanFactory.getBean(规避.class);
            bean.init(所在战法,作用者,1);
        }

    }
}

@Component
@Scope("prototype")
class 垒实迎击援护效果 extends State {
    {
        this.type = StateType.垒实迎击;
        this.持续时间 = 100;
        this.生效时间点 = TimePoint.回合开始;
    }

    @Override
    public void 执行状态逻辑() {
        int 几率 = 25 + (25 / 9) * (所在战法.战法等级 - 1);
        if (所在战法.判断效果是否发动(几率)){
            ArrayList<Hero> 友方目标 = 选择目标.友方目标(作用者, 5, 2);
            for (Hero hero : 友方目标) {
                援护 bean = beanFactory.getBean(援护.class);
                bean.init(所在战法,hero);
            }

        }
    }
}

