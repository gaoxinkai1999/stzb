package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.伤害计算变化类.造成的主动战法伤害增加;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 辅臣应势 extends 主动战法 {
    {
        this.name="辅臣应势";
        发动几率=40;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 2, 1);
        发动一次攻击.一次物理攻击(敌方目标,this,携带者,0.5+(0.5/9)*(战法等级-1));
        ArrayList<Hero> 友方目标 = 选择目标.友方目标(携带者, 2, 2);
        for (Hero hero : 友方目标) {
            造成的主动战法伤害增加 bean = beanFactory.getBean(造成的主动战法伤害增加.class);
            bean.init(this,hero,1,0.14+(0.14/9)*(战法等级-1));
        }
    }
}
