package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.数值冲突类.特殊恢复类.休整;
import com.Service.Fight.tactic.tool.指挥战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 援军之策 extends 指挥战法 {
    {
        this.name="援军之策";
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 我方目标 = 选择目标.我方目标(携带者, 2, 2);
        休整 bean = beanFactory.getBean(休整.class);
        for (Hero hero : 我方目标) {
            bean.init(this,hero,0.38+(0.38/9)*(战法等级-1),0.007,100,5,100);
        }

    }
}
