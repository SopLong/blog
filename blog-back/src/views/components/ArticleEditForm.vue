<template>
 <div>
    <el-dialog
    title="博文详情"
    :visible.sync="dialogVisible"
    :close-on-click-modal="false"
    @close="closeDialog"
    width="50%">
        <el-form ref="form" :model="articleForm">
            <el-form-item label="标题" prop="title">
                <el-input v-model="articleForm.title"></el-input>
            </el-form-item>
            <el-form-item label="简介" prop="summary">
                <el-input type="text-area" v-model="articleForm.summary"></el-input>
            </el-form-item>
            <el-form-item label="是否发布" prop="postFlag">
                <el-switch v-model="articleForm.postFlag"></el-switch>
            </el-form-item>
            <el-form-item label="标签" prop="postFlag">
                <el-select v-model="articleForm.tags" multiple placeholder="请选择">
                    <el-option
                    v-for="item in dynamicTags"
                    :key="item.id"
                    :label="item.tagName"
                    :value="item.id">
                    </el-option>
                </el-select>
            </el-form-item>
            <mavon-editor v-model="articleForm.content"/>
            <el-form-item>
                <el-button type="primary" @click="save()">Save</el-button>
            </el-form-item>
        </el-form>
    </el-dialog>
 </div>
</template>
<script>

export default {
    components: { },
    data() {
        return {
            articleForm: { title: '', postFlag: false },
            dialogVisible: false,
            editorOption: {},
            dynamicTags: [],
            flag: '',
        }
    },
    mounted() {
        this.getTagList()
    },
    methods: {
        open(flag, row) {
            this.flag = flag
            this.dialogVisible = true
            if (flag === 1) {
                this.getArticleDetail(row.id)
            }
        },
        getArticleDetail(articleId) {
            this.$axios.get(`/api/article/info/back/articleDetail/${articleId}`, {
            }).then(response => {
                this.articleForm = response.data
                this.$refs.richText.setContent(this.articleForm.content)
            }).catch(error => {
                console.log(error)
            })
        },
        // 关闭弹窗
        closeDialog() {
            this.dialogVisible = false
            this.$emit('freshTable')
        },
        save() {
            let url
            let method
            if (this.flag === 0) {
                console.log('add')
                url = '/api/article/info/add'
                method = 'post'
            } else {
                console.log('edit')
                url = '/api/article/info/edit'
                method = 'put'
            }
            const data = this.articleForm
            this.$axios({
                method,
                url,
                data,
            }).then((res) => {
                if (res.code === 200) {
                    this.closeDialog()
                }
            })
        },
        // 获取标签列表
        getTagList() {
            this.$axios({
                method: 'get',
                url: '/api/article/tag/getTagAll',
            }).then((res) => {
                if (res.code === 200) {
                    // this.getTableList()
                    this.dynamicTags = res.data
                }
            })
        },
    },
}
</script>
