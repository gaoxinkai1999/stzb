package com.Service.Fight.tactic.指挥战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.数值冲突类.基础属性变化类.攻击距离提高;
import com.Service.Fight.state.数值冲突类.特殊伤害类.特殊谋略伤害类.恐慌;
import com.Service.Fight.state.数值冲突类.特殊伤害类.特殊谋略伤害类.特殊谋略伤害;
import com.Service.Fight.state.特殊状态类.分兵;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tactic.tool.指挥战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 帝临回光 extends 指挥战法 {
    {
        this.name="帝临回光";
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(this.携带者, 5, 3);
        ArrayList<特殊谋略伤害> 恐慌 = 发动一次攻击.一次特殊谋略攻击("恐慌", 敌方目标, this, 0.59, 0.0055, 100);
        for (特殊谋略伤害 特殊谋略伤害 : 恐慌) {
            特殊谋略伤害.生效时间点=TimePoint.回合开始;
            特殊谋略伤害.开始生效回合=3;
        }
        分兵 bean = beanFactory.getBean(分兵.class);
        bean.init(this,携带者,0.7,10);
        bean.开始生效回合=3;
        bean.生效时间点=TimePoint.回合开始;
        攻击距离提高 bean1 = beanFactory.getBean(攻击距离提高.class);
        bean1.init(this,携带者,0,100);
        bean1.开始生效回合=3;
        bean1.配置刷新(true,1,TimePoint.回合开始,1);
    }
}
