package com.Service.Fight;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import com.Service.Fight.tools.战报;
import com.Service.Fight.tools.战斗结算;
import com.Service.Fight.tools.数据统计;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;

@Component
@Scope("prototype")
public class Fighting {

    @Autowired
    private 战报 战报工具;
    public ArrayList<Hero> heroes = new ArrayList<>();

    public 数据统计 统计;
    public int 回合;

    public boolean gameover = false;
    public StringBuilder 战斗信息 = new StringBuilder();

    public void start() {
        for (Hero hero : heroes) {
            if (hero.所属队伍.equals("攻击方")){
                战报工具.demo(this,"[攻方]",hero,"  ", hero.tactics,"  ","兵力:",hero.兵力);
            }
            if (hero.所属队伍.equals("防守方")){
                战报工具.demo(this,"[守方]",hero,"  ", hero.tactics,"  ","兵力:",hero.兵力);
            }
        }

        for (回合 = -1; 回合 < 9; 回合++) {
            if (gameover) {
                return;
            }
            switch (回合) {
                case -1: {
                    战报工具.demo(this, "战斗开始");
                    for (Hero hero : heroes) {
                        hero.兵种.start(hero);
                    }
                    break;
                }
                case 0: {
                    战报工具.demo(this, "战前准备回合");
                    break;
                }

                default:
                    战报工具.demo(this, "第", 回合, "回合");
            }
            //每回合伤兵衰减
            for (Hero hero : heroes) {
                hero.伤兵 = (int) (hero.伤兵 * 0.87);
            }
            if (回合 >= 1) {
                //回合开始状态
                for (Hero hero : heroes) {
                    if (!hero.isDie) {
                        for (int i = 0; i < hero.states.size(); i++) {
                            State state = hero.states.get(i);
                            state.start(TimePoint.回合开始);
                        }
                    }

                }
            }
            行动排序();
            for (Hero hero : heroes) {
                hero.start();
            }
            //回合结束状态
            if (回合 >= 1) {
                for (Hero hero : heroes) {
                    if (!hero.isDie) {
                        for (int i = 0; i < hero.states.size(); i++) {
                            State state = hero.states.get(i);
                            state.start(TimePoint.回合结束);
                        }
                    }

                }
            }

        }
        if (gameover==false){
            over();
        }

    }

    private void 行动排序() {
        heroes.sort(new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                //不先手为0
                int 一号先手=0;
                int 二号先手=0;
                for (State state : o1.states) {
                    if (!state.isDie && state.type == StateType.先手) {
                        一号先手 = 1;
                        break;
                    }
                }
                for (State state : o2.states) {
                    if (!state.isDie && state.type == StateType.先手) {
                        二号先手 = 1;
                        break;
                    }
                }
                if (一号先手==二号先手){
                    return Double.compare(o2.速度, o1.速度);
                }else {
                    return 二号先手-一号先手;
                }
            }
        });
    }
    private void 位置排序(){
        ArrayList<Hero> clone = (ArrayList<Hero>) heroes.clone();
        clone.sort(new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                return Integer.compare(o1.heroId, o2.heroId);
            }
        });
    }
    public void over(){
        战报工具.demo(this, "****************游戏结束");
        统计.添加数据(this);
        位置排序();
        for (Hero hero : heroes) {
            if (hero.所属队伍.equals("攻击方")){
                战报工具.demo(this,"[攻方]",hero,hero.tactics,hero.普攻,"  剩余兵力:",hero.兵力);
            }
            if (hero.所属队伍.equals("防守方")){
                战报工具.demo(this,"[守方]",hero,hero.tactics,hero.普攻,"  剩余兵力:",hero.兵力);
            }
        }
        gameover=true;
    }
    public void init(){

    }
}
