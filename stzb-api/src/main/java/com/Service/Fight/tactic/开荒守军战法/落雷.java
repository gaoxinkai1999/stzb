package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.控制状态类.混乱;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 落雷 extends 主动战法 {
    {
        this.name="落雷";
        发动几率=35;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 4, 1);
        发动一次攻击.一次谋略攻击(敌方目标,this,携带者,0.74+(0.74/9)*(战法等级-1),0.0135);
        for (Hero hero : 敌方目标) {
            混乱 bean = beanFactory.getBean(混乱.class);
            bean.init(this,hero,1);
        }
    }
}
