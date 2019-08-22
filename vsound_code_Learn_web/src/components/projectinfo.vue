<template>
  <el-container class="container">
    <el-header class="header">
      <span class="header_title">
        {{projectForm.projectName}}
      </span>
      <div class="header_buttons">
        <el-button size="small" @click="addNewCode">新增</el-button>
        <el-button size="small" @click="goBack">返回主页</el-button>
      </div>
    </el-header>
    <el-container>
      <el-main class="main">
        <el-row>
          <el-col :span="2">
            <el-input placeholder="请输入源码名称" v-model="codeSearch.codeName"></el-input>
          </el-col>
          <el-col :span="2" style="margin-left: 10px">
            <el-input placeholder="请输入继承级别" v-model="codeSearch.codeLevel"></el-input>
          </el-col>
          <el-col :span="2" style="margin-left: 10px">
            <el-select v-model="codeSearch.codeType" clearable>
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-col>
          <el-col :span="2" style="margin-left: 10px">
            <el-button>查询</el-button>
          </el-col>
        </el-row>
        <el-table :data="tableData" style="margin-top: 10px">
          <el-table-column
            label="名称"
            align="center"
            prop="codeName">
          </el-table-column>
          <el-table-column
            label="类型"
            align="center"
            prop="codeType">
          </el-table-column>
          <el-table-column
            label="继承级别"
            align="center"
            prop="codeLevel">
          </el-table-column>
          <el-table-column
            label="详情"
            align="center">
            <template slot-scope="scope">
              <el-button size="mini">查看详情</el-button>
            </template>
          </el-table-column>
          <el-table-column
            label="操作"
            align="center">
            <template slot-scope="scope">
              <el-button size="mini">编辑</el-button>
              <el-button size="mini">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-main>

      <el-dialog
        title="新增源码解释"
        :visible.sync="dialogVisible"
        width="30%"
        :before-close="handleClose">
        <el-form ref="addCodeForm" :model="addCodeForm" :rules="rules"  style="margin-left: 10px;">
          <el-form-item label="源码项目名称:" prop="codeName">
            <el-input placeholder="请输入源码名称" v-model="addCodeForm.codeName" style="width: 220px"></el-input>
          </el-form-item>
          <el-form-item label="源码项目类型:" prop="codeType">
            <el-select v-model="codeSearch.type" clearable style="width: 220px" placeholder="请选择源码类型">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="源码继承等级:" prop="codeLevel">
            <el-input placeholder="请输入源码继承等级" v-model="addCodeForm.codeLevel" style="width: 220px"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="cancelDialog">取 消</el-button>
    <el-button type="primary" @click="sureAddCode">确 定</el-button>
  </span>
      </el-dialog>
    </el-container>
  </el-container>
</template>

<script>
  export default {
    name: "projectinfo",
    data() {
      return {
        projectForm: {
          projectName: "Netty"
        },
        addCodeForm:{
          codeName:"",
          codeType:"",
          codeLevel:"",
          codeProgramId:""
        },
        rules:{

        },
        codeSearch: {
          codeName: "",
          codeLevel: "",
          codeType: ""
        },
        tableData: [
          {
            codeName: "BeanDefinition",
            codeType: "Class",
            codeLevel: "1"
          }
        ],
        options: [
          {
            label: "Class",
            value: "CLASS"
          },
          {
            label: "Interface",
            value: "INTERFACE"
          },
          {
            label: "Annotation",
            value: "ANNOTATION"
          },
          {
            label: "Abstract",
            value: "ABSTRACT"
          }
        ],
        dialogVisible:true
      }
    },
    mounted(){
      this.$axios({
        url:"http://localhost:9055/base/code/codeInfoQuery?programId="+this.$route.query.projectId+"&keyWord="+"",
        method:"Get"
      }).then(res =>{
        if(res.data.status == "SUCCESS"){
          this.projectForm.projectName = res.data.object.projectName
          this.tableData = res.data.object.codeInfoList
        }
      })
    },
    methods: {
      goBack() {
        this.$router.push("/main")
      },
      addNewCode() {
        this.dialogVisible = true
      },
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
      cancelDialog(){
        this.dialogVisible = false
      },
      sureAddCode(){

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
    padding: 0px;
    border-bottom: 1px solid rgba(0, 0, 0, 0.1);
    box-shadow: 3px 3px 3px rgba(0, 0, 0, 0.1);
  }

  .header_title {
    font-size: 24px;
    font-weight: bold;
    position: relative;
    left: 30px;
    height: 60px;
    line-height: 60px;
  }

  .left_model {
    border-right: none;
  }

  .left_model_menu {
    height: 100% !important;
    border-right: none;
  }

  .el-collapse-item >>> .el-collapse-item__header {
    background-color: rgba(0, 0, 0, 0.0);
    border-bottom: none;
    font-size: 16px;
  }

  .el-collapse-item >>> .el-collapse-item__wrap {
    background-color: rgba(0, 0, 0, 0.0);
    border-bottom: none;
  }

  .header_buttons {
    float: right;
    margin-top: 14px;
    margin-right: 10px;
  }

</style>
