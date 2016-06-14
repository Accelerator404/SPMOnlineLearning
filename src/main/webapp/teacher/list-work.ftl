<#import "../template/bootstrap.ftl" as bootstrap>
<html style="position:relative;min-height:100%;">
<@bootstrap.head title="项目批阅">
</@bootstrap.head>
<@bootstrap.body>
<div class="container" style="padding-top:60px">
	<div class="row">
		<ol class="breadcrumb">
  			<li><a href="../teacher">Home</a></li>
  			<li class="active">项目批阅</a></li>
		</ol>
	</div>
	<div class="row">
		<div class="col-md-3">
			<div class="panel panel-default">
				<ul class="nav nav-pills nav-stacked">
  					<li role="presentation" class="dropdown">
  						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
  							参数设置
  						<span class="caret"></span></a>
  						<ul class="dropdown-menu">
  							<li><a href="../teacher/list-server">服务器设置</a></li>
    						<li><a href="#">用例编排</a></li>
    					</ul>
  					</li>
  					<li role="presentation" class="dropdown">
  						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
  							项目管理
  						<span class="caret"></span></a>
  						<ul class="dropdown-menu">
  							<li><a href="../teacher/list-student">学生信息</a></li>
    						<li><a href="../teacher/list-group">分组信息</a></li>
    						<li><a href="#">成绩管理</a></li>
    					</ul>
  					</li>
  					<li role="presentation" class="active"><a href="../teacher/list-work">项目批阅</a></li>
				</ul>
			</div>
		</div>
		<div class="col-md-9">
			<table class="table">
				<caption>项目列表
				</caption>
				<thead>
					<tr>
						<th>#</th>
						<th>小组序号</th>
						<th>小组名</th>
						<th>项目文件</th>
						<th>源代码</th>
						<th>小组分数</th>
						<th>分项打分</th>
						<th>成员打分</th>
						<th>小组打分</th>
					</tr>
				</thead>
			<#list works as work>
				<tr>
					<td>${work.getId()}</td>
					<td>${work.getStudentGroup().getId()}</td>
					<td>${work.getStudentGroup().getName()}</td>
					<td>${work.getProject()!"null"}</td>
					<td>${work.getSourceCode()!"null"}</td>
					<td>${work.getStudentGroup().getPoint()!"null"}</td>
					<td>
						
					</td>
					<td>
					</td>
					<td>
					</td>
				<tr>
			</#list>
			</table>
		</div>
	</div>
</div>
<script>
	function showModal(){
		if($(".modal").length!=0)$(".modal").remove();
		$.ajax({
			type: 'GET',
			url: '../teacher/add-group-input'
		}).done(function(data){
			$("body").append(data);
			$(".modal").modal();
		});
	}
</script>
</@bootstrap.body>
</html>