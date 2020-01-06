<template>
  <div class="containers">
    <el-header class="header">
      <el-button @click="addNewProject" round type="primary" size="small"
                 style="margin-top: 14px;width: 80px;font-size: 12px;margin-left: 30px">新 增
      </el-button>
      <el-row style="float:right;width: 400px;margin-top: 10px;">
        <el-col :span="12" :offset="6">
          <div class="header_search">
            <el-input v-model="searchInput" class="header_search_input" placeholder="框架名称/类型/所属框架"
                      @keyup.native.enter="doSearch">
              <el-button slot="append" icon="el-icon-search" @click="doSearch"></el-button>
            </el-input>
          </div>
        </el-col>
      </el-row>
    </el-header>
    <el-main id="main">
      <el-row :gutter="24">
        <el-col :span="8" v-for="item in projectList" :key="item.projectId">
          <el-card class="project">
            <div class="project_header">
              <el-row>
                <el-col :span="14">
                <span class="project_header_projectName"
                      @click="goInfo(item.projectId)">{{item.projectName}}</span>
                </el-col>
                <el-col :span="4" :offset="3">
                  <el-tag class="project_header_type" v-if="item.projectType != null">{{item.projectType}}</el-tag>
                </el-col>
                <el-col :span="2" :offset="1">
                  <el-button @click="deleteProject(item)" type="danger" icon="el-icon-delete" size="mini"
                             circle></el-button>
                </el-col>
              </el-row>
            </div>
            <div class="project_body">
              {{item.remark}}
            </div>
          </el-card>
        </el-col>
      </el-row>
    </el-main>
    <el-dialog
      title="源码研究新增"
      :visible.sync="disableDialog"
      width="40%"
      :before-close="handleClose">
      <el-form ref="addProjectForm" :model="addProjectForm" :rules="rules"
               :hide-required-asterisk="hideRequiredAsterisk" style="margin-left: 40px;">
        <el-form-item label="源码项目名称:" prop="projectName">
          <el-input v-model="addProjectForm.projectName"></el-input>
        </el-form-item>
        <el-form-item label="源码项目类型:" prop="projectType">
          <el-select v-model="addProjectForm.projectType" placeholder="请选择源码项目类型">
            <el-option
              v-for="item in projectType"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="源码适用范围:" prop="usePosition">
          <el-select v-model="addProjectForm.usePosition" placeholder="请选择源码项目类型">
            <el-option
              v-for="item in usePosition"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="源码项目简介:" prop="remark">
          <el-input type="textarea" v-model="addProjectForm.remark" maxlength="30" show-word-limit></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="handleClose">取 消</el-button>
    <el-button type="primary" @click="addProject()">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: "Main",
    data() {
      return {
        hideRequiredAsterisk: true,
        searchInput: "",
        disableDialog: false,
        projectList: [
          {
            projectName:"测试",
            projectType:"JAVA"
          }
        ],
        addProjectForm: {
          projectName: "",
          projectType:"",
          usePosition:"",
          remark: "",
          cudType: "CREATE"
        },
        projectType: [
          {
            label:"Java",
            value:"JAVA"
          },
          {
            label:"Python",
            value:"PYTHON"
          }
        ],
        usePosition: [
          {
            label:"全局",
            value:"ALL"
          },
          {
            label: "远程调用",
            value: "RPC",
          },
          {
            label:"网络",
            value:"WEB"
          },
          {
            label:"持久层",
            value:"DAO"
          },
          {
            label:"序列化",
            value:"SERIALIZE"
          },
          {
            label:"工具",
            value:"UTIL"
          }
        ],
        rules: {
          projectName: [{
            required: true, message: "项目名称不能为空", trigger: "blur"
          }],
          projectType: [{
            required: true, message: "项目类型不能为空", trigger: "blur"
          }],
          usePosition: [{
            required: true, message: "项目可用范围不能为空", trigger: "blur"
          }],
        }
      }
    },
    mounted() {

      this.$axios({
        url: this.Globel.requestUrl + "/project/projectListQuery",
        method: "get"
      }).then(res => {
        if (res.data.success) {
          this.projectList = res.data.data.projectInfoList
        }
      })
    },

    methods: {
      addNewProject() {
        this.disableDialog = true
      },

      /**
       * 对话框关闭
       * */
      handleClose(done) {
        this.disableDialog = false
        this.$refs['addProjectForm'].resetFields()
        done;
      },

      addProject() {
        this.$axios({
          url: this.Globel.requestUrl + "/project/projectCUD",
          data: this.addProjectForm,
          method: "Post"
        }).then(res => {
          if (res.data.success) {
            this.disableDialog = false
            this.$axios({
              url: this.Globel.requestUrl + "/project/projectListQuery",
              method: "GET"
            }).then(res => {
              if (res.data.success) {
                this.projectList = res.data.data.projectInfoList
              }
            })
          }
        })
      },

      doSearch() {
        this.$axios({
          url: this.Globel.requestUrl + "/project/projectListQuery?keyWord=" + this.searchInput,
          method: "GET"
        }).then(res => {
          if (res.data.success) {
            this.projectList = res.data.data.projectInfoList
          }
        })
      },

      goInfo(projectId) {
        this.$router.push({
          path: "/projectInfo",
          query: {
            projectId: projectId,
          }
        })
      },

      deleteProject(item) {
        item.cudType = "DELETE"
        this.$axios({
          url: this.Globel.requestUrl + "/project/projectCUD",
          method: "POST",
          data: item
        }).then(res => {
          if (res.data.success) {
            this.$message.success(res.data.msg)
            this.$axios({
              url: this.Globel.requestUrl + "/project/projectListQuery",
              method: "GET"
            }).then(res => {
              if (res.data.success) {
                this.projectList = res.data.data.projectInfoList
              }
            })
          } else {
            this.$message.error(res.data.msg)
          }
        })
      }
    }
  }
</script>

<style scoped>
  .containers {
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
    width: 290px !important;
    float: right;
  }

  .header_user {
    float: right;
  }

  .project {
    width: 400px !important;
    height: 400px;
    margin-top: 34px;
    margin-left: auto;
    margin-right: auto;
    box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.2);
    border: 1px solid rgba(0, 0, 0, 0.1);
  }

  .project_header {
    height: 40px;
    border-bottom: 2px solid rgba(0, 0, 0, 0.3);
  }

  .project_body {
    padding-top: 14px;
  }

  .project_header_projectName {
    text-align: left;
    cursor: pointer;
    font-size: 24px;
    font-weight: bolder;
    font-family: "宋体";
  }

  .project_header_type {
    float: right;
    font-size: 14px;
  }

  .el-input {
    width: 70%;
  }

</style>
