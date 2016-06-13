<#import "../template/bootstrap.ftl" as bootstrap>
<html style="position:relative;min-height:100%;">
<@bootstrap.head title="教师首页">
</@bootstrap.head>
<@bootstrap.body>
<div class="container" style="padding-top:60px">
	<div class="row">
		<ol class="breadcrumb">
  			<li class="active">Home</li>
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
  					<li role="presentation">
  						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
  							项目管理
  						<span class="caret"></span></a>
  						<ul class="dropdown-menu">
  							<li><a href="../teacher/list-student">学生信息</a></li>
    						<li><a href="../teacher/list-group">分组信息</a></li>
    						<li><a href="#">成绩管理</a></li>
    					</ul>
  					</li>
  					<li role="presentation"><a href="#">项目批阅</a></li>
				</ul>
			</div>
		</div>
		<div class="col-md-9">
			<div class="jumbotron">
  				<h2>老师，您好！</h2>
  				<p>以下是学生项目实践完成情况:</p>
  				<div class="panel panel-default">
  					<!-- List group -->
  					<ul class="list-group">
    					<li class="list-group-item">学生人数：${studentAmount}</li>
    					<li class="list-group-item">小组数：${groupAmount}</li>
    					<li class="list-group-item">提交项目数：${workAmount}</li>
  					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
</@bootstrap.body>
</html>