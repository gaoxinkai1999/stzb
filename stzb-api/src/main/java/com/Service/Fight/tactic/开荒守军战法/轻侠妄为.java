package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.state.伤害计算变化类.造成的攻击伤害增加;
import com.Service.Fight.state.特殊状态类.洞察;
import com.Service.Fight.tactic.tool.指挥战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 轻侠妄为 extends 指挥战法 {
    {
        this.name="轻侠妄为";
    }

    @Override
    public void 战法逻辑() {
        洞察 bean = beanFactory.getBean(洞察.class);
        bean.init(this,携带者,3);
        造成的攻击伤害增加 bean1 = beanFactory.getBean(造成的攻击伤害增加.class);
        bean1.init(this,携带者,3,0.2+(0.2/9)*(战法等级-1));
    }
}
