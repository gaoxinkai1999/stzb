package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.特殊状态类.镇静;
import com.Service.Fight.tactic.tool.TacticType;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 顽抗 extends 主动战法 {
    {
        this.name="顽抗";
        this.发动几率=35;
    }

    @Override
    public void 战法逻辑() {
        镇静 bean = beanFactory.getBean(镇静.class);
        bean.start(携带者,new TacticType[]{TacticType.主动战法,TacticType.追击战法});

        ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 2, 1);
        发动一次攻击.一次物理攻击(敌方目标,this,携带者,0.4+(0.4/9)*(战法等级-1));
    }
}
