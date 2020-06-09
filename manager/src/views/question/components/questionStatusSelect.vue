<template>
  <el-select v-model="select" placeholder="请选择" @change="change" clearable>
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
</template>


<script>
  import { questionStatus } from '@/utils/constants'
  export default {
    name: 'questionStatusSelect',
    props:['value'],
    data(){
      return {
        select:null,
        options:questionStatus
      }
    },
    methods:{
      change(val){
        this.$emit('input',val)
      }
    }
  }
</script>

<style scoped>

</style>
