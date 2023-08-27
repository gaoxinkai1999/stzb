package com.Service.Fight.tactic.指挥战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.数值冲突类.特殊恢复类.休整;
import com.Service.Fight.tactic.tool.指挥战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 洛水佳人 extends 指挥战法 {
    {
        this.name="洛水佳人";
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 我方目标 = 选择目标.我方目标(this.携带者, 3, 3);
        for (Hero hero : 我方目标) {
            休整 bean = beanFactory.getBean(休整.class);
            bean.init(this,hero,0.425+(0.425/9)*(战法等级-1),0.0075,10,1,75);
        }
    }
}
