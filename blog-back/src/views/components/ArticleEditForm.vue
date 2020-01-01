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
            <el-form-item label="封面">
                <el-upload
                    :action="Upload.url"
                    :data="Upload.params"
                    :limit="1"
                    list-type="picture-card"
                    :on-preview="handlePictureCardPreview"
                    :on-success="uploadSuccess"
                    :file-list="editFiles"
                    :on-remove="handleRemove">
                    <i class="el-icon-plus"></i>
                </el-upload>
                <el-dialog :visible.sync="dialogPicVisible" :modal="false">
                    <img width="100%" :src="dialogImageUrl" alt="">
                </el-dialog>
            </el-form-item>
            <mavon-editor v-model="articleForm.mdContent" @change="getHtmlContent" ref=md @imgAdd="$imgAdd" @imgDel="$imgDel"/>
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
            htmlContent: '',
            dialogImageUrl: '',
            editFiles: [], // 编辑时已上传图片初始化
            dialogPicVisible: false,
            Upload: {
                url: 'http://localhost:8080/api/file/upload',
                params: {
                    type: 'ARTICLE_PICTURE',
                },
            },
        }
    },
    mounted() {
        this.getTagList()
    },
    methods: {
        // 绑定@imgAdd event
        $imgAdd(pos, file) {
            console.log(pos)
            console.log(file)
            // 第一步.将图片上传到服务器.
            let formdata = new FormData()
            formdata.append('images', file)
            formdata.append('type', 'ARTICLE_CONTENT_PIC')
            console.log(formdata)
            this.$axios({
                url: '/api/file/upload/',
                method: 'post',
                data: formdata,
                headers: { 'Content-Type': 'multipart/form-data' },
            }).then((res) => {
                console.log(res)
                if (res.code === 200) {
                    // 第二步.将返回的url替换到文本原位置![...](0) -> ![...](url)
                    this.$refs.md.$img2Url(pos, res.data.httpPath)
                }
            })
        },
        uploadSuccess(response, file, fileList) {
            if (response.code === 200) {
                this.dialogImageUrl = response.data.httpPath
                this.articleForm.uuid = response.data.uuid
            }
        },
        handleRemove(file, fileList) {
            console.log(file, fileList)
            this.$axios.put(`/api/file/delFile/${file.uuid}`, {
            }).then(response => {

            }).catch(error => {
                console.log(error)
            })
        },
        handlePictureCardPreview(file) {
            this.dialogImageUrl = file.response.data.httpPath
            this.dialogPicVisible = true
        },
        getHtmlContent(content, htmlContent) {
            this.htmlContent = htmlContent
        },
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
                const file = response.data.file
                this.dialogImageUrl = file.httpPath
                this.editFiles.push({
                    name: 'name' + file.uuid,
                    url: file.httpPath,
                    uuid: file.uuid })
            }).catch(error => {
                console.log(error)
            })
        },
        // 关闭弹窗
        closeDialog() {
            this.dialogVisible = false
            this.dialogImageUrl = ''
            this.editFiles = []
            this.articleForm.htmlContent = ''
            this.articleForm = { title: '', postFlag: false }
            this.$refs.form.resetFields()
            this.$emit('freshTable')
        },
        save() {
            let url
            let method
            if (this.flag === 0) {
                url = '/api/article/info/add'
                method = 'post'
            } else {
                url = '/api/article/info/edit'
                method = 'put'
            }
            this.$set(this.articleForm, 'content', this.htmlContent)
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