<template>
 <div class="pageFullScreen">
    <ArticleEditForm ref="ArticleEditForm" @freshTable="freshTable()"></ArticleEditForm>
    <el-form ref="form" :inline="true" :model="form" style="margin-left:10px">
        <el-form-item label="标题">
            <el-input v-model="form.title"></el-input>
        </el-form-item>
        <el-form-item label="活动时间">
            <el-col>
                <el-date-picker
                    v-model="form.time"
                    type="daterange"
                    range-separator="至"
                    start-placeholder="开始日期"
                    end-placeholder="结束日期"
                    :default-time="['00:00:00', '23:59:59']">
                </el-date-picker>
            </el-col>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="search()">查询</el-button>
            <el-button type="primary" @click="add()">新增</el-button>
        </el-form-item>
    </el-form>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        prop="createtime"
        label="创建日期"
        width="180">
      </el-table-column>
      <el-table-column
        prop="title"
        label="标题"
        width="180">
      </el-table-column>
      <el-table-column
        prop="summary"
        label="简介">
      </el-table-column>
      <el-table-column
        label="是否发布">
        <template slot-scope="scope">
            <el-tag size="medium">{{ scope.row.isPost === 0 ? '未发布' : '已发布' }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column
        label="操作">
        <template slot-scope="scope">
            <el-button type="danger" @click="delArticle(scope.row.id)">删除</el-button>
            <el-button type="primary" @click="editArticle(scope.row)">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="block" style="margin-top: 13px">
        <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[10, 15, 20]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="totalSize">
        </el-pagination>
    </div>
 </div>
</template>
<script>
import Vue from 'vue'
import ArticleEditForm from './components/ArticleEditForm'

export default {
    components: { ArticleEditForm },
    data() {
        return {
            form: { title: '' },
            pageSize: 10,
            totalSize: 1,
            currentPage: 1,
            tableData: [],
        }
    },
    mounted() {
        this.getTableList()
    },
    methods: {
        search() {
            if (this.form.time !== null && this.form.time !== '' && this.form.time !== undefined) {
                const start = this.form.time[0]
                const end = this.form.time[1]
                const startDay = start.getDate() < 10 ? '0' + start.getDate().toString() : start.getDate().toString()
                const endDay = end.getDate() < 10 ? '0' + end.getDate().toString() : end.getDate().toString()

                const starttime = start.getFullYear().toString() + '-' + (start.getMonth() + 1).toString() + '-' + startDay + ' 00:00:00'
                const endtime = end.getFullYear().toString() + '-' + (end.getMonth() + 1).toString() + '-' + endDay + ' 23:59:59'
                this.$set(this.form, 'starttime', starttime)
                this.$set(this.form, 'endtime', endtime)
                Vue.delete(this.form, 'time')
            }
            // if (this.form.title !== null && this.form.title !== '' && this.form.title !== undefined) {
            //     this.$set(this.form, 'title', this.form.title)
            // }
            this.getTableList()
        },
        handleSizeChange(val) {
            this.pageSize = val
            this.getTableList()
        },
        handleCurrentChange(val) {
            this.currentPage = val
            this.getTableList()
        },
        getTableList() {
            this.$set(this.form, 'currentPage', this.currentPage)
            this.$set(this.form, 'pageSize', this.pageSize)
            this.$axios({
                method: 'get',
                url: '/api/article/info/back/getBackArticle',
                params: this.form,
            }).then((res) => {
                if (res.code === 200) {
                    this.$set(this, 'tableData', res.data.records)
                    this.totalSize = res.data.total
                }
            })
        },
        freshTable() {
            this.getTableList()
        },
        // 删除博文
        delArticle(articleId) {
            this.$confirm('此操作将永久删除该条数据, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning',
            }).then(() => {
                this.$axios({
                    method: 'delete',
                    url: `/api/article/info/back/delArticle/${articleId}`,
                }).then((res) => {
                    if (res.code === 200) {
                        this.getTableList()
                    }
                })
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除',
                })
            })
        },
        editArticle(row) {
            this.$refs.ArticleEditForm.open(1, row)
        },
        add() {
            this.$refs.ArticleEditForm.open(0)
        },
    },
}
</script>
