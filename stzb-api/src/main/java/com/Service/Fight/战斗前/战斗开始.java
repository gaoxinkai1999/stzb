package com.Service.Fight.战斗前;

import com.Service.Fight.hero.Hero;

import java.util.ArrayList;

public class 战斗开始 {
    public static void start(ArrayList<Hero> heroes){
        ArrayList<Hero> 攻击方=new ArrayList<>();
        ArrayList<Hero> 防守方 =new ArrayList<>();
        for (Hero hero : heroes) {
            if (hero.所属队伍.equals("攻击方")){
                攻击方.add(hero);
            }else {
                防守方.add(hero);
            }
        }
        阵营加成.start(攻击方);
        阵营加成.start(防守方);
    }
}
