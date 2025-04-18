const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  publicPath: './',
  devServer: {
    port: 8081, // 将开发服务器端口号设置为3000，根据需要修改为其它值
    host: '0.0.0.0' // 可选，允许局域网访问
  },
  configureWebpack: {
    module: {
      rules: [
        {
          test: /\.(glb|gltf)$/,
          type: 'asset/resource',
          generator: {
            filename: 'assets/[name].[hash][ext]',
          }
        }
      ]
    }
  }
})
