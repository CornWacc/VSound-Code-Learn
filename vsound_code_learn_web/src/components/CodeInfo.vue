<template>
  <el-container class="containers">
    <el-header class="header">
      <el-row :gutter="24" class="header_row">
        <el-col :span="20" class="header_row_project_name">
          <span>{{codeBase.codeName}}</span>
        </el-col>
        <el-col :span="2">
          <mu-button @click="toCodeList" color="#82A6F5" small>源码列表</mu-button>
        </el-col>
        <el-col :span="1">
          <mu-button @click="toMain" color="#82A6F5" small>返回主页</mu-button>
        </el-col>
      </el-row>
    </el-header>

    <el-main class="main">
      <div style="margin-bottom: 10px">
        <p style="font-size: 20px;;margin-bottom: 4px">源码参数:</p>
        <mu-button small color="#008B8B" @click="cudDialogShow('CREATE','PARAMETER')">新 增</mu-button>
      </div>

      <el-table :data="codeBase.codeParameterInfos">
        <el-table-column align="center" label="参数名称" prop="parameterName"></el-table-column>
        <el-table-column align="center" label="参数类型" prop="parameterType"></el-table-column>
        <el-table-column align="center" label="是否为常量" prop="isFinal"></el-table-column>
        <el-table-column align="center" label="是否Autowire引入" prop="isAutowire"></el-table-column>
        <el-table-column align="center" label="参数类型是否为接口" prop="isInterface"></el-table-column>
        <el-table-column align="center" label="参数备注" prop="parameterRemark">
          <template slot-scope="scope">
            <el-popover
              placement="top"
              title="备注"
              width="240"
              trigger="hover"
              :content="scope.row.parameterRemark">
              <el-button type="text" slot="reference">参数理解</el-button>
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column align="center" label="操作">
          <template slot-scope="scope">
            <mu-button icon color="primary" @click="cudDialogShow('UPDATE','PARAMETER',scope.row)">
              <mu-icon value="edit"></mu-icon>
            </mu-button>
            <mu-button icon color="error" @click="deletStrategy('PARAMETER',scope.row)">
              <mu-icon value="delete"></mu-icon>
            </mu-button>
          </template>
        </el-table-column>
      </el-table>

      <div style="margin-bottom: 10px;margin-top: 30px">
        <p style="font-size: 20px;margin-bottom: 4px">源码方法:</p>
        <mu-button small color="#008B8B" @click="cudDialogShow('CREATE','METHOD')">新 增</mu-button>
      </div>

      <el-table :data="codeBase.codeMethodInfoList">
        <el-table-column align="center" label="方法名称" prop="methodName"></el-table-column>
        <el-table-column align="center" label="方法返回类型" prop="methodResult"></el-table-column>
        <el-table-column align="center" label="方法基础类型" prop="methodBaseType"></el-table-column>
        <el-table-column align="center" label="是否常用" prop="methodCommonUse"></el-table-column>
        <el-table-column align="center" label="是否为构造方法" prop="methodIsConstruct"></el-table-column>
        <el-table-column align="center" label="是否重写" prop="methodIsOverwrite"></el-table-column>
        <el-table-column align="center" label="方法作用域" prop="methodActionScope"></el-table-column>
        <el-table-column align="center" label="方法入参">
          <template slot-scope="scope">
            <el-button type="text" @click="showMethodOrder(scope.row.methodOrder)">查看入参</el-button>
          </template>
        </el-table-column>
        <el-table-column align="center" label="操作">
          <template slot-scope="scope">
            <mu-button icon color="primary" @click="cudDialogShow('UPDATE','METHOD',scope.row)">
              <mu-icon value="edit"></mu-icon>
            </mu-button>
            <mu-button icon color="error" @click="deletStrategy('METHOD',scope.row)">
              <mu-icon value="delete"></mu-icon>
            </mu-button>
          </template>
        </el-table-column>
      </el-table>


      <div style="margin-bottom: 10px;margin-top: 30px">
        <p style="font-size: 20px;;margin-bottom: 4px">源码解析链接:</p>
        <mu-button small color="#008B8B" @click="cudDialogShow('CREATE','URL')">新 增</mu-button>
      </div>

      <el-table :data="codeBase.codeOutSideUrlInfos">
        <el-table-column align="center" label="链接地址" prop="urlPath">
          <template slot-scope="scope">
            <el-link type="primary" :href="'http://'+scope.row.urlPath" v-if="scope.row.urlPath != ''">
              {{scope.row.urlPath}}
            </el-link>
          </template>
        </el-table-column>
        <el-table-column align="center" label="链接备注" prop="urlRemark"></el-table-column>
        <el-table-column align="center" label="操作">
          <template slot-scope="scope">
            <mu-button icon color="primary" v-if="scope.row.type != 'NEW'" @click="cudDialogShow('UPDATE','URL',scope.row)">
              <mu-icon value="edit"></mu-icon>
            </mu-button>
            <mu-button icon color="error" v-if="scope.row.type != 'NEW'" @click="deletStrategy('URL',scope.row)">
              <mu-icon value="delete"></mu-icon>
            </mu-button>
            <mu-button icon color="success" v-if="scope.row.type == 'NEW'" @click="saveUrl(scope.row)">
              <mu-icon value="save"></mu-icon>
            </mu-button>
            <mu-button icon color="error" v-if="scope.row.type == 'NEW'" @click="cancelUrl(scope.$index)">
              <mu-icon value="cancel"></mu-icon>
            </mu-button>
          </template>
        </el-table-column>
      </el-table>
    </el-main>

    <el-dialog
      :title="configurationInfo.dialog.title"
      :visible.sync="configurationInfo.dialog.dialogIsShow"
      width="40%"
      :before-close="handleClose">

      <el-form :model="cudCodeParameterForm"
               :label-position="configurationInfo.labelPosition"
               ref="cudCodeParameterForm"
               label-width="120px"
               v-if="configurationInfo.dialog.type == 'PARAMETER'">
        <el-form-item prop="parameterName" label="参数名称:">
          <mu-text-field v-model="cudCodeParameterForm.parameterName"></mu-text-field>
        </el-form-item>
        <el-form-item label="参数类型:" prop="parameterType">
          <el-select
            v-model="cudCodeParameterForm.parameterType"
            filterable
            allow-create
            default-first-option
            placeholder="请选择参数类型">
            <el-option
              v-for="item in codeTypes"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否为常量:" prop="isFinal">
          <el-switch v-model="cudCodeParameterForm.isFinal" active-text="Y" active-value="Y" inactive-text="N"
                     inactive-value="N"></el-switch>
        </el-form-item>
        <el-form-item label="是否为引入:" prop="isAutowire">
          <el-switch v-model="cudCodeParameterForm.isAutowire" active-text="Y" active-value="Y" inactive-text="N"
                     inactive-value="N"></el-switch>
        </el-form-item>
        <el-form-item label="是否为接口:" prop="isInterface">
          <el-switch v-model="cudCodeParameterForm.isInterface" active-text="Y" active-value="Y" inactive-text="N"
                     inactive-value="N"></el-switch>
        </el-form-item>
        <el-form-item label="参数备注" prop="parameterRemark">
          <el-input type="textarea" show-word-limit maxlength="30"
                    v-model="cudCodeParameterForm.parameterRemark"></el-input>
        </el-form-item>
      </el-form>

      <el-form :model="cudCodeMethodForm"
               :label-position="configurationInfo.labelPosition"
               ref="cudCodeMethodForm"
               label-width="120px"
               v-if="configurationInfo.dialog.type == 'METHOD'">
        <el-form-item label="方法名称:" prop="methodName">
          <mu-text-field v-model="cudCodeMethodForm.methodName"></mu-text-field>
        </el-form-item>
        <el-form-item label="方法返回类型:" prop="methodResult">
          <el-select
            v-model="cudCodeMethodForm.methodResult"
            filterable
            allow-create
            default-first-option
            placeholder="请选择返回类型">
            <el-option
              v-for="item in codeTypes"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="方法作用域:" prop="methodActionScope">
          <el-radio-group v-model="cudCodeMethodForm.methodActionScope">
            <el-radio-button label="PUBLIC">公共可用</el-radio-button>
            <el-radio-button label="PRIVATE">本类可用</el-radio-button>
            <el-radio-button label="PROTECTED">子类可用</el-radio-button>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="方法基础类型:" prop="methodBaseType">
          <el-radio-group v-model="cudCodeMethodForm.methodBaseType">
            <el-radio label="COMMON">基本</el-radio>
            <el-radio label="STATIC">静态方法</el-radio>
            <el-radio label="ABSTRACT">抽象方法</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="是否常用:" prop="methodCommonUse">
          <el-switch v-model="cudCodeMethodForm.methodCommonUse" active-text="Y" active-value="Y" inactive-text="N"
                     inactive-value="N"></el-switch>
        </el-form-item>
        <el-form-item label="是否为构造方法:" prop="methodIsConstruct">
          <el-switch v-model="cudCodeMethodForm.methodIsConstruct" active-text="Y" active-value="Y" inactive-text="N"
                     inactive-value="N"></el-switch>
        </el-form-item>
        <el-form-item label="是否重写:" prop="methodIsOverwrite">
          <el-switch v-model="cudCodeMethodForm.methodIsOverwrite" active-text="Y" active-value="Y" inactive-text="N"
                     inactive-value="N"></el-switch>
        </el-form-item>
        <el-form-item label="方法备注:" prop="methodUsage">
          <el-input type="textarea" maxlength="30" show-word-limit v-model="cudCodeMethodForm.methodUsage"></el-input>
        </el-form-item>
      </el-form>

      <el-form :model="cudCodeOutSideUrlForm"
               :label-position="configurationInfo.labelPosition"
               ref="cudCodeParameterForm"
               label-width="120px"
               v-if="configurationInfo.dialog.type == 'URL'">
        <el-form-item prop="urlPath" label="链接地址:">
          <mu-text-field prefix="Http://" v-model="cudCodeOutSideUrlForm.urlPath"></mu-text-field>
        </el-form-item>
        <el-form-item label="链接备注" prop="urlRemark">
          <el-input type="textarea" show-word-limit maxlength="30"
                    v-model="cudCodeOutSideUrlForm.urlRemark"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="handleClose">取 消</el-button>
    <el-button type="primary" @click="cudForward">确 定</el-button></span>
    </el-dialog>

  </el-container>
