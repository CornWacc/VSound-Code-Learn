<template>
  <el-container class="container">
    <el-main class="main">
      <el-table :data="projectList" class="table" style="width: 100%">
        <el-table-column type="expand" width="20">
          <template slot-scope="props">
            <el-form label-position="left" inline class="demo-table-expand">
              <el-form-item label="项目Id:">
                <span>{{ props.row.projectId }}</span>
              </el-form-item>
              <el-form-item label="项目名称:">
                <span>{{ props.row.projectName }}</span>
              </el-form-item>
              <el-form-item label="项目类型:">
                <span>{{ props.row.projectType }}</span>
              </el-form-item>
              <el-form-item label="适用范围:">
                <span>{{ props.row.usePosition }}</span>
              </el-form-item>
              <el-form-item label="项目简介:">
                <span>{{ props.row.remark }}</span>
              </el-form-item>
              <el-form-item label="已收集类数量:">
                <span>{{ props.row.gatherClassCount }}</span>
              </el-form-item>
              <el-form-item label="已收集接口数量:">
                <span>{{ props.row.gatherInterfaceCount }}</span>
              </el-form-item>
              <el-button round type="small">内容浏览</el-button>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column
          align="center"
          prop="projectId"
          label="项目id"
          width="290px"
          min-width="180px">
        </el-table-column>
        <el-table-column
          align="center"
          prop="projectName"
          label="项目名称"
          width="290px"
          min-width="180px">
        </el-table-column>
        <el-table-column
          align="center"
          prop="projectType"
          label="项目类型"
          width="290px"
          min-width="180px">
        </el-table-column>
        <el-table-column
          align="center"
          prop="usePosition"
          label="适用范围"
          width="290px"
          min-width="180px">
        </el-table-column>
        <el-table-column
          align="center"
          prop="remark"
          label="简介"
          width="290px"
          min-width="180px">
        </el-table-column>
        <el-table-column
          align="center"
          label="操作"
          width="150">
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">编辑
            </el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
</template>

<script>
    export default {
      name: "projectList",
      data(){
          return{
            projectList:[{
              projectId:"1",
              projectName:"!",
              projectType:"1",
              usePosition:"全面",
              remark:"嘿嘿",
              gatherClassCount:50,
              gatherInterfaceCount:50
            }]
          }
      },
      mounted(){
        this.$axios({
          url:"https://119.3.219.207:9055/base/project/projectListQuery",
          method:"get"
        }).then(res =>{
          if(res.data.status = "SUCCESS"){
            this.projectList = res.data.object.projectInfoList
          }
        })
      },
      methods:{
        goProject(row, column, event){
          console.log(row)
        }
      }
    }
</script>

<style scoped>
  .container{
    width: 100%;
  }
  .main {
    width: 100%;
  }
  .table{
    width: 100%;
    background: none;
  }
  .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
  .el-table /deep/ .el-table__expanded-cell{
    background: none;
  }

</style>
