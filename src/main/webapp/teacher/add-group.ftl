<#import "../template/bootstrap.ftl" as bootstrap>
<@bootstrap.modal title="Add Group">
<form method="POST" action="../teacher/add-group">
  <div class="form-group">
  	<label for="name">名字</label>
  	<input name="name" type="text" class="form-control" id="name">
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