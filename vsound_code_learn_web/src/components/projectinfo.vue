<template>
  <el-container class="container">
    <el-header class="header">
      <span class="header_title">
        {{projectForm.projectName}}
      </span>
      <div class="header_buttons">
        <el-button size="small" @click="createCodeParameters(type = 'CODE')">新增</el-button>
        <el-button size="small" @click="goBack">返回主页</el-button>
      </div>
    </el-header>
    <el-container>
      <el-main class="main">
        <el-row>
          <el-col :span="4">
            <el-input placeholder="源码名称" v-model="codeSearch.codeName"></el-input>
          </el-col>
          <el-col :span="2" style="margin-left: 10px">
            <el-select v-model="codeSearch.codeType" clearable placeholder="类型">
              <el-option
                v-for="item in codeType"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-col>
          <el-col :span="2" style="margin-left: 10px">
            <el-button @click="doSearch" type="primary">查 询</el-button>
          </el-col>
        </el-row>
        <el-table :data="tableData" style="margin-top: 10px;background-color: rgba(0,0,0,0.1)">
          <el-table-column
            label="名称"
            align="center"
            prop="codeName"
            width="280">
          </el-table-column>
          <el-table-column
            label="类型"
            align="center"
            prop="codeType">
          </el-table-column>
          <el-table-column
            label="方法数量"
            align="center"
            prop="codeLevel">
          </el-table-column>
          <el-table-column
            label="Field数量"
            align="center"
            prop="codeLevel">
          </el-table-column>
          <el-table-column
            label="外链数量"
            align="center"
            prop="codeLevel">
          </el-table-column>
          <el-table-column
            label="详情"
            align="center">
            <template slot-scope="scope">
              <el-button size="mini" @click="viewDetails(scope.row)" type="primary">查看详情</el-button>
            </template>
          </el-table-column>
          <el-table-column
            label="操作"
            align="center">
            <template slot-scope="scope">
              <el-button size="mini" type="primary" @click="updateCodeParameters(scope.row,'CODE')">编辑</el-button>
              <el-button size="mini" type="danger" @click="deleteCodeParameters(scope.row,'CODE')">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-main>
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
                <el-col :span="4"><span style="font-size: 20px">{{drawerData.codeName}}</span></el-col>
              </el-row>
              <el-row>
                <el-col :span="4"><span style="font-size: 18px;font-weight: bolder">类型:</span></el-col>
                <el-col :span="4"><span style="font-size: 14px">{{drawerData.codeType}}</span></el-col>
              </el-row>
              <el-row>
                <el-col :span="4"><span style="font-size: 18px;font-weight: bolder">简介:</span></el-col>
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
                               @click="createCodeParameters(type = 'METHOD')">+
                    </el-button>
                  </el-col>
                </el-row>
                <el-table :data="drawerData.codeMethodInfoList" class="code_methods_table" border>
                  <el-table-column
                    label="方法名称"
                    align="center"
                    prop="methodName">
                  </el-table-column>
                  <el-table-column
                    label="基础属性"
                    align="center"
                    prop="methodBasic">
                  </el-table-column>
                  <el-table-column
                    label="作用域"
                    align="center"
                    prop="methodAction">
                  </el-table-column>
                  <el-table-column
                    label="是否常用"
                    align="center"
                    prop="methodCommonUse">
                  </el-table-column>
                  <el-table-column label="详情" align="center">
                    <template slot-scope="scope">
                      <el-button size="mini" type="primary" v-if="scope.row.type !== 'new'"
                                 @click="">查看详情
                      </el-button>
                    </template>
                  </el-table-column>
                  <el-table-column label="操作" align="center" style="text-align: center">
                    <template slot-scope="scope">
                      <el-button size="mini" type="primary" v-if="scope.row.type !== 'new'"
                                 @click="updateCodeParameters(scope.row,type = 'METHOD')">编辑
                      </el-button>
                      <el-button size="mini" v-if="scope.row.type !== 'new'"
                                 @click="deleteCodeParameters(scope.row,type = 'METHOD')">删除
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
                               @click="createCodeParameters(type = 'PARAMETER')">+
                    </el-button>
                  </el-col>
                </el-row>
                <el-table :data="drawerData.codeParameterInfos" class="outside_url_table" border>
                  <el-table-column
                    label="参数名称"
                    align="center"
                    prop="parameterName">
                  </el-table-column>
                  <el-table-column
                    label="参数类型"
                    align="center"
                    prop="parameterType">
                  </el-table-column>
                  <el-table-column
                    label="参数解释"
                    align="center"
                    prop="parameterRemark">
                  </el-table-column>
                  <el-table-column label="操作" align="center">
                    <template slot-scope="scope">
                      <el-button size="mini" type="primary" @click="updateCodeParameters(scope.row,'PARAMETER')"
                                 v-if="scope.row.type !== 'new'">编辑
                      </el-button>
                      <el-button size="mini" v-if="scope.row.type !== 'new'"
                                 @click="deleteCodeParameters(scope.row,'PARAMETER')">删除
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
                               @click="createCodeParameters(type = 'URL')">+
                    </el-button>
                  </el-col>
                </el-row>
                <el-table :data="drawerData.codeOutSideUrlInfos" class="outside_url_table" border>
                  <el-table-column
                    label="链接注释"
                    align="center"
                    prop="urlRemark">
                  </el-table-column>
                  <el-table-column
                    label="路径"
                    align="center"
                    prop="urlPath">
                  </el-table-column>
                  <el-table-column label="操作" align="center">
                    <template slot-scope="scope">
                      <el-button size="mini" type="primary" @click="updateCodeParameters(scope.row,'URL')"
                                 v-if="scope.row.type !== 'new'">编辑
                      </el-button>
                      <el-button size="mini" @click="deleteCodeParameters(scope.row,'URL')"
                                 v-if="scope.row.type !== 'new'">删除
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
    <el-dialog
      :title="dialog.dialogTitle"
      :visible.sync="dialog.dialogVisible"
      width="28%"
      :before-close="handleClose">
      <el-form ref="codeForm" :model="codeForm" :rules="rules" style="margin-left: auto;margin-right: auto; width: 80%;"
               v-if="dialog.dialogType == 'CODE'">
        <el-form-item label="源码名称:" prop="codeName">
          <el-input placeholder="请输入源码名称" v-model="CUDCodeForm.codeName" style="width: 300px"></el-input>
        </el-form-item>
        <el-form-item label="源码类型:" prop="codeType">
          <el-select v-model="CUDCodeForm.codeType" clearable style="width: 300px" placeholder="请选择源码类型">
            <el-option
              v-for="item in codeType"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>

      <code-method-c-u-d-form :CUDCodeMethodForm="CUDCodeMethodForm" :dialog="dialog"></code-method-c-u-d-form>
      <code-parameter-c-u-d-form :CUDCodeParameterForm="CUDCodeParameterForm"
                                 :dialog="dialog"></code-parameter-c-u-d-form>
      <code-out-side-url-c-u-d-form :CUDCodeUrlForm="CUDCodeUrlForm" :dialog="dialog"></code-out-side-url-c-u-d-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="cancelDialog">取 消</el-button>
    <el-button type="primary" @click="doCodeParameterCUD">确 定</el-button>
  </span>
    </el-dialog>
  </el-container>


