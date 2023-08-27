package com.Service.Fight.tactic.tool;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.tactic.Tactic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 追击战法 extends Tactic {
    {
        this.type=TacticType.追击战法;
    }

    public void start(){
        if (判断战法是否发动()){
            战报工具.demo(携带者.fighting,携带者,"发动战法",this.name);
            战法逻辑();
            //发动追击战法后时间点
            for (int i = 0; i < 携带者.states.size(); i++) {
                State state = 携带者.states.get(i);
                state.start(TimePoint.发动追击战法后);
            }
        }
    }
}
