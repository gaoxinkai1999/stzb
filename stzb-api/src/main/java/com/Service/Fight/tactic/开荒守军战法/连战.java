package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.state.特殊状态类.连击;
import com.Service.Fight.tactic.tool.主动战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 连战 extends 主动战法 {
    {
        this.name="连战";
        发动几率=(int)(25+(10.0/9)*(5-1));

    }

    @Override
    public void 战法逻辑() {
        连击 bean = beanFactory.getBean(连击.class);
        bean.init(this,携带者);
        bean.持续时间=1;
    }
}
