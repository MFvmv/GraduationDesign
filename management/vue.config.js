const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  publicPath: './',
  devServer: {
    port: 8081,  // 把端口改成 8081
  }
})
