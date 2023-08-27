package com.Controller;

import com.Dao.开荒预设Dao;
import com.PoJo.开荒预设;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tools")
public class ToolsController {
    @Autowired
    开荒预设Dao Dao;
    @RequestMapping("add")
    public void 添加开荒预设(@RequestBody String 预设){
        开荒预设 开荒预设 = JSONObject.parseObject(预设, 开荒预设.class);
        Dao.add(开荒预设);

    }
}
