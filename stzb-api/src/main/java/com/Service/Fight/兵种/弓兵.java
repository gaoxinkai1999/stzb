package com.Service.Fight.兵种;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.伤害计算变化类.伤害计算变化父类;
import com.Service.Fight.state.制造伤害类.制造伤害父类;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 弓兵 extends 兵种{
    @Override
    public void start(Hero hero) {
        hero.states.add(beanFactory.getBean(弓兵减伤.class));
    }
}
@Component
@Scope("prototype")
class 弓兵减伤 extends 伤害计算变化父类{

    @Override
    public void 改变伤害(制造伤害父类 伤害) {
        if (this.作用者 == 伤害.所在战法.携带者&&伤害.作用者.兵种 instanceof 步兵){
            伤害.增减伤-=0.25;
        }
    }

    @Override
    public void 失效() {

    }
}
