<template>
  <div style="text-align: center" >
    <el-row :gutter="2" style="width: 1300px;margin: auto">
      <el-col :span="3">
        <span>武将:&nbsp;</span>
        <el-cascader v-model="value" :options="herosinfo" :filterable="true" :emitPath="false" @change="herochange"
                     size="small" style="width: 100px"/>
      </el-col>
      <el-col :span="3">
        <span>战法一:&nbsp;</span>
        <el-cascader v-model="战法一.name" :options="tacticsinfo" :filterable="true" :emitPath="false"
                     :show-all-levels="false"
                     @change="tactic1change" size="small" style="width: 100px"/>
      </el-col>
      <el-col :span="3">
        <span>战法二:&nbsp;</span>
        <el-cascader v-model="战法二.name" :options="tacticsinfo" :filterable="true" :emitPath="false"
                     :show-all-levels="false"
                     @change="tactic2change" size="small" style="width: 80px"/>
      </el-col>
      <el-col :span="3">
        <span>攻击:&nbsp;</span>
        <el-input-number v-model="hero.攻击" size="small" style="width: 80px" :precision="2" :step="0.01"/>
      </el-col>
      <el-col :span="3">
        <span>谋略:&nbsp;</span>
        <el-input-number v-model="hero.谋略" size="small" style="width: 80px" :precision="2" :step="0.01"/>
      </el-col>
      <el-col :span="3">
        <span>防御:&nbsp;</span>
        <el-input-number v-model="hero.防御" size="small" style="width: 80px" :precision="2" :step="0.01"/>
      </el-col>
      <el-col :span="3">
        <span>速度:&nbsp;</span>
        <el-input-number v-model="hero.速度" size="small" style="width: 80px" :precision="2" :step="0.01"/>
      </el-col>
      <el-col :span="3">
        <span>兵力:&nbsp;</span>
        <el-input-number v-model="hero.兵力" size="small" style="width: 80px"/>
      </el-col>



    </el-row>
    <el-divider>
    </el-divider>
  </div>
</template>


<script>


export default {
  name: "MyHero",
  data() {
    return {
      hero: {
        name: '',
        攻击: '',
        防御: '',
        谋略: '',
        速度: '',
        兵力: '',
        主战法: '',
        战法: ['',''],
        攻击距离: '',
        所属队伍: this.所属队伍,
        阵营: '',
        heroId: this.heroId,
        位置: this.位置,
        兵种: '',
      },
      herosinfo: '',
      value: '',
      tacticsinfo: '',
      战法一: {
        name:'',
        等级:3,
      },
      战法二: {
        name:'',
        等级:3,
      },
    }
  },
  props: ['所属队伍', 'heroId', '位置','gethero'],

  created() {
    this.$http({
      url: 'getheroesinfo',
      method: 'get'
    }).then(res => {
      this.herosinfo = res.data
    })

    this.$http({
      url: 'gettacticsinfo',
      method: 'get'
    }).then(res => {
      this.tacticsinfo = res.data
    })

  },
  methods: {
    herochange() {
      this.hero.name = this.value[2].name;
      this.hero.攻击距离 = this.value[2].攻击距离;
      this.hero.兵种 = this.value[2].原始兵种;
      this.hero.阵营 = this.value[1];
      this.hero.主战法 = this.value[2].主战法;

    },
    tactic1change() {
      this.战法一.name=this.战法一.name[1];
      this.hero.战法[0]=this.战法一;
    },
    tactic2change() {
      this.战法二.name=this.战法二.name[1];
      this.hero.战法[1] = this.战法二;
    },

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
