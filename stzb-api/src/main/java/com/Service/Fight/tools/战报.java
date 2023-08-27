package com.Service.Fight.tools;

import com.Service.Fight.Fighting;
import com.Service.Fight.hero.Hero;
import org.springframework.stereotype.Component;

@Component
public class 战报 {
    public void demo(Fighting fighting, Object... objects){
        if (!fighting.gameover){
            for (Object object : objects) {
                if (object instanceof Hero){
                    fighting.战斗信息.append("[").append(((Hero) object).name).append("]");
                }else if (object instanceof Double) {
                    fighting.战斗信息.append( String.format("%.2f", object));
                }else {
                    fighting.战斗信息.append(object);
                }
            }
            fighting.战斗信息.append("\n");
        }

    }
}
