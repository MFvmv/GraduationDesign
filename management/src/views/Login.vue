<template>
  <div>
    <el-card class="login-form-layout">
      <el-form autoComplete="on"
                :model="loginForm"
                :rules="loginRules"
                ref="loginForm"
                label-position="left">
        <div style="text-align: center">
          <svg-icon icon-class="login" style="width: 56px;height: 56px;color: #409EFF"></svg-icon>
        </div>
        <h2 class="login-title color-main">hospital-admin-web</h2>

        <el-form-item prop="username">
          <el-input name="username"
                    type="text"
                    v-model="loginForm.username"
                    autoComplete="on"
                    placeholder="请输入用户名">
          <template #prefix>
            <svg-icon icon-class="user" class="color-main"></svg-icon>
          </template>
          </el-input>
        </el-form-item>

        <el-form-item prop="password">
          <el-input name="password"
                    :type="password"
                    @keyup.enter.native="handleLogin"
                    v-model="loginForm.password"
                    autoComplete="on"
                    placeholder="请输入密码"
                    show-password
                    >
            <template #prefix>
              <svg-icon icon-class="password" class="color-main"></svg-icon>
            </template>
          </el-input>
        </el-form-item>

        <el-form-item v-if="is_register" prop="password2">
          <el-input name="password2"
                    :type="password"
                    @keyup.enter.native="handleLogin"
                    v-model="loginForm.password2"
                    autoComplete="on"
                    placeholder="请再次输入密码"
                    show-password
                    >
            <template #prefix>
              <svg-icon icon-class="password" class="color-main"></svg-icon>
            </template>
          </el-input>

        </el-form-item>

        <el-form-item style="margin-bottom: 60px;text-align: center">
          <el-button style="width: 45%" type="primary" :loading="loading" @click.native.prevent="handleLogin">
            登录
          </el-button>
          <el-button style="width: 45%" type="primary" @click.native.prevent="handleRegister">
            注册
          </el-button>
        </el-form-item>
      </el-form>
    </el-card>
    <img :src="login_center_bg" class="login-center-layout">
    
  </div>
</template>

<script>
  import {isvalidUsername} from '@/utils/validate';
  import {setSupport,getSupport,setCookie,getCookie} from '@/utils/support';
  import login_center_bg from '@/assets/images/login_center_bg.png'

  export default {
    name: 'login',
    data() {
      const validateUsername = (rule, value, callback) => {
        if (!isvalidUsername(value)) {
          callback(new Error('请输入正确的用户名'))
        } else {
          callback()
        }
      };
      const validatePass = (rule, value, callback) => {
        if (value.length < 3) {
          callback(new Error('密码不能小于3位'))
        } else {
          callback()
        }
      };
      const validatePass2 = (rule, value, callback) => {
        if (value !== this.loginForm.password) {
          callback(new Error('两次输入密码不一致'))
        } else {
          callback()
        }
      };
      return {
        loginForm: {
          username: '',
          password: '',
          password2: ''
        },
        loginRules: {
          username: [{required: true, trigger: 'blur', validator: validateUsername}],
          password: [{required: true, trigger: 'blur', validator: validatePass}],
          password2: [{required: true, trigger: 'blur', validator: validatePass2}]
        },
        loading: false,
        login_center_bg,
        is_register:false
      }
    },
    mounted() {
      console.log('login mounted');
      this.$store.dispatch("setSidebarHidden",true)
      this.$router.push({path: '/'})
    },
    created() {
      this.loginForm.username = getCookie("username");
      this.loginForm.password = getCookie("password");
      if(this.loginForm.username === undefined||this.loginForm.username==null||this.loginForm.username===''){
        this.loginForm.username = 'admin';
      }
      if(this.loginForm.password === undefined||this.loginForm.password==null){
        this.loginForm.password = '';
      }
    },
    methods: {
      handleRegister() {
        if(!this.is_register) {
          this.is_register = true;
          return;
        }
        this.$refs.loginForm.validate(valid => {
          if (valid) {
            this.loading = true;
            this.$store.dispatch('Register', this.loginForm).then(() => {
              this.loading = false;
              setCookie("username",this.loginForm.username,15);
              setCookie("password",this.loginForm.password,15);
              this.$router.addRoute(this.$store.getters.root);
              this.$router.push({path: '/'})
            }).catch((error) => {
              this.loading = false
              console.log(error)
            })
          } else {
            console.log('参数验证不合法！');
            return false
          }
        })
      },
      handleLogin() {
        if(this.is_register) {
          this.is_register = false;
          return;
        }
        this.$refs.loginForm.validate(valid => {
          if (valid) {
            this.loading = true;
            this.$store.dispatch('Login', this.loginForm).then(() => {
              this.loading = false;
              setCookie("username",this.loginForm.username,15);
              setCookie("password",this.loginForm.password,15);
              this.$router.addRoute(this.$store.getters.root);
              this.$router.replace({path: '/'})
            }).catch((error) => {
              this.loading = false
              console.log(error)
            })
          } else {
            console.log('参数验证不合法！');
            return false
          }
        })
      },
      dialogConfirm(){
        this.dialogVisible =false;
        setSupport(true);
      },
      dialogCancel(){
        this.dialogVisible = false;
        setSupport(false);
      }
    }
  }
</script>

<style scoped>
  .login-form-layout {
    position: absolute;
    left: 0;
    right: 0;
    width: 360px;
    margin: 140px auto;
    border-top: 10px solid #409EFF;
  }

  .login-title {
    text-align: center;
  }

  .login-center-layout {
    background: #409EFF;
    width: auto;
    height: auto;
    max-width: 100%;
    max-height: 100%;
    margin-top: 200px;
  }
</style>
