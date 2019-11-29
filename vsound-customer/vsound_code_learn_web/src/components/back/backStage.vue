<template>
  <el-container class="container">
    <el-aside width="220px" class="left_model">
      <el-menu class="left_model_menu">
        <el-menu-item index="1">
          <i class="el-icon-menu"></i>
          <router-link to="/backStage" tag="span">后台管理</router-link>
        </el-menu-item>
        <el-submenu index="2">
          <template slot="title"><i class="el-icon-user"></i>用户管理</template>
            <el-menu-item index="2-1"><router-link to="/backStage/userList" tag="div">用户列表</router-link></el-menu-item>
        </el-submenu>
        <el-submenu index="3">
          <template slot="title"><i class="el-icon-s-promotion"></i>项目管理</template>
          <el-menu-item index="3-1"><router-link to="/backStage/projectList" tag="div">源码列表</router-link></el-menu-item>
          <el-menu-item index="3-2"><router-link to="/backStage/projectCategory" tag="div">源码分类</router-link></el-menu-item>
        </el-submenu>
        <el-button class="to_main_button" @click="goMain">回到主页</el-button>
      </el-menu>

    </el-aside>
    <el-main class="main">
      <router-view/>
    </el-main>
  </el-container>
</template>

<script>
  export default {
    name: "backStage",
    data() {
      return {}
    },
    methods:{
      goMain(){
        this.$router.push("/main")
      }
    }
  }
</script>

<style scoped>
  .container {
    width: 100%;
    height: 100%;
    background: linear-gradient(#F8F8FF, #BBFFFF);
  }

  .left_model {
    box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.1);

  }

  .left_model_menu {
    height: 100%;
  }

  .el-menu {
    background: none !important;
  }

  .el-menu-item {
    background: none;
  }

  .main {
    width: 100%;
    height: 100%;
    background-color: red;
    padding: 0px;
  }

  .to_main_button{
    position: absolute;
    bottom: 20px;
    margin-left: 90px;
    left: -35px;
    width: 100px;

  }
</style>
