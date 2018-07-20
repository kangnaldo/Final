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
}

.main2Sub {
	padding-top: 100px;
}
th{
	text-align:center;
}
td{
	background: rgba(255,255,255,0.1);
}
</style>
</head>
<body>

	<div class="main2">
		<div class="col-md-2"></div>

		<div class="col-md-8 main2Sub text-center">
			<h2>판매</h2>
			<table class="table">
				<tr>
					<th>ID</th>
					<th>상품명</th>
					<th>구매기한</th>
					<th>제목</th>
					<th>거래방법</th>
					<th>완료여부</th>
				</tr>
				<c:if test="${productCount == 0}">
					<tr>
						<td colspan="6">등록 물건 없음</td>
					</tr>
				</c:if>
				<c:if test="${productCount > 0}">
					<c:forEach var="list" items="${productSellList }">
						<tr>
							<td>${list.id }</td>
							<td>${list.productName }</td>
							<td>${list.endDate }</td>
							<c:if test="${list.complete == '거래중'}">
								<td>${list.subject }</td>
							</c:if>
							<c:if test="${list.complete == '거래대기'}">
							<td><a
								href="/authority/productSellInfo?sellProductNo=${list.sellProductNo }&cano=${list.cano}">${list.subject }</a></td>
							</c:if>
							<td>${list.tm }</td>
							<td>${list.complete }</td>
						</tr>
					</c:forEach>
				</c:if>
				<tr>
					<td colspan="6">
						<c:if test="${productCount > 0}">
							<c:if test="${startPg > pageGroup}">
								<a href="buy?pageNum=${startPg - pageGroup}">[이전]</a>
							</c:if>
							<c:forEach var="i" begin="${ startPg }" end="${ endPg }">
								<c:if test="${ i == pageNum }">
												[${  i  }]
											</c:if>
								<c:if test="${ i != pageNum }">
									<a href="buy?pageNum=${i }">[${i }]</a>
								</c:if>
							</c:forEach>
							<c:if test="${endPg < listPg}">
								<a href="buy?pageNum=${startPg + pageGroup}">[다음]</a>
							</c:if>
						</c:if>
					</td>
				</tr>
			</table>
		</div>
		<div class="col-md-2"></div>
	</div>
</body>
</html>