<template>
  <h2>新增开荒预设</h2>
  <span>赛季类型:</span>
  <el-select v-model="result.赛季类型" class="m-2" placeholder=" " >
    <el-option
        v-for="item in 赛季类型"
        :key="item"
        :value="item"
    />
  </el-select>
  <span>土地等级: </span>
  <el-select v-model="result.土地等级" class="m-2" placeholder=" ">

    <el-option
        v-for="item in 土地等级"
        :key="item"
        :value="item"
    />
  </el-select>
  <span>阵容名: </span>
  <el-input v-model="result.阵容名" placeholder="Please input"  style="width: auto;"/>
  <br>  <br>  <br>  <br>  <br>
  <h4>大营</h4>
  <demohero heroId=6 位置="大营" v-on:change="gethero" ></demohero>
  <h4>中军</h4>
  <demohero  heroId=5 位置="中军" v-on:change="gethero"></demohero>
  <h4>前锋</h4>
  <demohero  heroId=4 位置="前锋" v-on:change="gethero"></demohero>
  <el-button type="primary" @click="提交">提交</el-button>
</template>


<script>

import demohero from "@/components/demohero";
import { toRaw } from '@vue/reactivity';
export default {
  name: "MyTools",
  components:{demohero},
  data(){
    return{
      赛季类型:["一般征服赛季","太师类征服赛季","烽火类征服赛季"],
      土地等级: [4,5],
      阵容名:'',
      result:{
        赛季类型:'',
        土地等级:'',
        阵容名:'',
        阵容配置:['','',''],
      }
    }
  },
  methods:{
    gethero(hero){

      const hero1 = toRaw(hero);
      console.log(hero1.heroId)
      if (hero1.heroId==6){
        console.log("123")
        this.result.阵容配置[0]=hero1
      }else if (hero1.heroId==5){
        this.result.阵容配置[1]=hero1
      }else if (hero1.heroId==4){
        this.result.阵容配置[2]=hero1
      }



      this.result.阵容名=this.result.阵容配置[0].name+'+'+this.result.阵容配置[1].name+'+'+this.result.阵容配置[2].name
      // console.log(this.result.阵容名)
    },
    提交(){
      this.$http({
        url:'tools/add',
        method:"get",
        params:{
          '预设':this.result
        }
          }

      )

    }
  }
}
</script>

<style scoped>

</style>
