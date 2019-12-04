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
                          <span>{{ scope.row.isAbstract }}</span>
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
                  </el-table-column>
                  <el-table-column
                    label="方法用处"
                    align="center"
                    prop="methodUsage">
                  </el-table-column>
                  <el-table-column
                    label="是否常用"
                    align="center"
                    prop="methodCommonUse">
                  </el-table-column>
                  <el-table-column label="操作" align="center" style="text-align: center">
                    <template slot-scope="scope">
                      <el-button size="mini" type="primary" v-if="scope.row.type !== 'new'"
                                 @click="sureCUDCodeMethod(scope.row,type = 'U')">编辑
                      </el-button>
                      <el-button size="mini" v-if="scope.row.type !== 'new'"
                                 @click="sureCUDCodeMethod(scope.row,type = 'D')">删除
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
                  <el-table-column type="expand">
                    <template slot-scope="scope">
                      <el-form label-position="left" inline class="code_methods_expand">
                        <el-form-item label="参数名称：">
                          <span>{{ scope.row.parameterName }}</span>
                        </el-form-item>
                        <el-form-item label="参数注释：">
                          <span>{{ scope.row.parameterRemark }}</span>
                        </el-form-item>
                        <el-form-item label="参数类型：">
                          <span>{{ scope.row.parameterType }}</span>
                        </el-form-item>
                        <el-form-item label="是否为常量：">
                          <span>{{ scope.row.isFinal }}</span>
                        </el-form-item>
                        <el-form-item label="是否Autowire：">
                          <span>{{ scope.row.isAutowire }}</span>
                        </el-form-item>
                        <el-form-item label="是否为接口：">
                          <span>{{ scope.row.isInterface }}</span>
                        </el-form-item>
                      </el-form>
                    </template>
                  </el-table-column>
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
                      <el-button size="mini" type="primary" @click="sureCUDCodeParameter(scope.row,type='U')" v-if="scope.row.type !== 'new'">编辑</el-button>
                      <el-button size="mini" v-if="scope.row.type !== 'new'" @click="sureCUDCodeParameter(scope.row,type='D')">删除</el-button>
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
                    prop="urlRemark">
                  </el-table-column>
                  <el-table-column
                    label="路径"
                    align="center"
                    prop="urlPath">
                  </el-table-column>
                  <el-table-column label="操作" align="center">
                    <template slot-scope="scope">
                      <el-button size="mini" type="primary" @click="sureCUDCodeUrl(scope.row,type='U')" v-if="scope.row.type !== 'new'">编辑</el-button>
                      <el-button size="mini" @click="sureCUDCodeUrl(scope.row,type='D')" v-if="scope.row.type !== 'new'">删除</el-button>
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
      :title="dialog.dialogTital"
      :visible.sync="dialog.dialogVisible"
      width="30%"
      :before-close="handleClose">
      <el-form ref="codeForm" :model="codeForm" :rules="rules" style="margin-left: 10px;" v-if="dialog.dialogType == 'code'">
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
      <el-form v-else-if="dialog.dialogType=='method'" ref="CUDCodeMethodForm" label-width="100px" :model="CUDCodeMethodForm" :label-position="labelPosition">
        <el-form-item label="方法名称:" prop="methodName">
          <el-input placeholder="请输入方法名称" v-model="CUDCodeMethodForm.methodName" style="width: 220px"></el-input>
        </el-form-item>
        <el-form-item label="方法注释:" prop="methodNotice">
          <el-input placeholder="请输入方法注释" v-model="CUDCodeMethodForm.methodNotice" style="width: 220px"></el-input>
        </el-form-item>
        <el-form-item label="方法入参:" prop="methodOrder">
          <el-input placeholder="请输入方法入参" v-model="CUDCodeMethodForm.methodOrder" style="width: 220px"></el-input>
        </el-form-item>
        <el-form-item label="方法反参:" prop="methodResult">
          <el-input placeholder="请输入方法反参" v-model="CUDCodeMethodForm.methodResult" style="width: 220px"></el-input>
        </el-form-item>
        <el-form-item label="是否为抽象:" prop="isAbstract">
          <el-switch
            v-model="CUDCodeMethodForm.isAbstract"
            active-color="#ff4949"
            inactive-color="#13ce66"
            active-value="N"
            inactive-value="Y">
          </el-switch>
        </el-form-item>
        <el-form-item label="是否常用:" prop="methodCommonUse">
          <el-switch
            v-model="CUDCodeMethodForm.methodCommonUse"
            active-color="#ff4949"
            inactive-color="#13ce66"
            active-value="N"
            inactive-value="Y">
          </el-switch>
        </el-form-item>
        <el-form-item label="用法:" prop="methodUsage">
          <el-input type="textarea" show-word-limit maxlength="50"  v-model="CUDCodeMethodForm.methodUsage" style="width: 220px"></el-input>
        </el-form-item>
      </el-form>
      <el-form v-else-if="dialog.dialogType=='parameter'" ref="CUDCodeParameterForm" label-width="100px" :model="CUDCodeParameterForm" :label-position="labelPosition">
        <el-form-item label="参数名称:" prop="parameterName">
          <el-input placeholder="请输入参数名称" v-model="CUDCodeParameterForm.parameterName" style="width: 220px"></el-input>
        </el-form-item>
        <el-form-item label="参数类型:" prop="parameterType">
          <el-input placeholder="请输入参数类型" v-model="CUDCodeParameterForm.parameterType" style="width: 220px"></el-input>
        </el-form-item>
        <el-form-item label="是否常量:" prop="isFinal">
          <el-switch
            v-model="CUDCodeParameterForm.isFinal"
            active-color="#ff4949"
            inactive-color="#13ce66"
            active-value="N"
            inactive-value="Y">
          </el-switch>
        </el-form-item>
        <el-form-item label="是否Autowire:" prop="isAutowire">
          <el-switch
            v-model="CUDCodeParameterForm.isAutowire"
            active-color="#ff4949"
            inactive-color="#13ce66"
            active-value="N"
            inactive-value="Y">
          </el-switch>
        </el-form-item>
        <el-form-item label="是否接口:" prop="isInterface">
          <el-switch
            v-model="CUDCodeParameterForm.isInterface"
            active-color="#ff4949"
            inactive-color="#13ce66"
            active-value="N"
            inactive-value="Y">
          </el-switch>
        </el-form-item>
        <el-form-item label="参数理解:" prop="parameterRemark">
          <el-input type="textarea" show-word-limit maxlength="50" v-model="CUDCodeParameterForm.parameterRemark" style="width: 220px"></el-input>
        </el-form-item>
      </el-form>
      <el-form v-else-if="dialog.dialogType=='url'"  ref="CUDCodeUrlForm" label-width="100px" :model="CUDCodeUrlForm" :label-position="labelPosition">
        <el-form-item label="链接注释:" prop="urlRemark">
          <el-input placeholder="请输入链接注释" v-model="CUDCodeUrlForm.urlRemark" style="width: 220px"></el-input>
        </el-form-item>
        <el-form-item label="链接地址:" prop="urlPath">
          <el-input placeholder="请输入链接地址" v-model="CUDCodeUrlForm.urlPath" style="width: 220px"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="cancelDialog">取 消</el-button>
    <el-button type="primary" @click="sureAddCodeParams">确 定</el-button>
  </span>
    </el-dialog>
  </el-container>


