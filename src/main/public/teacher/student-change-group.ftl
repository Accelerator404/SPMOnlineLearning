<#import "../template/bootstrap.ftl" as bootstrap>
<@bootstrap.modal title="修改学生分组">
<form action="../teacher/student-change-group" method="POST">
	<div class="form-group">
  		<label for="studentId">Id</label>
  		<input name="studentId" type="text" class="form-control" id="studentId" value="${studentId}" readonly>
  	</div>
  	<div class="form-group">
  		<label for="groupId">Group</label>
  		<select name="groupId" class="form-control" id="groupId">
  		<#if groups??>
  			<#list groups as group>
  				<option value="${group.getId()}">${group.getName()}</option>
  			</#list>
		</#if>
  		</select>
  	</div>
  	<input type="hidden"
				name="${_csrf.parameterName}"
				value="${_csrf.token}"/>
</form>
<script>
	$(".modal-footer button:eq(1)").click(function(){
  		$(".modal form").submit();
  	});
</script>
</@bootstrap.modal>