package com.Service.Fight.tactic.主动战法;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.制造伤害类.急救;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tools.选择目标;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
@Scope("prototype")
public class 三军之众 extends 主动战法 {
    {
        this.name = "三军之众";
        this.发动几率 = 45;
        this.准备战法 = true;
        this.准备回合 = 1;
    }

    @Override
    public void 战法逻辑() {

        ArrayList<Hero> 我方目标 = 选择目标.我方目标(this.携带者, 3, 5);
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            Hero 治疗目标;
            ArrayList<Hero> 伤兵武将 = 选择目标.筛选存在伤兵武将(我方目标);
            if (!伤兵武将.isEmpty()) {

                int num = random.nextInt(伤兵武将.size());
                治疗目标 = 伤兵武将.get(num);

            } else {
                治疗目标 = 选择目标.我方目标(this.携带者, 3, 1).get(0);
            }
            急救 bean = beanFactory.getBean(急救.class);
            bean.init(this, 治疗目标, 1.51, 0.01575);
            bean.start();


        }

    }
}
