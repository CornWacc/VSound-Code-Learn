<template>
  <el-container class="container">
    <el-header class="header">
      <el-row style="float:right;width: 400px;margin-top: 10px">
        <el-col :span="12">
          <div class="header_search">
            <el-input v-model="searchInput" suffix-icon="el-icon-search" class="header_search_input" placeholder="搜索想看的源码解析"></el-input>
          </div>
        </el-col>
        <el-col :span="8">
          <div class="header_user">
            <el-dropdown>
              <el-avatar></el-avatar>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item command="userInfo">个人资料</el-dropdown-item>
                <el-dropdown-item command="backStage">后台管理</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </div>
        </el-col>
      </el-row>
    </el-header>
    <el-main id="main">
      <el-row :gutter="24">
        <el-col :span="8" v-for="item in projects" :key="item.projectId">
          <el-card class="project">
            <div class="project_header">
              <span class="project_header_projectName">{{item.projectName}}</span>
              <el-tag class="project_header_type" v-if="item.type != null">{{item.type}}</el-tag>
            </div>
            <div class="project_body">
              {{item.content}}
            </div>
          </el-card>
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</template>

<script>
  export default {
    name: "Main",
    data() {
      return {
        searchInput:"",
        projects: [{
          projectId: "123",
          projectName: "SpringBeans",
          type: "Spring",
          content: ""
        }]
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

  .header {
    width: 100%;
    border-bottom: 2px solid rgba(0, 0, 0, 0.1);
    box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.1);
  }

  .header_search_input {
    width: 240px;
    float: right;
  }

  .header_user {
    float: right;
  }

  .main {

  }

  .project {
    width: 400px !important;
    height: 400px;
    margin-top: 34px;
    margin-left: auto;
    margin-right: auto;
    box-shadow: 3px 3px 3px rgba(0, 0, 0, 0.1);
    /*background: rgba(238, 250, 222, 0.1);*/
  }

  .project_header {
    height: 40px;
    border-bottom: 1px solid rgba(0, 0, 0, 0.2);
  }

  .project_body {
    padding-top: 14px;
  }

  .project_header_projectName {
    text-align: left;
  }

  .project_header_type {
    float: right;
  }
</style>
