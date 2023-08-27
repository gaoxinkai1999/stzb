package com.PoJo;

import org.springframework.stereotype.Component;

@Component
public class 开荒预设 {
    public String 赛季类型;
    public int 土地等级;
    public String 阵容名;
    public String 阵容配置;
    public 开荒预设(){

    }

//    public 开荒预设(String 赛季类型, int 土地等级, String 阵容名, String 阵容配置) {
//        this.赛季类型 = 赛季类型;
//        this.土地等级 = 土地等级;
//        this.阵容名 = 阵容名;
//        this.阵容配置 = 阵容配置;
//    }

    @Override
    public String toString() {
        return "开荒预设{" +
                "赛季类型='" + 赛季类型 + '\'' +
                ", 土地等级=" + 土地等级 +
                ", 阵容名='" + 阵容名 + '\'' +
                ", 阵容配置='" + 阵容配置 + '\'' +
                '}';
    }
}
