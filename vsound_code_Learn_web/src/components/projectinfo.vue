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
            <el-input placeholder="源码名称" v-model="codeSearch.codeName"></el-input>
          </el-col>
          <el-col :span="2" style="margin-left: 10px">
            <el-input placeholder="继承级别" v-model="codeSearch.codeLevel"></el-input>
          </el-col>
          <el-col :span="2" style="margin-left: 10px">
            <el-select v-model="codeSearch.codeType" clearable placeholder="类型">
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
              <el-button size="mini" type="primary" @click="updateCode(scope.row)">编辑</el-button>
              <el-button size="mini" type="danger" @click="delCode(scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-main>

      <el-dialog
        :title="dialog.dialogTital"
        :visible.sync="dialog.dialogVisible"
        width="30%"
        :before-close="handleClose">
        <el-form ref="codeForm" :model="codeForm" :rules="rules" style="margin-left: 10px;">
          <el-form-item label="源码名称:" prop="codeName">
            <el-input placeholder="请输入源码名称" v-model="codeForm.codeName" style="width: 220px"></el-input>
          </el-form-item>
          <el-form-item label="源码类型:" prop="codeType">
            <el-select v-model="codeForm.codeType" clearable style="width: 220px" placeholder="请选择源码类型">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="继承等级:" prop="codeLevel">
            <el-input placeholder="请输入源码继承等级" v-model="codeForm.codeLevel" style="width: 220px"></el-input>
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
        :before-close="drawerHandleClose"
        size="850px"
        class="drawer">
        <div class="wrapper" ref="wrapper">
          <div>
            <div class="drawer_form_model">
              <el-row>
                <el-col :span="4"><span style="font-size: 18px;font-weight: bolder">名称:</span></el-col>
                <el-col :span="4"><span style="font-size: 14px">{{drawerData.codeName}}</span></el-col>
              </el-row>
              <el-row>
                <el-col :span="4"><span style="font-size: 18px;font-weight: bolder">类型:</span></el-col>
                <el-col :span="4"><span style="font-size: 14px">{{drawerData.codeType}}</span></el-col>
              </el-row>
              <el-row>
                <el-col :span="4"><span style="font-size: 18px;font-weight: bolder">继承级别:</span></el-col>
                <el-col :span="4"><span style="font-size: 14px">{{drawerData.codeLevel}}</span></el-col>
              </el-row>
              <el-row :gutter="24">
                <el-col :span="4"><span style="font-size: 18px;line-height: 40px;font-weight: bolder">应用范围:</span>
                </el-col>
                <el-col :span="20">
                  <el-row :gutter="24">
                    <el-col :span="10">
                      <el-input placeholder="应用范围" @change="drawerInputChange" v-model="drawerData.usePosition"
                                class="drawer_form_model_useposition_input"></el-input>
                    </el-col>
                  </el-row>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="4"><span style="font-size: 18px">简介:</span></el-col>
              </el-row>
              <el-input type="textarea" @change="drawerInputChange" :autosize="{minRows:16,maxRows:16}"
                        class="drawer_form_model_remark" v-model="drawerData.codeRemark" maxlength="50" show-word-limit>
              </el-input>

              <div v-if="drawerData.codeType != 'ANNOTATION'">
                <el-row>
                  <el-col style="margin-top: 20px;text-align: center;font-size: 24px;font-weight: bolder;">
                    <span>方 法
                    </span>
                    <el-button size="mini" style="position: relative;bottom: 4px;"
                               @click="addParameterInput(type = 'method')">+
                    </el-button>
                  </el-col>
                </el-row>
                <el-table :data="drawerData.codeMethods" class="code_methods_table" border>
                  <el-table-column type="expand">
                    <template slot-scope="scope">
                      <el-form label-position="left" inline class="code_methods_expand">
                        <el-form-item label="方法名称：">
                          <span>{{ scope.row.methodName }}</span>
                        </el-form-item>
                        <el-form-item label="方法用处：">
                          <span>{{ scope.row.methodUsage }}</span>
                        </el-form-item>
                        <el-form-item label="方法理解：">
                          <span>{{ scope.row.methodNotice }}</span>
                        </el-form-item>
                        <el-form-item label="方法入参：">
                          <span>{{ scope.row.methodOrder }}</span>
                        </el-form-item>
                        <el-form-item label="方法出参：">
                          <span>{{ scope.row.methodResult }}</span>
                        </el-form-item>
                        <el-form-item label="是否为静态方法：">
                          <span>{{ scope.row.abstract }}</span>
                        </el-form-item>
                        <el-form-item label="是否常用：">
                          <span>{{ scope.row.methodCommonUse }}</span>
                        </el-form-item>
                      </el-form>
                    </template>
                  </el-table-column>
                  <el-table-column
                    label="方法名称"
                    align="center"
                    prop="methodName">
                    <template slot-scope="scope">
                      <el-input placeholder="方法名称" v-model="scope.row.methodName"
                                v-if="scope.row.type == 'new'"></el-input>
                      <span v-else>{{scope.row.methodName}}</span>
                    </template>
                  </el-table-column>
                  <el-table-column
                    label="方法用处"
                    align="center"
                    prop="methodsUsage">
                    <template slot-scope="scope">
                      <el-input placeholder="用法" v-model="scope.row.methodUsage"
                                v-if="scope.row.type == 'new'"></el-input>
                      <span v-else>{{scope.row.methodUsage}}</span>
                    </template>

                  </el-table-column>
                  <el-table-column
                    label="是否常用"
                    align="center"
                    prop="isCommonUse">
                    <template slot-scope="scope">
                      <el-switch v-model="scope.row.methodCommonUse" active-value="Y"
                                 inactive-value="N" v-if="scope.row.type == 'new'"></el-switch>
                      <span v-else>{{scope.row.methodCommonUse}}</span>
                    </template>
                  </el-table-column>
                  <el-table-column label="操作" align="center" style="text-align: center">
                    <template slot-scope="scope">
                      <el-button size="mini" type="primary" v-if="scope.row.type !== 'new'">编辑</el-button>
                      <el-button size="mini" v-if="scope.row.type !== 'new'">删除</el-button>
                      <el-button size="mini" v-if="scope.row.type == 'new'" type="primary"
                                 @click="sureAddCodeParam(scope.row,type = 'method')">保存
                      </el-button>
                      <el-button size="mini" v-if="scope.row.type == 'new'" type="danger"
                                 @click="cancelNewParamInput(scope.$index,drawerData.codeMethods)">撤销
                      </el-button>
                    </template>
                  </el-table-column>
                </el-table>
              </div>


              <div v-if="drawerData.codeType != 'INTERFACE'">
                <el-row>
                  <el-col style="margin-top: 20px;text-align: center;font-size: 24px;font-weight: bolder;">
                    <span>参 数
                    </span>
                    <el-button size="mini" style="position: relative;bottom: 4px;"
                               @click="addParameterInput(type = 'parameter')">+
                    </el-button>
                  </el-col>
                </el-row>
                <el-table :data="drawerData.codeParameters" class="outside_url_table" border>
                  <el-table-column
                    label="参数名称"
                    align="center"
                    prop="parameterName">
                    <template slot-scope="scope">
                      <el-input placeholder="参数名称" v-model="scope.row.parameterName"
                                v-if="scope.row.type == 'new'"></el-input>
                      <span v-else>{{scope.row.parameterName}}</span>
                    </template>
                  </el-table-column>
                  <el-table-column
                    label="参数类型"
                    align="center"
                    prop="parameterType">
                    <template slot-scope="scope">
                      <el-input placeholder="参数类型" v-model="scope.row.parameterType"
                                v-if="scope.row.type == 'new'"></el-input>
                      <span v-else>{{scope.row.parameterType}}</span>
                    </template>
                  </el-table-column>
                  <el-table-column
                    label="参数解释"
                    align="center"
                    prop="parameterRemark">
                    <template slot-scope="scope">
                      <el-input placeholder="参数解释" v-model="scope.row.parameterRemark"
                                v-if="scope.row.type == 'new'"></el-input>
                      <span v-else>{{scope.row.parameterRemark}}</span>
                    </template>
                  </el-table-column>
                  <el-table-column label="操作" align="center">
                    <template slot-scope="scope">
                      <el-button size="mini" type="primary" v-if="scope.row.type !== 'new'">编辑</el-button>
                      <el-button size="mini" v-if="scope.row.type !== 'new'">删除</el-button>
                      <el-button size="mini" v-if="scope.row.type == 'new'" type="primary"
                                 @click="sureAddCodeParam(scope.row,type = 'params')">保存
                      </el-button>
                      <el-button size="mini" v-if="scope.row.type == 'new'" type="danger"
                                 @click="cancelNewParamInput(scope.$index,drawerData.codeParameters)">撤销
                      </el-button>
                    </template>
                  </el-table-column>
                </el-table>
              </div>
              <div>
                <el-row>
                  <el-col style="margin-top: 20px;text-align: center;font-size: 24px;font-weight: bolder;">
                    <span>外部链接
                    </span>
                    <el-button size="mini" style="position: relative;bottom: 4px;"
                               @click="addParameterInput(type = 'url')">+
                    </el-button>
                  </el-col>
                </el-row>
                <el-table :data="drawerData.outSideUrl" class="outside_url_table" border>
                  <el-table-column
                    label="链接注释"
                    align="center"
                    prop="outSideUrlRemark">
                    <template slot-scope="scope">
                      <el-input placeholder="链接注释" v-model="scope.row.outSideUrlPath"
                                v-if="scope.row.type == 'new'"></el-input>
                      <span v-else>{{scope.row.outSideUrlRemark}}</span>
                    </template>
                  </el-table-column>
                  <el-table-column
                    label="路径"
                    align="center"
                    prop="outSideUrlPath">
                    <template slot-scope="scope">
                      <el-input placeholder="路径" v-model="scope.row.outSideUrlRemark"
                                v-if="scope.row.type == 'new'"></el-input>
                      <span v-else>{{scope.row.outSideUrlPath}}</span>
                    </template>
                  </el-table-column>
                  <el-table-column label="操作" align="center">
                    <template slot-scope="scope">
                      <el-button size="mini" type="primary" v-if="scope.row.type !== 'new'">编辑</el-button>
                      <el-button size="mini" v-if="scope.row.type !== 'new'">删除</el-button>
                      <el-button size="mini" v-if="scope.row.type == 'new'" type="primary"
                                 @click="sureAddCodeParam(scope.row,type = 'url')">保存
                      </el-button>
                      <el-button size="mini" v-if="scope.row.type == 'new'" type="danger"
                                 @click="cancelNewParamInput(scope.$index,drawerData.outSideUrl)">撤销
                      </el-button>
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
        codeForm: {
          codeName: "",
          codeType: "",
          codeLevel: "",
          codeProgram: "",
          codeId: "",
          type: ""
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
        dialog: {
          dialogTital: "",
          dialogVisible: false
        },
        drawerData: {
          codeId: "",
          codeName: "",
          codeType: "",
          codeLevel: "",
          codeRemark: "",
          haveChange: false,
          usePosition: ""
        },
        codeParamAddForm: {
          methodAddForm: {
            methodName: "",
            methodUsage: "",
            methodOrder: "",
            isCommonUse: "",
          },
          paramAddForm: {
            parameterName: "",
            parameterType: "",
            parameterRemark: "",
          },
          urlAddForm: {
            outSideUrlRemark: "",
            outSideUrlPath: "",
          }
        },
        codeUpdateForm: {
          codeId: "",
          codeName: "",
          codeType: "",
          codeLevel: 0,
          codeRemark: "",
          usePosition: "",
          updateType: ""
        },
      }
    },
    mounted() {
      this.$axios({
        url: "http://localhost:9055/base/code/codeInfoQuery?programId=" + this.$route.query.projectId + "&keyWord=" + "",
        method: "Get"
      }).then(res => {
        if (res.data.status == "SUCCESS") {
          console.log(res)
          this.projectForm.projectName = res.data.object.projectName
          this.tableData = res.data.object.codeInfoList
        } else {
          this.$message.error("查询失败!" + res.data.msg)
        }
      })
    },
    methods: {
      goBack() {
        this.$router.push("/main")
      },
      addNewCode() {
        this.dialog.dialogVisible = true
        this.dialog.dialogTital = "新增源码"
      },
      updateCode(row) {
        this.dialog.dialogVisible = true
        this.dialog.dialogTital = "编辑源码"
        this.codeForm = row
        this.codeUpdateForm = row
        this.codeUpdateForm.updateType = "BASE"
      },
      handleClose(done) {
        done()
      },
      drawerHandleClose(done) {
        if (this.drawerData.haveChange == true) {
          this.$confirm('该源码有文本已编辑, 是否保存?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.codeUpdateForm.updateType = "EXTRA"
            this.codeUpdateForm = this.drawerData
            this.codeUpdate()
            done()
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '撤销保存!'
            });
          });
        } else {
          done()
        }

      },
      cancelDialog() {
        this.doSearch()
        this.dialog.dialogVisible = false
      },
      sureAddCode() {
        this.codeForm.codeProgram = this.$route.query.projectId
        if (this.dialog.dialogTital == "编辑源码") {
          this.codeUpdate()
        } else {
          this.$axios({
            url: "http://localhost:9055/base/code/codeAdd",
            data: this.codeForm,
            method: "Post"
          }).then(res => {
            if (res.data.status == "SUCCESS") {
              this.$message.success("操作成功")
              this.dialog.dialogVisible = false
              this.doSearch()
            }
          })
        }

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
        this.drawerData = row
      },
      delCode(row) {
        this.$axios({
          url: "http://localhost:9055/base/code/delCode",
          data: {
            codeId: row.codeId,
          },
          method: "Post"
        }).then(res => {
          if (res.data.status == "SUCCESS") {
            this.$axios({
              url: "http://localhost:9055/base/code/codeInfoQuery?programId=" + this.$route.query.projectId + "&codeName=" + this.codeSearch.codeName + "&codeType=" + this.codeSearch.codeType + "&codeLevel=" + this.codeSearch.codeLevel,
              method: "get"
            }).then(res => {
              if (res.data.status = "SUCCESS") {
                this.tableData = res.data.object.codeInfoList
              }
            })
          }
        })
      },
      addParameterInput(type) {
        if (type == 'method') {
          this.drawerData.codeMethods.push({
            methodName: "",
            methodUsage: "",
            methodOrder: "",
            isCommonUse: "",
            type: "new"
          })
        } else if (type == 'parameter') {
          this.drawerData.codeParameters.push({
            parameterName: "",
            parameterType: "",
            parameterRemark: "",
            type: "new"
          })
        } else if (type == 'url') {
          this.drawerData.outSideUrl.push({
            outSideUrlRemark: "",
            outSideUrlPath: "",
            type: "new"
          })
        }
      },
      cancelNewParamInput(index, tableDate) {
        tableDate.splice(index, 1)
      },
      drawerInputChange() {
        this.drawerData.haveChange = true
      },
      codeUpdate() {
        this.$axios({
          url: "http://localhost:9055/base/code/codeUpdate",
          data: this.codeUpdateForm,
          method: "Post"
        }).then(res => {
          if (res.data.status == "SUCCESS") {
            this.$message({
              type: 'success',
              message: '保存成功!'
            });
            this.dialog.dialogVisible = false
            this.doSearch()
          } else {
            this.$message({
              type: 'error',
              message: '保存失败!' + res.data.msg + "!"
            });
          }
        })
      },
      sureAddCodeParam(row, type) {
        var obj;
        if (type == 'method') {
          obj = {
            methodName: row.methodName,

          }
        }
        this.$axios({
          url: "http://localhost:9055/base/code/codeParamsAdd",
          method: "Post",
          data: {
            codeId: this.drawerData.codeId,
            info: obj,
            type: type
          }
        }).then(res => {
          if (res.data.status == "SUCCESS") {
            console.log(res)
            this.drawerData.codeMethods = res.data.object.codeMethodInfoList
            this.drawerData.codeParameters = res.data.object.codeParameterInfos
            this.drawerData.outSideUrl = res.data.object.codeOutSideUrlInfos
          }
        })
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
    margin-right: 20px;
  }

  .drawer_form_model >>> .el-row {
    margin-bottom: 20px;
  }

  .drawer_form_model_remark {
    padding: 10px;
    /*border: 1px solid rgba(0, 0, 0, 0.1);*/
    height: 400px;
    font-size: 14px;
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

  .outside_url_table {
    margin-bottom: 20px;
  }

  .el-button + .el-button {
    margin-left: 0px;
  }

  .code_methods_expand {
    font-size: 0;
  }

  .code_methods_expand label {
    width: 90px;
    color: #99a9bf;
  }

  .code_methods_expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }


</style>
