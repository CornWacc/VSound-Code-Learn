<template>
  <el-container class="containers">

    <el-header class="header">
      <el-row :gutter="24" class="header_row">
        <el-col :span="22" class="header_row_project_name">
          <span>{{projectBase.projectName}}</span>
        </el-col>
        <el-col :span="1">
          <el-button @click="toMain">返回主页</el-button>
        </el-col>
      </el-row>

    </el-header>

    <el-main>
      <div class="main_base_control">
        <el-row :gutter="24">
          <el-col :span="6">
            <mu-text-field :full-width="true" v-model="baseControl.codeName" placeholder="请输入源码名称..."></mu-text-field>
          </el-col>
          <el-col :span="6">
            <el-select v-model="baseControl.codeType" placeholder="请选择源码类型" clearable>
              <el-option
                v-for="item in baseControl.codeTypes"
                :key="item.index"
                :label="item.label"
                :value="item.value"
              >
                <span style="float: left">{{ item.label }}</span>
                <span style="float: right; color: #8492a6;">{{ item.value }}</span>
              </el-option>
            </el-select>
          </el-col>
          <el-col :xl="{span:3}" :lg="{span:4}">
            <el-button type="primary" style="font-weight: bolder; margin-left: -16px" @click="getCodeList">搜 索 <i
              class="el-icon-search"></i>
            </el-button>
          </el-col>
          <el-col :lg="{span:3}" :xl="{span:3}" style="margin-left: -28px">
            <el-button type="primary" style="font-weight: bolder;" @click="forwardCud(cudType='CREATE')">新 增 <i
              class="el-icon-edit"></i></el-button>
          </el-col>
        </el-row>
      </div>

      <el-table :data="codeList" style="width: 100%">
        <el-table-column prop="codeId" label="源码id" align="center">
        </el-table-column>
        <el-table-column prop="codeName" label="源码名称" align="center">
        </el-table-column>
        <el-table-column prop="codeType" label="源码类型" align="center">
          <template slot-scope="scope">
            <el-tag>{{scope.row.codeType}}</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="详情" align="center">
          <template slot-scope="scope">
            <el-row>
              <el-col>
                <mu-button small color="info" style="font-weight: bolder" @click="toCodeDetail(scope.row.codeId)">查看详情
                </mu-button>
              </el-col>
            </el-row>
          </template>
        </el-table-column>
        <el-table-column label="操作" align="center">
          <template slot-scope="scope">
            <el-row :gutter="20" style="margin-left: auto;margin-right: auto;width:80%">
              <el-col :span="12">
                <mu-button small color="primary" @click="forwardCud('UPDATE',scope.row)">编辑
                  <mu-icon value="edit" right></mu-icon>
                </mu-button>
              </el-col>
              <el-col :span="10">
                <mu-button small color="error" @click="forwardCud(cudType = 'DELETE',row = scope.row)">删除
                  <mu-icon value="delete" right></mu-icon>
                </mu-button>
              </el-col>
            </el-row>
          </template>
        </el-table-column>
      </el-table>
    </el-main>

    <el-dialog
      :title="dialog.title"
      :visible.sync="configurationInfo.dialogIsShow"
      width="30%"
      :before-close="handleClose">
      <el-form :model="codeForm" :label-position="configurationInfo.labelPosition" ref="codeForm" label-width="100">
        <el-form-item label="源码名称:">
          <el-input v-model="codeForm.codeName" style="width: 70%" placeholder="请输入源码名称"></el-input>
        </el-form-item>
        <el-form-item label="源码类型:">
          <el-select v-model="codeForm.codeType" placeholder="请选择源码类型" clearable>
            <el-option
              v-for="item in baseControl.codeTypes"
              :key="item.index"
              :label="item.label"
              :value="item.value"
            >
              <span style="float: left">{{ item.label }}</span>
              <span style="float: right; color: #8492a6;">{{ item.value }}</span>
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="源码备注:">
          <el-input type="textarea" maxlength="30" show-word-limit v-model="codeForm.codeRemark" style="width: 70%"
                    placeholder="请输入源码名称"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="configurationInfo.dialogIsShow = false">取 消</el-button>
    <el-button type="primary" @click="cudCode">确 定</el-button></span>
    </el-dialog>
  </el-container>
