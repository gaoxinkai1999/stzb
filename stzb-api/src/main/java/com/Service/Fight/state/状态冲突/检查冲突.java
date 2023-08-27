package com.Service.Fight.state.状态冲突;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.数值冲突类.数值冲突;
import com.Service.Fight.tools.战报;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 检查冲突并添加该状态
 */
@Component
public class 检查冲突 {
    @Autowired
    战报 战报工具;

    public boolean check(State state, Hero 作用者) {
        if (state.冲突 == 冲突类型.任意类型不叠加) {
            for (State state1 : 作用者.states) {
                if (state1.type == state.type && !state1.isDie) {
                    战报工具.demo(作用者.fighting, 作用者, "已存在",state.type,"效果");
                    return false;
                }
            }

        } else if (state.冲突 == 冲突类型.同类型不叠加) {
            for (State state1 : 作用者.states) {
                if (state1.type==state.type&&!state1.isDie&&state.所在战法.type==state1.所在战法.type){
                    战报工具.demo(作用者.fighting, 作用者, "已存在",state.type,"效果");
                    return false;
                }
            }
        } else if (state.冲突 == 冲突类型.数值替换) {
            for (State state1 : 作用者.states) {
                //同类型战法不叠加，但会由更高的效果替代    不同类型可叠加
                if (state1.type==state.type&&!state1.isDie&&state.所在战法.type==state1.所在战法.type){
                    if (((数值冲突)state).数值>((数值冲突)state1).数值){
                        state1.isDie=true;
                        战报工具.demo(作用者.fighting, 作用者,"的",state.type, "效果刷新了");
                        break;
                    }else {
                        战报工具.demo(作用者.fighting, 作用者,"已存在同等或更强的",state.type, "效果");
                        return false;
                    }


                }

            }

        }
        if (state.type!= StateType.造成单次攻击伤害&&state.type!=StateType.造成单次策略伤害&&state.type!=StateType.立即型急救){
            作用者.states.add(state);
        }

        return true;
    }
}
