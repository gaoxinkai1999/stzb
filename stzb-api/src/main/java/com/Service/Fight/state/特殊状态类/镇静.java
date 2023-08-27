package com.Service.Fight.state.特殊状态类;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.tactic.tool.TacticType;
import com.Service.Fight.tools.战报;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 镇静 {
    @Autowired
    public 战报 战报工具;

    public void start(Hero hero, TacticType[] tacticTypes) {
        战报工具.demo(hero.fighting,hero,"受到了镇静");
        boolean 是否移除了效果=false;
        for (State state : hero.states) {
            //状态没有失效,且是有害效果，且不是自残
            if (!state.isDie&&state.有害效果&&state.所在战法.携带者!= state.作用者){
                for (TacticType tacticType : tacticTypes) {
                    if (state.所在战法.type==tacticType){
                        state.isDie=true;
                        战报工具.demo(hero.fighting,hero,"消除了",state.type,"效果");
                        if (!是否移除了效果){
                            是否移除了效果=true;
                        }
                    }
                }

            }
        }
        if (!是否移除了效果){
            战报工具.demo(hero.fighting,hero,"没有有害效果可以移除");
        }

    }
}
