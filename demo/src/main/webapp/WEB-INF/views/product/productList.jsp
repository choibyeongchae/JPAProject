<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../head.jsp" />
<script type="text/javascript">
	$(function(){
		var pageNum = '${pageNum}';
		$(".nav-menu ul li").eq(1).addClass("active");
		getList(pageNum);
		getBannerList();
	})
	
	function getList(pageNum) {
		$.ajax({
			type : "GET",
			url : "./getProductList",
			data : {
				"pageNum" : pageNum
			},
			cache : false,
			contentType : 'application/json',
			dataType : 'json',
			success : function(data) {
				var list = data.content;
				var pages = data.totalPages;
				for (var i = 0; i < list.length; i++) {
					var listHtml = "<div class='col-lg-4 col-md-6 mb-4'>";
					var imgUrl = list[i].prdImgurl +"/" +list[i].prdImgnm;
					listHtml += "<div class='card h-100'>";
					listHtml += "	<a href='/product/productDetail?prdno="+list[i].prdno+"'><img class='card-img-top' src='.."+imgUrl+"' height = '200px' alt=''></a>";
					listHtml += "	<div class='card-body'>";
					listHtml += "		<h4 class='card-title'>";
					if (list[i].newYn == "Y") {
						listHtml += "		<a href='/product/productDetail?prdno="+list[i].prdno+"'>"+ list[i].prdnm +"<span class = 'new'>NEW</span></a>";
					} else {
						listHtml += "		<a href='/product/productDetail?prdno="+list[i].prdno+"'>"+ list[i].prdnm +"</a>";
					}
					listHtml += "		<h5>"+list[i].prdPrice+"</h5>";
					listHtml += "		<p class='card-text'>"+list[i].prdDesc+"</p>";
					listHtml += "	</div>";
					listHtml += "	<div class='card-footer'>";
					if (list[i].prdAvg == 5) {
						listHtml += "		<small class='text-muted'>&#9733; &#9733; &#9733; &#9733; &#9733;</small>";
					} else if (list[i].prdAvg == 4) {
						listHtml += "		<small class='text-muted'>&#9733; &#9733; &#9733; &#9733; &#9734;</small>";
					} else if (list[i].prdAvg == 3) {
						listHtml += "		<small class='text-muted'>&#9733; &#9733; &#9733; &#9734; &#9734;</small>";
					} else if (list[i].prdAvg == 2) {
						listHtml += "		<small class='text-muted'>&#9733; &#9733; &#9734; &#9734; &#9734;</small>";
					} else if (list[i].prdAvg == 1) {
						listHtml += "		<small class='text-muted'>&#9733; &#9734; &#9734; &#9734; &#9734;</small>";
					} else {
						listHtml += "		<small class='text-muted'>&#9734; &#9734; &#9734; &#9734; &#9734;</small>";
					}
					listHtml += "	</div>";
					listHtml += "</div>";
					listHtml += "</div>";
					
					
					$(".row").eq(1).append(listHtml);
				}
				
				goPaging(pageNum,5,"product/productList",pages,".page",'page-item');
			},
			error : function(error) {
				alert(error);
			}
		});
	}
	
	function getBannerList() {
		$.ajax({
			type : "GET",
			url : "./getProductBannerList",
			cache : false,
			contentType : 'application/json',
			dataType : 'json',
			success : function(data) {
				
				var bannerList = '<ol class="carousel-indicators">';
				bannerList += '	<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>';
				bannerList += '	<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>';
				bannerList += '	<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>';
				bannerList += '</ol>';
				bannerList += '<div class="carousel-inner" role="listbox">';
				for (var i = 0; i < data.length; i++) {
					var imgUrl = data[i].prdImgurl +"/" +data[i].prdImgnm;
					if (i == 0) {
						bannerList += '	<div class="carousel-item active">';
						bannerList += '		<img class="d-block img-fluid" src="'+imgUrl+'" alt="">';
						bannerList += '	</div>';
					} else {
						bannerList += '	<div class="carousel-item">';
						bannerList += '		<img class="d-block img-fluid" src="'+imgUrl+'" alt="">';
						bannerList += '	</div>';
					}
				}
				bannerList += '</div>';
				bannerList += '<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">';
				bannerList += '	<span class="carousel-control-prev-icon" aria-hidden="true"></span>';
				bannerList += '	<span class="sr-only">Previous</span>';
				bannerList += '</a>';
				bannerList += '<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">';
				bannerList += '	<span class="carousel-control-next-icon" aria-hidden="true"></span>';
				bannerList += '	<span class="sr-only">Next</span>';
				bannerList += '</a>';
					
				$("#carouselExampleIndicators").append(bannerList);
			},
			error : function(error) {
				alert(error);
			}
		});
	}
	
	function goSearch(pageNum) {
		var keyword = $("#keyword").val();
		
		if (keyword == "" || keyword == null) {
			alert("キーワードを入力してください。");
			return;
		}
		
		$.ajax({
			type : "GET",
			url : "./getSearchList",
			data : {
				"keyword" : escape(keyword),
				"pageNum" : pageNum
			},
			cache : false,
			contentType : 'application/json',
			dataType : 'json',
			success : function(data) {
				var list = data.content;
				var pages = data.totalPages;
				$(".row").eq(1).empty();
				for (var i = 0; i < list.length; i++) {
					var listHtml = "<div class='col-lg-4 col-md-6 mb-4'>";
					var imgUrl = list[i].prdImgurl +"/" +list[i].prdImgnm;
					listHtml += "<div class='card h-100'>";
					listHtml += "	<a href='/product/productDetail?prdno="+list[i].prdno+"'><img class='card-img-top' src='.."+imgUrl+"' height = '200px' alt=''></a>";
					listHtml += "	<div class='card-body'>";
					listHtml += "		<h4 class='card-title'>";
					if (list[i].newYn == "Y") {
						listHtml += "		<a href='/product/productDetail?prdno="+list[i].prdno+"'>"+ list[i].prdnm +"<span class = 'new'>NEW</span></a>";
					} else {
						listHtml += "		<a href='/product/productDetail?prdno="+list[i].prdno+"'>"+ list[i].prdnm +"</a>";
					}
					listHtml += "		<h5>"+list[i].prdPrice+"</h5>";
					listHtml += "		<p class='card-text'>"+list[i].prdDesc+"</p>";
					listHtml += "	</div>";
					listHtml += "	<div class='card-footer'>";
					if (list[i].prdAvg == 5) {
						listHtml += "		<small class='text-muted'>&#9733; &#9733; &#9733; &#9733; &#9733;</small>";
					} else if (list[i].prdAvg == 4) {
						listHtml += "		<small class='text-muted'>&#9733; &#9733; &#9733; &#9733; &#9734;</small>";
					} else if (list[i].prdAvg == 3) {
						listHtml += "		<small class='text-muted'>&#9733; &#9733; &#9733; &#9734; &#9734;</small>";
					} else if (list[i].prdAvg == 2) {
						listHtml += "		<small class='text-muted'>&#9733; &#9733; &#9734; &#9734; &#9734;</small>";
					} else if (list[i].prdAvg == 1) {
						listHtml += "		<small class='text-muted'>&#9733; &#9734; &#9734; &#9734; &#9734;</small>";
					} else {
						listHtml += "		<small class='text-muted'>&#9734; &#9734; &#9734; &#9734; &#9734;</small>";
					}
					listHtml += "	</div>";
					listHtml += "</div>";
					listHtml += "</div>";
					
					$(".row").eq(1).append(listHtml);
				}
				
				goPaging(pageNum,5,"product/getSearchList",pages,".page",'page-item');
			}
		});
		
	}
	
</script>
</head>
<body>
<jsp:include page="../header.jsp" />

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">

        <h1 class="my-4">Shop Name</h1>
        <div class="list-group">
          <a href="#" class="list-group-item">Category 1</a>
          <a href="#" class="list-group-item">Category 2</a>
          <a href="#" class="list-group-item">Category 3</a>
        </div>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">
		
		<div id = "search">
			商品を探す<input type = "text" id = "keyword" />
			<button id = "searchBtn" onclick="goSearch(1)">検索</button>
		</div>
		
        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
        
        </div>

        <div class="row">

        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->
	<div class = 'page'>
		<ul class = 'pagination'>
		</ul>
	</div>
  </div>
  <!-- /.container -->

<jsp:include page="../footer.jsp" />
</body>
</html>