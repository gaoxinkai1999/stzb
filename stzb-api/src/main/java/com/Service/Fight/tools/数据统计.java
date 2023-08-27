package com.Service.Fight.tools;

import com.Service.Fight.Fighting;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.tactic.Tactic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 数据统计 {
   public 战斗结算 result=new 战斗结算();
   public Fighting last_fighting ;

    public void init(ArrayList<武将初始化模板> 模板s){



        for (武将初始化模板 模板 : 模板s) {
            武将结算 武将结算 = new 武将结算();
            武将结算.name= 模板.name;
            武将结算.heroId= 模板.heroId;
            武将结算.初始兵力= 模板.兵力;;

            for (战法初始化模板 s : 模板.战法) {
                战法结算 战法结算 = new 战法结算();
                战法结算.name=s.name;
                武将结算.战法结算s.add(战法结算);
            }
            战法结算 主战法结算 = new 战法结算();
            主战法结算.name=模板.主战法.name;
            武将结算.战法结算s.add(主战法结算);

            result.武将结算s.add(武将结算);

        }

    }
    public void 结算(){
//        result.平均剩余总兵力= result.平均剩余总兵力/result.战斗次数;

        for (武将结算 hero : result.武将结算s) {
            hero.平均剩余兵力=hero.平均剩余兵力/ result.战斗次数;
            hero.普攻杀伤=hero.普攻杀伤/ result.战斗次数;
            for (战法结算 tactic : hero.战法结算s) {
                tactic.伤害= tactic.伤害/ result.战斗次数;
                tactic.治疗= tactic.治疗/ result.战斗次数;
            }
        }
    }

    public void 添加数据(Fighting fighting){
//        if (fighting==last_fighting){
//            System.out.println(fighting.战斗信息);
//            return;
//        }
        //战斗数据
        //判断平局，胜利或失败
        boolean 我方大营阵亡 = false;
        boolean 敌方大营阵亡=false;
        for (Hero hero : fighting.heroes) {
            if (hero.isDie&&hero.heroId==1){
                我方大营阵亡=true;
                break;
            }else if (hero.isDie&&hero.heroId==6){
                敌方大营阵亡=true;
                break;
            }
        }
        if (我方大营阵亡){
            result.战败数+=1;
        } else if (敌方大营阵亡) {
            result.获胜数+=1;
        }else {
            result.平局数+=1;
        }

        //武将数据
        for (武将结算 武将结算 : result.武将结算s) {
            for (Hero hero : fighting.heroes) {
                if (武将结算.heroId==hero.heroId){
                    武将结算.平均剩余兵力+=hero.兵力;
                    武将结算.普攻杀伤+=hero.普攻.伤害;
                    //重伤数
                    if (hero.isDie){
                        武将结算.重伤次数+=1;
                    }
                    //战法数据
                    for (战法结算 战法结算 : 武将结算.战法结算s) {
                        for (Tactic tactic : hero.tactics) {
                            if (tactic.name.equals(战法结算.name)){
                                //找到同一个战法
                                //录入数据
                                战法结算.伤害+= tactic.伤害;
                                战法结算.治疗+= tactic.治疗;
                            }
                        }
                    }
                }
            }
        }
        last_fighting=fighting;
    }
}
