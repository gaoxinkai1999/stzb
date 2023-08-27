<template>
  <h1>小辅助</h1>
  <el-menu
      :default-active="activeIndex"
      class="el-menu-demo"
      mode="horizontal"
      :router="true"
  >
    <el-menu-item index="MyHome" style="width: 200px">主页</el-menu-item>
    <el-menu-item index="MyTeam" style="width: 200px">我的队伍</el-menu-item>
    <el-menu-item index="MyFight" style="width: 200px">对战</el-menu-item>
    <el-menu-item index="4" style="width: 200px" disabled>自动配将</el-menu-item>
    <el-menu-item index="MyTools" style="width: 200px" >开发者工具</el-menu-item>
  </el-menu>
<router-view></router-view>


</template>

<script lang="ts" setup>

</script>
