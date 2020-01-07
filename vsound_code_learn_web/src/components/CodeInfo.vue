<template>
  <el-container class="containers">
    <el-header class="header">
      <el-row :gutter="24" class="header_row">
        <el-col :span="22" class="header_row_project_name">
          <span>{{codeBase.codeName}}</span>
        </el-col>
        <el-col :span="1">
          <el-button @click="toMain" type="primary" size="medium">返回主页</el-button>
        </el-col>
      </el-row>
    </el-header>

    <el-main class="main">
      <div style="margin-bottom: 10px">
        <p style="font-size: 20px;;margin-bottom: 4px">源码参数:</p>
        <mu-button small color="#008B8B">新增</mu-button>
      </div>

      <el-table :data="codeBase.codeParameterInfos">
        <el-table-column align="center" label="参数id" prop="parameterId"></el-table-column>
        <el-table-column align="center" label="参数名称" prop="parameterName"></el-table-column>
        <el-table-column align="center" label="参数类型" prop="parameterType"></el-table-column>
        <el-table-column align="center" label="是否为常量" prop="isFinal"></el-table-column>
        <el-table-column align="center" label="是否Autowire引入" prop="isAutowire"></el-table-column>
        <el-table-column align="center" label="参数类型是否为接口" prop="isInterface"></el-table-column>
        <el-table-column align="center" label="操作">
          <template slot-scope="scope">
            <mu-button icon color="primary">
              <mu-icon value="edit"></mu-icon>
            </mu-button>
            <mu-button icon color="error">
              <mu-icon value="delete"></mu-icon>
            </mu-button>
          </template>
        </el-table-column>
      </el-table>

      <div style="margin-bottom: 10px">
        <p style="font-size: 20px;margin-bottom: 4px">源码方法:</p>
        <mu-button small color="#008B8B">新增</mu-button>
      </div>

      <el-table :data="codeBase.codeMethodInfoList">
        <el-table-column align="center" label="方法名称" prop="methodName"></el-table-column>
        <el-table-column align="center" label="方法返回参数" prop="methodResult"></el-table-column>
        <el-table-column align="center" label="方法基础类型" prop="methodBaseType"></el-table-column>
        <el-table-column align="center" label="是否常用" prop="methodCommonUse"></el-table-column>
        <el-table-column align="center" label="是否为构造方法" prop="methodIsConstruct"></el-table-column>
        <el-table-column align="center" label="是否重写" prop="methodIsOverwrite"></el-table-column>
        <el-table-column align="center" label="方法作用域" prop="methodActionScope"></el-table-column>
        <el-table-column align="center" label="操作">
          <template slot-scope="scope">
            <mu-button icon color="primary">
              <mu-icon value="edit"></mu-icon>
            </mu-button>
            <mu-button icon color="error">
              <mu-icon value="delete"></mu-icon>
            </mu-button>
          </template>
        </el-table-column>
      </el-table>


      <div style="margin-bottom: 10px">
        <p style="font-size: 20px;;margin-bottom: 4px">源码解析链接:</p>
        <mu-button small color="#008B8B">新增</mu-button>
      </div>

      <el-table :data="codeBase.codeOutSideUrlInfos">
        <el-table-column align="center" label="链接id" prop="urlId"></el-table-column>
        <el-table-column align="center" label="链接地址" prop="urlPath">
          <template slot-scope="scope">
            <el-link type="primary" :href="scope.row.urlPath">{{scope.row.urlPath}}</el-link>
          </template>
        </el-table-column>
        <el-table-column align="center" label="链接备注" prop="urlRemark"></el-table-column>
        <el-table-column align="center" label="操作">
          <template slot-scope="scope">
            <mu-button icon color="primary">
              <mu-icon value="edit"></mu-icon>
            </mu-button>
            <mu-button icon color="error">
              <mu-icon value="delete"></mu-icon>
            </mu-button>
          </template>
        </el-table-column>
      </el-table>
    </el-main>

    <el-dialog
      :title="configurationInfo.dialog.title"
      :visible.sync="configurationInfo.dialog.dialogIsShow"
      width="30%"
      :before-close="handleClose">

      <el-form :model="cudCodeParameterForm" :label-position="configurationInfo.labelPosition"
               ref="cudCodeParameterForm"
               label-width="100">
      </el-form>

      <el-form :model="cudCodeMethodForm" :label-position="configurationInfo.labelPosition" ref="cudCodeMethodForm"
               label-width="100">
      </el-form>

      <el-form :model="cudCodeOutSideUrlForm" :label-position="configurationInfo.labelPosition"
               ref="cudCodeOutSideUrlForm"
               label-width="100">
      </el-form>


      <span slot="footer" class="dialog-footer">
    <el-button @click="configurationInfo.dialog.dialogIsShow = false">取 消</el-button>
    <el-button type="primary" @click="configurationInfo.dialog.dialogIsShow = false">确 定</el-button></span>
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
            dialogIsShow: true,
            cudType: "",
            title:"",
            type:""
          },
          labelPosition: "left"
        },
        // 源码基础信息
        codeBase: {
          codeId: "",
          codeName: "asd",
          codeType: "",
          codeMethodInfoList: [],
          codeParameterInfos: [{parameterId: "123", parameterName: "123", parameterType: "CLASS", remark: "12312312"}],
          codeOutSideUrlInfos: []
        },
        cudCodeParameterForm: {},
        cudCodeMethodForm: {},
        cudCodeOutSideUrlForm: {}
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
       * 返回主页
       * */
      toMain() {
        this.$router.push({path: "/"});
      },

      /**
       * 弹出框关闭回调
       * */
      handleClose() {

      }

    }
  }
</script>

<style scoped>
  .header {
    /*border-bottom: 1px solid aquamarine;*/
  }

  .header_row {
    line-height: 60px;
    height: 60px;
  }

  .header_row_project_name {
    font-size: 30px;
    font-family: "Kaiti SC";
    font-weight: 400;
    /*margin-left: 10px;*/
  }
</style>
