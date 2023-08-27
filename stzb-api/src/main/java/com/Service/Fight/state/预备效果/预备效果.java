package com.Service.Fight.state.预备效果;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.state.控制状态类.怯战;
import com.Service.Fight.state.控制状态类.控制;
import com.Service.Fight.state.状态冲突.冲突类型;
import com.Service.Fight.tactic.Tactic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public abstract class 预备效果 extends State {


    {
        this.冲突= 冲突类型.任意类型不叠加;
        this.生效时间点=TimePoint.自身回合前;
        this.结算时间点=TimePoint.自身回合前;
    }
    public Class stateClass;
    public State state;



    @Override
    public void 执行状态逻辑() {
            if (state==null){
                state = beanFactory.getBean(stateClass.getSimpleName(), State.class);
                state.init(所在战法, 作用者);
                state.持续时间=1;
            }else {
                if (state.isDie){
                    state = beanFactory.getBean(stateClass.getSimpleName(), State.class);
                    state.init(所在战法, 作用者);
                    state.持续时间=1;
                }else {
                    state.持续时间+=1;
                }
            }
    }

    public void init(Tactic 所在战法, Hero 作用者, int 生效几率, int 持续时间, int 开始生效回合) {
        super.init(所在战法, 作用者);
        this.生效几率=生效几率;
        this.持续时间=持续时间;
        this.开始生效回合=开始生效回合;

    }
}
