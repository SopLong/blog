<template>
	<div class="tag">
		<el-card class="box-card">
			<div slot="header" class="d-flex align-items-center">
				<img class="card-icon" src="../assets/biaoqian.png" />
				<span>{{$t('tag.tag')}}</span>
			</div>
			<div class="text item">
				
					<el-tag
					class="tag-item"
					v-for="(tag) in tags"
					:key="tag"
					type= 'primary'
					>
						<router-link :to="{path:  '/archive', query:{tagId:tags.id}}">
							<i>{{tag.tagName}}</i>
						</router-link>
					</el-tag>
				
			</div>
		</el-card>
	</div>
</template>

<script>
	export default {
		name: 'tag',
		data(){
			return{
				tags:[]
			}
		},
		mounted(){
			this.getTags()
		},
		methods: {
			getTags(){
				this.$axios.get('/api/article/tag/getTagAll', {
				}).then(response => {
					this.tags = response.data.data	
				}).catch(error => {
					console.log(error)
				})
			},
			tag(id) {
				console.log(111111111)
				console.log(id)
				this.$router.push({
					name: 'archive',
					params: {
						'name': id
					}
				});
			}
		}
	}
</script>

<style scoped>
	.box-card .item:hover {
		color: #409EFF;
		cursor: pointer;
	}
	
	.box-card span {
		font-weight: bold;
	}
	
	.card-icon {
		width: 20px;
		height: 20px;
		margin-right: 10px;
	}
	
	.tag-item {
		margin-right: 10px;
	}
</style>