</template>


<script>
  export default {
    name: "ProjectInfo",
    data() {
      return {
        // 基本配置
        configurationInfo: {
          dialogIsShow: false,
          labelPosition: "left",
        },

        //弹出框配置
        dialog: {
          title: "",
          cudType: ""
        },

        //项目基本信息
        projectBase: {
          projectId: "",
          projectName: "测试"
        },

        // 源码列表信息
        codeList: [],

        // 源码基础信息
        baseControl: {
          codeName: "",
          codeType: "",
          codeTypes: [
            {
              label: "类",
              value: "CLASS",
              index: 1
            },
            {
              label: "枚举",
              value: "ENUM",
              index: 2
            },
            {
              label: "接口",
              value: "INTERFACE",
              index: 3
            },
            {
              label: "注解",
              value: "ANNOTATION",
              index: 4
            },
          ]
        },

        // 源码form表单
        codeForm: {
          codeName: "",
          codeType: "",
          codeRemark: "",
          cudType: "",
          fromProjectId: ""
        },

        // 源码查询表单
        codeSearchForm: {
          remark: "",
          codeType: ""
        }
      }
    },
    mounted() {
      this.getCodeList()
    },
    methods: {

      /**
       * 查询源码列表
       * */
      getCodeList() {
        this.$axios({
          url: this.Globel.requestUrl + "/project/projectQuery?projectId=" + this.$route.query.projectId,
        }).then(res => {
          if (res.data.success) {
            this.codeList = res.data.data.codeInfoList;
          } else {
            this.$message.error(res.data.msg)
          }
        })
      },

      /**
       * dialog关闭
       * */
      handleClose() {
        this.$refs["codeForm"].resetFields();
      },

      /**
       * 转发cud方法
       * */
      forwardCud(cudType, row) {
        this.dialog.cudType = cudType;
        this.codeForm.cudType = cudType;
        if (cudType == "CREATE") {
          this.configurationInfo.dialogIsShow = true;
          this.dialog.title = "新增源码";
          this.codeForm.fromProjectId = this.$route.query.projectId
        }
        if (cudType == "DELETE") {
          this.codeForm = row;
          this.codeForm.cudType = "DELETE";
          this.cudCode()
        }
        if (cudType == "UPDATE") {
          this.codeForm = Object.assign({}, row);
          this.codeForm.cudType = "UPDATE";
          this.configurationInfo.dialogIsShow = true;
          this.dialog.title = "编辑源码";
        }
      },

      /**
       * 确认新增源码
       * */
      cudCode() {
        this.$axios({
          url: this.Globel.requestUrl + "/code/codeCUD",
          data: this.codeForm,
          method: "POST"
        }).then(res => {
          if (res.data.success) {
            this.$message.success("操作成功");
            this.getCodeList();
            this.configurationInfo.dialogIsShow = false;
          } else {
            this.$message.error(res.data.msg);
          }
        })
      },

      /**
       * 回到主页
       * */
      toMain() {
        this.$router.push({path: "/"})
      },

      /**
       * 源码详情
       * */
      toCodeDetail(codeId) {
        this.$router.push(
          {
            path: "/codeInfo",
            query: {codeId: codeId,projectId:this.$route.query.projectId}
          })
      }
    }
  }
</script>


<style scoped>
  .header {
    border-bottom: 1px solid aquamarine;
  }

  .header_row {
    line-height: 60px;
    height: 60px;
  }

  .header_row_project_name {
    font-size: 32px;
    font-weight: bolder;
  }

  .button-wrapper {
    text-align: center;
  }

  .mu-button {
    margin: 8px;
    vertical-align: top;
  }

  .main_base_control {
    width: 48%;
  }
</style>
