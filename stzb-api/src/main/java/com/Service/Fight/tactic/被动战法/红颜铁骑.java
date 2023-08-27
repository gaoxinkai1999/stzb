package com.Service.Fight.tactic.被动战法;

import com.Service.Fight.state.数值冲突类.基础属性变化类.攻击提高;
import com.Service.Fight.state.特殊状态类.连击;
import com.Service.Fight.tactic.tool.被动战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 红颜铁骑 extends 被动战法 {
    {
        this.name="红颜铁骑";
    }

    @Override
    public void 战法逻辑() {
        连击 bean = beanFactory.getBean(连击.class);
        bean.init(this,携带者);
        bean.持续时间=100;
        攻击提高 bean1 = beanFactory.getBean(攻击提高.class);
        bean1.init(this,携带者,15+(15.0/9)*(战法等级-1),100);
    }
}
