<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!-- <link rel="stylesheet" href="css/main.css"> -->
<title>Insert title here</title>
<style>
.mainTop {
	background: rgba(0, 0, 0, 0.6);
	position: relative;
	z-index: 1;
}

.navbar-right {
	margin-right: 0px;
}

#nav {
	height: 70px;
	background: rgba(0, 0, 0, 0.8);
	color: aqua;
}

#innav {
	margin-top: 10px;
	font-size: 20px;
}

.navbar-default .navbar-nav>li>a {
	color: snow;
}

.usern {
	margin-left: 400px;
	padding-top: 12px;
	margin-top: 0px;
}
</style>

<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}

	$(function() {
		$("#loginateg1").click(function() {
			var section2 = $("#section1").offset();
			$('html,body').animate({
				scrollTop : section2.top
			}, 500);
		});
		$("#loginateg2").click(function() {
			var section2 = $("#section2").offset();
			$('html,body').animate({
				scrollTop : section2.top
			}, 500);
		});
		$("#loginateg3").click(function() {
			var section2 = $("#section3").offset();
			$('html,body').animate({
				scrollTop : section2.top
			}, 500);
		});
	});
</script>
</head>
<body>
	<sec:authentication var="user" property="principal" />
	<c:url var="logoutUrl" value="/logout" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<div class="mainTop">
		<nav id="nav" class="navbar navbar-default navbar-fixed-top">
			<div id="innav" class="container-fluid collapse navbar-collapse">

				<div class="navbar-header textHeader">
					<p class="navbar-text" style="color: dodgerblue;">
						<strong>&nbsp;강태욱의 중고시장</strong>

					</p>
				</div>
				<sec:authorize access="hasRole('ROLE_USER')">
					<div class="navbar-text usern">안녕하세요 ${user.username } 님!</div>
				</sec:authorize>

				<ul class="nav1 nav navbar-nav navbar-right ">
					<sec:authorize access="isAnonymous()">
						<li ><a href="#" id="loginateg1">홈</a></li>
						<li ><a href="#" id="loginateg2">로그인</a></li>
						<li ><a href="#" id="loginateg3">회원가입</a></li>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_USER')">
						<li><a href="/">홈</a></li>
						<li class="dropdown"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown" role="button"
							aria-expanded="false">내정보<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="/authority/myinfo">개인정보</a></li>
								<li class="divider"></li>
								<li><a href="/authority/mybuylist">나의 구매 등록 물건</a></li>
								<li><a href="/authority/myselllist">나의 판매 등록 물건</a></li>
								<li class="divider"></li>
								<li><a href="/authority/myTenders">입찰한 물건</a></li>
							</ul>
						</li>
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
							aria-expanded="false" id="loginateg2">장터게시판<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="/authority/buy">구매</a></li>
								<li><a href="/authority/sell">판매</a></li>
											<li><a href="/authority/buyhagi">구매 임시</a></li>
											<li><a href="/authority/sellhagi">판매 임시</a></li>
							</ul>
						</li>
						<li><a href="/authority/point" id="loginateg2">포인트 충전</a></li>
						<li><a href="javascript:formSubmit()">로그아웃</a></li>
					</sec:authorize>

				</ul>
			</div>
		</nav>
	</div>
</body>
</html>