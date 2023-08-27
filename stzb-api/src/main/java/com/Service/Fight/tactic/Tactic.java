package com.Service.Fight.tactic;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.tactic.tool.TacticType;
import com.Service.Fight.tools.一次攻击;
import com.Service.Fight.tools.战报;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 战法类父类
 */
@Component
@Scope("prototype")
public  abstract class Tactic {
    @Autowired
    public BeanFactory beanFactory;
    @Autowired
    public 战报 战报工具;
    public int 伤害;
    public int 治疗;
    public int 战法等级;
    @Autowired
    public 一次攻击 发动一次攻击;
    @Getter
    public String name;
    public double 发动几率;

    public TacticType type;


    @Setter
    @Getter
    public Hero 携带者;
    public void start(){
    }
    public boolean 判断战法是否发动() {
        double 士气效果=(携带者.士气-100)/(100-0.5*(携带者.士气));
        double random = Math.random() * 100;
        return random <= 发动几率*(1+士气效果);
    }
    public  boolean 判断效果是否发动(double 几率) {
        double 士气效果=(携带者.士气-100)/(100-0.5*(携带者.士气));
        double random = Math.random() * 100;
        return random <= 几率*(1+士气效果);
    }

    public boolean 判断阵亡(){
        return 携带者.isDie;
    }
    public void 战法逻辑(){

    }

    @Override
    public String toString() {
        return  name +" 造成伤害: "+伤害+" 恢复:"+治疗;
    }

}
