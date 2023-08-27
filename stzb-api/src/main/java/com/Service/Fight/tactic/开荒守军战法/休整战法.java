package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 休整战法 extends 主动战法 {
    {
        this.name="休整";
        发动几率=35;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 友方目标 = 选择目标.友方目标(携带者, 3, 2);
        for (Hero hero : 友方目标) {
            com.Service.Fight.state.数值冲突类.特殊恢复类.休整 bean = beanFactory.getBean(com.Service.Fight.state.数值冲突类.特殊恢复类.休整.class);
            bean.init(this,hero,0.6283,0.005,2,携带者.fighting.回合,100);
        }
    }
}
