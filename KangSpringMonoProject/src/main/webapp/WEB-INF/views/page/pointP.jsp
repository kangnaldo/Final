<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/WEB-INF/views/module/mainNav.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<title>Insert title here</title>
<style>
.main2 {
	background: url(/resources/img/b.jpg) left top no-repeat;
	background-size: 100% 100%;
	height: -webkit-fill-available;
	width: 100%;
	/* overflow: hidden; */
}

.main2Sub {
	padding-top: 270px;
}

td {
	background: rgba(255, 255, 255, 0.1);
	color: floralwhite;
}
</style>
<%
	response.setHeader("Refresh", "3;URL=/");
%>  
</head>
<body>
	<div class="main2">
		<div class="col-md-3"></div>
		<div class="col-md-6 main2Sub text-center">
		<table class="table table-bordered">
			<tr>
				<td><h2>OK!!!! 충전완료!!!!!<br> 3초후 홈으로 이동합니다.</h2><br><input type="button" onclick="javascript:location.href='/'" class="btn btn-primary" value="바로이동"></td>
			</tr>
		</table>
		
		</div>
		<div class="col-md-3"></div>
	</div>
</body>
</html>
