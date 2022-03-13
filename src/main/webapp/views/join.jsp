<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>	 	
		<title>회원가입</title>
	</head>
	<script type="text/javascript">				
		function idCheck() {    
			var id = $("#id").val();    
			$.ajax({
				async : true, 
				type : 'POST', 
				data: id,
				url: "/idCheck",
				dataType: "json",
				contentType: "application/json; charset=UTF-8",
				success: function(count) {    
					if(count > 0) {
						alert("해당 아이디 존재");    
						$("#submit").attr("disabled", "disabled");
						window.location.reload();
					} else {
						alert("사용가능 아이디");
						$("#submit").removeAttr("disabled");
					}            
				},
				error: function(error) {
					alert("아이디를 입력해주세요.");
				}        
			});
		}
	</script>
<%@ include file="../views/header.jsp"%>

<div class="container">
	<form class="was-validated" method="post" action="/join">
		<div class="form-group">
			<label for="id">ID :</label>
			<button id="btn-id-check" type="button" class="btn btn-warning float-right" onclick="idCheck()">중복확인</button>
			<input id="id" name="id" type="text" class="form-control" placeholder="Enter ID" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<div class="form-group">
			<label for="name">Username:</label>
			<input id="name" name="name" type="text" class="form-control" placeholder="Enter username" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<div class="form-group">
			<label for="password">Password:</label> 
			<input id="password" name="password" type="password" class="form-control" placeholder="Enter password" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<div class="form-group">
			<label for="email">Email:</label> 
			<input id="email" name="email" type="email" class="form-control" placeholder="Enter Email" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<button type="submit" id="submit" >회원가입</button>
	</form>
</div>
<%@ include file="../views/footer.jsp"%>
	
</html>