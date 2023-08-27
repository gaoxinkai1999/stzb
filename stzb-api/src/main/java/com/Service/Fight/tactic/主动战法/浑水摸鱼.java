package com.Service.Fight.tactic.主动战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.控制状态类.混乱;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Scope("prototype")
@Component
public class 浑水摸鱼 extends 主动战法 {


    {
        this.name = "浑水摸鱼";
        this.发动几率 = 35;
        this.准备回合=1;
        this.准备战法=true;
    }
    @Override
    public void 战法逻辑(){

                ArrayList<Hero> 敌方目标 = 选择目标.敌方目标(携带者, 4, 2);
                for (Hero hero : 敌方目标) {
                    混乱 bean = beanFactory.getBean(混乱.class);
                    bean.init(this,hero,2);
                }

    }
}
