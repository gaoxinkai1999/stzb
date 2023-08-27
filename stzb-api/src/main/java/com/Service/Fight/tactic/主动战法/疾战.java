package com.Service.Fight.tactic.主动战法;

import com.Service.Fight.state.特殊状态类.免疫怯战;
import com.Service.Fight.state.特殊状态类.连击;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tactic.tool.追击战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 疾战 extends 主动战法 {
    {
        this.name="疾战";
        this.发动几率=40;
        准备战法=false;
    }

    @Override
    public void 战法逻辑() {
        连击 bean = beanFactory.getBean(连击.class);
        bean.init(this,携带者);
        bean.持续时间=1;
        免疫怯战 bean1 = beanFactory.getBean(免疫怯战.class);
        bean1.init(this,携带者,1);
    }
}
