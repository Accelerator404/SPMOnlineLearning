<#import "/template/bootstrap.ftl" as bootstrap>
<html style="position:relative;min-height:100%;">
<@bootstrap.head title="这是首页"></@bootstrap.head>
<@bootstrap.body>
<div class="container" style="padding-top:60px">
<div class="col-md-4">
<div class="thumbnail">
      <img src="/images/admin.jpg" alt="管理员">
      <div class="caption">
        <a href="/admin"><h3>管理员入口</h3></a>
      </div>
    </div>
</div>
<div class="col-md-4">
<div class="thumbnail">
      <img src="/images/teacher.jpg" alt="教师">
      <div class="caption">
        <a href="/teacher"><h3>教师入口</h3></a>
      </div>
    </div>
</div>
<div class="col-md-4">
<div class="thumbnail">
      <img src="/images/student.jpg" alt="学生">
      <div class="caption">
        <a href="/student"><h3>学生入口</h3></a>
      </div>
    </div>
</div>
</div>
</@bootstrap.body>
</html>