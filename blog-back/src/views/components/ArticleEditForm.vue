<template>
 <div>
    <el-dialog
    title="博文详情"
    :visible.sync="dialogVisible"
    :close-on-click-modal="false"
    width="50%">
        <el-form ref="form" :model="form">
            <el-form-item label="标题">
                <el-input v-model="form.title"></el-input>
            </el-form-item>
            <el-form-item label="简介">
                <el-input type="text-area" v-model="form.summary"></el-input>
            </el-form-item>
            <el-form-item label="是否发布">
                <el-switch v-model="form.delivery"></el-switch>
            </el-form-item>
            <richTextForm ref="richText"></richTextForm>
            <el-form-item>
                <el-button type="primary" @click="search">查询</el-button>
            </el-form-item>
        </el-form>
    </el-dialog>
 </div>
</template>
<script>
import richTextForm from '../../components/richTextForm'

export default {
    components: { richTextForm },
    data() {
        return {
            form: {},
            dialogVisible: false,
            editorOption: {},
        }
    },
    mounted() {
    },
    methods: {
        open() {
            this.dialogVisible = true
        },
    },
}
</script>