</template>

<script>
  import CodeMethodCUDForm from "./formwidget/CodeMethodCUDForm";
  import CodeParameterCUDForm from "./formwidget/CodeParameterCUDForm";
  import CodeOutSideUrlCUDForm from "./formwidget/CodeOutSideUrlCUDForm";

  export default {
    name: "projectinfo",
    components: {CodeOutSideUrlCUDForm, CodeParameterCUDForm, CodeMethodCUDForm},
    data() {
      return {
        drawer: false,
        labelPosition: "right",
        direction: 'rtl',
        form: {
          reset: false,
          formName: ""
        },
        rules: {},
        projectForm: {
          projectName: ""
        },
        codeForm: {
          codeName: "",
          codeType: "",
          codeLevel: "",
          codeProgram: "",
          codeId: "",
          cudType: ""
        },
        codeSearch: {
          codeName: "",
          codeLevel: "",
          codeType: ""
        },
        CUDCodeMethodForm: {
          methodId: "",
          methodName: "",
          methodOrder: [{parameterName: "asdas"}],
          methodResult: "",
          cudType: "",
          fromCodeId: "",
          methodUsage: "",
          methodBasic: "",
          methodAction: "",
          methodType: false,
          isOverwrite: false
        },
        CUDCodeParameterForm: {
          isAutowire: "",
          isFinal: "",
          isInterface: "",
          parameterName: "",
          parameterRemark: "",
          parameterType: "",
          cudType: ""
        },
        CUDCodeUrlForm: {
          urlId: "",
          urlPath: "",
          urlRemark: "",
          cudType: "",
          fromCodeId: ""
        },
        tableData: [],
        codeType: [
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
          dialogTitle: "",
          dialogVisible: false,
          dialogType: "",
          cudType: "",
          dialogData: {}
        },
        drawerData: {
          codeId: "",
          codeName: "",
          codeType: "",
          codeLevel: "",
          codeRemark: "",
          haveChange: false,
          usePosition: "",
          codeMethodInfoList: [],
          codeOutSideUrlList: []
        },
        CUDCodeForm: {
          codeId: "",
          codeName: "",
          codeType: "",
          codeLevel: 1,
          codeRemark: "",
          usePosition: "",
          cudType: "",
          codeProgram: ""
        },
      }
    },
    mounted() {
      this.$axios({
        url: this.Globel.requestUrl + "/project/projectQuery?projectId=" + this.$route.query.projectId,
        method: "GET"
      }).then(res => {
        if (res.data.success) {
          this.projectForm.projectName = res.data.data.projectName
          this.tableData = res.data.data.codeInfoList
        } else {
          this.$message.error("查询失败!" + res.data.msg)
        }
      })
    },

    methods: {
      goBack() {
        this.$router.push("/main")
      },

      codeMethodListQuery(codeId) {
        this.$axios({
          url: this.Globel.requestUrl + "/code/codeMethodListQuery?codeId=" + codeId,
          method: "GET"
        }).then(res => {
          if (res.data.success) {
            this.drawerData.codeMethodInfoList = res.data.data.codeMethodInfoList
          } else {
            this.$message.error(res.data.msg)
          }
        })
      },

      handleClose(done) {
        done()
      },

      doSearch() {
        this.$axios({
          url: this.Globel.requestUrl + "/project/projectQuery?projectId=" + this.$route.query.projectId,
          method: "GET"
        }).then(res => {
          if (res.data.success) {
            this.projectForm.projectName = res.data.data.projectName
            this.tableData = res.data.data.codeInfoList
          } else {
            this.$message.error("查询失败!" + res.data.msg)
          }
        })
      },

      /**
       * 查询源码详情
       * */
      viewDetails(row) {
        this.drawer = true
        this.$axios({
          url: this.Globel.requestUrl + "/code/codeDetailQuery?codeId=" + row.codeId,
          method: "GET",
        }).then(res => {
          this.drawerData = res.data.data
        })
      },

      /**
       * CUD源码内容
       * */
      createCodeParameters(type) {
        this.dialog.dialogVisible = true
        this.dialog.cudType = "CREATE"

        if (type === "CODE") {
          this.dialog.dialogTitle = "源码新增";
          this.dialog.dialogType = "CODE";
        }
        if (type === "METHOD") {
          this.dialog.dialogTitle = "方法新增";
          this.dialog.dialogType = "METHOD";
        }
        if (type === "PARAMETER") {
          this.dialog.dialogTitle = "参数新增";
          this.dialog.dialogType = "PARAMETER";
        }
        if (type === "URL") {
          this.dialog.dialogTitle = "外链新增";
          this.dialog.dialogType = "URL";
        }
      },

      /**
       * 更新源码相关参数
       * */
      updateCodeParameters(row, type) {
        this.dialog.dialogVisible = true;
        this.dialog.cudType = "UPDATE";

        if (type === "CODE") {
          this.dialog.dialogTitle = "源码编辑";
          this.dialog.dialogType = "CODE";
          this.CUDCodeForm = row;
        }
        if (type === "METHOD") {
          this.dialog.dialogTitle = "方法编辑";
          this.dialog.dialogType = "METHOD";
          this.CUDCodeMethodForm = row;
        }
        if (type === "PARAMETER") {
          this.dialog.dialogTitle = "参数编辑";
          this.dialog.dialogType = "PARAMETER";
          this.CUDCodeParameterForm = row;
        }
        if (type === "URL") {
          this.dialog.dialogTitle = "外链编辑";
          this.dialog.dialogType = "URL";
          this.CUDCodeUrlForm = row;
        }
      },

      deleteCodeParameters(row, type) {
        this.dialog.cudType = "DELETE";
        if (type === "CODE") {
          this.CUDCodeForm = row;
          this.sureCUDCode()
        }
        if (type === "METHOD") {
          this.CUDCodeMethodForm = row;
          this.sureCUDCodeMethod()
        }
        if (type === "PARAMETER") {
          this.CUDCodeParameterForm = row;
          this.sureCUDCodeParameter()
        }
        if (type === "URL") {
          this.CUDCodeUrlForm = row;
          this.sureCUDCodeUrl()
        }
      },

      /**
       * 执行CUD转发方法
       * */
      doCodeParameterCUD() {
        if (this.dialog.dialogType === "CODE") {
          this.sureCUDCode();
        }
        if (this.dialog.dialogType === "METHOD") {
          this.sureCUDCodeMethod();
        }
        if (this.dialog.dialogType === "PARAMETER") {
          this.sureCUDCodeParameter();
        }
        if (this.dialog.dialogType === "URL") {
          this.sureCUDCodeUrl();
        }
      },

      /**
       * 新增或编辑源码
       * */
      sureCUDCode() {
        this.CUDCodeForm.cudType = this.dialog.cudType;
        this.CUDCodeForm.codeProgram = this.$route.query.projectId;
        this.$axios({
          url: this.Globel.requestUrl + "/code/codeCUD",
          data: this.CUDCodeForm,
          method: "POST"
        }).then(res => {
          if (res.data.success) {
            this.$message.success(res.data.msg)
            this.dialog.dialogVisible = false
            this.doSearch()
          } else {
            this.$message({
              showClose: true,
              message: res.data.msg,
              type: 'error'
            })
          }
        })
      },

      /**
       * CUD源码方法
       * */
      sureCUDCodeMethod() {
        this.CUDCodeMethodForm.cudType = this.dialog.cudType;  //CUD类型
        this.CUDCodeMethodForm.fromCodeId = this.drawerData.codeId //从抽屉中获取CodeId
        this.$axios({
          url: this.Globel.requestUrl + "/code/codeMethodCUD",
          method: "POST",
          data: this.CUDCodeMethodForm
        }).then(res => {
          if (res.data.success) {
            this.$message.success(res.data.msg)
            this.dialog.dialogVisible = false
            this.$refs["CUDCodeMethodForm"].resetFields()
            this.codeMethodListQuery(this.drawerData.codeId)
          } else {
            this.$message.error(res.data.msg)
          }
        });
      },

      /**
       * CUD源码参数
       * */
      sureCUDCodeParameter() {

        this.CUDCodeParameterForm.cudType = this.dialog.cudType;
        this.CUDCodeParameterForm.fromCodeId = this.drawerData.codeId; //从抽屉中获取CodeId
        this.$axios({
          url: this.Globel.requestUrl + "/code/codeParameterCUD",
          method: "POST",
          data: this.CUDCodeParameterForm
        }).then(res => {
          if (res.data.success) {
            this.$message.success("操作成功！")
            this.dialog.dialogVisible = false
            this.$axios({
              url: this.Globel.requestUrl + "/code/codeParameterListQuery?codeId=" + this.CUDCodeParameterForm.fromCodeId,
              method: "GET"
            }).then(res => {
              if (res.data.success) {
                this.drawerData.codeParameterInfos = res.data.data.codeParameterInfoList
              } else {
                this.$message.error("获取方法列表失败!")
              }
            })
            this.$refs["CUDCodeParameterForm"].resetFields()
          } else {
            this.$message.error(res.data.msg)
          }
        })

      },

      /**
       * CUD源码链接
       * */
      sureCUDCodeUrl() {
        this.CUDCodeUrlForm.cudType = this.dialog.cudType;
        this.CUDCodeUrlForm.fromCodeId = this.drawerData.codeId; //从抽屉中获取CodeId
        this.$axios({
          url: this.Globel.requestUrl + "/code/codeOutSideUrlCUD",
          method: "POST",
          data: this.CUDCodeUrlForm
        }).then(res => {
          if (res.data.success) {
            this.$message.success("操作成功！")
            this.dialog.dialogVisible = false
            this.$axios({
              url: this.Globel.requestUrl + "/code/codeOutSideUrlListQuery?codeId=" + this.CUDCodeUrlForm.fromCodeId,
              method: "GET",
            }).then(res => {
              if (res.data.success) {
                this.drawerData.codeOutSideUrlInfos = res.data.data.codeOutSideUrlInfoList
              }
            })
            this.$refs["CUDCodeUrlForm"].resetFields()
          } else {
            this.$message.error(res.data.msg)
          }
        })

      },
      drawerHandleClose(done) {
        if (this.drawerData.haveChange == true) {
          this.$confirm('该源码有文本已编辑, 是否保存?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.CUDCodeForm = this.drawerData
            this.dialog.cudType = "UPDATE"
            this.sureCUDCode()
            done()
          }).catch(() => {

          })
        } else {
          done()
        }
      },

      cancelDialog() {
        this.doSearch()
        this.dialog.dialogVisible = false
        this.$refs["CUDCodeMethodForm"].resetFields()
      },

      drawerInputChange() {
        this.drawerData.haveChange = true
      },

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
    font-size: 28px;
    font-weight: bold;
    position: relative;
    left: 40px;
    height: 60px;
    line-height: 60px;
    font-family: "宋体";
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
    margin-right: 25px;
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
