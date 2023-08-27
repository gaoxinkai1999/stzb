package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.state.数值冲突类.基础属性变化类.攻击提高;
import com.Service.Fight.state.数值冲突类.基础属性变化类.谋略提高;
import com.Service.Fight.state.数值冲突类.基础属性变化类.速度提高;
import com.Service.Fight.state.数值冲突类.基础属性变化类.防御提高;
import com.Service.Fight.tactic.tool.被动战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 百战精兵 extends 被动战法 {
    {
        this.name="百战精兵";
    }

    @Override
    public void 战法逻辑() {
        攻击提高 攻击 = beanFactory.getBean(攻击提高.class);
        攻击.init(this,携带者,16+(16.0/9)*(战法等级-1),100);
        谋略提高 谋略 = beanFactory.getBean(谋略提高.class);
        谋略.init(this,携带者,16+(16.0/9)*(战法等级-1),100);
        防御提高 防御= beanFactory.getBean(防御提高.class);
        防御.init(this,携带者,16+(16.0/9)*(战法等级-1),100);
        速度提高 速度 = beanFactory.getBean(速度提高.class);
        速度.init(this,携带者,16+(16.0/9)*(战法等级-1),100);
    }
}
