import { defineConfig } from 'vite'
import uni from '@dcloudio/vite-plugin-uni'
import { resolve } from 'path'
// https://vitejs.dev/config/
export default defineConfig({
  base: './', // 关键配置：使用相对路径
  build: {
    assetsDir: 'assets', // 可选：静态资源输出目录（默认是 assets）
  },
  css: {
    preprocessorOptions: {
      scss: {
        api: "modern-compiler",
        silenceDeprecations: ["legacy-js-api"],
      },
    },
  },
  plugins: [
    uni(),
  ],
  resolve: {
    alias: {
      '@': resolve(__dirname, 'src')
    }
  }
})
