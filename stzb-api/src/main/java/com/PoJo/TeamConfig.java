package com.PoJo;

import org.springframework.stereotype.Component;

@Component
public class TeamConfig {
    public String id;
    public String 阵容名;
    public String 阵容配置;

    public TeamConfig() {

    }

    public TeamConfig(String id, String 阵容名, String 阵容配置) {
        this.id = id;
        this.阵容名 = 阵容名;
        this.阵容配置 = 阵容配置;
    }

    @Override
    public String toString() {
        return "TeamConfig{" +
                "id='" + id + '\'' +
                ", 阵容名='" + 阵容名 + '\'' +
                ", 阵容配置='" + 阵容配置 + '\'' +
                '}';
    }
}
