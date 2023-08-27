package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.数值冲突类.基础属性变化类.攻击降低;
import com.Service.Fight.state.数值冲突类.基础属性变化类.谋略降低;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 花中秀 extends 主动战法 {
    {
        this.name="花中秀";
        发动几率=35;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 4, 1);
        发动一次攻击.一次物理攻击(敌方目标,this,携带者,1.275+(1.275/9)*(战法等级-1));
        for (Hero hero : 敌方目标) {
            攻击降低 bean = beanFactory.getBean(攻击降低.class);
            bean.init(this,hero,hero.攻击*0.35,2);
            谋略降低 bean1 = beanFactory.getBean(谋略降低.class);
            bean1.init(this,hero,hero.谋略*0.35,2);
        }
    }
}
