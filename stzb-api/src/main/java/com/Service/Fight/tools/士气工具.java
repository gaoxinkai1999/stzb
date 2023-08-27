package com.Service.Fight.tools;

import com.Service.Fight.hero.Hero;

public class 士气工具 {
    public static void a(Hero hero){
        double 效果=(hero.士气-100)/(100-0.5*(hero.士气));
    }
}
