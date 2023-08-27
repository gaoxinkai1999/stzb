package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.TimePoint;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.制造伤害类.急救;
import com.Service.Fight.state.预备效果.先手预备;
import com.Service.Fight.tactic.tool.被动战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 合众 extends 被动战法 {
    {
        this.name="合众";
    }

    @Override
    public void 战法逻辑() {
        先手预备 bean = beanFactory.getBean(先手预备.class);
        bean.init(this,携带者,100,100,1);
        合众效果 bean1 = beanFactory.getBean(合众效果.class);
        bean1.init(this,携带者);
    }
}
@Component
@Scope("prototype")
class 合众效果 extends State {
    {
        this.type= StateType.合众;
        this.生效时间点= TimePoint.回合开始;
        this.持续时间=100;
    }

    @Override
    public void 执行状态逻辑() {
        if (作用者.fighting.回合==2||作用者.fighting.回合==4||作用者.fighting.回合==6||作用者.fighting.回合==8){
            急救 bean = beanFactory.getBean(急救.class);
            bean.init(所在战法,作用者,1.3+(1.3/9)*(所在战法.战法等级-1),0);
            bean.start();
        }
    }
}
