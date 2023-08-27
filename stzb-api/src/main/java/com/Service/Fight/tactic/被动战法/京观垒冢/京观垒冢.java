package com.Service.Fight.tactic.被动战法.京观垒冢;

import com.Service.Fight.tactic.tool.被动战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 京观垒冢 extends 被动战法 {
    {
        this.name = "京观垒冢";
    }

    @Override
    public void 战法逻辑() {
        京观垒冢效果 bean = beanFactory.getBean(京观垒冢效果.class);
        bean.init(this,携带者);
    }
}
