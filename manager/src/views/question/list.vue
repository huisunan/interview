<template>
  <div>
    <div class="search">
      <question-status-select v-model="search.status"/>
      <el-input v-model="search.name" clearable placeholder="请输入问题名" @clear="getList"></el-input>
      <el-button @click="getList" type="primary" round size="small">搜索</el-button>
      <el-button @click="add" type="primary" round size="small">新增</el-button>
    </div>
    <div>
      <el-table
        :data="list">
        <el-table-column
          label="id"
          prop="id">
        </el-table-column>
        <el-table-column
          label="名称"
          prop="name">
        </el-table-column>
        <el-table-column
          label="状态">
          <template slot-scope="{row}">
            <el-tag v-if="row.status === 0" type="success" class="tag">创建</el-tag>
            <el-tag v-if="row.status === 1" type="danger" class="tag">审核不通过</el-tag>
            <el-tag v-if="row.status === 2" type="primary" class="tag">审核通过</el-tag>
          </template>
        </el-table-column>
        <el-table-column
          prop="author"
          label="作者">
        </el-table-column>
        <el-table-column
          label="操作">
          <template slot-scope="{row}">
            <el-button type="primary" round size="small" @click="detail(row.id)">查看</el-button>
              <el-popconfirm title="确定删除该问题吗？"  @onConfirm="deleteQuestion(row.id)">
                <el-button slot="reference" type="danger" round size="small">删除</el-button>
              </el-popconfirm>
            <el-button type="info" round size="small" @click="approve(row)" v-if="row.status === 0">审核</el-button>

          </template>
        </el-table-column>
      </el-table>
    </div>


    <el-dialog
      title="审核"
      :visible.sync="dialogVisible"
      width="30%">
      <el-form>
        <el-form-item label="名称">
          <span>{{form.name}}</span>
        </el-form-item>
        <el-form-item>
          <template>
            <el-radio v-model="radio" :label="2">通过</el-radio>
            <el-radio v-model="radio" :label="1">不通过</el-radio>
          </template>
        </el-form-item>
        <el-form-item
          v-show="radio === 1"
          label="原因">
          <el-input type="textarea" v-model="reason" clearable placeholder="原因"
                    :autosize="{ minRows: 2, maxRows: 4}"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitApprove">确 定</el-button>
      </span>
    </el-dialog>

  </div>
</template>

<script>
  import { fetchDelete, fetchGet, fetchPost } from '@/utils/request'
  import QuestionStatusSelect from '@/views/question/components/questionStatusSelect'

  export default {
    name: 'list',
    components: { QuestionStatusSelect },
    created() {
      this.getList()
    },
    data() {
      return {
        search: {
          name: null,
          status: null,
          current: 1,
          size: 10
        },
        total: 0,
        list: [],
        dialogVisible: false,
        form: {},
        radio: null,
        reason: null,
        id: null
      }
    },
    methods: {
      getList() {
        fetchPost('question/list', this.search).then(res => {
          this.list = res.records
          this.total = res.total
          console.log(res)
        })
      },
      add() {
        this.$router.push({
          name: 'QuestionEdit'
        })
      }, detail(id) {
        this.$router.push({
          name: 'QuestionEdit',
          params: {
            type: 'detail',
            id: id
          }
        })
      }, approve(row) {
        this.form = row
        this.id = row.id
        this.dialogVisible = true
      }, submitApprove() {
        if (this.radio !== 1) {
          this.reason = null
        }
        fetchGet('question/approve/' + this.id, { reason: this.reason, status: this.radio }).then(() => {
          this.getList()
        })
        this.dialogVisible = false
      }, deleteQuestion(id) {
        fetchDelete('/question/' + id).then(() => this.getList())
      }
    }
  }
</script>

<style lang="scss" scoped>
  .tag {
    width: 80px;
    text-align: center;
  }

  .search {
    margin-left: 5px;

    .el-input {
      width: 200px;

    }
  }
</style>
