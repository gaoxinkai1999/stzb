package com.Service;

import com.Dao.HeroDao;
import com.Dao.TacticsDao;
import com.Dao.开荒预设Dao;
import com.PoJo.HeroInfo;
import com.PoJo.TacticInfo;
import com.PoJo.开荒预设;
import com.Service.Fight.tools.武将初始化模板;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 该类用于提供前端所需的一些数据
 */
@Service

//@Scope("prototype")
public class InfoService {
    @Autowired
    public HeroDao heroDao;
    @Autowired
    private TacticsDao tacticsDao;

    @Autowired
    开荒预设Dao 开荒预设Dao;

    /**
     * 获取全部武将数据,
     */
    public ArrayList getHeroesInfo() {
        ArrayList<HeroInfo> allHeros = heroDao.getAll();
        ArrayList<JSONObject> HeroesInfo = new ArrayList<>();
        String[] 星级 = {"5"};
        String[] 阵营 = {"魏", "蜀", "吴", "汉", "群"};
        for (String s : 星级) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("value", s);
            jsonObject.put("label", s + "星");
            jsonObject.put("children", new JSONArray());
            HeroesInfo.add(jsonObject);
        }
        for (String s : 阵营) {
            for (JSONObject o : HeroesInfo) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("value", s);
                jsonObject.put("label", s);
                jsonObject.put("children", new JSONArray());
                JSONArray children = o.getJSONArray("children");
                children.add(jsonObject);
            }
        }


        for (HeroInfo Hero : allHeros) {
            for (JSONObject jsonObject : HeroesInfo) {
                String value = jsonObject.getString("value");
                //先判断星级
                if (value.equals(String.valueOf(Hero.get星级()))) {
                    JSONArray children = jsonObject.getJSONArray("children");
                    //再判断阵营
                    for (Object child : children) {
                        JSONObject jsonObject1 = (JSONObject) child;
                        String value1 = jsonObject1.getString("value");
                        if (value1.equals(String.valueOf(Hero.get阵营()))) {
                            JSONArray children1 = jsonObject1.getJSONArray("children");
                            JSONObject jsonObject2 = new JSONObject();
                            jsonObject2.put("value", Hero);
                            jsonObject2.put("label", Hero.getName());
                            children1.add(jsonObject2);
                        }
                    }
                }
            }
        }
        return HeroesInfo;
    }

    /**
     * 获取全部战法数据
     */
    public JSONArray getTacticsInfo() {
        //获取全部战法
        ArrayList<TacticInfo> all = tacticsDao.getAll();
        //准备要返回的数组
        JSONArray objects = new JSONArray();
        String[] type = {"主动战法", "被动战法", "指挥战法", "追击战法"};
        for (String s : type) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("value", s);
            jsonObject.put("label", s);
            //子数组
            JSONArray childrens = new JSONArray();
            jsonObject.put("children", childrens);
            for (TacticInfo tactic : all) {
                if (tactic.getType().equals(s)) {
                    JSONObject children = new JSONObject();
                    children.put("value", tactic.getName());
                    children.put("label", tactic.getName());
                    childrens.add(children);
                }
            }
            objects.add(jsonObject);
        }

        return objects;
    }

    public HeroInfo getHeroInfo(String name) {
        return heroDao.getHero(name);
    }

    public JSONArray 获取全部开荒预设() {
        ArrayList<开荒预设> getall = 开荒预设Dao.getall();
        //准备要返回的数组
        JSONArray objects = new JSONArray();
        String[] type = {"一般征服赛季", "太师类征服赛季", "烽火类征服赛季"};
        int[] 等级 = {4, 5};
        for (String s : type) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("value", s);
            jsonObject.put("label", s);
            //子数组
            JSONArray childrens = new JSONArray();
            jsonObject.put("children", childrens);
            for (int i : 等级) {
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("value", i);
                jsonObject1.put("label", i + "级地");
                JSONArray childrens1 = new JSONArray();
                jsonObject1.put("children", childrens1);
                childrens.add(jsonObject1);
                for (开荒预设 开荒预设 : getall) {
                    if (开荒预设.赛季类型.equals(s) && 开荒预设.土地等级 == i) {
                        JSONObject children2 = new JSONObject();
                        List<武将初始化模板> 武将初始化模板s = JSONArray.parseArray(开荒预设.阵容配置, 武将初始化模板.class);
                        children2.put("value", 武将初始化模板s);
                        children2.put("label", 开荒预设.阵容名);
                        childrens1.add(children2);
                    }
                }
                if (childrens1.isEmpty()){
                    jsonObject1.put("disabled",true);
                }
            }
            objects.add(jsonObject);
        }
        return objects;
    }
}
