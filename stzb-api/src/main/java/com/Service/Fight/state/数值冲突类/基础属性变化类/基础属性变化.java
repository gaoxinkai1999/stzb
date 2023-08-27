package com.Service.Fight.state.数值冲突类.基础属性变化类;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.数值冲突类.数值冲突;
import com.Service.Fight.tactic.Tactic;
import org.springframework.stereotype.Component;

@Component
public abstract class 基础属性变化 extends 数值冲突 {

    public double 实际数值;
    public void init(Tactic 所在战法, Hero 作用者, double 数值, int 持续时间) {
        this.数值=数值;
        this.持续时间=持续时间;
        super.init(所在战法, 作用者);
        执行();

    }
    public abstract void 执行();
    public abstract void 恢复();

    @Override
    public void 失效前回调() {
        恢复();
    }
    @Override
    public void 施加描述() {
        战报工具.demo(所在战法.携带者.fighting, 作用者, "的", type.name(), "效果已施加,数值为:",数值);
    }
    private boolean 是否刷新=false;
    private double 刷新数值;
    private int 刷新次数;
    @Override
    public void 执行状态逻辑() {
        //刷新效果逻辑
        if (是否刷新&&刷新次数>0){
            刷新次数-=1;
            数值+=刷新数值;
            战报工具.demo(作用者.fighting,作用者,所在战法.name,"的",this.type.name(),"效果刷新了,当前数值为:",数值);
        } else if (是否刷新&&刷新次数==0) {

            战报工具.demo(作用者.fighting,作用者,所在战法.name,"的",this.type.name(),"效果已为最大值");
        }
    }

    public void 配置刷新(boolean 是否刷新,double 刷新数值,TimePoint 刷新时间点,int 刷新次数){
        this.刷新次数=刷新次数;
        this.是否刷新=是否刷新;
        this.刷新数值=刷新数值;
        this.生效时间点=刷新时间点;
    }

    @Override
    public void 生效描述() {

    }
}
