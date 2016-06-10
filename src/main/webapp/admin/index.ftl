<#import "../template/bootstrap.ftl" as bootstrap>
<html style="position:relative;min-height:100%;">
<@bootstrap.head title="管理员首页">
</@bootstrap.head>
<@bootstrap.body>
<div class="container" style="padding-top:60px">
<table class="table">
	<caption>用户列表</caption>
	<thead>
		<tr>
			<th>#</th>
			<th>Username</th>
			<th>Email</th>
			<th>Phone Number</th>
			<th>Created Time</th>
			<th>Last Login</th>
			<th>Name</th>
			<th>Role</th>
			<th>Edit</th>
		</tr>
	</thead>
	<#list users as user>
		<tr>
			<td>${user.getId()}</td>
			<td>${user.getUsername()}</td>
			<td>${user.getEmail()}</td>
			<td>${user.getPhoneNumber()}</td>
			<td>${user.getCreateTime()}</td>
			<td>${user.getLastLogin()}</td>
			<td>${user.getName()}</td>
			<td>${user.getRole().getRoleName()}</td>
			<td>
				<button type="button" onclick="showModal(${user.getId()})" class="btn btn-default" aria-label="Edit">
  					<span class="glyphicon glyphicon-pencil" aria-hidden="true" style="visibility:false;"></span>
				</button>
			</td>
		<tr>
	</#list>
</table>
</div>
<script type="text/javascript">
	function showModal(id){
		if($(".modal").length!=0)$(".modal").remove();
		$.ajax({
			type: 'GET',
			url: '../admin/user?Id='+id
		}).done(function(data){
			$("body").append(data);
			$(".modal").modal();
		});
	};
</script>
</@bootstrap.body>
</html>