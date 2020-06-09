<template>
    <div class="question"
         element-loading-text="拼命加载中"
         element-loading-spinner="el-icon-loading"
         element-loading-background="rgba(0, 0, 0, 0.8)"
         v-loading="loading">

        <h3>{{question.name}}</h3>
        <div class="content" v-html="question.content">
        </div>
    </div>
</template>

<script>
    import {fetchGet} from "@/utils/request";

    export default {
        name: "question",
        created() {
            let query = this.$route.query;

            if (query.id) {
                this.getQuestion(query.id)
            }
        },
        data() {
            return {
                question: {},
                loading: false
            }
        },
        methods: {
            getQuestion(id) {
                this.loading = true
                fetchGet('/question/' + id)
                    .then(res => {
                        this.question = res.data
                    })
                    .finally(() => {
                        this.loading = false
                    })
            }
        }
    }
</script>

<style lang="scss" scoped>
    .question {
        width: 80%;
        height: 600px;
        margin: 0 auto;
        border: 1px solid #EBEEF5;
        box-shadow: 0 2px 12px 0 rgba(0, 0, 0, .1);

        h3 {
            text-align: center;
        }

        .content {
            margin-left: 5px;
            margin-right: 5px;
        }
    }

</style>
