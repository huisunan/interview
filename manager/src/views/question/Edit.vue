<template>
    <div class="form">
      <el-form :model="question" label-width="100px">
        <el-form-item
          label="问题名称">
          <el-input v-model="question.name" :disabled="disabled"></el-input>
        </el-form-item>
        <el-form-item
          label="作者">
          <el-input v-model="question.author" :disabled="disabled"></el-input>
        </el-form-item>
        <el-form-item
          label="内容">
          <div v-if="disabled" v-html="question.content"></div>
          <tinymce v-else v-model="question.content"/>
        </el-form-item>
        <el-form-item style="text-align: center">
          <el-button type="primary" round style="width: 200px;margin-bottom: 50px" @click="type = 'update';disabled = false" v-if="disabled">编辑</el-button>
          <el-button type="primary" round style="width: 200px;margin-bottom: 50px" @click="option" v-else>
            {{type === 'add'?'新增':'修改'}}
          </el-button>
        </el-form-item>
      </el-form>
    </div>
</template>

<script>
  import Tinymce from '@/components/Tinymce/index'
  import { fetchGet, fetchPost, fetchPut } from '@/utils/request'
  export default {
    name: 'Edit',
    components: { Tinymce },
    data(){
      return{
        question:{
          id:null,
          name:null,
          content:null,
          author:null,
        },
        disabled:false,
        type:'add',
      }
    },created() {
      let type = this.$route.params.type
      if (type === 'detail'){
        let id = this.$route.params.id
        if (id){
          this.detail(id)
          this.disabled = true
        }else {
          this.$notify.error("出现错误")
        }
      }

    },
    methods:{
      option(){
        if (this.type === 'add'){
          fetchPost('question/create',this.question).then(res=>{
            this.$router.push({
              name:'QuestionList'
            })
          })
        }else if (this.type === 'update'){
          fetchPost('question/update/'+this.question.id,this.question).then(res=>{
            this.$router.push({
              name:'QuestionList'
            })
          })
        }
      },detail(id){
        fetchGet('question/'+id).then(res=>{
          let data = res.data
          data.createTime = undefined
          data.updateTime = undefined
          this.question = data
        })
      }
    }
  }
</script>

<style lang="scss" scoped>
  .form{
    margin: 10px;
  }
</style>
