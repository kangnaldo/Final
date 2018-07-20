<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/WEB-INF/views/module/mainNav.jsp"></jsp:include>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=aa960db744f1352b9127ac727d1ee646&libraries=services"></script>
<script>
	var geocoder = new daum.maps.services.Geocoder();// // 주소-좌표 변환 객체를 생성합니다
	$(function() {
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center : new daum.maps.LatLng(37.50436375510194, 126.87744332374989), //지도의 중심좌표.
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

		// 지도에 클릭 이벤트를 등록합니다
		// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
		daum.maps.event
				.addListener(
						map,
						'click',
						function(mouseEvent) {

							// 클릭한 위도, 경도 정보를 가져옵니다 
							latlng = mouseEvent.latLng;
							searchDetailAddrFromCoords(
									mouseEvent.latLng,
									function(result, status) {
										if (status === daum.maps.services.Status.OK) {
											var detailAddr = '<div>지번 주소 : '
													+ result[0].address.address_name
													+ '</div>';

											var content = '<div class="bAddr">'
													+ detailAddr + '</div>';
											marker.setPosition(latlng);
											marker.setMap(map);
											$("#aa")
													.val(
															result[0].address.address_name);
											infowindow.setContent(content);
											infowindow.open(map, marker);
										}
										var a = map.getLevel();
										// 마커 위치를 클릭한 위치로 옮깁니다

										$("#let").val(latlng.getLat());
										$("#longs").val(latlng.getLng());
										$("#level").val(a);
										/*   var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
										  message += '경도는 ' + latlng.getLng() + ' 입니다';
										  var resultDiv = document.getElementById('clickLatlng'); 
										  resultDiv.innerHTML = message; */
									});
						});
	});
	function searchAddrFromCoords(coords, callback) {
		// 좌표로 행정동 주소 정보를 요청합니다
		geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);
	}

	function searchDetailAddrFromCoords(coords, callback) {
		// 좌표로 법정동 상세 주소 정보를 요청합니다
		geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
	}
</script>
<title>Insert title here</title>
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
td{
	background: rgba(255,255,255,0.1);
	
}
</style>
</head>
<body>
	<sec:authentication var="user" property="principal" />
	<div class="main2">
		<div class="col-md-3">${user.username }님!</div>

		<div class="col-md-6 main2Sub text-center">
			<form action="/authority/buyinsert" method="post">
				<input type='hidden' name='${_csrf.parameterName }'
					value='${_csrf.token }' /> <input type="hidden" id="let"
					name="let"> <input type="hidden" id="longs" name="longs">
				<input type="hidden" id="level" name="level">
				<h2>구매 등록</h2>
				<table class="table table-bordered">
					<tr>
						<td><label class="control-label">제목</label></td>
						<td><input class="form-control" type="text" name="subject"></td>
					</tr>
					<tr>
						<td><label>내용</label></td>
						<td><textarea class="form-control" name="content" rows="5"></textarea></td>
					</tr>
					<tr>
						<td><label>상품명</label></td>
						<td><input class="form-control" type="text"
							name="productName"></td>
					</tr>
					<tr>
						<td><label>구입희망 가격</label></td>
						<td><input class="form-control" type="text"
							name="price">
						</td>
					</tr>
					<tr>
						<td><label>카테고리</label></td>
						<td><select name="cano" class="form-control">
								<option value="1">여성의류/잡화</option>
								<option value="2">남성의류/잡화</option>
								<option value="3">전자제품/컴퓨터/휴대폰</option>
								<option value="4">도서</option>
								<option value="5">생활용품</option>
						</select></td>
					</tr>
					<tr>
						<td><label>구매기한</label></td>
						<td><input class="form-control" type="date" name="endDate"></td>
					</tr>
					<tr>
						<td><label>거래방식</label></td>
						<td><select name="tm" class="form-control">
								<option value="직거래">직거래</option>
								<option value="택배거래">택배거래</option>
						</select></td>
					</tr>
					<tr>
						<td><label>구매가능<br>장소
						</label></td>
						<td><input type="text" id="aa" name="place"
							class="form-control" /><br>
						<div id="map" style="width: 100%; height: 350px;"></div></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="등록하기"
							class="btn btn-primary">&nbsp;<input type="reset"
							value="취소" class="btn btn-danger"></td>
					</tr>
				</table>

			</form>
		</div>
		<div class="col-md-3"></div>
	</div>
</body>
</html>