package com.Service.Fight.tactic.被动战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.state.伤害计算变化类.造成的攻击伤害增加;
import com.Service.Fight.tactic.tool.被动战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 愈战愈勇 extends 被动战法 {
    {
        this.name="愈战愈勇";
    }

    @Override
    public void 战法逻辑() {
        造成的攻击伤害增加 bean = beanFactory.getBean(造成的攻击伤害增加.class);
        bean.init(this,携带者,100,0.1);
        bean.配置刷新(true,0.1, TimePoint.回合开始,100);
    }
}
