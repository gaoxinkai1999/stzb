package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.state.伤害计算变化类.造成的攻击伤害增加;
import com.Service.Fight.state.制造伤害类.急救;
import com.Service.Fight.state.数值冲突类.基础属性变化类.防御提高;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tactic.tool.主动战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 莽撞 extends 主动战法 {
    {
        this.name="莽撞";
        发动几率=100;
    }

    @Override
    public void 战法逻辑() {
        防御提高 bean = beanFactory.getBean(防御提高.class);
        bean.init(this,携带者,17.5+(17.5/9)*(战法等级-1),0);

        if (this.判断效果是否发动(50)){
            急救 bean1 = beanFactory.getBean(急救.class);
            bean1.init(this,携带者,0.75+(0.75/9)*(战法等级-1),0);
            bean1.start();
        }else {
            造成的攻击伤害增加 bean1 = beanFactory.getBean(造成的攻击伤害增加.class);
            bean1.init(this,携带者,0,0.08+(0.08/9)*(战法等级-1));
        }

    }
}
