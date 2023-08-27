package com.Service.Fight.tactic.tool;
import com.Service.Fight.TimePoint;
import com.Service.Fight.state.State;
import com.Service.Fight.tactic.Tactic;


public class 主动战法 extends Tactic {
    public boolean 准备战法=false;
    public int 准备回合;
    public boolean 是否准备 = false;
    public int 剩余准备回合;
    {
        this.type=TacticType.主动战法;
    }
    @Override
    public void start() {
        if (!判断阵亡()) {
            //试图发动主动战法
            for (int i = 0; i < 携带者.states.size(); i++) {
                State state = 携带者.states.get(i);
                state.start(TimePoint.试图发动主动战法);
            }
            if (准备战法) {
                if (this.是否准备) {
                    if (剩余准备回合 - 1 <= 0) {
                        战报工具.demo(携带者.fighting,携带者,"发动",this.name);
                        战法逻辑();
                        //发动主动战法后时间点
                        for (int i = 0; i < 携带者.states.size(); i++) {
                            State state =  携带者.states.get(i);
                            state.start(TimePoint.发动主动战法后);
                        }
                        是否准备 = false;
                    } else {
                        剩余准备回合 -= 1;

                    }
                } else {
                    if (判断战法是否发动()) {
                        //准备战法开始准备时间点
                        for (int i = 0; i < 携带者.states.size(); i++) {
                            State state = 携带者.states.get(i);
                            state.start(TimePoint.发动准备战法前);
                        }
                        战报工具.demo(携带者.fighting,携带者,"的战法",this.name,"开始准备");
                        是否准备 = true;
                        剩余准备回合 = 准备回合;

                    }
                }
            } else {
                if (判断战法是否发动()) {
                    战报工具.demo(携带者.fighting,携带者,"发动战法",this.name);
                    战法逻辑();
                    //发动主动战法后时间点
                    for (int i = 0; i < 携带者.states.size(); i++) {
                        State state =  携带者.states.get(i);
                        state.start(TimePoint.发动主动战法后);
                    }
                }
            }
        }
    }
}
