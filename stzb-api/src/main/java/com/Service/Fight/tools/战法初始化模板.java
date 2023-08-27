package com.Service.Fight.tools;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 战法初始化模板 {
    public String name;
    public int 等级;
    public 战法初始化模板(String name,int 等级){

    }
    public 战法初始化模板(){

    }

    @Override
    public String toString() {
        return "战法初始化模板{" +
                "name='" + name + '\'' +
                ", 等级=" + 等级 +
                '}';
    }
}
