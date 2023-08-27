package com.Service.Fight.tactic.开荒守军战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.伤害计算变化类.造成的主动战法伤害增加;
import com.Service.Fight.state.伤害计算变化类.造成的追击战法伤害增加;
import com.Service.Fight.tactic.tool.追击战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 行樵偶遇 extends 追击战法 {
    {
        this.name="行樵偶遇";
        发动几率=50;
    }

    @Override
    public void 战法逻辑() {
        ArrayList<Hero> 目标=new ArrayList<>();
        目标.add(携带者.普攻.普攻目标);
        发动一次攻击.一次物理攻击(目标,this,携带者,0.25+(0.25/9)*(战法等级-1));
        ArrayList<Hero> 友方目标 = 选择目标.友方目标(携带者, 5, 1);
        for (Hero hero : 友方目标) {
            造成的主动战法伤害增加 bean = beanFactory.getBean(造成的主动战法伤害增加.class);
            bean.init(this,hero,2,0.105+(0.105/9)*(战法等级-1));
            造成的追击战法伤害增加 bean1 = beanFactory.getBean(造成的追击战法伤害增加.class);
            bean1.init(this,hero,2,0.105+(0.105/9)*(战法等级-1));
        }


    }
}
