<#import "../template/bootstrap.ftl" as bootstrap>
<@bootstrap.modal title="Edit User">
<form method="POST" action="../admin/edit-user">
  <div class="form-group">
  	<label for="id">Id</label>
  	<input name="id" type="text" class="form-control" id="id" value="${user.getId()}" readonly>
  </div>
  <div class="form-group">
    <label for="username">Username</label>
    <input name="username" type="text" class="form-control" id="username" value="${user.getUsername()}" readonly>
  </div>
  <div class="form-group">
    <label for="email">Email</label>
    <input name="email" type="email" class="form-control" id="email" value="${user.getEmail()}">
  </div>
  <div class="form-group">
    <label for="phoneNumber">PhoneNumber</label>
    <input name="phoneNumber" type="text" class="form-control" id="phoneNumber" value="${user.getPhoneNumber()}">
  </div>
  <div class="form-group">
  	<label for="name">Name</label>
  	<input name="name" type="text" class="form-control" id="name" value="${user.getName()}">
  </div>
  <div class="form-group">
  	<label for="roleName">Role</label>
  	<select name="roleName" class="form-control" id="roleName">
  		<option value="ROLE_TEACHER">Teacher</option>
  		<option value="ROLE_STUDENT">Student</option>
  	</select>
  </div>
  <input type="hidden"
				name="${_csrf.parameterName}"
				value="${_csrf.token}"/>
</form>
<script>
  	if("ROLE_TEACHER"=="${user.getRole().getRoleName()}")
  		$("select option:first").attr("selected","selected");
  	else $("select option:eq(1)").attr("selected","selected");
  	$(".modal-footer button:eq(1)").click(function(){
  		$(".modal form").submit();
  	});
  </script>
</@bootstrap.modal>