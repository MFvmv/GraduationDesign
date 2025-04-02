<script>
export default {
  onLaunch: function () {
    const token = uni.getStorageSync('loginToken');
    if (!token) {
      uni.reLaunch({ url: '/pages/login/login' });
    }
  }
}
</script>

<style>
/*每个页面公共css */
</style>
