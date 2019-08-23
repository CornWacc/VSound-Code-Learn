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
            <el-button @click="doSearch">查询</el-button>
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
              <el-button size="mini" @click="viewDetails(scope.row)">查看详情</el-button>
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
        <el-form ref="addCodeForm" :model="addCodeForm" :rules="rules" style="margin-left: 10px;">
          <el-form-item label="源码项目名称:" prop="codeName">
            <el-input placeholder="请输入源码名称" v-model="addCodeForm.codeName" style="width: 220px"></el-input>
          </el-form-item>
          <el-form-item label="源码项目类型:" prop="codeType">
            <el-select v-model="addCodeForm.codeType" clearable style="width: 220px" placeholder="请选择源码类型">
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
      <el-drawer
        :title="drawerData.codeName"
        :visible.sync="drawer"
        :direction="direction"
        :before-close="handleClose"
        size="800px"
        class="drawer">
        <div class="wrapper" ref="wrapper">
          <div>
            <div class="drawer_form_model">
              <el-row>
                <el-col :span="4"><span style="font-size: 18px">名称:</span></el-col>
                <el-col :span="4"><span style="font-size: 14px">{{drawerData.codeName}}</span></el-col>
              </el-row>
              <el-row>
                <el-col :span="4"><span style="font-size: 18px">类型:</span></el-col>
                <el-col :span="4"><span style="font-size: 14px">{{drawerData.codeType}}</span></el-col>
              </el-row>
              <el-row>
                <el-col :span="4"><span style="font-size: 18px">继承级别:</span></el-col>
                <el-col :span="4"><span style="font-size: 14px">{{drawerData.codeLevel}}</span></el-col>
              </el-row>
              <el-row>
                <el-col :span="4"><span style="font-size: 18px;line-height: 40px">应用范围:</span></el-col>
                <el-col :span="4">
                  <span style="font-size: 14px" v-if="drawerData.usePosition != ''"></span>
                  <el-input v-else placeholder="应用范围" class="drawer_form_model_useposition_input"></el-input>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="4"><span style="font-size: 18px">简介:</span></el-col>
              </el-row>
              <div class="drawer_form_model_remark">
                {{drawerData.codeRemark}}
              </div>
              <div v-if="drawerData.codeType != 'ANNOTATION'">
                <div
                  style="margin-top: 20px;text-align: center;font-size: 22px;font-weight: bolder;margin-bottom: 10px">方
                  法
                </div>
                <el-table :data="drawerData.codeMethods" class="code_methods_table" border>
                  <el-table-column
                    label="方法名称"
                    align="center"
                    prop="methodName">
                    <template slot-scope="scope">
                      <span v-if="scope.row.methodName != 'null'">{{scope.row.methodName}}</span>
                      <el-input placeholder="方法名称" v-if="scope.row.methodName == 'null'"></el-input>
                    </template>
                  </el-table-column>
                  <el-table-column
                    label="用法"
                    align="center"
                    prop="methodsUsage">
                    <template slot-scope="scope">
                      <span v-if="scope.row.methodUsage != 'null'">{{scope.row.methodsUsage}}</span>
                      <el-input placeholder="用法" v-if="scope.row.methodUsage == 'null'"></el-input>
                    </template>
                  </el-table-column>
                  <el-table-column
                    label="方法入参"
                    align="center"
                    prop="methodOrder">
                    <template slot-scope="scope">
                      <span v-if="scope.row.methodOrder != 'null'">{{scope.row.methodOrder}}</span>
                      <el-input placeholder="方法入参" v-if="scope.row.methodOrder == 'null'"></el-input>
                    </template>
                  </el-table-column>
                  <el-table-column
                    label="是否常用"
                    align="center"
                    prop="isCommonUse">
                    <template slot-scope="scope">
                      <span v-if="scope.row.isCommonUse != 'null'">{{scope.row.isCommonUse}}</span>
                      <el-input placeholder="是否常用" v-if="scope.row.isCommonUse == 'null'"></el-input>
                    </template>
                  </el-table-column>
                  <el-table-column label="操作" align="center">
                    <template slot-scope="scope">
                      <el-button size="mini" type="primary" v-if="scope.row.type !== 'new'">编辑</el-button>
                      <el-button size="mini" v-if="scope.row.type !== 'new'">删除</el-button>
                      <el-button size="mini" v-if="scope.row.type == 'new'">保存</el-button>
                    </template>
                  </el-table-column>
                </el-table>
              </div>
              <div v-if="drawerData.codeType != 'INTERFACE'">
                <div
                  style="margin-top: 30px;text-align: center;font-size: 22px;font-weight: bolder;margin-bottom: 10px">
                  参 数
                </div>
                <el-table :data="drawerData.codeParameters" class="outside_url_table" border>
                  <el-table-column
                    label="参数名称"
                    align="center"
                    prop="parameterName">
                    <template slot-scope="scope">
                      <span v-if="scope.row.parameterName != 'null'">{{scope.row.parameterName}}</span>
                      <el-input placeholder="参数名称" v-if="scope.row.parameterName == 'null'"></el-input>
                    </template>
                  </el-table-column>
                  <el-table-column
                    label="参数类型"
                    align="center"
                    prop="parameterType">
                    <template slot-scope="scope">
                      <span v-if="scope.row.parameterType != 'null'">{{scope.row.methodOrder}}</span>
                      <el-input placeholder="参数类型" v-if="scope.row.parameterType == 'null'"></el-input>
                    </template>
                  </el-table-column>
                  <el-table-column
                    label="参数解释"
                    align="center"
                    prop="parameterRemark">
                    <template slot-scope="scope">
                      <span v-if="scope.row.parameterRemark != 'null'">{{scope.row.parameterRemark}}</span>
                      <el-input placeholder="参数解释" v-if="scope.row.parameterRemark == 'null'"></el-input>
                    </template>
                  </el-table-column>
                  <el-table-column label="操作" align="center">
                    <template slot-scope="scope">
                      <el-button size="mini" type="primary" v-if="scope.row.type !== 'new'">编辑</el-button>
                      <el-button size="mini" v-if="scope.row.type !== 'new'">删除</el-button>
                      <el-button size="mini" v-if="scope.row.type == 'new'">保存</el-button>
                    </template>
                  </el-table-column>
                </el-table>
              </div>
              <div>
                <div
                  style="margin-top: 30px;text-align: center;font-size: 22px;font-weight: bolder;margin-bottom: 10px">
                  外部链接
                </div>
                <el-table :data="drawerData.outSideUrl" class="outside_url_table" border>
                  <el-table-column
                    label="链接注释"
                    align="center"
                    prop="outSideUrlRemark">
                    <template slot-scope="scope">
                      <span v-if="scope.row.outSideUrlRemark != 'null'">{{scope.row.outSideUrlRemark}}</span>
                      <el-input placeholder="链接注释" v-if="scope.row.outSideUrlRemark == 'null'"></el-input>
                    </template>
                  </el-table-column>
                  <el-table-column
                    label="路径"
                    align="center"
                    prop="outSideUrlPath">
                    <template slot-scope="scope">
                      <span v-if="scope.row.outSideUrlPath != 'null'">{{scope.row.outSideUrlPath}}</span>
                      <el-input placeholder="路径" v-if="scope.row.outSideUrlPath == 'null'"></el-input>
                    </template>
                  </el-table-column>
                  <el-table-column label="操作" align="center">
                    <template slot-scope="scope">
                      <el-button size="mini" type="primary" v-if="scope.row.type !== 'new'">编辑</el-button>
                      <el-button size="mini" v-if="scope.row.type !== 'new'">删除</el-button>
                      <el-button size="mini" v-if="scope.row.type == 'new'">保存</el-button>
                    </template>
                  </el-table-column>
                </el-table>
              </div>
            </div>
          </div>
        </div>
      </el-drawer>
    </el-container>
  </el-container>
