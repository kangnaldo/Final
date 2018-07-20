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
}
</style>
</head>
<body>
	<div class="main2">
		<div class="col-md-3"></div>
		<div class="col-md-6 main2Sub text-center">
			<form action="/authority/pointProcess" method="post">
				<input type='hidden' name='${_csrf.parameterName }'
							value='${_csrf.token }' />
				<table class="table table-bordered">
					<tr>
						<td><h2>충전 금액을 선택해 주세요</h2></td>
					</tr>
					<tr>
						<td><input type="radio" name="point" value="10000"> 10,000원 &nbsp;<input
							type="radio" name="point" value="50000"> 50,000원 &nbsp;<input type="radio"
							name="point" value="100000"> 100,000원 &nbsp;<input type="radio" name="point" value="1000000">
							1,000,000원 &nbsp;<input type="radio" name="point" value="10000000"> 10,000,000원
						</td>
					</tr>
					<tr>
						<td><input type="submit" value="확인" class="btn btn-success"></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="col-md-3"></div>
	</div>
</body>
</html>