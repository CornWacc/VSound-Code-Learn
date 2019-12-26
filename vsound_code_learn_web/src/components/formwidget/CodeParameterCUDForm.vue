<template>
  <div>
    <el-form v-if="dialog.dialogType=='PARAMETER'" ref="CUDCodeParameterForm" label-width="100px"
             :model="CUDCodeParameterForm" :label-position="labelPosition">
      <el-form-item label="参数名称:" prop="parameterName">
        <el-input placeholder="请输入参数名称" v-model="CUDCodeParameterForm.parameterName" style="width: 300px"></el-input>
      </el-form-item>
      <el-form-item label="参数类型:" prop="parameterType">
        <el-input placeholder="请输入参数类型" v-model="CUDCodeParameterForm.parameterType" style="width: 300px"></el-input>
      </el-form-item>
      <el-form-item label="是否常量:" prop="isFinal" v-if="drawerData.codeType !== 'ANNOTATION'">
        <el-switch
          v-model="CUDCodeParameterForm.isFinal"
          active-color="#ff4949"
          inactive-color="#13ce66"
          active-value="N"
          inactive-value="Y">
        </el-switch>
      </el-form-item>
      <el-form-item label="是否Autowire:" prop="isAutowire" v-if="drawerData.codeType !== 'ANNOTATION'">
        <el-switch
          v-model="CUDCodeParameterForm.isAutowire"
          active-color="#ff4949"
          inactive-color="#13ce66"
          active-value="N"
          inactive-value="Y">
        </el-switch>
      </el-form-item>
      <el-form-item label="是否接口:" prop="isInterface" v-if="drawerData.codeType !== 'ANNOTATION'">
        <el-switch
          v-model="CUDCodeParameterForm.isInterface"
          active-color="#ff4949"
          inactive-color="#13ce66"
          active-value="N"
          inactive-value="Y">
        </el-switch>
      </el-form-item>
      <el-form-item label="参数理解:" prop="parameterRemark">
        <el-input type="textarea" show-word-limit maxlength="50" v-model="CUDCodeParameterForm.parameterRemark"
                  style="width: 300px"></el-input>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  export default {
    name: "CodeParameterCUDForm",
    props: ["CUDCodeParameterForm", "dialog", "drawerData"],
    data() {
      return {
        labelPosition: "left"
      }
    },
    methods:{
      reset(){
        this.$refs["CUDCodeParameterForm"].resetFields()
      }
    }
  }
</script>

<style scoped>

</style>
