package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.控制状态类.犹豫;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 叛羌急袭 extends 主动战法 {
    {
        this.name="叛羌急袭";
        发动几率=35;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 4, 2);
        发动一次攻击.一次物理攻击(敌方目标,this,携带者,1.125+(1.125/9)*(战法等级-1));
        犹豫 bean = beanFactory.getBean(犹豫.class);
        bean.init(this,携带者,1);

    }
}
