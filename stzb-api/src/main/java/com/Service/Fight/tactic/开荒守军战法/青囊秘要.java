package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.state.数值冲突类.特殊恢复类.休整;
import com.Service.Fight.tactic.tool.被动战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 青囊秘要 extends 被动战法 {
    {
        this.name="青囊秘要";
    }

    @Override
    public void 战法逻辑() {
        休整 bean = beanFactory.getBean(休整.class);
        bean.init(this,携带者,0.75+(0.75/9)*(战法等级-1),0,100,1,100);
    }
}
