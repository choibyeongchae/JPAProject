<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript">
	$(function(){

		$("#boardNum").click(function(){
			search();
		})
		$("#boardWrite").click(function(){
			searchWriter();
		})
	})
	
	function searchWriter() {
		var boardWriter = $("#boardWriteSearch").val();
		var data = {
				"boardWriter" : boardWriter
		};
		
		$.ajax({
			type : "GET",
			url : "/board/getWriter",
			contentType: "application/json",
		    data : data,
			cache : false,
			success : function(data) {
				
				for (var i = 0; i < data.length; i++) {
					console.log(data[i].boardNum);
				}
				
				console.log(data);
			},
			error : function(err) {
				alert(err);
			}
		});
	}
	
	function search(){
		
		var boardNum = $("#boardNumSearch").val();
		var data = {
				"boardNum" : boardNum
		};
		
		$.ajax({
			type : "GET",
			url : "/board/getDetail",
			contentType: "application/json",
		    data : data,
			cache : false,
			success : function(data) {
				console.log(data.boardNum);
			},
			error : function(err) {
				alert(err);
			}
		});
	}
</script>
</head>
<body>
	<input type="text" value ="" id = "boardNumSearch">
	<button id = "boardNum">검색</button>
	<input type="text" value = "" id = "boardWriteSearch">
	<button id = "boardWrite">검색</button>
</body>
</html>