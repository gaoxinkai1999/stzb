package com.Service.Fight.state;

import com.Service.Fight.state.控制状态类.暴走;
import com.Service.Fight.state.控制状态类.混乱;
import com.Service.Fight.state.控制状态类.犹豫;
import com.Service.Fight.state.特殊状态类.*;

public enum StateType {
    //基础属性变化
    攻击值提高,
    攻击值降低,
    谋略值提高,
    谋略值降低,
    防御值提高,
    防御值降低,
    速度值提高,
    速度值降低,
    增大攻击距离,
    减小攻击距离,
    //制造伤害
    造成单次攻击伤害,
    造成单次策略伤害,
    //伤害计算变化
    受到的策略伤害减少,
    受到的策略伤害增加,
    受到的攻击伤害减少,
    受到的攻击伤害增加,
    造成的策略伤害减少,
    造成的策略伤害增加,
    造成的攻击伤害减少,
    造成的攻击伤害增加,
    受到的主动战法伤害减少,
    受到的主动战法伤害增加,
    造成的主动战法伤害减少,
    造成的主动战法伤害增加,
    造成的普通攻击伤害减少,
    造成的普通攻击伤害增加,
    受到的普通攻击伤害减少,
    受到的追击战法伤害减少,
    造成的追击战法伤害增加,
    造成的追击战法伤害减少,
    //特殊状态
    休整,
    持续型急救,
    立即型急救,
    围困,
    动摇,
    妖术,
    燃烧,
    恐慌,
    怯战,

    犹豫,
    混乱,
    暴走,
    攻心,
    反击,
    挑衅,
    援护,
    分兵,
    先手,
    连击,
    洞察,
    镇静,
    看破,
    规避,
    无视防御,
    无视谋略,
    无视规避,
    无视兵种相克,
    战法发动几率提升,
    免疫怯战,
    跳过准备回合,

    //预备类效果
    怯战预备,
    混乱预备,
    暴走预备,
    犹豫预备,
    连击预备,
    先手预备,
    围困预备,
    洞察预备,
    镇静预备,

//    延迟伤害类
    策略攻击伤害,
    攻击伤害,
    //战法类效果.
    战必断金,
    反计之策,
    白衣渡江,
    奇兵拒北,
    始计,
    奉令护蜀,
    帝临回光,
    众谋不懈,
    击势,
    磐阵善守,
    谋定后动,
    京观垒冢,
    西陵克晋,
    垒实迎击,
    桃园结义,
    健卒不殆,
    拔箭啖睛,
    合众,
    借刀斩叛,
    空城,
    战伤无畏,
    不攻,
}
