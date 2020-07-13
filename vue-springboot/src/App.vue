<template>
  <div id="app">
    <router-view />
  </div>
</template>

<style lang="scss">
html,
body {
  padding: 0px;
  margin: 0px;
  width: 100%;
  height: 100%;
}
@import '~normalize.css/normalize.css'; // normalize.css 样式格式化
@import './styles/index.scss'; // 全局自定义的css样式
</style>
