package com.Service.Fight.tools;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class 战斗结算 {
    public ArrayList<武将结算> 武将结算s=new ArrayList<>();
    public int 战斗次数;
    public int 平局数;
    public int 获胜数;
    public int 战败数;
//    public int 初始总兵力;
//    public int 平均剩余总兵力;

    @Override
    public String toString() {
        return "战斗结算{" +
                "武将结算s=" + 武将结算s +
                ", 战斗次数=" + 战斗次数 +
                ", 平局数=" + 平局数 +
                ", 获胜数=" + 获胜数 +
                ", 战败数=" + 战败数 +
//                ", 初始总兵力=" + 初始总兵力 +
//                ", 平均剩余总兵力=" + 平均剩余总兵力 +
                '}';
    }
}
