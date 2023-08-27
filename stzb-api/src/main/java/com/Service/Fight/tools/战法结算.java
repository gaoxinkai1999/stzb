package com.Service.Fight.tools;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 战法结算 {
    public String name;
    public int 伤害;
    public int 治疗;

    @Override
    public String toString() {
        return name + ':' + " 伤害=" + 伤害 + ", 治疗=" + 治疗;
    }
}

