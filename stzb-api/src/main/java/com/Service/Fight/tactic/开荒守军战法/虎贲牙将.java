package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.数值冲突类.基础属性变化类.防御降低;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 虎贲牙将 extends 主动战法 {
    {
        this.name="虎贲牙将";
        发动几率=35;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 3, 1);
        发动一次攻击.一次物理攻击(敌方目标,this,携带者,0.625+(0.625/9)*(战法等级-1));
        for (Hero hero : 敌方目标) {
            防御降低 bean = beanFactory.getBean(防御降低.class);
            bean.init(this,hero,hero.防御*0.2,1);
        }
        if (this.判断效果是否发动(50)){
            发动一次攻击.一次物理攻击(敌方目标,this,携带者,0.625+(0.625/9)*(战法等级-1));
        }
    }
}
