<#import "../template/bootstrap.ftl" as bootstrap>
<@bootstrap.modal title="Add Student To Group">
<table class="table">
	<caption>学生列表<span style="float:right;"></caption>
		<thead>
			<tr>
				<th>#</th>
				<th>名字</th>
				<th>用户名</th>
				<th>添加</th>
			</tr>
		</thead>
		<#list students as student>
			<tr>
				<td>${student.getId()}</td>
				<td>${student.getUser().getName()}</td>
				<td>${student.getUser().getUsername()}</td>
				<td>
					<a href="../teacher/group-add-student?groupId=${groupId}&studentId=${student.getId()}" aria-label="Edit">
  						<span class="glyphicon glyphicon-plus" aria-hidden="true" style="visibility:false;"></span>
					</a>
				</td>
			<tr>
		</#list>
</table>
<script>
	$(".modal-footer .btn-primary").hide();
</script>
</@bootstrap.modal>