<template>
  <span>战法一:</span>
  <el-cascader  v-model="value.战法一" :options="tacticsinfo" :filterable="true" :emitPath="false" :show-all-levels="false"/>
  <br>
  <span>战法二:</span>
  <el-cascader  v-model="value.战法二" :options="tacticsinfo" :filterable="true" :emitPath="false" :show-all-levels="false"/>
</template>

<script>
export default {
  name: "MyTactics",
  data(){
    return{
      value: {
        战法一:'',
        战法二:''
      },
      tacticsinfo:{}
    }
  },
  methods:{
    getTactics(){
      this.$http({
        url:'',
        method:'get'
      }).then(res=>{
        console.log(res);
      })
    },

  },
  created() {
    this.$http({
      url:'gettacticsinfo',
      method:'get'
    }).then(res=>{
      this.tacticsinfo=res.data
    })

  }
}
</script>

<style scoped>

</style>
