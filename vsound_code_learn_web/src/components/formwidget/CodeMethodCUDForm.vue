<template>
  <div>
    <el-form v-if="dialog.dialogType=='METHOD'" ref="CUDCodeMethodForm" label-width="100px" style="margin-right: auto;margin-left: auto;"
             :model="CUDCodeMethodForm" :label-position="labelPosition">
      <el-form-item label="方法名称:" prop="methodName">
        <el-input placeholder="请输入方法名称" v-model="CUDCodeMethodForm.methodName" ></el-input>
      </el-form-item>

      <el-form-item label="方法入参" prop="methodOrder">
        <el-button type="primary"  @click="showMethodOrderDialog">点击新增</el-button>
      </el-form-item>

      <el-form-item label="方法反参:" prop="methodResult">
        <el-input placeholder="请输入方法反参" v-model="CUDCodeMethodForm.methodResult"></el-input>
      </el-form-item>

      <el-form-item label="构造方法:" prop="methodIsConstruct">
        <el-switch
          v-model="CUDCodeMethodForm.methodIsConstruct"
          active-text="是"
          inactive-text="否"
          active-value="Y"
          inactive-value="N">
        </el-switch>
      </el-form-item>

      <el-form-item label="作用域:" prop="methodActionScope">
        <el-radio v-model="CUDCodeMethodForm.methodActionScope" label="PUBLIC">公开</el-radio>
        <el-radio v-model="CUDCodeMethodForm.methodActionScope" label="PRIVATE">私有</el-radio>
        <el-radio v-model="CUDCodeMethodForm.methodActionScope" label="PROTECTED">子类</el-radio>
      </el-form-item>

      <el-form-item label="方法属性:" prop="methodBasic" v-if="CUDCodeMethodForm.methodIsConstruct == 'N'">
        <el-radio v-model="CUDCodeMethodForm.methodBaseType" label="COMMON">正常</el-radio>
        <el-radio v-model="CUDCodeMethodForm.methodBaseType" label="STATIC">静态</el-radio>
        <el-radio v-model="CUDCodeMethodForm.methodBaseType" label="ABSTRACT">抽象</el-radio>
      </el-form-item>

      <el-form-item label="是否重写:" prop="methodIsOverwrite" v-if="CUDCodeMethodForm.methodIsConstruct == 'N'">
        <el-switch
          v-model="CUDCodeMethodForm.methodIsOverwrite"
          active-text="是"
          inactive-text="否"
          active-value="Y"
          inactive-value="N">
        </el-switch>
      </el-form-item>

      <el-form-item label="使用方式:" prop="methodUsage">
        <el-input type="textarea" show-word-limit maxlength="50" v-model="CUDCodeMethodForm.methodUsage"></el-input>
      </el-form-item>
    </el-form>

    <el-dialog title="参数列表" :visible.sync="methodParamesDialog.isShow" :modal="false" width="50%">
      <el-table
        :data="CUDCodeMethodForm.methodOrders"
        border
        style="width: 100%">
        <el-table-column
          type="index"
          label="排序"
          width="150"
          align="center">
        </el-table-column>
        <el-table-column
          prop="parameterName"
          label="参数名称"
          align="center"
          width="200"
        >
          <template slot-scope="scope">
            <el-input v-model="scope.row.codeMethodOrderName" clearable></el-input>
          </template>
        </el-table-column>
        <el-table-column
          prop="parameterType"
          label="参数类型"
          align="center"
          width="200"
        >
          <template slot-scope="scope">
            <el-input v-model="scope.row.codeMethodOrderClassType" clearable></el-input>
          </template>
        </el-table-column>
        <el-table-column
          label="操作"
          align="center"
        >
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="danger"
              @click="deleteMethodOrderInput(scope.$index)">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-button type="primary" style="margin-top: 14px" size="mini" @click="addMethodOrderInput">新 增</el-button>
      <div slot="footer" class="dialog-footer">
        <el-button @click="methodParamesDialog.isShow = false">取 消</el-button>
        <el-button type="primary" @click="methodParamesDialog.isShow = false">确 定</el-button>
      </div>
    </el-dialog>
  </div>

</template>

<script>
  export default {
    name: "CodeMethodCUDForm",
    props: ["CUDCodeMethodForm", "dialog"],
    data() {
      return {
        labelPosition: "left",
        methodParamesDialog: {
          isShow: false,
        }
      }
    },
    methods: {
      /**
       * 展开方法入参列表框
       * */
      showMethodOrderDialog() {
        this.methodParamesDialog.isShow = true
      },
      /**
       * 新增一个方法入参的输入框
       * */
      addMethodOrderInput() {
        this.CUDCodeMethodForm.methodOrders.push({})
      },

      /**
       * 删除一个方法入参的输入框
       * */
      deleteMethodOrderInput(index) {
        this.CUDCodeMethodForm.methodOrders.splice(index, 1)
      },

      reset(){
        this.$refs["CUDCodeMethodForm"].resetFields()
        this.CUDCodeMethodForm.methodOrders = [];
      }
    }
  }
</script>

<style scoped>

</style>
