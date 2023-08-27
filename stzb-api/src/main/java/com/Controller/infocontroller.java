package com.Controller;

import com.PoJo.HeroInfo;
import com.Service.InfoService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class infocontroller {
    @Autowired
    private InfoService infoService;


    @RequestMapping("/getheroesinfo")
    public ArrayList getheroesinfo() {

        return infoService.getHeroesInfo();
    }
    @RequestMapping("/gettacticsinfo")
    public JSONArray gettacticsinfo() {

        return infoService.getTacticsInfo();
    }
    @RequestMapping("/getheroinfo")
    public HeroInfo getHeroInfo(String name){
        return infoService.getHeroInfo(name);
    }
    @RequestMapping("getkaihuangteam")
    public JSONArray getkaihuangteam(){
        return infoService.获取全部开荒预设();
    }

}
