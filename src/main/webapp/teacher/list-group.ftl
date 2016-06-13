<#import "../template/bootstrap.ftl" as bootstrap>
<html style="position:relative;min-height:100%;">
<@bootstrap.head title="分组管理">
</@bootstrap.head>
<@bootstrap.body>
<div class="container" style="padding-top:60px">
	<#if errorMessage??>
		<div class="alert alert-danger alert-dismissible" role="alert">
  			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  			${errorMessage}
		</div>
	</#if>
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
  							<li><a href="#">服务器设置</a></li>
    						<li><a href="#">用例编排</a></li>
    					</ul>
  					</li>
  					<li role="presentation" class="active">
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
				<caption>分组列表<span style="float:right;">
				<button type="button" onclick="showModal()" class="btn btn-default" aria-label="Left Align">
  					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
				</button></span>
				</caption>
				<thead>
					<tr>
						<th>#</th>
						<th>名字</th>
						<th>分数</th>
						<th>SPM币</th>
						<th>学生人数</th>
						<th>项目</th>
						<th>修改</th>
					</tr>
				</thead>
			<#list groups as group>
				<tr>
					<td>${group.getId()}</td>
					<td>${group.getName()}</td>
					<td>${group.getPoint()!"null"}</td>
					<td>${group.getSpm()}</td>
					<td>${group.getStudents().size()}</td>
					<td></td>
					<td>
						<a href="../teacher/group?id=${group.getId()}" aria-label="Edit">
  							<span class="glyphicon glyphicon-pencil" aria-hidden="true" style="visibility:false;"></span>
						</a>
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