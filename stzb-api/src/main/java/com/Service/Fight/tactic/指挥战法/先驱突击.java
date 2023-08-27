package com.Service.Fight.tactic.指挥战法;

import com.Service.Fight.state.数值冲突类.基础属性变化类.攻击提高;
import com.Service.Fight.state.预备效果.先手预备;
import com.Service.Fight.state.预备效果.连击预备;
import com.Service.Fight.tactic.tool.指挥战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 先驱突击 extends 指挥战法 {
    {
        this.name="先驱突击";
    }

    @Override
    public void 战法逻辑() {
        先手预备 bean = beanFactory.getBean(先手预备.class);
        bean.init(this,携带者,100,3,1);
        连击预备 bean1 = beanFactory.getBean(连击预备.class);
        bean1.init(this,携带者,100,3,1);
        攻击提高 bean2 = beanFactory.getBean(攻击提高.class);
        bean2.init(this,携带者,15+ 15/9 *(战法等级-1),3);
    }
}
