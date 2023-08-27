package com.Service.Fight.tactic.指挥战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.数值冲突类.特殊恢复类.持续型急救;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tactic.tool.指挥战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 皇裔流离 extends 指挥战法 {
    {
        this.name="皇裔流离";
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 我方目标 = 选择目标.我方目标(this.携带者, 3, 3);
        for (Hero hero : 我方目标) {


            持续型急救 bean = beanFactory.getBean(持续型急救.class);
            bean.init(this,hero,0.68,0.006);
            bean.生效几率=50;
            bean.生效时间点=TimePoint.受到伤害时;

        }
    }
}

