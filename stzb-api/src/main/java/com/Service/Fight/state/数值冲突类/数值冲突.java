package com.Service.Fight.state.数值冲突类;

import com.Service.Fight.hero.Hero;
import com.Service.Fight.state.State;
import com.Service.Fight.state.状态冲突.冲突类型;
import com.Service.Fight.tactic.Tactic;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public abstract class 数值冲突 extends State {
   public double 数值;
   {
      this.冲突= 冲突类型.数值替换;
   }

}
