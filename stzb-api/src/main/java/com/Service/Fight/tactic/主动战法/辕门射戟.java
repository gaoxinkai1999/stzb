package com.Service.Fight.tactic.主动战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.伤害计算变化类.造成的攻击伤害减少;
import com.Service.Fight.state.制造伤害类.造成单次攻击伤害;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.一次攻击;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 辕门射戟 extends 主动战法 {
    {
        this.name="辕门射戟";
        this.是否准备=false;
        this.发动几率=35;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(this.携带者, 5, 2);
        发动一次攻击.一次物理攻击(敌方目标,this,携带者,1.2);
        for (Hero hero : 敌方目标) {
            造成的攻击伤害减少 bean = beanFactory.getBean(造成的攻击伤害减少.class);
            bean.init(this,hero,1,1.5);
        }
        ArrayList<Hero> 敌方目标1 = 选择目标.敌方目标(this.携带者, 5, 2);
        发动一次攻击.一次物理攻击(敌方目标1,this,携带者,1.2);
    }
}
