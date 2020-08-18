<template>
  <div class="testHome">
    <div>
      <img src="../assets/welcome.jpg">
    </div>
    <div class="btnBlocks">
      <button class="btn" @click="$router.push('/login')">登入</button>
      <button class="btn" @click="$router.push('/NewAccount')">註冊</button>
    </div>
  </div>
</template>

<script>

export default {
  name: 'Home',
}
</script>

<style scoped>
.btnBlocks{
    position: absolute;
    margin: 0px -50px -15px 0px;
    transform: translate3d(160px, 80px, 0px);
}

.testHome{
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100vw;
  height: 100vh;
}

.testHome .btn{
  background-color: hotpink;
  border-radius: 12px;
  color: aliceblue;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  width: 120px;
  height: 80px;
  font-size: 20px;
  margin-left : 30px;
  cursor: pointer;
}

</style>

