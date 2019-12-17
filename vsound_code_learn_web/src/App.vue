<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
  export default {
    name: 'App'
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
  }

  html, body, #app {
    height: 100%;
    width: 100%;
    margin: 0px;
    padding: 0px;
  }

  .el-menu {
    background: none !important;
  }
  .el-table th, .el-table tr{
    background: none;
  }
</style>
