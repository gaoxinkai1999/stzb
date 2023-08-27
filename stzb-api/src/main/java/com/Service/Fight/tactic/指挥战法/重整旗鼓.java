package com.Service.Fight.tactic.指挥战法;

import com.Service.Fight.tactic.tool.指挥战法;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 重整旗鼓 extends 指挥战法 {
    {
        this.name = "重整旗鼓";
    }
}
