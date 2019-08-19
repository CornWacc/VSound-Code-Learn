<template>
  <el-container class="container">
    <el-header class="header">
      <span class="header_title">
        Netty
      </span>
      <div class="header_buttons">
        <el-button>新增</el-button>
        <el-button>返回主页</el-button>
      </div>
    </el-header>
    <el-main class="main">
      <div class="class_model">
        <div class="class_model_title">类(Class)</div>
        <el-collapse @change="handleChange" class="class_model_content">
          <el-collapse-item :title="item.className" name="1" v-for="item in classList" :key="item.comId">
            <div class="remark">简介:{{item.classRemark}}</div>
            <div class="usage">用法:{{item.classUsage}}</div>
            <div class="all">
              <el-button type="primary" size="mini" round style="float: right">详细</el-button>
            </div>
          </el-collapse-item>
        </el-collapse>
      </div>
      <div class="interface_model">
        <div class="interface_model_title">接口(Interface)</div>
        <el-collapse @change="handleChange" class="class_model_content">
          <el-collapse-item :title="item.interfaceName" name="1" v-for="item in interfaceList" :key="item.comId">
            <div class="remark">简介:{{item.interfaceRemark}}</div>
            <div class="usage">用法:{{item.interfaceUsage}}</div>
            <div class="all">
              <el-button type="primary" size="mini" round style="float: right">详细</el-button>
            </div>
          </el-collapse-item>
        </el-collapse>
      </div>
      <div class="annotation_model">
        <div class="annotation_model_title">注解(Annotation)</div>
        <el-collapse v-model="activeNames" @change="handleChange" class="class_model_content">
          <el-collapse-item :title="item.annotationName" name="1" v-for="item in annotationList" :key="item.comId">
            <div class="remark">简介:{{item.annotationRemark}}</div>
            <div class="usage">用法:{{item.annotationUsage}}</div>
            <div class="all">
              <el-button type="primary" size="mini" round style="float: right">详细</el-button>
            </div>
          </el-collapse-item>
        </el-collapse>
      </div>
      <div class="abstract_model">
        <div class="abstract_model_title">抽象类(Abstract)</div>
        <el-collapse v-model="activeNames" @change="handleChange" class="class_model_content">
          <el-collapse-item :title="item.abstractName" name="1" v-for="item in abstractList" :key="item.comId">
            <div class="remark">简介:{{item.abstractRemark}}</div>
            <div class="usage">用法:{{item.abstractUsage}}</div>
            <div class="all"><el-button type="primary" size="mini" round style="float: right">详细</el-button></div>
          </el-collapse-item>
        </el-collapse>
      </div>
    </el-main>
  </el-container>
</template>

<script>
  export default {
    name: "projectinfo",
    data() {
      return {
        classList: [{
          comId: "",
          className: "BeanDefinition",
          classRemark: "类简介",
          classUsage: "类用法描述"
        }],
        interfaceList:[],
        annotationList:[],
        abstractList:[]
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
    border-bottom: 1px solid red;
  }

  .header_title {
    font-size: 24px;
    font-weight: bold;
    position: relative;
    left: 30px;
    height: 60px;
    line-height: 60px;
  }

  .class_model, .interface_model, .annotation_model, .abstract_model {
    margin-top: 20px;
    background-color: rgba(0, 0, 0, 0.1) !important;
    width: 100%;
    box-shadow: 4px 4px 4px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
  }

  .class_model_title, .interface_model_title, .annotation_model_title, .abstract_model_title {
    font-size: 24px;
    border-bottom: 2px solid white;
    width: 94%;
    padding-top: 4px;
    padding-bottom: 4px;
    margin-left: auto;
    margin-right: auto;
    text-align: center;
  }

  .class_model_content {
    /*background-color: rgba(0,0,0,0.1) !important;*/
    border-bottom: none !important;
    margin-left: 16px;
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
  .header_buttons{
    float: right;
    margin-top: 10px;
    margin-right: 10px;
  }

</style>
