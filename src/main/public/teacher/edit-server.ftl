<#import "../template/bootstrap.ftl" as bootstrap>
<@bootstrap.modal title="Edit Server">
<form method="POST" action="../teacher/edit-server">
  <div class="form-group">
  	<label for="serverId">Id</label>
  	<input name="serverId" type="text" class="form-control" id="serverId" value="${server.getId()}" readonly>
  </div>
  <div class="form-group">
  	<label for="name">名字</label>
  	<input name="name" type="text" class="form-control" id="name" value="${server.getName()}" required="required">
  </div>
  <div class="form-group">
  	<label for="linkAddress">IP地址</label>
  	<input name="linkAddress" type="text" class="form-control" id="linkAddress" value="${server.getLinkAddress()}" required="required">
  </div>
  <input type="hidden"
				name="${_csrf.parameterName}"
				value="${_csrf.token}"/>
</form>
<script>
  	$(".modal-footer:eq(1) button:eq(1)").click(function(){
  		$(".modal:eq(1) form").submit();
  	});
  </script>
</@bootstrap.modal>