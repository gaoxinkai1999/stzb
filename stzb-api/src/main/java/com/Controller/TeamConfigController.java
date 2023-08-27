package com.Controller;

import com.PoJo.TeamConfig;
import com.Service.TeamConfigService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("teamconfigcontroller")
public class TeamConfigController {

    @Autowired
    TeamConfigService teamConfigService;


    @RequestMapping("add")
    public String add(@RequestBody String team){
        TeamConfig teamConfig = JSONObject.parseObject(team, TeamConfig.class);
        return teamConfigService.add(teamConfig);
    }
    public void set(){

    }
    public void remove(){

    }
    @RequestMapping("select")
    public ArrayList<TeamConfig> select(String id){
            return teamConfigService.select(id);
    }
}
