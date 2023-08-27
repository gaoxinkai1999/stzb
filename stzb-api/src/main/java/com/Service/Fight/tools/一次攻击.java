package com.Service.Fight.tools;

import com.Service.Fight.TimePoint;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.制造伤害类.造成单次攻击伤害;
import com.Service.Fight.state.制造伤害类.造成单次谋略伤害;
import com.Service.Fight.state.延迟伤害类.延迟攻击伤害;
import com.Service.Fight.state.延迟伤害类.延迟谋略伤害;
import com.Service.Fight.state.数值冲突类.特殊伤害类.特殊攻击伤害类.动摇;
import com.Service.Fight.state.数值冲突类.特殊伤害类.特殊谋略伤害类.特殊谋略伤害;
import com.Service.Fight.tactic.Tactic;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 一次攻击 {
    @Autowired
    public BeanFactory beanFactory;

    public ArrayList<造成单次攻击伤害> 一次物理攻击(ArrayList<Hero> 目标, Tactic 所在战法,Hero 攻击者,double 伤害率){
        ArrayList<造成单次攻击伤害> 造成单次攻击伤害s = new ArrayList<>();
        for (Hero hero : 目标) {
            造成单次攻击伤害 bean = beanFactory.getBean(造成单次攻击伤害.class);
            bean.init(所在战法,攻击者,hero,伤害率);
            bean.start();
            造成单次攻击伤害s.add(bean);
        }
    //造成一次物理攻击后判断
        for (int i = 0; i < 攻击者.states.size(); i++) {
            State state = 攻击者.states.get(i);
            state.start(TimePoint.造成一次攻击后);
        }
        return 造成单次攻击伤害s;
    }
    public ArrayList<造成单次谋略伤害> 一次谋略攻击(ArrayList<Hero> 目标,Tactic 所在战法,Hero 攻击者,double 基础伤害率,double 伤害率增长率){
        ArrayList<造成单次谋略伤害> 造成单次谋略伤害s = new ArrayList<>();
        for (Hero hero : 目标) {
            造成单次谋略伤害 bean = beanFactory.getBean(造成单次谋略伤害.class);
            bean.init(所在战法,攻击者,hero,基础伤害率,伤害率增长率);
            bean.start();
            造成单次谋略伤害s.add(bean);
        }
        //造成一次谋略攻击后判断
        for (int i = 0; i < 攻击者.states.size(); i++) {
            State state = 攻击者.states.get(i);
            state.start(TimePoint.造成一次谋略攻击后);
        }
        return 造成单次谋略伤害s;

    }
    public ArrayList<特殊谋略伤害> 一次特殊谋略攻击(String type,ArrayList<Hero> 目标,Tactic 所在战法,double 基础伤害率,double 伤害率增长率,int 持续时间){
        ArrayList<特殊谋略伤害> 特殊谋略伤害= new ArrayList<特殊谋略伤害>();
        for (Hero hero : 目标) {
            特殊谋略伤害 bean = beanFactory.getBean(type, 特殊谋略伤害.class);
            bean.init(所在战法,hero,基础伤害率,伤害率增长率,持续时间);
            特殊谋略伤害.add(bean);
        }
        //造成一次谋略攻击后判断
        for (int i = 0; i < 所在战法.携带者.states.size(); i++) {
            State state = 所在战法.携带者.states.get(i);
            state.start(TimePoint.造成一次谋略攻击后);
        }
        return 特殊谋略伤害;
    }
    public ArrayList<动摇> 一次动摇(ArrayList<Hero> 目标, Tactic 所在战法, double 伤害率,int 持续时间){
        ArrayList<动摇> 动摇= new ArrayList<动摇>();
        for (Hero hero : 目标) {
            动摇 bean = beanFactory.getBean(动摇.class);
            bean.init(所在战法,hero,伤害率,持续时间);
            动摇.add(bean);
        }
        //造成一次谋略攻击后判断
        for (int i = 0; i < 所在战法.携带者.states.size(); i++) {
            State state = 所在战法.携带者.states.get(i);
            state.start(TimePoint.造成一次攻击后);
        }
        return 动摇;
    }
    public ArrayList<延迟攻击伤害> 一次延迟攻击伤害(ArrayList<Hero> 目标,Tactic 所在战法,Hero 攻击者,double 伤害率){
        ArrayList<延迟攻击伤害> 延迟攻击伤害s = new ArrayList<>();
        for (Hero hero : 目标) {
            延迟攻击伤害 bean = beanFactory.getBean(延迟攻击伤害.class);
            bean.init(所在战法,hero,伤害率);
            延迟攻击伤害s.add(bean);

        }
        //造成一次攻击后判断
        for (int i = 0; i < 攻击者.states.size(); i++) {
            State state = 攻击者.states.get(i);
            state.start(TimePoint.造成一次攻击后);
        }
        return 延迟攻击伤害s;

    }
    public ArrayList<延迟谋略伤害> 一次延迟谋略伤害(ArrayList<Hero> 目标,Tactic 所在战法,Hero 攻击者,double 基础伤害率,double 伤害率增长率){
        ArrayList<延迟谋略伤害> 延迟谋略伤害s = new ArrayList<>();
        for (Hero hero : 目标) {
            延迟谋略伤害 bean = beanFactory.getBean(延迟谋略伤害.class);
            bean.init(所在战法,hero, 基础伤害率,伤害率增长率);
            延迟谋略伤害s.add(bean);

        }
        //造成一次谋略攻击后判断
        for (int i = 0; i < 攻击者.states.size(); i++) {
            State state = 攻击者.states.get(i);
            state.start(TimePoint.造成一次谋略攻击后);
        }
        return 延迟谋略伤害s;

    }
}
