<template>
  <div class="edit_container">
    <quill-editor
      v-model="content"
      ref="myQuillEditor"
      :options="editorOption"
      @blur="onEditorBlur($event)"
      @focus="onEditorFocus($event)"
      @change="onEditorChange($event)"
      style="height:300px"
    >
    </quill-editor>
  </div>
</template>

<script>
export default {
    name: 'App',
    data() {
        return {
            content: '',
            editorOption: {
                theme: 'snow',
                imageResize: {},
                modules: {
                    toolbar: [
                        ['bold', 'italic', 'underline', 'strike'], // 加粗，斜体，下划线，删除线
                        ['blockquote', 'code-block'], // 引用，代码块
                        [{ header: 1 }, { header: 2 }], // 几级标题
                        [{ list: 'ordered' }, { list: 'bullet' }], // 有序列表，无序列表
                        [{ script: 'sub' }, { script: 'super' }], // 下角标，上角标
                        [{ indent: '-1' }, { indent: '+1' }], // 缩进
                        [{ direction: 'rtl' }], // 文字输入方向
                        [{ size: ['small', false, 'large', 'huge'] }], // 字体大小
                        [{ header: [1, 2, 3, 4, 5, 6, false] }], // 标题
                        [{ color: [] }, { background: [] }], // 颜色选择
                        [{ font: [] }], // 字体
                        [{ align: [] }], // 居中
                        ['clean'], // 清除样式
                    ],
                },
            },
        }
    },
    computed: {
        editor() {
            return this.$refs.myQuillEditor.quill
        },
    },
    methods: {
        onEditorReady(editor) { // 准备编辑器
        },
        onEditorBlur() { }, // 失去焦点事件
        onEditorFocus() { }, // 获得焦点事件
        onEditorChange() { }, // 内容改变事件
        getContent() {
            return this.content
        },
        resetContent() {
            this.$set(this, 'content', '')
        },
        setContent(content) {
            this.$set(this, 'content', content)
        },
    },
}
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /* text-align: center; */
  color: #2c3e50;
  /* margin-top: 60px; */
}
</style>