<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript">
	$(function () {
		if (sessionStorage.getItem("userInfo") != "" && sessionStorage.getItem("userInfo") != null) {
			$(".jwtlogin").before('<a href="javascript:void(0);" onclick = "javascript:logout(this);" class="primary-btn top-btn logout"><i class="fa fa-ticket"></i> ログアウト</a>');
			$(".jwtlogin").hide();
			$(".memberregist").hide();
		}
	});
	
	function logout() {
		sessionStorage.removeItem("userInfo");
		location.href = "/";
	}
</script>
<body>
	<!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header Section Begin -->
    <header class="header-section">
        <div class="container">
            <div class="logo">
                <a href="/">
                    <img src="../resources/img/logo.png" alt="">
                </a>
            </div>
            <div class="nav-menu">
                <nav class="mainmenu mobile-menu">
                    <ul>
                        <li class="active"><a href="/">Home</a></li>
                        <li><a href="/product/productList">Product</a></li>
                        <li><a href="./speaker.html">Speakers</a>
                            <ul class="dropdown">
                                <li><a href="#">Jayden</a></li>
                                <li><a href="#">Sara</a></li>
                                <li><a href="#">Emma</a></li>
                                <li><a href="#">Harriet</a></li>
                            </ul>
                        </li>
                        <li><a href="./schedule.html">Schedule</a></li>
                        <li><a href="./blog.html">Blog</a></li>
                        <li><a href="./contact.html">Contacts</a></li>
                    </ul>
                </nav>
                <a href="../member/member_login" class="primary-btn top-btn jwtlogin"><i class="fa fa-ticket"></i> ログイン</a>
                <a href="../member/member_regist" class="primary-btn top-btn memberregist"><i class="fa fa-ticket"></i> 会員登録</a>
            </div>
            <div id="mobile-menu-wrap"></div>
        </div>
    </header>
    <!-- Header End -->
</body>
</html>