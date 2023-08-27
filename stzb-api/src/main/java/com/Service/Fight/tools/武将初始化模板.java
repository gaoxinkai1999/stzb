package com.Service.Fight.tools;


import com.Service.Fight.Fighting;
import com.Service.Fight.hero.Hero;
import com.Service.Fight.tactic.Tactic;
import com.Service.Fight.tactic.普通攻击;
import com.Service.Fight.兵种.兵种;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
@Scope("prototype")
public class 武将初始化模板 {

    public String name;
    public double 攻击;
    public double 谋略;
    public double 防御;
    public double 速度;
    public int 兵力;
    public String 所属队伍;
    public 战法初始化模板 主战法;
    public int 攻击距离;
    public String 阵营;
    public ArrayList<战法初始化模板> 战法;
    public int heroId;
    public String 位置;
    public String 兵种;
    public Hero init(Fighting fighting,BeanFactory beanFactory) {
        Hero bean = beanFactory.getBean(Hero.class);
//        Hero bean = new Hero();
        bean.fighting = fighting;
        bean.name = this.name;
        bean.攻击 = this.攻击;
        bean.防御 = this.防御;
        bean.谋略 = this.谋略;
        bean.速度 = this.速度;
        bean.兵力 = this.兵力;
        bean.所属队伍 = this.所属队伍;
        bean.攻击距离 = this.攻击距离;
        bean.阵营 = this.阵营;
        Tactic tactic = beanFactory.getBean(主战法.name, Tactic.class);
        tactic.战法等级= 主战法.等级;
        tactic.携带者 = bean;
        bean.tactics.add(tactic);
        for (战法初始化模板 战法模板 : 战法) {
            Tactic tactic1 = beanFactory.getBean(战法模板.name, Tactic.class);
            tactic1.战法等级= 战法模板.等级;
            tactic1.携带者 = bean;
            bean.tactics.add(tactic1);
        }
        bean.heroId = this.heroId;
        bean.位置 = this.位置;
        bean.兵种 = beanFactory.getBean(this.兵种, com.Service.Fight.兵种.兵种.class);
        普通攻击 bean1 = beanFactory.getBean(普通攻击.class);
        bean1.携带者 = bean;
        bean.普攻 = bean1;
        return bean;

    }

    public void build(String name, double 攻击, double 谋略, double 防御, double 速度, int 兵力, int 攻击距离,
                      String 所属队伍, String 阵营, String 位置, int heroId, ArrayList<战法初始化模板> 战法, String 兵种) {
        this.name = name;
        this.攻击 = 攻击;
        this.谋略 = 谋略;
        this.防御 = 防御;
        this.速度 = 速度;
        this.兵力 = 兵力;
        this.攻击距离 = 攻击距离;
        this.所属队伍 = 所属队伍;
        this.阵营 = 阵营;
        this.位置 = 位置;
        this.heroId = heroId;
        this.战法 = 战法;
        this.兵种 = 兵种;
    }

    @Override
    public String toString() {
        return "武将初始化模板{" +
                "name='" + name + '\'' +
                ", 攻击=" + 攻击 +
                ", 谋略=" + 谋略 +
                ", 防御=" + 防御 +
                ", 速度=" + 速度 +
                ", 兵力=" + 兵力 +
                ", 所属队伍='" + 所属队伍 + '\'' +
                ", 主战法=" + 主战法 +
                ", 攻击距离=" + 攻击距离 +
                ", 阵营='" + 阵营 + '\'' +
                ", 战法=" + 战法 +
                ", heroId=" + heroId +
                ", 位置='" + 位置 + '\'' +
                ", 兵种='" + 兵种 + '\'' +
                '}';
    }
}
