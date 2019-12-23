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
                // modules: {
                //     toolbar: [
                //         ['bold', 'italic', 'underline', 'strike'], // toggled buttons
                //         ['blockquote', 'code-block'],
                //     ],
                // },
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