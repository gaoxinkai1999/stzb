package com.Service.Fight.兵种;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.tools.战报;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 兵种 {
    @Autowired
    public BeanFactory beanFactory;
    @Autowired
    private 战报 战报工具;
    public void start(Hero hero){

    }
}
