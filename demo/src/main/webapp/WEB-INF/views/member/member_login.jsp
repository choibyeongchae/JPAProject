<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>ログイン</title>
<jsp:include page="../head.jsp" />
<script type="text/javascript">
	function doLogin() {
		
		var jsonObj = new Object();
		jsonObj.email = $("#email").val();
		jsonObj.password = $("#password").val();
		
		$.ajax({
			type : "POST",
			url : "./doLogin",
			cache : false,
			contentType : 'application/json',
			dataType : 'json',
			data : JSON.stringify(jsonObj),
			success : function(data) {
				console.log(data);
				if (data.result != "fail") {
					alert("正常に処理されました。");
					sessionStorage.setItem('userInfo', JSON.stringify({ email: data.email,token : data.token }));
					location.href = "/";
				} else {
					localStorage["userInfo"] = "";
					alert("メールとかパスワードが一致しません。");
				}
			},
			error : function(error) {
				alert(error);
			}
		});
	}
</script>
</head>
<body>
<jsp:include page="../header.jsp" />
<form class="signUp" id="signupForm">
   <h1 class="signUpTitle">Sign up in seconds</h1>
   <input type="text" name = "email" id = "email" class="signUpInput" placeholder="Type your username" autofocus required>
   <input type="password" name = "password" id = "password" class="signUpInput" placeholder="Choose a password" required>
   <input type="button" onclick = "doLogin();" value="Sign me up!" class="signUpButton">
</form>
<jsp:include page="../footer.jsp" />
</body>
</html>