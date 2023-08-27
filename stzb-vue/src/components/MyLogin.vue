<template>
  <el-form label-width="80px">

      <el-input v-model="id" placeholder="用户名" style="width: auto" ></el-input>
    <br><br><br>
      <el-input v-model="password" placeholder="密码" style="width: auto" ></el-input>
    <br><br><br>
      <el-button type="primary" @click="login">登录</el-button>

  </el-form>
</template>
<script>
export default {
  name: 'MyLogin',
  data () {
    return {
      id: '',
      password:''
    }
  },
  methods: {
    login () {
      this.$http({
        url: '/user/login',
        method: 'get',
        params: {
          'id': this.id,
          'password':this.password
        }
      }).then(res => {
        console.log(res.data)
        if (res.data==='登陆成功'){
          this.$emit('login',this.id)
        }

      })
    }
  }
}
</script>

<style >
</style>
