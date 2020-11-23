<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>会員登録</title>
<jsp:include page="../head.jsp" />
<script type="text/javascript">
var checkId = 0;
	$(function() {
		getDrawSelect();
		
	})

	function getDrawSelect() {
		$("#name").val("");
		$("#email").val("");
		$("#password").val("");
		$("#passwordRe").val("");
		$("#birth").val("");
		$("#phone").val("");
		$("#address").val("");
		for (var i = 0; i < 100; i++) {
			var year = 2000;
			var str = "";
			if (i == 0 ) {
				str = "<option value="+(year-i)+" selected>"+(year-i)+"</option>";
			} else {
				str = "<option value="+(year-i)+">"+(year-i)+"</option>";
			}
			$("select[name=birth_year]").append(str);
		}
		
		for (var i = 0; i < 12; i++) {
			var month = 1;
			var str = "";
			if (i == 0) {
				str = "<option value="+(month+i)+" selected>" +(month+i)+"</option>";
			} else {
				str = "<option value="+(month+i)+ ">" +(month+i)+"</option>";
			}
			$("select[name=birth_mon]").append(str);		
		}
		
		for (var i = 0; i < 31; i++) {
			var day = 1;
			var str = "";
			if (i == 0) {
				str = "<option value="+(day+i)+" selected>" +(day+i)+"</option>";
			} else {
				str = "<option value="+(day+i)+ ">" +(day+i)+"</option>";
			}
			$("select[name=birth_day]").append(str);	
		}
	}
	
	function memberSave() {
		
		if ($("#name").val() == "") {
			alert("名前をご入力してください。")
			return;
		}
		
		if ($("#email").val() == "") {
			alert("メールアドレスを入力してください。")
			return;
		}
		if (checkId == 0) {
			alert("IDチェックを行ってください。");
			return;
		}

		var emailRule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;//이메일 정규식
		 
		if(!emailRule.test($("#email").val())) {            
			alert("メールアドレスを確認してください。");
			return;
		}
		
		if ($("#password").val() == "") {
			alert("パスワードを入力してください。");
			return;
		}
		
		if ($("#passwordRe").val() == "") {
			alert("パスワードチェックを入力してください。");
			return;
		}
		
		if ($("#password").val() != $("#passwordRe").val()) {
			alert("パスワードを確認してください。")
			return;
		}
		
		var passRule = /^[A-Za-z0-9]{6,12}$/;//숫자와 문자 포함 형태의 6~12자리 이내의 암호 정규식
		 
		if(!passRule.test($("#password").val())) {
			alert("パスワードを確認してください。")
		    return;
		}
		
		if ($("#phone").val() == "") {
			alert("携帯番号を入力してください。");
			return;
		}
		var regExp = /^\d{3}-\d{3,4}-\d{4}$/;

		if(!regExp.test($("#phone").val())) {
			alert("携帯番号を確認してください。")
		    return;
		}
		
		if ($("#address").val() == "") {
			alert("住所を入力してください。")
			return;
		}
		
		
		/* json setting */
		var jsonObj = new Object();
		jsonObj.name = $("#name").val();
		jsonObj.email = $("#email").val();
		jsonObj.password = $("#password").val();
		jsonObj.phone = $("#phone").val();
		var month;
		if ($("select[name=birth_mon]").val() < 10) {
			month = "0"+$("select[name=birth_mon]").val();
		} else {
			month = $("select[name=birth_mon]").val();
		}
		
		var day;
		if ($("select[name=birth_day]").val() < 10) {
			day = "0"+$("select[name=birth_day]").val() ;
		} else {
			day = $("select[name=birth_day]").val();
		}
		
		jsonObj.birth = $("select[name=birth_year]").val() + month + day;
		jsonObj.address = $("#address").val();
		
		$.ajax({
			type : "POST",
			url : "./memberSave",
			cache : false,
			contentType : 'application/json',
			dataType : 'json',
			data : JSON.stringify(jsonObj),
			success : function(data) {
				if (data.result == "success") {
					alert("正常に処理されました。");
					getDrawSelect();
					checkId = 0;
				} else {
					alert("エラーが発生されました。システム管理者に問合せしてください。");
					checkId = 0;
				}
			},
			error : function(error) {
				alert(error);
				checkId = 0;
			}
		});
	}

	function checkMember() {
		
		var jsonObj = new Object();
		jsonObj.email = $("#email").val();
		
		$.ajax({
			type : "POST",
			url : "./idCheck",
			cache : false,
			contentType : 'application/json',
			dataType : 'json',
			data : JSON.stringify(jsonObj),
			success : function(data) {
				if (data.result == "success") {
					alert("登録可能メールアドレスです。");
					checkId = 1;
				} else {
					alert("すでに登録されている会員です。");
				}
			},
			error : function(error) {
				console.log(error);
				alert("error");
			}
		});
	}
	
</script>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div id="stylized" class="myform">
			<h1>会員登録</h1>
			<p>登録情報入力</p>

			<label>Name <span class="small">お名前</span></label>
			 <input type="text" name="mbrnm" id="name" /><br>
			 <label>Email <span class="small">メールアドレス</span> </label>
			  <input type="text" name="email" id="email" /> <input type = "button" id = "chkBtn" onclick="javascript:checkMember(); return false;" value = "中腹チェック" /> <br>
			  <label>Password <span class="small">パスワード</span> </label>
			   <input type="password" name="password" id="password" /> <br>
			   <label>Password <span class="small">パスワード</span> </label>
			   <input type="password" name="passwordRe" id="passwordRe" /> <br>
			   <label>Phone <span class="small">携帯電話番号</span> </label> 
			   <input type="text" name="phone" id="phone" /> <br>
			    <label>Birth <span class="small">お誕生日</span> </label> 
			   <!-- <input type="text" name="birth" id="birth" /> <br> -->
			   <select name="birth_year">
			   </select>
			   <select name= "birth_mon">	
			   </select>
			   <select name= "birth_day">
			   </select> <br><br><br>
			   <label>Address <span class="small">自宅を住所</span> </label> 
			   <input type="text" name="address" id="address" /><br>
			<button type="button" onclick="javascript:memberSave(); return false;">会員登録</button>
			<div class="spacer"></div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>