<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../head.jsp" />
<script type="text/javascript">

	var likeCnt = 0;

	$(function() {
		$(".nav-menu ul li").eq(1).addClass("active");
		getProductInfo();
	})
	
	function getProductInfo() {
		$.ajax({
			type : "GET",
			url : "./getProductInfo",
			data : {
				prdno : '${prdno}'
			},
			cache : false,
			contentType : 'application/json',
			dataType : 'json',
			success : function(data) {
				console.log(data.productInfo);
				var productInfo = data.productInfo;
				var optionList = "";
				likeCnt = productInfo[0].likeCnt;
				for (var i = 0; i < productInfo.length; i++) {
					$("#prdname").text(productInfo[i].prdnm);
					$("#prddesc").text(productInfo[i].prdDesc);
					optionList += "<option value = "+productInfo[i].optNm+">"+productInfo[i].optNm+"</option>";
					$("#likeBtn").text("いいね("+productInfo[i].likeCnt+")");
				}
				$("#optList").append(optionList);
			},
			error : function(error) {
				alert(error);
			}
		});
	}
	
	function upLikeCnt() {
		$.ajax({
			type : "GET",
			url : "./upProductlikeCnt",
			data : {
				prdno : '${prdno}'
			},
			cache : false,
			contentType : 'application/json',
			dataType : 'json',
			success : function(data) {
				$('#likeBtn').attr('disabled', true);
				if (data.rtnMsg == "success") {
					var cnt = data.resultLikeCnt;
					$("#likeBtn").text("いいね("+cnt+")");
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

    <!-- About Section Begin -->
    <section class="about-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="about-pic">
                        <img src="../resources/img/about-us.jpg" alt="">
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="about-text">
                        <h3 id = "prdname">The 2019 Conference</h3>
                        <p id = "prddesc">When I first got into the online advertising business, I was looking for the magical combination that would put my website into the top search engine rankings, catapult me to the forefront of the minds or individuals looking to buy my product, and generally make me rich beyond my wildest dreams! After succeeding in the business for this long, I’m able to look back on my old self with this kind of thinking and shake my head. </p>
                        <div class = "prdAvg">&#9733; &#9733; &#9733; &#9733; &#9733;</div><br>
                        <div class = "prdPrice">販売価 : 1000円(税込み)</div>
                        <div class = "prddelivceprice">配送費 : 500円</div>
                        <div class = "point">積立ポイント : 1%</div>
                        <br>
                        <div id = "selectOption">
                        オプション : 
                        <select id = "optList">
                        <!-- 
                            <li><span class="icon_check"></span> Write On Your Business Card</li>
                            <li><span class="icon_check"></span> Advertising Outdoors</li>
                            <li><span class="icon_check"></span> Effective Advertising Pointers</li>
                            <li><span class="icon_check"></span> Kook 2 Directory Add Url Free</li> -->
                        </select>
                        </div>
                        <br>
                        <div id = "sumprice">
                        	会計 : 1000円
                        </div>
                        <br>
                        <div id = "purchase">
                        	<button id = "cart">
                        		カート
                        	</button>
                        	<c:choose>
                        		<c:when test="${cookieMsg eq 'disable' }">
                        			<button id ="likeBtn" disabled>
	                        			いいね
	                        		</button>
                        		</c:when>
                        		<c:otherwise>
                        			<button id ="likeBtn" onclick="upLikeCnt();">
	                        		いいね
	                        	</button>
                        		</c:otherwise>
                        	</c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- About Section End -->

	<!-- Team Member Section Begin -->
    <section class="team-member-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2>상세정보</h2>
                        <table style = "width : 100%; border : 1px solid black;">
                        	<tr style = "border : 1px solid black;">
                        		<td width = "50%;">제품용량</td>
                        		<td width = "50%;" style = "text-align : left">20</td>
                        	</tr>
                        	<tr style = "border : 1px solid black;">
                        		<td width = "50%;">제조국가</td>
                        		<td width = "50%;" style = "text-align : left">한국</td>
                        	</tr>
                        	<tr style = "border : 1px solid black;">
                        		<td width = "50%;">사용기간</td>
                        		<td width = "50%;" style = "text-align : left">제조일로부터 3개월</td>
                        	</tr>
                        	<tr style = "border : 1px solid black;">
                        		<td width = "50%;">제품사항</td>
                        		<td width = "50%;" style = "text-align : left">모든피부</td>
                        	</tr>
                        	<tr style = "border : 1px solid black;">
                        		<td width = "50%;">주의사항</td>
                        		<td width = "50%;" style = "text-align : left">사용 후 가려움등의 증상 시 전문의 등과 상의할 것</td>
                        	</tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Team Member Section End -->

    <!-- Testimonial Section Begin -->
    <section class="testimonial-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2>配送のご案内</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                	<p>ご注文が完了した後、通常2~3日営業日以内に発送されます。</p>
                	<p>1. 配送会社</p>
                	<small>佐川急便</small>
                	<p>2. 送料</p>
                	<small>5,000円（税抜）以上、送料無料</small>
                	<small>通常配送の場合、500円（税抜）</small>
                	<small>北海道、沖縄、離島の場合、1,000円（税抜）</small>
                	<p>3. 配送希望日指定</p>
                	<small>ご注文日の5日後から1週間の範囲で希望日を選択してください。</small>
                	<p>4. 配送希望時間指定</p>
                	<small>「午前中（8時～12時）」「12時～14時」「14時～16時」「16時～18時」「18時～21時」「19時～21時」 の中から選択してください。</small>
                	<p>※注意事項</p>
                	<small>- 配送希望日の指定がない場合、最短での配送となります。</small>
                	<small>- 天候・交通事情などにより、ご希望に添えないことがあります。</small>
                	<small>- 年末年始、GWなどの長期連休期間中は、配送遅延の可能性があります。</small>
                	<small>- 北海道・沖縄・離島などの一部地域の場合、通常配送より時間がかかります。</small>
                	<p>5. 長期不在・受取拒否について</p>
                	<small>- 長期不在・受取拒否が発生した場合、今後のお取引の停止など、ご利用を制限されることがあります。</small>
                	<small>- ポストに投函された不在票がを確認し、再発送を依頼してください。</small>
                	<small>- 長期不在や受取拒否で商品が返送された場合、往復分の送料を頂戴いたします。</small>
                	
                </div>
            </div>
        </div>
    </section>
    <!-- Testimonial Section End -->

<jsp:include page="../footer.jsp" />
</body>
</html>