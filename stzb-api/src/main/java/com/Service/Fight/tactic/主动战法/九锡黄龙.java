package com.Service.Fight.tactic.主动战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.特殊状态类.规避;
import com.Service.Fight.state.特殊状态类.镇静;
import com.Service.Fight.tactic.tool.TacticType;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 九锡黄龙 extends 主动战法 {
    {
        this.name="九锡黄龙";
        this.发动几率=100;
    }
@Autowired
    镇静 镇静工具;
    @Override
    public void 战法逻辑() {

        ArrayList<Hero> 我方目标 = 选择目标.我方目标(携带者, 3, 3);
        for (Hero hero : 我方目标) {
            镇静工具.start(hero,new TacticType[]{TacticType.主动战法,TacticType.追击战法});
            规避 bean = beanFactory.getBean(规避.class);
            bean.init(this,hero,2);
        }
    }
}
