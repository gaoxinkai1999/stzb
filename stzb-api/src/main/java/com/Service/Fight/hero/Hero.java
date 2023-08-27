package com.Service.Fight.hero;

import com.Service.Fight.Fighting;
import com.Service.Fight.TimePoint;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tactic.tool.主动战法;
import com.Service.Fight.tactic.tool.指挥战法;
import com.Service.Fight.tactic.普通攻击;
import com.Service.Fight.tactic.tool.被动战法;
import com.Service.Fight.tools.战报;
import com.Service.Fight.兵种.兵种;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class Hero {


    public BeanFactory beanFactory;
    @Autowired
    public 战报 战报工具;

   public Hero(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
        普通攻击 bean = beanFactory.getBean(普通攻击.class);
        bean.携带者 = this;
        this.普攻 = bean;

    }
    public Hero(){

    }

    public String name;
    public double 攻击;
    public double 谋略;
    public double 防御;
    public double 速度;
    public double 基础攻击;
    public double 基础谋略;
    public double 基础防御;
    public double 基础速度;
    public int 兵力 = 10000;
    public String 位置;
    public int 士气;
    public String 所属队伍;
    public int 攻击距离;
    public int 伤兵;
    public String 阵营;
    public String sex;
    public 兵种 兵种;
    public Fighting fighting;
    public boolean isDie = false;

    public int heroId;
    public ArrayList<String> 战法 = new ArrayList<>();
    public ArrayList<State> states = new ArrayList<>();
    public ArrayList<Tactic> tactics = new ArrayList<>();
    public 普通攻击 普攻;

    public void start() {
        if (isDie) {
            return;
        }
        //战斗开始
        if (fighting.回合 == -1) {
            for (Tactic tactic : tactics) {
                if (tactic instanceof 被动战法) {
                    tactic.start();
                }
            }
        }
        //战前准备回合
        if (fighting.回合 == 0) {
            for (Tactic tactic : tactics) {
                if (tactic instanceof 指挥战法) {
                    tactic.start();
                }
            }
        }

        //正式回合
        if (fighting.回合 > 0) {
//            回合前状态执行
            for (int i = 0; i < states.size(); i++) {
                State state = states.get(i);

                state.start(TimePoint.自身回合前);

            }

            // 判断混乱
            boolean 混乱 = 判断混乱();
            if (混乱){
                战报工具.demo(fighting, this, "无法行动");
                打断准备中战法();
                return;
            }
            //主动战法 先判断犹豫
            boolean 犹豫 = 判断犹豫();
            if (犹豫){
                战报工具.demo(fighting, this, "无法发动主动战法");
                打断准备中战法();
            }else {
                for (Tactic tactic : tactics) {
                    if (tactic instanceof 主动战法) {
                        tactic.start();
                    }
                }
            }
            //普通攻击 先判断怯战
            boolean 怯战 = 判断怯战();
            if (怯战){
                战报工具.demo(fighting, this, "无法普通攻击");
            }else {
                普攻.start();
            }
        }

    }

    public void init(String name, double 攻击, double 谋略, double 防御, double 速度,
                     int 兵力, String 所属队伍, int 攻击距离, String 阵营, Fighting fighting, String[] 战法, int heroID, String 位置,String 兵种) {
        this.位置 = 位置;
        this.heroId = heroID;
        this.name = name;
        this.攻击 = 攻击;
        this.基础攻击 = 攻击;
        this.谋略 = 谋略;
        this.基础谋略 = 谋略;
        this.防御 = 防御;
        this.基础防御 = 防御;
        this.速度 = 速度;
        this.基础速度 = 速度;
        this.兵力 = 兵力;
        this.所属队伍 = 所属队伍;
        this.攻击距离 = 攻击距离;
        this.阵营 = 阵营;
        this.fighting = fighting;
        for (String s : 战法) {
            Tactic tactic = beanFactory.getBean(s, Tactic.class);
            tactic.携带者 = this;
            tactics.add(tactic);
        }
        this.兵种=beanFactory.getBean(兵种,兵种.class);
    }

    public void init(String 所属队伍, Fighting fighting, int heroID) {
        this.heroId = heroID;
        this.所属队伍 = 所属队伍;
        this.fighting = fighting;
        if (!name.isEmpty()) {
            fighting.heroes.add(this);
            return;
        }
//        if (!战法.isEmpty()){
//            for (String s : 战法) {
//                Tactic tactic = beanFactory.getBean(s, Tactic.class);
//                tactic.携带者 = this;
//                tactics.add(tactic);
//            }
//        }

    }
    public void 打断准备中战法(){
        for (Tactic tactic : tactics) {
            if (tactic instanceof 主动战法 && ((主动战法) tactic).是否准备) {
                ((主动战法) tactic).是否准备 = false;
                战报工具.demo(fighting, this, "的战法", tactic.name, "被打断了");
            }
        }
    }
    public boolean 判断怯战(){
        for (State state : states) {
            if (!state.isDie&&state.type==StateType.怯战){
                    if (判断是否自残(state)){
                        return true;
                    }else {
                        return !判断洞察() && !判断免疫怯战();
                    }
            }
        }
        return false;
    }
    public boolean 判断混乱(){
        for (State state : states) {
            if (!state.isDie&&state.type==StateType.混乱){
                if (判断是否自残(state)){
                    return true;
                }else {
                    return !判断洞察();
                }
            }
        }
        return false;
    }
    public boolean 判断犹豫(){
        for (State state : states) {
            if (!state.isDie&&state.type==StateType.犹豫){
                if (判断是否自残(state)){
                    return true;
                }else {
                    return !判断洞察();
                }
            }
        }
        return false;
    }
    public boolean 判断洞察(){
        for (State state : states) {
            if (!state.isDie&&state.type==StateType.洞察){
                战报工具.demo(fighting,this,"处在洞察状态,免疫控制");
                return true;
            }
        }
        return false;
    }
    public boolean 判断免疫怯战(){
        for (State state : states) {
            if (!state.isDie&&state.type==StateType.免疫怯战){
                战报工具.demo(fighting,this,"处在免疫怯战状态");
                return true;
            }
        }
        return false;
    }
    public boolean 判断是否自残(State state){
        return state.所在战法.携带者 == this;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", 攻击=" + 攻击 +
                ", 谋略=" + 谋略 +
                ", 防御=" + 防御 +
                ", 速度=" + 速度 +
                ", 兵力=" + 兵力 +
                ", 位置='" + 位置 + '\'' +
                ", 所属队伍='" + 所属队伍 + '\'' +
                ", 攻击距离=" + 攻击距离 +
                ", 伤兵=" + 伤兵 +
                ", 阵营='" + 阵营 + '\'' +
                ", sex='" + sex + '\'' +
                ", 兵种='" + 兵种 + '\'' +
                ", 战法=" + 战法 +
                '}';
    }
}

