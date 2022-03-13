<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../views/header.jsp"%>

<div class="container">
	<form class="was-validated" method="post" action="/login">

		<div class="form-group">
			<label for="id">ID:</label> 
			<input id="id" name="id" type="text" class="form-control"	placeholder="Enter ID" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<div class="form-group">
			<label for="pwd">Password:</label>
			 <input id="password" name="password" type="password" class="form-control" placeholder="Enter password" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<button type="submit" id="submit">로그인</button>
	</form>
</div>

</script>

<%@ include file="../views/footer.jsp"%>