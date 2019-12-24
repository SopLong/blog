<template>
 <div class="pageFullScreen">
    <el-tag
        :key="tag"
        v-for="tag in dynamicTags"
        closable
        :disable-transitions="false"
        @close="handleClose(tag.id)">
        {{tag.tagName}}
    </el-tag>
    <el-input
        class="input-new-tag"
        v-if="inputVisible"
        v-model="inputValue"
        ref="saveTagInput"
        size="small"
        @keyup.enter.native="handleInputConfirm"
        @blur="handleInputConfirm"
    >
    </el-input>
    <el-button v-else class="button-new-tag" size="small" @click="showInput">+ New Tag</el-button>
 </div>
</template>

<script>
export default {
    data() {
        return {
            dynamicTags: [],
            inputVisible: false,
            inputValue: '',
        }
    },
    mounted() {
        this.getTagList()
    },
    methods: {
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
        handleClose(id) {
            this.$confirm('此操作将永久删除该条数据, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning',
            }).then(() => {
                this.$axios({
                    method: 'delete',
                    url: `/api/article/tag/del/${id}`,
                }).then((res) => {
                    if (res.code === 200) {
                        this.getTagList()
                    }
                })
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除',
                })
            })
        },

        showInput() {
            this.inputVisible = true
            this.$nextTick(_ => {
                this.$refs.saveTagInput.$refs.input.focus()
            })
        },

        handleInputConfirm() {
            let inputValue = this.inputValue
            if (inputValue === '' || inputValue === null || inputValue === undefined) {
                this.$message({
                    message: '警告哦，标签内容不能为空',
                    type: 'warning',
                })
            } else {
                const data = { tagName: inputValue }
                this.$axios({
                    method: 'post',
                    url: '/api/article/tag/add',
                    data,
                }).then((res) => {
                    if (res.code === 200) {
                        this.getTagList()
                        this.$set(this, 'inputValue', '')
                        this.$set(this, 'inputVisible', false)
                    }
                })
            }
        },
    },
}
</script>
<style>
  .el-tag + .el-tag {
    margin-left: 10px;
  }
  .button-new-tag {
    margin-left: 10px;
    height: 32px;
    line-height: 30px;
    padding-top: 0;
    padding-bottom: 0;
  }
  .input-new-tag {
    width: 90px;
    margin-left: 10px;
    vertical-align: bottom;
  }
</style>