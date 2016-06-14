<#import "../template/bootstrap.ftl" as bootstrap>
<html style="position:relative;min-height:100%;">
<@bootstrap.head title="安装部署">
</@bootstrap.head>
<@bootstrap.body>
<div class="container" style="padding-top:60px">
	<div class="row">
		<ol class="breadcrumb">
  			<li><a href="../student">Home</a></li>
  			<li class="active">安装部署</li>
		</ol>
	</div>
	<div class="row">
		<div class="col-md-3">
			<div class="panel panel-default">
				<ul class="nav nav-pills nav-stacked">
  					<li role="presentation" class="active"><a href="../student/deploy">安装部署</a></li>
  					<li role="presentation" class="dropdown">
  						<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
  							项目测试
  						<span class="caret"></span></a>
  						<ul class="dropdown-menu">
  							<li><a href="#">首页检测</a></li>
    						<li><a href="#">功能检测</a></li>
    						<li><a href="#">性能测试</a></li>
    						<li><a href="#">代码测试</a></li>
    					</ul>
  					</li>
  					<li role="presentation"><a href="#">文档提交</a></li>
  					<li role="presentation"><a href="#">查询成绩</a></li>
				</ul>
			</div>
		</div>
		<div class="col-md-9">
			<form method="POST" action="../student/deploy" enctype="multipart/form-data">
				<div class="form-group">
  					<label for="server">服务器</label>
  					<select class="form-control" name="server">
  						<#list servers as server>
  						<option value="${server.getId()}">${server.getLinkAddress()}</option>
  						</#list>
  					</select>
  				</div>
  				<div class="form-group">
  					<label for="upload">项目文件</label>
  					<input name="upload" type="file" class="form-control" required="required">
  					<#if work??>
  					<span id="helpBlock" class="help-block">你已有已上传的项目文件在<a href="${work.getProject()}">这里</a></span>
  					</#if>
  				</div>
  				<div class="form-group">
  					<label for="sourceCode">源代码</label>
  					<input name="sourceCode" type="text" class="form-control" required="required"<#if work??> value="${work.getSourceCode()}"</#if>>
  				</div>
  				<input type="hidden"
					name="${_csrf.parameterName}"
					value="${_csrf.token}"/>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</div>
</div>
</@bootstrap.body>
</html>