<template>
  <section class="blog-body">
    <el-tag
      :key="index"
      v-for="(tag,index) in Tags"
      closable
      :disable-transitions="false"
      @close="handleClose(tag)"
    >{{tag}}</el-tag>
    <el-input
      class="input-new-tag"
      v-if="inputVisible"
      v-model="inputValue"
      ref="saveTagInput"
      size="small"
      @keyup.enter.native="handleInputConfirm"
    ></el-input>
    <el-button v-else class="button-new-tag" size="small" @click="showInput">+ New Tag</el-button>
  </section>
</template>
<script>
export default {
  name: "tags",
  data() {
    return {
      Tags: [],
      inputVisible: false,
      inputValue: ""
    };
  },
  methods: {
    handleClose(name) {
      this.axios
        .post("/api/admin/delTag", { name })
        .then(response => {
          this.Tags.splice(this.Tags.indexOf(name), 1);
          this.$message({
            message: "删除成功",
            type: "success"
          });
        })
        .catch(error => {
          console.log(error);
        });
    },

    showInput() {
      this.inputVisible = true;
      this.$nextTick(_ => {
        this.$refs.saveTagInput.$refs.input.focus();
      });
    },

    handleInputConfirm() {
      let inputValue = this.inputValue;
      if (inputValue.length < 1) {
        this.$message({
          message: "内容不能为空",
          type: "warning"
        });
        return;
      }
      this.axios
        .post("/api/article/tag/add", { tagName: inputValue })
        .then(response => {
        if(response.data.code !== 200){
          this.$message({
            message: response.data.msg,
            type: 'warning'
          });
        }else{
         this.$message({
            message: "添加成功",
            type: "success"
          });

          if (inputValue) {
            this.Tags.push(inputValue);
          }
            this.inputVisible = false;
            this.inputValue = "";
          }
        }).catch(error => {
          console.log(error);
        });
    }
  },
  mounted() {
    this.axios
      .get("/api/article/tag/getTagAll")
      .then(response => {
        let data = response.data.data;
        let tags = data.map(v => v.tagName);
        this.Tags = tags;
      })
      .catch(error => {
        console.log(error.response)
        toastr.error(error.response.data.message);
      });
  }
};
</script>
<style scoped>
.el-tag,
.el-tag {
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

