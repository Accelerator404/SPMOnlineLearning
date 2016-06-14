<#import "../template/bootstrap.ftl" as bootstrap>
<html style="position:relative;min-height:100%;">
<@bootstrap.head title="学生首页">
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
  			<li class="active">Home</li>
		</ol>
	</div>
	<div class="row">
		<div class="col-md-3">
			<div class="panel panel-default">
				<ul class="nav nav-pills nav-stacked">
  					<li role="presentation"><a href="../student/deploy">安装部署</a></li>
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
			<div class="jumbotron">
  				<h2>项目实践检测流程：</h2>
  				<p>1、 在编号为SPM-XXX的服务器上安装部署系统</p>
				<p>2、 登陆系统首页；</p>
				<p>3、 提交源程序，放到指定的目录：/SPM-组号</p>
				<p>4、 随机选择5个功能测试用例，</p>
				<p>5、 随机选择1个压力测试用例</p>
				<p>6、 提交需求文档、概要设计、详细设计，符合文件名字（BUPT-SPM-组号-SRS、BUPT-SPM-组号-HLD、BUPT-SPM-组号-DLD）、章节检查（参照模板）</p>
				<p>7、 可以查询实践成绩。</p>
			</div>
		</div>
	</div>
</div>
</@bootstrap.body>
</html>