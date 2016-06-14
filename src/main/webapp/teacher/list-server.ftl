<#import "../template/bootstrap.ftl" as bootstrap>
<html style="position:relative;min-height:100%;">
<@bootstrap.head title="服务器设置">
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
  			<li><a href="#">参数设置</a></li>
  			<li class="active">服务器设置</li>
		</ol>
	</div>
	<div class="row">
		<div class="col-md-3">
			<div class="panel panel-default">
				<ul class="nav nav-pills nav-stacked">
  					<li role="presentation" class="dropdown active">
  						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
  							参数设置
  						<span class="caret"></span></a>
  						<ul class="dropdown-menu">
  							<li class="active"><a href="../teacher/list-server">服务器设置</a></li>
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
  					<li role="presentation"><a href="#">项目批阅</a></li>
				</ul>
			</div>
		</div>
		<div class="col-md-9">
			<table class="table">
				<caption>服务器列表<span style="float:right;">
				<button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal">
  					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
				</button>
				</span>
				</caption>
				<thead>
					<tr>
						<th>#</th>
						<th>IP地址</th>
						<th>名字</th>
						<th>修改</th>
						<th>部署</th>
						<th>删除</th>
					</tr>
				</thead>
			<#list servers as server>
				<tr>
					<td>${server.getId()}</td>
					<td>${server.getLinkAddress()}</td>
					<td>${server.getName()}</td>
					<td>
						<button type="button" onclick="showModal(${server.getId()})" class="btn btn-default" aria-label="Left Align">
  							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						</button>
					</td>
					<td>
						<a href="${server.getLinkAddress()}/manager/html" aria-lebel="Deploy">
							<span class="glyphicon glyphicon-cloud-upload" aria-hidden="true"></span>
						</a>
					</td>
					<td>
						<a href="../teacher/del-server?id=${server.getId()}" aria-label="Del">
  							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
						</a>
					</td>
				<tr>
			</#list>
			</table>
		</div>
	</div>
</div>
<div class="modal fade" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">添加服务器</h4>
      </div>
      <div class="modal-body">
        <form method="POST" action="../teacher/add-server">
        	<div class="form-group">
  				<label for="name">名字</label>
  				<input name="name" type="text" class="form-control" id="name" required="required">
  			</div>
  			<div class="form-group">
  				<label for="link">IP地址</label>
  				<input name="linkAddress" type="text" class="form-control" id="linkAddress" required="required">
  			</div>
  			<input type="hidden"
				name="${_csrf.parameterName}"
				value="${_csrf.token}"/>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="submitAdd()">Save changes</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script>
	function showModal(id){
		if($(".modal:eq(1)").length!=0)$(".modal:eq(1)").remove();
		$.ajax({
			type: 'GET',
			url: '../teacher/edit-server?serverId='+id
		}).done(function(data){
			$("body").append(data);
			$(".modal:eq(1)").modal();
		});
	}
	
	function submitAdd(){
		$("form:eq(2)").submit();
	}
</script>
</@bootstrap.body>
</html>