</template>

<script>
  export default {
    name: "projectinfo",
    data() {
      return {
        drawer: false,
        direction: 'rtl',
        projectForm: {
          projectName: ""
        },
        addCodeForm: {
          codeName: "",
          codeType: "",
          codeLevel: "",
          codeProgram: ""
        },
        rules: {},
        codeSearch: {
          codeName: "",
          codeLevel: "",
          codeType: ""
        },
        tableData: [],
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
        dialogVisible: false,
        drawerData: {
          codeName: "",
          codeType: "",
          codeLevel: "",
          codeRemark: "",
        },
        codeMethods: [],
      }
    },
    mounted() {
      this.$axios({
        url: "http://localhost:9055/base/code/codeInfoQuery?programId=" + this.$route.query.projectId + "&keyWord=" + "",
        method: "Get"
      }).then(res => {
        if (res.data.status == "SUCCESS") {
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
        done()
      },
      cancelDialog() {
        this.dialogVisible = false
      },
      sureAddCode() {
        this.addCodeForm.codeProgram = this.$route.query.projectId
        this.$axios({
          url: "http://localhost:9055/base/code/codeAdd",
          data: this.addCodeForm,
          method: "Post"
        }).then(res => {
          if (res.data.status == "SUCCESS") {
            this.$message.success("新增成功")
            this.dialogVisible = false
            this.$axios({
              url: "http://localhost:9055/base/code/codeInfoQuery?programId=" + this.$route.query.projectId + "&keyWord=" + "",
              method: "Get"
            }).then(res => {
              if (res.data.status == "SUCCESS") {
                this.tableData = res.data.object.codeInfoList
              }
            })
          }
        })
      },
      doSearch() {
        this.$axios({
          url: "http://localhost:9055/base/code/codeInfoQuery?programId=" + this.$route.query.projectId + "&codeName=" + this.codeSearch.codeName + "&codeType=" + this.codeSearch.codeType + "&codeLevel=" + this.codeSearch.codeLevel,
          method: "get"
        }).then(res => {
          if (res.data.status = "SUCCESS") {
            this.tableData = res.data.object.codeInfoList
          }
        })
      },
      viewDetails(row) {
        this.drawer = true
        row.codeMethods.push({
          methodName: "null",
          methodUsage: "null",
          methodOrder: "null",
          isCommonUse: "null",
          type: "new"
        })
        row.codeParameters.push({
          parameterName: "null",
          parameterType: "null",
          parameterRemark: "null",
          type: "new"
        })
        row.outSideUrl.push({
          outSideUrlRemark: "null",
          outSideUrlPath: "null",
          type: "new"
        })
        console.log(row)
        this.drawerData = row
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

  .drawer_form_model {
    margin-left: 40px;
  }

  .drawer_form_model >>> .el-row {
    margin-bottom: 20px;
  }

  .drawer_form_model_remark {
    padding: 10px;
    border: 1px solid rgba(0, 0, 0, 0.1);
    height: 400px;
    box-shadow: 3px 3px 3px rgba(0, 0, 0, 0.1);
    font-size: 14px;
    margin-right: 10px;
  }

  .drawer_form_model_useposition_input >>> .el-input__inner {
    border-right: none !important;
    border-left: none !important;
    border-top: none !important;
    width: 250px;
  }

  .wrapper {
    height: 100%;
  }

  .drawer /deep/ .el-drawer.rtl {
    overflow: auto;
  }


</style>