</template>

<script>
  export default {
    name: "projectinfo",
    data() {
      return {
        drawer: false,
        labelPosition:"right",
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
        CUDCodeMethodForm:{},
        CUDCodeParameterForm:{},
        CUDCodeUrlForm:{},
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
          dialogVisible: false,
          dialogType: "code"
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
        url: this.Globel.requestUrl+"/project/projectQuery?projectId=" + this.$route.query.projectId,
        method: "Get"
      }).then(res => {
        if (res.data.success) {
          console.log(res)
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

      addNewCode() {
        this.dialog.dialogVisible = true
        this.dialog.dialogTital = "新增源码"
        this.dialog.dialogType = "code"
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
            this.codeUpdateForm = this.drawerData
            this.codeUpdateForm.updateType = "EXTRA"
            this.sureCUCode()
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

      doSearch() {
        this.$axios({
          url: "https://119.3.219.207:9055/base/code/codeInfoQuery?programId=" + this.$route.query.projectId + "&codeName=" + this.codeSearch.codeName + "&codeType=" + this.codeSearch.codeType + "&codeLevel=" + this.codeSearch.codeLevel,
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
        console.log(this.drawerData)
      },

      delCode(row) {
        this.$axios({
          url: "https://119.3.219.207:9055/base/code/delCode",
          data: {
            codeId: row.codeId,
          },
          method: "Post"
        }).then(res => {
          if (res.data.status == "SUCCESS") {
            this.$axios({
              url: "https://119.3.219.207:9055/base/code/codeInfoQuery?programId=" + this.$route.query.projectId + "&codeName=" + this.codeSearch.codeName + "&codeType=" + this.codeSearch.codeType + "&codeLevel=" + this.codeSearch.codeLevel,
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
        this.dialog.dialogVisible = true
        if(type == "method"){
          this.dialog.dialogTital="方法新增"
        }else if(type == "parameter"){
          this.dialog.dialogTital="参数新增"
        }else{
          this.dialog.dialogTital="链接新增"
        }
        this.dialog.dialogType = type
      },

      drawerInputChange() {
        this.drawerData.haveChange = true
      },

      /**
       * 新增源码内容
       * */
      sureAddCodeParams() {
        if(this.dialog.dialogType == 'code'){
          this.sureCUCode();
        }
        if(this.dialog.dialogType == 'method'){
          this.sureCUDCodeMethod(null,"C")
        }
        if(this.dialog.dialogType == 'parameter'){
          this.sureCUDCodeParameter(null,"C")
        }
        if(this.dialog.dialogType == 'url'){
          this.sureCUDCodeUrl(null,"C")
        }
      },

      /**
       * 新增或编辑源码
       * */
      sureCUCode() {
        this.codeForm.codeProgram = this.$route.query.projectId
        if (this.dialog.dialogTital == "编辑源码" || this.codeUpdateForm.updateType == 'EXTRA') {
          this.$axios({
            url: "https://119.3.219.207:9055/base/code/codeUpdate",
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
        } else {
          this.$axios({
            url: "https://119.3.219.207:9055/base/code/codeAdd",
            data: this.codeForm,
            method: "Post"
          }).then(res => {
            if (res.data.status == "SUCCESS") {
              this.$message.success("操作成功")
              this.dialog.dialogVisible = false
              this.$refs[""]
              this.doSearch()
            }
          })
        }
      },

      /**
       * CUD源码方法
       * */
      sureCUDCodeMethod(row,type){
        if(row != null){
          this.CUDCodeMethodForm = row;
        }
        this.$axios({
          url:"https://119.3.219.207:9055/base/code/codeMethodCUD",
          method:"Post",
          data:{
            type:type,
            codeId:this.drawerData.codeId,
            methodId:this.CUDCodeMethodForm.methodId,
            codeMethodInfo:this.CUDCodeMethodForm
          }
        }).then(res =>{
          console.log(res.data.object)
          if(res.data.status == "SUCCESS"){
            this.$message.success("操作成功！")
            this.dialog.dialogVisible = false
            this.drawerData.codeMethods = res.data.object.codeMethodInfoList

            if(type == "C"){
              this.$refs["CUDCodeMethodForm"].resetFields()
            }
          }
        })

      },

      /**
       * CUD源码参数
       * */
      sureCUDCodeParameter(row,type){
        if(row != null){
          this.CUDCodeParameterForm = row;
        }
        this.$axios({
          url:"https://119.3.219.207:9055/base/code/codeParameterCUD",
          method:"Post",
          data:{
            type:type,
            codeId:this.drawerData.codeId,
            parameterId:this.CUDCodeParameterForm.parameterId,
            codeParameterInfo:this.CUDCodeParameterForm
          }
        }).then(res =>{
          if(res.data.status == "SUCCESS"){
            this.$message.success("操作成功！")
            this.dialog.dialogVisible = false
            this.drawerData.codeParameters = res.data.object.codeParameterInfoList

            if(type == "C"){
              this.$refs["CUDCodeParameterForm"].resetFields()
            }
          }
        })

      },

      /**
       * CUD源码链接
       * */
      sureCUDCodeUrl(row,type){
        if(row != null){
          this.CUDCodeUrlForm = row;
        }
        this.$axios({
          url:"https://119.3.219.207:9055/base/code/codeUrlCUD",
          method:"Post",
          data:{
            type:type,
            codeId:this.drawerData.codeId,
            urlId:this.CUDCodeUrlForm.urlId,
            codeOutSideUrlInfo:this.CUDCodeUrlForm
          }
        }).then(res =>{
          if(res.data.status == "SUCCESS"){
            this.$message.success("操作成功！")

            this.dialog.dialogVisible = false
            this.drawerData.outSideUrl = res.data.object.codeOutSideUrlInfoList

            if(type == "C"){
              this.$refs["CUDCodeUrlForm"].resetFields()
            }
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
