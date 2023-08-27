package com.Service.Fight.tools;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.StateType;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class 选择目标 {
    public static ArrayList<Hero> 敌方目标(Hero hero, int 距离, int num) {
        ArrayList<Hero> 基本判断 = 基本判断(hero, 距离);
        基本判断.remove(hero);
        if (!检查是否暴走(hero)) {
            Iterator<Hero> iterator = 基本判断.iterator();
            while (iterator.hasNext()) {
                Hero next = iterator.next();
                if (next.所属队伍.equals(hero.所属队伍)) {
                    iterator.remove();
                }
            }
        }
        return 随机截取(基本判断, num);
    }

    public static ArrayList<Hero> 我方目标(Hero hero, int 距离, int num) {
        ArrayList<Hero> 基本判断 = 基本判断(hero, 距离);
        if (!检查是否暴走(hero)) {
            Iterator<Hero> iterator = 基本判断.iterator();
            while (iterator.hasNext()) {
                Hero next = iterator.next();
                if (!next.所属队伍.equals(hero.所属队伍)) {
                    iterator.remove();
                }
            }
        }
        return 随机截取(基本判断, num);
    }

    public static ArrayList<Hero> 友方目标(Hero hero, int 距离, int num) {
        ArrayList<Hero> 基本判断 = 基本判断(hero, 距离);
        基本判断.remove(hero);
        if (!检查是否暴走(hero)) {
            Iterator<Hero> iterator = 基本判断.iterator();
            while (iterator.hasNext()) {
                Hero next = iterator.next();
                if (!next.所属队伍.equals(hero.所属队伍)) {
                    iterator.remove();
                }
            }
        }
        return 随机截取(基本判断, num);
    }

    public static ArrayList<Hero> 敌方大营和中军(Hero hero) {
        ArrayList<Hero> result = new ArrayList<>();
        if (检查是否暴走(hero)) {
            ArrayList<Hero> 大营 = new ArrayList<>();
            ArrayList<Hero> 中军 = new ArrayList<>();
            for (Hero hero1 : hero.fighting.heroes) {
                if (hero1.位置.equals("大营") && !hero1.isDie) {
                    大营.add(hero1);
                }
            }
            for (Hero hero1 : hero.fighting.heroes) {
                if (hero1.位置.equals("中军") && !hero1.isDie) {
                    中军.add(hero1);
                }
            }
            大营= 随机截取(大营,1);
            中军=随机截取(中军,1);
            result.addAll(大营);
            result.addAll(中军);

        } else {
            for (Hero hero1 : hero.fighting.heroes) {
                if (!hero1.所属队伍.equals(hero.所属队伍) &&
                        (hero1.位置.equals("大营") || hero1.位置.equals("中军"))
                        && !hero1.isDie) {
                    result.add(hero1);
                }
            }
        }
        return result;
    }
    public static Hero 友军速度最高(Hero hero){
        ArrayList<Hero>  我方=new ArrayList<>();
        for (Hero hero1 : hero.fighting.heroes) {
            if (hero1!=hero&&hero1.所属队伍.equals(hero.所属队伍)&&!hero1.isDie){
                我方.add(hero1);
            }
        }
        ArrayList<Hero>  敌方=new ArrayList<>();
        for (Hero hero1 : hero.fighting.heroes) {
            if (!hero1.所属队伍.equals(hero.所属队伍)&&!hero1.isDie){
                敌方.add(hero1);
            }
        }
        我方.sort(new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                return Double.compare(o2.速度, o1.速度);
            }
        });
        敌方.sort(new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                return Double.compare(o2.速度, o1.速度);
            }
        });
        if (检查是否暴走(hero)){
            ArrayList<Hero> 两个速度最快=new ArrayList<>();
            两个速度最快.add(我方.get(0));
            两个速度最快.add(敌方.get(0));
            ArrayList<Hero> 随机截取 = 随机截取(两个速度最快, 1);
            return 随机截取.get(0);
        }else {
            return 我方.get(0);
        }


    }

    public static ArrayList<Hero> 分兵目标判断(Hero 分兵主目标) {
        ArrayList<Hero> result = new ArrayList<>();
        for (Hero hero : 分兵主目标.fighting.heroes) {
            //没有阵亡,且与分兵主目标同一队伍，距离相差为1
            if (!hero.isDie && Math.abs(hero.heroId - 分兵主目标.heroId) == 1 && 分兵主目标.所属队伍.equals(hero.所属队伍)) {
                result.add(hero);
            }
        }
        return result;
    }
    public static boolean 反击判断(Hero 反击者,Hero 被击者){
        ArrayList<Hero> 基本判断 = 基本判断(反击者, 反击者.攻击距离);
        return 基本判断.contains(被击者);
    }

    /**
     * 暴走返回true
     *
     * @param hero
     * @return
     */
    private static boolean 检查是否暴走(Hero hero) {
        for (State state : hero.states) {
            if (state.type == StateType.暴走 && !state.isDie) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<Hero> 随机截取(ArrayList<Hero> heroes, int num) {
        if (heroes.size() <= num) {
            return heroes;
        } else {
            ArrayList<Hero> result = new ArrayList<>();
            int a = 0;
            while (true) {
                int i = new Random().nextInt(heroes.size());
                if (!result.contains(heroes.get(i))) {
                    result.add(heroes.get(i));
                    a += 1;
                }
                if (a == num) {
                    return result;
                }
            }
        }
    }

    /**
     * 判断攻击距离,判断是否阵亡
     *
     * @param hero
     * @param 距离
     * @return
     */
    private static ArrayList<Hero> 基本判断(Hero hero, int 距离) {
        ArrayList<Hero> result = new ArrayList<>();
        //添加没有阵亡
        for (Hero hero1 : hero.fighting.heroes) {
            if (!hero1.isDie) {
                result.add(hero1);
            }
        }

        result.sort(new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                return Integer.compare(o1.heroId, o2.heroId);
            }
        });
        Iterator<Hero> sListIterator = result.iterator();
        //判断攻击距离
        while (sListIterator.hasNext()) {
            Hero e = sListIterator.next();
            if (Math.abs(result.indexOf(hero) - result.indexOf(e)) > 距离) {
                sListIterator.remove();
            }
        }
        return result;
    }
    public static Hero 我军兵力最低(Hero hero){
        Hero result = null;
        if (检查是否暴走(hero)){
            for (Hero hero1 : hero.fighting.heroes) {
                if (!hero1.isDie) {
                    if (result==null){
                        result =hero1;
                    }else {
                        if (hero1.兵力<result.兵力){
                            result=hero1;
                        }
                    }
                }
            }
        }else {
            for (Hero hero1 : hero.fighting.heroes) {
                if (!hero1.isDie&&hero1.所属队伍.equals(hero.所属队伍)) {
                    if (result==null){
                        result =hero1;
                    }else {
                        if (hero1.兵力<result.兵力){
                            result=hero1;
                        }
                    }
                }
            }
        }
     return result;
    }

    public static ArrayList<Hero> 筛选存在伤兵武将(ArrayList<Hero>heroes){
        ArrayList<Hero> result = new ArrayList<>();
        for (Hero hero : heroes) {
            if (hero.伤兵>0){
                result.add(hero);
            }
        }
        return result;
    }



}
