<template>
  <h2>进攻方</h2>
  <MyHero></MyHero>
  <h2>防守方</h2>
  <div class="example-block">
    <span class="example-demonstration">选择阵容</span>
    <el-cascader v-model="proxy_right_team" :options="right_options" @change="change" />
  </div>
  <el-button type="primary" @click="提交">提交</el-button>
  <div >
    <span>{{toRawthis.right_team[0]}}</span>
  </div>
</template>

<script>

import MyHero from "@/components/MyHero";
import {toRaw} from "@vue/reactivity";

export default {
  name: "MyFight",
  components: {MyHero},
  data() {
    return {
      left_options:[],
      right_options:[],

      proxy_right_team:'',
      right_team:'',
    }
  },
  created() {
    this.$http({
      url: 'getkaihuangteam',
      method: 'get',
    }).then(res=>{
      this.right_options=res.data
    })
  },
  methods: {
    // gethero(hero){
    //   // var parse = JSON.parse(JSON.stringify(hero));
    //   // console.log(parse)
    //   // console.log(parse.heroId)
    //   this.fight.heroes[hero.heroId-1]=hero
    // },
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
    change(){

     this.right_team=toRaw(toRaw(this.proxy_right_team)[2])
      console.log(this.right_team)

    }
  }
}
</script>

<style scoped>

</style>
