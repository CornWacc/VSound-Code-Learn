<template>
  <div>
    <el-form v-if="dialog.dialogType=='URL'" ref="CUDCodeUrlForm" label-width="100px" :model="CUDCodeUrlForm"
             :label-position="labelPosition">
      <el-form-item label="链接注释:" prop="urlRemark">
        <el-input placeholder="请输入链接注释" v-model="CUDCodeUrlForm.urlRemark" style="width: 300px"></el-input>
      </el-form-item>
      <el-form-item label="链接地址:" prop="urlPath">
        <el-input placeholder="请输入链接地址" v-model="CUDCodeUrlForm.urlPath" style="width: 300px"></el-input>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  export default {
    name: "CodeOutSideUrlCUDForm",
    props:["CUDCodeUrlForm","dialog"],
    data(){
      return{
        labelPosition:"left"
      }
    }
  }
</script>

<style scoped>

</style>
