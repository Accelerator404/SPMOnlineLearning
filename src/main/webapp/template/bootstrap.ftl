<#macro head title>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <meta name="description" content="">
  <meta name="author" content="">

  <title>${title}</title>
  <link href="https://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" rel="stylesheet">

  
  <#nested>
  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
</#macro>

<#macro body user="">
<body style="margin-bottom:60px">
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="../index">PIP</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="../index">首页</a></li>
            <li><a href="#about">关于</a></li>
          </ul>
          <#if (user?has_content)>
          <form class="navbar-form navbar-right" method="POST" action="../user/logout">
          	<div class="form-group">
  				<a href="../user" style="color:Ivory;padding:10px 15px">${user}</a>
            </div>
            <input type="hidden"
				name="${_csrf.parameterName}"
				value="${_csrf.token}"/>
          	<button type="submit" class="btn btn-success">登出</button>
          </form>
          <#else>
          <form class="navbar-form navbar-right" action="../login" method="POST">
            <div class="form-group">
              <input name="username" type="text" placeholder="Username" class="form-control">
            </div>
            <div class="form-group">
              <input name="password" type="password" placeholder="Password" class="form-control">
            </div>
            <input type="hidden"
				name="${_csrf.parameterName}"
				value="${_csrf.token}"/>
            <button type="submit" class="btn btn-success" value="Login">Sign in</button>
          </form>
          </#if>
        </div>
      </div>
    </nav>
    <#nested>
    <footer style="height:60px;position:absolute;bottom:0;width:100%;background-color:#2a2730">
      <div class="container" style="padding-right:15px;padding-left:15px;margin-top:10px">
        <p style="color:Ivory;text-align:center">Copyright (c) 2016 <a href="https://github.com/ZeroNightStudio">ZeroNightStudio</a></p>
      </div>
    </footer>
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  </body>
</#macro>

