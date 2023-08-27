package com.Service;

import com.Dao.TeamConfigDao;
import com.PoJo.TeamConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeamConfigService {
    @Autowired
    TeamConfigDao teamConfigDao;
    public String add(TeamConfig teamConfig){
        TeamConfig select = teamConfigDao.select(teamConfig.id, teamConfig.阵容名);
        if (select==null){
            teamConfigDao.add(teamConfig);
            return "添加成功";
        }else {
            return "重复阵容名";
        }


    }
    public void set(){

    }
    public void remove(){

    }
    public ArrayList<TeamConfig> select(String id){
         return teamConfigDao.selectall(id);
    }
}
