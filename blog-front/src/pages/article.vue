<template>
	<div>
		<el-row class="main" type="flex" justify="center">
			<el-col :span="16">
				<div id="artcle-info">
					<h2 class="text-center"><strong>{{articleForm.title}}</strong></h2>
					<!-- 描述：文章信息 -->
					<div class="text-center timeAndView">
						<span class="article-time">
							<i class="el-icon-time"></i>
							发表于：<span>{{articleForm.createtime}}</span>
						</span>
						&nbsp;|&nbsp;
						<span class="article-views">
							<i class="el-icon-view"></i>
							阅读量：<span>1</span>万
						</span>
					</div>
					<p class="abstract">
						{{articleForm.summary}}
					</p>
				</div>
				<hr />
				<div id="artcle-content" v-html="articleForm.content">
					{{articleForm.content}}
				</div>
				<div id="statement">
					<div class="item">{{$t('article.author')}}：it疯子也</div>
					<div class="item">{{$t('article.originalLink')}}：
						<a href="https://www.fengziy.cn/">https://www.fengziy.cn/</a>
					</div>
					<div class="item">{{$t('article.copyright')}}：本博客所有文章除特别声明外,转载请注明出处!</div>
				</div>
			</el-col>
		</el-row>
	</div>
</template>

<script>
	export default {
		name: 'article',
		data(){
			return {
				articleId:'',
				articleForm:{}
			}
		},
		mounted(){
			this.articleId=this.$route.query.id
			this.getArticleDetail()
		},
		methods:{
			getArticleDetail(){
				//包含参数的情况一
				this.$axios.get(`/api/article/info/articleDetail/${this.articleId}`, {
				}).then(response => {
					this.articleForm = response.data.data
					
					console.log(this.articleForm)		
				}).catch(error => {
					console.log(error)
				})
			}
		}
	}
</script>

<style scoped>
	#artcle-info {
		padding: 20px;
		background-image: url(../assets/vue.jpg);
		margin-bottom: 40px;
	}
	
	#artcle-info .abstract {
		color: #ffffff;
		border-left: 3px solid #F56C6C;
		padding: 10px;
		background-color: rgba(126, 129, 135, 0.3);
	}
	
	#artcle-info .timeAndView {
		padding: 20px;
		line-height: 30px;
		font-size: 16px;
		color: #ffffff;
	}
	
	pre.has {
		color: #ffffff;
		background-color: rgba(0, 0, 0, 0.8);
	}
	
	img.has {
		width: 100%;
	}
	
	#statement {
		border-left: 3px solid #F56C6C;
		padding: 20px;
		background-color: #EBEEF5;
	}
</style>