</template>

<script>
  export default {
    name: "CodeInfo",
    data() {
      return {
        // 配置文件info
        configurationInfo: {
          dialog: {
            dialogIsShow: false,
            cudType: "",
            title: "",
            type: ""
          },
          labelPosition: "left"
        },
        // 源码基础信息
        codeBase: {
          codeId: "",
          codeName: "",
          codeType: "",
          codeMethodInfoList: [],
          codeParameterInfos: [],
          codeOutSideUrlInfos: []
        },
        cudCodeParameterForm: {
          parameterName: "",
          parameterType: "",
          parameterRemark: "",
          isFinal: "",
          isAutowire: "",
          isInterface: "",
          fromCodeId: this.$route.query.codeId,
          cudType: "",
        },
        cudCodeMethodForm: {
          cudType: "",
          fromCodeId: this.$route.query.codeId,
          methodName: "",
          methodUsage: "",
          methodResult: "",
          methodBaseType: "COMMON",
          methodCommonUse: "",
          methodIsOverwrite: "",
          methodIsConstruct: "",
          methodActionScope: "PUBLIC"
        },
        cudCodeOutSideUrlForm: {
          cudType: "",
          fromCodeId: this.$route.query.codeId,
          urlPath: "",
          urlRemark: ""
        },
        codeTypes: [
          {
            label: "String",
            value: "String"
          },
          {
            label: "Integer",
            value: "Integer"
          },
          {
            label: "Double",
            value: "Double"
          },
          {
            label: "Boolean",
            value: "Boolean"
          },
        ],
      }
    },
    mounted() {

      this.getCodeDetail();
    },
    methods: {

      /**
       * 源码详情
       * */
      getCodeDetail() {
        this.$axios({
          url: this.Globel.requestUrl + "/code/codeDetailQuery?codeId=" + this.$route.query.codeId
        }).then(res => {
          if (res.data.success) {
            console.log(res)
            this.codeBase = res.data.data;
          } else {
            this.$message.error(res.data.msg)
          }
        })
      },

      /**
       * cud弹出框渲染
       * */
      cudDialogShow(cudType, type, row) {
        this.configurationInfo.dialog.type = type;
        this.configurationInfo.dialog.cudType = cudType;

        if (cudType == "UPDATE") {
          if (type == 'PARAMETER') {
            this.cudCodeParameterForm = Object.assign({}, row);
          }
          if (type == 'METHOD') {
            this.cudCodeMethodForm = Object.assign({}, row);
          }
          if (type == 'URL') {
            this.cudCodeOutSideUrlForm = Object.assign({}, row);
          }
        }

        if (type == 'PARAMETER') {
          this.configurationInfo.dialog.title = '参数' + this.cudTypeChange(cudType)
          this.configurationInfo.dialog.dialogIsShow = true;
        }
        if (type == 'METHOD') {
          this.configurationInfo.dialog.title = '方法' + this.cudTypeChange(cudType)
          this.configurationInfo.dialog.dialogIsShow = true;
        }
        if (type == 'URL') {
          this.configurationInfo.dialog.title = '链接' + this.cudTypeChange(cudType)
          this.configurationInfo.dialog.dialogIsShow = true;
        }
      },

      /**
       * cud类型字段转换中文
       * */
      cudTypeChange(cudType) {
        if (cudType == "CREATE") {
          return "新增";
        }
        if (cudType == "UPDATE") {
          return "编辑";
        }
      },

      /**
       * cud转发操作
       * */
      cudForward() {
        if (this.configurationInfo.dialog.type == "PARAMETER") {
          this.cudCodeParameterForm.cudType = this.configurationInfo.dialog.cudType;
          this.cudParameter();
        }
        if (this.configurationInfo.dialog.type == "METHOD") {
          this.cudCodeMethodForm.cudType = this.configurationInfo.dialog.cudType;
          this.cudMethod();
        }
        if (this.configurationInfo.dialog.type == "URL") {
          this.cudCodeOutSideUrlForm.cudType = this.configurationInfo.dialog.cudType;
          this.cudUrl();
        }
      },

      /**
       * 单独转发删除
       * */
      deletStrategy(type, row) {
        console.log(type)
        if (type == "PARAMETER") {
          this.cudCodeParameterForm = row;
          this.cudCodeParameterForm.cudType = "DELETE";
          this.cudParameter();
        }
        if (type == "METHOD") {
          this.cudCodeMethodForm = row;
          this.cudCodeMethodForm.cudType = "DELETE";
          this.cudMethod();
        }
        if (type == "URL") {
          this.cudCodeOutSideUrlForm = row;
          this.cudCodeOutSideUrlForm.cudType = "DELETE";
          this.cudUrl();
        }
      },
      /**
       * cud参数请求
       * */
      cudParameter() {
        this.$axios({
          url: this.Globel.requestUrl + "/code/codeParameterCUD",
          data: this.cudCodeParameterForm,
          method: "POST"
        }).then(res => {
          if (res.data.success) {
            this.configurationInfo.dialog.dialogIsShow = false;
            this.getCodeDetail();
            this.resetForm();
            this.$message.success("操作成功!");
          } else {
            this.$message.error(res.data.msg);
          }
        })
      },

      /**
       * cud方法请求
       * */
      cudMethod() {
        this.$axios({
          url: this.Globel.requestUrl + "/code/codeMethodCUD",
          data: this.cudCodeMethodForm,
          method: "POST"
        }).then(res => {
          if (res.data.success) {
            this.configurationInfo.dialog.dialogIsShow = false;
            this.getCodeDetail();
            this.resetForm();
            this.$message.success("操作成功!");
          } else {
            this.$message.error(res.data.msg);
          }
        })
      },

      /**
       * cud链接请求
       * */
      cudUrl() {
        this.$axios({
          url: this.Globel.requestUrl + "/code/codeOutSideUrlCUD",
          data: this.cudCodeOutSideUrlForm,
          method: "POST"
        }).then(res => {
          if (res.data.success) {
            this.configurationInfo.dialog.dialogIsShow = false;
            this.getCodeDetail();
            this.resetForm();
            this.$message.success("操作成功!");
          } else {
            this.$message.error(res.data.msg);
          }
        })
      },


      /**
       * 返回主页
       * */
      toMain() {
        this.$router.push({path: "/"});
      },

      /**
       * 返回源码列表
       * */
      toCodeList() {
        this.$router.push({path: "/projectInfo", query: {projectId: this.$route.query.projectId}})
      },

      /**
       * 弹出框关闭回调
       * */
      handleClose() {
        this.resetForm()
        this.configurationInfo.dialog.dialogIsShow = false;
      },

      resetForm(){
        if (this.configurationInfo.dialog.type == "PARAMETER") {
          this.cudCodeParameterForm = {
            parameterName: "",
            parameterType: "",
            parameterRemark: "",
            isFinal: "",
            isAutowire: "",
            isInterface: "",
            fromCodeId: this.$route.query.codeId,
            cudType: "",
          }
        }
        if (this.configurationInfo.dialog.type == "METHOD") {
          this.cudCodeMethodForm = {
            cudType: "",
            fromCodeId: this.$route.query.codeId,
            methodName: "",
            methodUsage: "",
            methodResult: "",
            methodBaseType: "COMMON",
            methodCommonUse: "",
            methodIsOverwrite: "",
            methodIsConstruct: "",
            methodActionScope: "PUBLIC"
          }
        }
        if (this.configurationInfo.dialog.type == "URL") {
          this.cudCodeOutSideUrlForm = {
            cudType: "",
            fromCodeId: this.$route.query.codeId,
            urlPath: "",
            urlRemark: ""
          }
        }
      },
    }
  }
</script>

<style scoped>
  .header {
    border-bottom: 2px solid rgba(0,0,0,0.1);
    box-shadow: 4px 4px 4px rgba(0,0,0,0.1);
  }

  .header_row {
    line-height: 60px;
    height: 60px;
  }

  .header_row_project_name {
    font-size: 28px;
    font-family: "Kaiti SC";
    font-weight: 500;
  }
</style>
