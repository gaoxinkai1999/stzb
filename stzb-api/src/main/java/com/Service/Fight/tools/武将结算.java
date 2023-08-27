package com.Service.Fight.tools;

import com.Service.Fight.hero.Hero;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope
public class 武将结算 {
   public String name;
   public int heroId;
   public int 初始兵力;
   public int 平均剩余兵力;
   public int 重伤次数;

   public int 普攻杀伤;

   public ArrayList<战法结算> 战法结算s=new ArrayList<>();

   @Override
   public String toString() {
      return "武将结算{" +
              "name='" + name + '\'' +
              ", 初始兵力=" + 初始兵力 +
              ", 平均剩余兵力=" + 平均剩余兵力 +
              ", 重伤次数=" + 重伤次数 +
              ", 普攻杀伤=" + 普攻杀伤 +
              ", 战法结算s=" + 战法结算s +
              '}';
   }
}
