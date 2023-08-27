package com.Service.Fight.tactic.tool;

import com.Service.Fight.tactic.Tactic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 指挥战法 extends Tactic {
    {
        this.type=TacticType.指挥战法;
    }
    @Override
    public void start(){
        战报工具.demo(携带者.fighting,携带者,"发动",this.name);
        战法逻辑();
    }
}
