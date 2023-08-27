package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.伤害计算变化类.受到的攻击伤害增加;
import com.Service.Fight.state.伤害计算变化类.受到的策略伤害增加;
import com.Service.Fight.state.数值冲突类.基础属性变化类.攻击提高;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Scope("prototype")
@Component
public class 愚勇 extends 主动战法 {
    {
        this.name="愚勇";
        this.发动几率=30;
    }

    @Override
    public void 战法逻辑() {
        攻击提高 bean = beanFactory.getBean(攻击提高.class);
        bean.init(this,携带者,15+(15.0/9)*(战法等级-1),2);
        受到的策略伤害增加 bean1 = beanFactory.getBean(受到的策略伤害增加.class);
        bean1.init(this,携带者,2,0.12);
        受到的攻击伤害增加 bean2 = beanFactory.getBean(受到的攻击伤害增加.class);
        bean2.init(this,携带者,2,0.12);
        ArrayList<Hero> 目标;
        if (this.判断效果是否发动(50)){
            目标= 选择目标.敌方目标(携带者,3,1);
        }else {
            目标=选择目标.敌方目标(携带者,3,2);
        }
        发动一次攻击.一次物理攻击(目标,this,携带者,1.05+(1.05/9)*(战法等级-1));
    }
}
