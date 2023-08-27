<template>
  <el-form label-width="80px" @submit.native.prevent>
    <el-form-item label="">
      <el-input v-model="username" placeholder="用户名" style="width: auto" @keyup.enter.native="login"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="login">注册</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  name: "MyRegister"
}
</script>

<style scoped>

</style>