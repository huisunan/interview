<template>
    <div class="question">

        <h3>{{question.name}}</h3>
        <div v-html="question.content">
        </div>
    </div>
</template>

<script>
    import {fetchGet} from "@/utils/request";

    export default {
        name: "question",
        created(){
            let query = this.$route.query;

            if (query.id){
                this.getQuestion(query.id)
            }
        },
        data(){
            return{
                question:{

                }
            }
        },
        methods:{
            getQuestion(id){
                fetchGet('/question/'+id).then(res=>{
                    console.log(res.data);
                    this.question = res.data
                })
            }
        }
    }
</script>

<style lang="scss" scoped>
    .question{
        width: 80%;
        margin: 0 auto;
        border: 1px solid #EBEEF5;
        box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
        h3{
            text-align: center;
        }
    }

</style>
