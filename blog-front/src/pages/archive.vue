<template>
	<div class="archive">
		<div class="count">{{this.$route.params.name || $t('header.archive')}}：234{{$t('archive.article')}}</div>
		<el-timeline>
			<el-timeline-item v-for="(activity, index) in activities" :key="index" :color="activity.color" :timestamp="activity.postTime" placement="top" @mouseenter="hoverLine(activity)">
				<div class="line-item">
					<router-link :to="{path:  '/article', query:{id:activity.id}}">
						{{activity.title}}
					</router-link>
				</div>
			</el-timeline-item>
		</el-timeline>
	</div>
</template>

<script>
	export default {
		name: 'archive',
		data() {
			return {
				activities: []
			};
		},
		mounted(){
			this.archiveLine()
		},
		methods: {
			archiveLine(){
				//包含参数的情况一
				this.$axios.get('/api/article/info/archiveTimeLine', {
					
				}).then(response => {
					this.activities = response.data.data	
				}).catch(error => {
					console.log(error)
				})
			},
			hoverLine(activity) {
				activity.color = "#409eff"
			}
		}
	}
</script>

<style scoped>
	.line-item {
		display: inline-block;
	}
	
	.line-item:hover {
		cursor: pointer;
		color: #409EFF;
	}
	
	.count {
		margin-bottom: 20px;
		font-size: 20px;
		color: #E6A23C;
	}
</style>