package com.Service.Fight.tactic.被动战法;

import com.Service.Fight.state.伤害计算变化类.造成的攻击伤害增加;
import com.Service.Fight.state.控制状态类.犹豫;
import com.Service.Fight.tactic.tool.被动战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 血溅黄砂 extends 被动战法 {
    {
        this.name="血溅黄砂";
    }

    @Override
    public void 战法逻辑() {
        造成的攻击伤害增加 bean = beanFactory.getBean(造成的攻击伤害增加.class);
        bean.init(this,this.携带者,10,1.2);
        犹豫 bean1 = beanFactory.getBean(犹豫.class);
        bean1.init(this,this.携带者,10);
    }
}
