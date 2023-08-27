package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.state.数值冲突类.基础属性变化类.攻击提高;
import com.Service.Fight.state.数值冲突类.基础属性变化类.攻击距离提高;
import com.Service.Fight.tactic.tool.被动战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 远攻强化 extends 被动战法 {
    {
        this.name="远攻强化";
    }

    @Override
    public void 战法逻辑() {
        攻击距离提高 bean = beanFactory.getBean(攻击距离提高.class);
        bean.init(this,携带者,1,100);
        攻击提高 bean1 = beanFactory.getBean(攻击提高.class);
        bean1.init(this,携带者,7.5+(7.5/9)*(战法等级-1),100);
    }
}
