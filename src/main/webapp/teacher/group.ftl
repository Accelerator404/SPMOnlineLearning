<#import "../template/bootstrap.ftl" as bootstrap>
<html style="position:relative;min-height:100%;">
<@bootstrap.head title="分组信息">
</@bootstrap.head>
<@bootstrap.body>
<div class="container" style="padding-top:60px">
	<div class="row">
		<ol class="breadcrumb">
  			<li><a href="../teacher">Home</a></li>
  			<li><a href="#">项目管理</a></li>
  			<li class="active">分组信息</li>
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
  					<li role="presentation" class="active dropdown">
  						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
  							项目管理
  						<span class="caret"></span></a>
  						<ul class="dropdown-menu">
  							<li><a href="../teacher/list-student">学生信息</a></li>
    						<li class="active"><a href="../teacher/list-group">分组信息</a></li>
    						<li><a href="#">成绩管理</a></li>
    					</ul>
  					</li>
  					<li role="presentation"><a href="#">项目批阅</a></li>
				</ul>
			</div>
		</div>
		<div class="col-md-9">
			<table class="table">
				<caption>第${id}组<span style="float:right;">
				<button type="button" onclick="showModal(${id})" class="btn btn-default" aria-label="Left Align">
  					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
				</button></span>
				</caption>
				<thead>
					<tr>
						<th>#</th>
						<th>名字</th>
						<th>用户名</th>
						<th>分数</th>
						<th>任务</th>
						<th>工作时间</th>
						<th>打分</th>
						<th>删除</th>
					</tr>
				</thead>
			<#list students as student>
				<tr>
					<td>${student.getId()}</td>
					<td>${student.getUser().getName()}</td>
					<td>${student.getUser().getUsername()}</td>
					<td>${student.getPoint()!"null"}</td>
					<td>${student.getMission()!"null"}</td>
					<td>${student.getWorkTime()!"null"}</td>
					<td>
						<button type="button" onclick="markStudent(${student.getId()})" class="btn btn-default" aria-label="Mark">
  							<span class="glyphicon glyphicon-check" aria-hidden="true"></span>
						</button>
					</td>
					<td>
						<a href="../teacher/group-delete-student?studentId=${student.getId()}&groupId=${id}" aria-label="Delete">
  							<span class="glyphicon glyphicon-remove" aria-hidden="true" style="visibility:false;"></span>
						</a>
					</td>
				<tr>
			</#list>
			</table>
		</div>
	</div>
</div>
<script>
	function showModal(id){
		if($(".modal").length!=0)$(".modal").remove();
		$.ajax({
			type: 'GET',
			url: '../teacher/group-add-student?studentId=0&groupId='+id
		}).done(function(data){
			$("body").append(data);
			$(".modal").modal();
		});
	}
	
	function markStudent(id){
		if($(".modal").length!=0)$(".modal").remove();
		$.ajax({
			type: 'GET',
			url: '../teacher/mark-group-student?studentId='+id
		}).done(function(data){
			$("body").append(data);
			$(".modal").modal();
		});
	}
</script>
</@bootstrap.body>
</html>