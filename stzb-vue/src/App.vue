<template>
  <div id="app" >
    <!--    <img src="./assets/logo.png">-->
    <!--    <router-view/>-->
    <MyMenu v-if="!islogin===false"></MyMenu>
    <div v-if="islogin===false">
    <h1 style="font-size: 50px" >小辅助</h1>

    <br><br><br> <br><br><br>

    <MyLogin  v-on:login="login"></MyLogin>
    </div>



<!--    <div v-if="username!=''">-->
<!--      <MyMenu></MyMenu>-->
<!--      <keep-alive>-->
<!--        <router-view :username="username"></router-view>-->
<!--      </keep-alive>-->
<!--    </div>-->
<!--    <div v-if="username==''">-->
<!--      <br><br><br><br><br>-->
<!--      <MyLogin  @username="getusername"></MyLogin>-->
<!--      <MyRegister v-if="value1==false" @username="getusername"></MyRegister>-->
<!--      <br><br><br><br><br>-->
<!--      <el-switch-->
<!--          v-model="value1"-->
<!--          active-text="登录"-->
<!--          inactive-text="注册"-->
<!--          style="width: 500px">-->
<!--      </el-switch>-->
<!--    </div>-->
  </div>

</template>

<script>
import MyMenu from "@/components/MyMenu";
import MyLogin from "@/components/MyLogin";


export default {
  name: 'App',
  components: {
    MyLogin,
    MyMenu,
  },
  data(){
    return{
      islogin:false,
      value1:true,
      id:'',
    }
  },
  methods:{
    login(id){
      this.islogin=true;
      this.id=id;
    }
  }
}
</script>

<style scoped>
#app {
  /*font-family: 'Avenir', Helvetica, Arial, sans-serif;*/
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: -webkit-center;
  color: #2c3e50;
  margin-top: 20px;
  font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
}
span{
  font-size: 16px;
  color: var(--el-text-color-secondary);
  line-height: 44px;
  flex: 1;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  margin-bottom: 0;
}
</style>
