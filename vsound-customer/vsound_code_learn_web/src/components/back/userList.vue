<template>
  <el-container class="container">
    <el-main class="main">
      <el-table
        class="table"
        :data="tableData"
        style="width: 100%">
        <el-table-column
          align="center"
          type="index"
          width="300px"
          min-width="180px">
        </el-table-column>
        <el-table-column
          align="center"
          prop="userId"
          label="用户id"
          width="300px"
          min-width="180px">
        </el-table-column>
        <el-table-column
          align="center"
          prop="userAccount"
          label="用户账号"
          width="300px"
          min-width="180px">
        </el-table-column>
        <el-table-column
          align="center"
          prop="userName"
          label="用户名称"
          width="300px"
          min-width="180px">
        </el-table-column>
        <el-table-column
          align="center"
          prop="userAvatar"
          label="用户头像"
          width="300px"
          min-width="180px">
          <template slot-scope="scope">
            <el-popover
              placement="bottom"
              width="300"
              trigger="hover">
              <el-image
                style="width:100%; height: 100%"
                :src="scope.row.userAvatar"
                :fit="fit"></el-image>
              <el-button slot="reference" type="small">查看</el-button>
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column
          align="center"
          label="操作"
          width="160">
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">编辑
            </el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-button class="add_button" @click="dialogIsShow = true" style="margin-top: 10px" size="small" round>新增</el-button>
    </el-main>
    <el-dialog
      title="用户新增"
      :visible.sync="dialogIsShow"
      width="30%"
      :before-close="handleClose">
      <el-form ref="addUserForm" :model="addUserForm" :rules="rules">
        <el-upload
          class="avatar-uploader"
          action="https://jsonplaceholder.typicode.com/posts/"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload">
          <img v-if="addUserForm.imageUrl" :src="addUserForm.imageUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
        <el-form-item label="登录名称:" prop="userName">
          <el-input v-model="addUserForm.userName"></el-input>
        </el-form-item>
        <el-form-item label="登录账号:" prop="userAccount">
          <el-input v-model="addUserForm.userAccount"></el-input>
        </el-form-item>
        <el-form-item label="登录密码:" prop="userPassword">
          <el-input v-model="addUserForm.userPassword"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogIsShow = false">取 消</el-button>
    <el-button type="primary" @click="addUser()">确 定</el-button>
  </span>
    </el-dialog>
  </el-container>
</template>

<script>
  export default {
    name: "userList",
    data() {
      return{
        dialogIsShow:false,
        fit:"cover",
        tableData:[],
        addUserForm:{
          imageUrl:"",
          userAccount:"",
          userName:"",
          userPassword:"",
          userAvatar:""
        },
        rules:{
          userAccount:[{
            required:true,message:"用户登录账号不能为空",trigger:"blur"
          }],
          userPassword:[{
            required:true,message:"用户登录密码不能为空",trigger:"blur"
          }],
          userName:[{
            required:true,message:"用户登录名称不能为空",trigger:"blur"
          }]
        }
      }
    },
    mounted(){
      this.$axios({
        url:this.Globel.requestUrl+"/base/user/userListQuery",
        method:"Get",
      }).then(res =>{
        if(res.data.status = "SUCCESS"){
          this.tableData = res.data.object.userInfoList
        }
      })
    },
    methods: {

      /**
       * 对话框关闭
       * */
      handleClose(done) {
        this.$refs['addUserForm'].resetFields()
        done();
      },

      /**
       * 头像选择
       * */
      handleAvatarSuccess(res, file) {
        this.imageUrl = URL.createObjectURL(file.raw);
      },
      beforeAvatarUpload(file) {
      },

      /**
       * 用户新增
       * */
      addUser(){
        this.$refs['addUserForm'].validate((valid) =>{
          if(valid){
            this.dialogIsShow = false;
          }else{
            return false;
          }
        })

      }
    }
  }
</script>

<style scoped>

  .container {

  }

  .table {
    background: none;
  }
  .add_button{
    background: linear-gradient(to right,#00F5FF, #BBFFFF);
    border: none;
    box-shadow: 2px 2px 2px rgba(0,0,0,0.1);
  }

  .avatar-uploader {
    width: 150px;
    height: 150px;
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    text-align: center;
    margin-left: auto;
    margin-right: auto;
    line-height: 150px;
    font-weight: bolder;
    font-size: 24px;
    margin-bottom: 24px;
  }
  .el-input{
    width: 70%;
  }

</style>
