package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.伤害计算变化类.造成的攻击伤害增加;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 固陵杀将 extends 主动战法 {
    {
        this.name="固陵杀将";
        发动几率=30;
    }

    @Override
    public void 战法逻辑() {
        造成的攻击伤害增加 bean = beanFactory.getBean(造成的攻击伤害增加.class);
        bean.init(this,携带者,1,0.25+(0.25/9)*(战法等级-1));
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 4, 1);
        发动一次攻击.一次物理攻击(敌方目标,this,携带者,0.65+(0.65/9)*(战法等级-1));
    }
}
