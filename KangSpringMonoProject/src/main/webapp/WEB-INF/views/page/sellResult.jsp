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
<script
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=aa960db744f1352b9127ac727d1ee646&libraries=services"></script>
<script>
	
	$(function() {
		var let = ${bean.let};// // 주소-좌표 변환 객체를 생성합니다
		var longs = ${bean.longs};
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center : new daum.maps.LatLng(let, longs), //지도의 중심좌표.
			level : 3
		//지도의 레벨(확대, 축소 정도)
		};

		var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴

		// 지도를 클릭한 위치에 표출할 마커입니다
		var marker = new daum.maps.Marker({
			// 지도 중심좌표에 마커를 생성합니다 
			position : map.getCenter()
		});
		var infowindow = new daum.maps.InfoWindow({
			zindex : 1
		});
		// 지도에 마커를 표시합니다
		marker.setMap(map);
		var latlng;
		
		
	});
	

	
</script>
<style>
.main2 {
	background: url(/resources/img/b.jpg) left top no-repeat;
	background-size: 100% 100%;
	/* height: -webkit-fill-available; */
	width: 100%;
	overflow: hidden;
}

.main2Sub {
	padding-top: 100px;
}

td {
	background: rgba(255, 255, 255, 0.1);
}
.modal-content {
	margin-top: 280px;
}
</style>
</head>
<body>
	<div class="main2">
		<div class="col-md-3"></div>
		<div class="col-md-6 main2Sub text-center">
			<h2>거래를 진행해 주세요</h2>
			<table class="table">
				<tr>
					<td>거래 물품</td>
					<td>${bean.productName }</td>
				</tr>
				<tr>
					<td>거래 가격</td>
					<td>${ bean2.tenderPrice }</td>
				</tr>
				<tr>
					<td>거래 방법</td>
					<td>${ bean.tm }</td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>${ bean2.tel }</td>
				</tr>
				<tr>
					<td colspan="2">
						<div id="map" style="width: 100%; height: 350px;"></div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="거래 완료" class="btn btn-primary btn-block" data-toggle="modal"
						data-target="#modal"/>
						<div class="modal fade" id="modal" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<form id="modalform" action="/authority/sellResultOk"
									method="post">
									<input type='hidden' name='${_csrf.parameterName }'
										value='${_csrf.token }' /> 
									<input type="hidden" name="sellProductNo" value="${ bean.sellProductNo }" />
									<div class="modal-content">

										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="myModalLabel">정말 거래를
												완료하시겠습니까?</h4>
										</div>
										<div class="modal-body text-center">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">취소</button>
											<input type="submit" class="btn btn-primary" id="sbm"
												value="완료">

										</div>

									</div>
								</form>
							</div>
						</div>
						
					</td>
				</tr>
				<tr>
					<td  colspan="2">
						<input type="button" onclick=""  value="거래 취소" class="btn btn-danger btn-block" data-toggle="modal"
						data-target="#modal2"/>
						<div class="modal fade" id="modal2" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<form id="modalform" action="/authority/sellResult"
									method="post">
									<input type='hidden' name='${_csrf.parameterName }'
										value='${_csrf.token }' /> 

									<div class="modal-content">

										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="myModalLabel">거래를 취소하시겠습니까?</h4>
										</div>
										<div class="modal-body text-center">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">취소</button>
											<input type="submit" class="btn btn-primary" id="sbm"
												value="취소">

										</div>

									</div>
								</form>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div class="col-md-3"></div>
	</div>
</body>
</html>