package com.PoJo;

import lombok.Data;

@Data
public class HeroInfo {
    private String name;
    private int 星级;
    private char sex;
    private char 阵营;
    private int 攻击距离;
    private String 原始兵种;
    private String 进阶兵种1;
    private String 进阶兵种2;
    private String 主战法;
    private float 攻击基础;
    private float 防御基础;
    private float 谋略基础;
    private float 速度基础;
    private float 攻击成长;
    private float 防御成长;
    private float 谋略成长;
    private float 速度成长;


}
