<template>
  <div style="text-align: center" >
    <el-row :gutter="2" style="width: 1300px;margin: auto">
      <el-col :span="2">
        <span>武将:&nbsp;</span>
        <el-input v-model="hero.name" placeholder=" "  style="width: auto;"/>
      </el-col>

      <el-col :span="2">
        <span>主战法:&nbsp;</span>
        <el-input v-model="hero.主战法.name" placeholder=" "  style="width: auto;"/>
      </el-col>

      <el-col :span="2">
        <span>战法一:&nbsp;</span>
        <el-input v-model="hero.战法[0].name" placeholder=" "  style="width: auto;"/>
      </el-col>
      <el-col :span="2">
        <span>攻击距离:&nbsp;</span>
        <el-input v-model="hero.攻击距离" placeholder=" "  style="width: auto;"/>
      </el-col>
      <el-col :span="2">
        <span>兵种:&nbsp;</span>
        <el-input v-model="hero.兵种" placeholder=" "  style="width: auto;"/>
      </el-col>
      <el-col :span="2">
        <span>阵营:&nbsp;</span>
        <el-input v-model="hero.阵营" placeholder=" "  style="width: auto;"/>
      </el-col>
      <el-col :span="2">
        <span>攻击:&nbsp;</span>
        <el-input-number v-model="hero.攻击" size="small" style="width: 80px" :precision="2" :step="0.01" />
      </el-col>
      <el-col :span="2">
        <span>谋略:&nbsp;</span>
        <el-input-number v-model="hero.谋略" size="small" style="width: 80px" :precision="2" :step="0.01"/>
      </el-col>
      <el-col :span="2">
        <span>防御:&nbsp;</span>
        <el-input-number v-model="hero.防御" size="small" style="width: 80px" :precision="2" :step="0.01"/>
      </el-col>
      <el-col :span="2">
        <span>速度:&nbsp;</span>
        <el-input-number v-model="hero.速度" size="small" style="width: 80px" :precision="2" :step="0.01"/>
      </el-col>
      <el-col :span="2">
        <span>兵力:&nbsp;</span>
        <el-input-number v-model="hero.兵力" size="small" style="width: 80px" />
      </el-col>



    </el-row>
    <el-divider>
    </el-divider>
  </div>
</template>


<script>



export default {
  name: "DemoHero",
  data() {
    return {
      hero: {
        name: '',
        攻击: '',
        防御: '',
        谋略: '',
        速度: '',
        兵力: '',
        主战法: {
          name:'',
          等级:5,
        },
        战法: [{
          name:'',
          等级:5
        }],
        攻击距离: '',
        所属队伍: '防守方',
        阵营: '',
        heroId: this.heroId,
        位置: this.位置,
        兵种: '',
      },
    }
  },
  props: ['heroId', '位置'],

  methods: {
    sendhero(){
      this.gethero(this.hero)
    }
  },
  watch:{
    hero:{
      handler() {
        console.log('hero改变了')
        this.$emit('change',this.hero)
      },
      deep:true,
    }
  }

}
</script>

<style scoped>
el-cascader {

}

</style>
