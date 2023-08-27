<template>
  <h2>预设阵容</h2>
  <span>我的预设:</span>
  <el-select v-model="value" class="m-2" placeholder="Select" >
    <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value"
    />
  </el-select>
  <MyHero 所属队伍="攻击方" heroId=1 位置="大营" v-on:change="gethero" ></MyHero>
  <h4>中军</h4>
  <MyHero 所属队伍="攻击方" heroId=2 位置="中军" v-on:change="gethero"></MyHero>
  <h4>前锋</h4>
  <MyHero 所属队伍="攻击方" heroId=3 位置="前锋" v-on:change="gethero"></MyHero>
</template>

<script>
import MyHero from "@/components/MyHero";
export default {
  name: "MyTeam",
  components:{MyHero},
  data(){
    return{

    }

  },
  methods: {
    gethero(hero){
      console.log("接收到了hero:")
      // var parse = JSON.parse(JSON.stringify(hero));
      // console.log(parse)
      // console.log(parse.heroId)
      console.log(hero.heroId)
      // this.fight.heroes[hero.heroId-1]=hero
    },
    提交(){
      this.$http({
        url: 'demo',
        params:{
          '模板':this.fight
        },
        method: 'get',
        dataType:"json",
        contentType:"application/json",
      })
    },
  }
}
</script>

<style scoped>

</style>
