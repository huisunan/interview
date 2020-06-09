<template>
    <div class="question">
        <el-card shadow="always" v-for="item in questions" class="question-item"
                 >
            <div  @click="toQuestion(item.id)">
                <span class="name">{{item.name}}</span>

            </div>
        </el-card>
        <div class="pagination">
            <el-pagination

                    background
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :page-sizes="[5, 10, 20]"
                    layout="total, sizes, prev, pager, next"
                    :total="total">
            </el-pagination>
        </div>
    </div>
</template>

<script>
    import {fetchPost} from "@/utils/request";

    export default {
        name: "index",
        data() {
            return {
                questions: [],
                search:{
                    current:1,
                    size:10
                },
                total:0
            }
        },
        created() {
           this.getList()
        },
        methods:{
            getList(){
                fetchPost('/question/list',this.search).then(res => {
                    this.questions = res.records
                    this.total = res.total
                })
            },
            toQuestion(id){
                this.$router.push({
                    name:'Question',
                    query:{
                        id:id
                    }
                })
            },
            handleSizeChange(val){
                this.search.size = val
                this.getList()
            },
            handleCurrentChange(val){
                this.search.current = val
                this.getList()
            }
        }
    }
</script>

<style lang="scss" scoped>
    .question {
        .question-item{
            margin:0 auto;
            width: 60%;
            .name{
                margin-right: 10px;
            }
            .author{
                margin-right: 20px;
                display: inline-block;
                float: right;

            }
            .time{
                display: inline-block;
                float: right;
                font-size: 14px;
            }
        }
        .pagination{
            text-align: center;
        }
    }

</style>
