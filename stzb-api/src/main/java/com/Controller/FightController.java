package com.Controller;

import com.Service.Fight.init.FightInit;
import com.Service.Fight.tools.战斗结算;
import com.Service.Fight.tools.战法初始化模板;
import com.Service.Fight.tools.武将初始化模板;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@CrossOrigin
@RestController
public class FightController {
    @Autowired
    FightInit fightInit;
    @Autowired
    com.Service.Fight.demo demo;


    @ResponseBody
    @PostMapping("fighting")
    public 战斗结算 fighting(@RequestBody ArrayList<武将初始化模板> heroes) {
        //处理空
        Iterator<武将初始化模板> iterator = heroes.iterator();
        while (iterator.hasNext()) {
            武将初始化模板 next = iterator.next();
            if (next.name.equals("")){
                iterator.remove();
            }
            Iterator<战法初始化模板> iterator1 = next.战法.iterator();
            while (iterator1.hasNext()) {
                战法初始化模板 战法初始化模板 = iterator1.next();
                if (战法初始化模板.name.equals("")){
                    iterator1.remove();
                }
            }
        }

       return demo.一次战斗demo(heroes);
    }

    @RequestMapping("demo")
    @ResponseBody
    public void demo(String 模板) {
        JSONObject jsonObject = JSONObject.parseObject(模板);
        JSONArray heroes = jsonObject.getJSONArray("heroes");
        List<武将初始化模板> 武将初始化模板s = heroes.toJavaList(武将初始化模板.class);
        System.out.println(武将初始化模板s);

//        武将初始化模板 武将 = JSONObject.parseObject(模板, 武将初始化模板.class);
//        System.out.println(武将);

    }

}
