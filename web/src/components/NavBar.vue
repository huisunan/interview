<template>
    <div class="nav">
        <router-link to="/"><el-link type="primary">首页</el-link></router-link>
    </div>
</template>

<script>
    export default {
        name: "NavBar"
    }
</script>

<style lang="scss" scoped>
    .nav {
        text-align: center;
        margin-bottom: 10px;
        .el-link{
            font-size: 20px;
        }
    }
    .bar-item{
        margin-right: 20px;
    }
</style>
