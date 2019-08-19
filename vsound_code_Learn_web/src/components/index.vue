<template>

  <el-container class="container">
    <el-main class="main">
      <div class="login_model">
        <div class="login_model_tital"></div>
        <el-form ref="loginForm" :model="loginForm" :label-position="labelPosition" :rules="loginFormRules">
          <el-form-item style="width: 70%;margin-left: auto;margin-right: auto" prop="userAccount">
            <el-input class="login_model_account_input" placeholder="Username" v-model="loginForm.userAccount" style="width: 280px;"></el-input>
          </el-form-item>
          <el-form-item style="width: 70%;margin-left: auto;margin-right: auto;margin-top: 20px" prop="userPassword">
            <el-input class="login_model_password_input" placeholder="Password" show-password v-model="loginForm.userPassword" @keydown.native.enter="doLogin" style="width: 280px;"></el-input>
          </el-form-item>
        </el-form>
        <el-button class="login_model_button" round @click="doLogin">登录</el-button>
      </div>
    </el-main>
  </el-container>
</template>

<script>
    export default {
        name: "index",
        data(){
          return{
            loginForm:{
              userAccount:"",
              userPassword:"",
            },
            loginFormRules:{
              userAccount:[{
                required:true,message:"请输入登录账号",trigger:'blur'
              }],
              userPassword:[{
                required:true,message:"请输入登录密码",trigger:'blur'
              }],
            },
            labelPosition:"right"
          }
        },
      methods:{
          doLogin(){
            this.$refs["loginForm"].validate((valid) =>{
              if(valid){
                this.$axios({
                  url:"http://localhost:9055/base/user/userLogin",
                  method:"post",
                  data:this.loginForm
                }).then(res =>{
                  if(res.data.status == "SUCCESS"){
                    this.$router.push('/main')
                  }
                })
              }else{
                this.$message.error('请正确输入登录账号密码哟！')
              }
            })
          }
      }
    }
</script>

<style scoped>

  .container{
    text-align: center;
    width: 100%;
    height: 100%;
    background: linear-gradient(#F8F8FF,#BBFFFF);
  }

  .main{
    width: 100%;
    background: rgba(0,0,0,0.1);
  }

  .login_model{
    margin-left: auto;
    margin-right: auto;
    width: 400px;
    height: 400px;
    border: 1px solid rgba(0,0,0,0.2);
    margin-top: 300px;
    position: relative;
    top: -150px;
    border-radius: 20px;
    box-shadow: 4px 4px 4px rgba(0,0,0,0.2);
  }

  .login_model_tital{
    width: 100%;
    height: 140px;
    background-size: cover;
    background: url("scode.svg") no-repeat;
    margin-top: 20px;
  }



  .login_model_button{
    margin-top: 10px;
    width: 280px;
    background: linear-gradient(to bottom right,#BBFFFF,#FFFFF0);
    border: 1px solid rgba(0,0,0,0.1);
    box-shadow: 4px 4px 4px rgba(0,0,0,0.1);
    margin-left: auto;
    margin-right: auto;
  }
  .el-form /deep/ .el-input__inner{
    border-radius: 20px !important;
    /*background: rgba(0,0,0,0.1);*/

  }

</style>
