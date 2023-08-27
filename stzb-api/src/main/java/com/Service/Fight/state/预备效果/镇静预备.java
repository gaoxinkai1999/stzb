package com.Service.Fight.state.预备效果;

import com.Service.Fight.state.StateType;
import com.Service.Fight.state.特殊状态类.镇静;
import com.Service.Fight.state.状态冲突.冲突类型;
import com.Service.Fight.tactic.tool.TacticType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class 镇静预备 extends 预备效果 {


    {
        this.type = StateType.镇静预备;
        this.冲突 = 冲突类型.任意类型不叠加;
    }

    @Autowired
    镇静 镇静工具;

    TacticType[] tacticTypes;

    @Override
    public void 执行状态逻辑() {
        镇静工具.start(作用者, tacticTypes);
    }
}
