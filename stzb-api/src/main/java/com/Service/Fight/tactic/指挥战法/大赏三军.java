package com.Service.Fight.tactic.指挥战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.伤害计算变化类.受到的攻击伤害增加;
import com.Service.Fight.state.伤害计算变化类.受到的策略伤害增加;
import com.Service.Fight.state.伤害计算变化类.造成的攻击伤害增加;
import com.Service.Fight.state.伤害计算变化类.造成的策略伤害增加;
import com.Service.Fight.tactic.tool.指挥战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 大赏三军 extends 指挥战法 {
    {
        this.name="大赏三军";
    }
    @Override
    public void 战法逻辑() {
        double 数值=0.3+(携带者.谋略-80)*0.0015;

        ArrayList<Hero> 我方目标 = 选择目标.我方目标(携带者, 3, 2);
        for (Hero hero : 我方目标) {
            造成的攻击伤害增加 bean = beanFactory.getBean(造成的攻击伤害增加.class);
            bean.init(this,hero,3,数值);
            造成的策略伤害增加 bean1 = beanFactory.getBean(造成的策略伤害增加.class);
            bean1.init(this,hero,3,数值);
        }
    }


}
