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
	/* height: -webkit-fill-available; */
	width: 100%;
	overflow: hidden;
}

.main2Sub {
	padding-top: 100px;
}

.en {
	position: relative;
}

.BTN {
	position: absolute;
	right: 14px;
	top: 125px;
	text-align: right;
}

td {
	background: rgba(255, 255, 255, 0.1);
}

.modal-dialog {
	padding-top: 15%;
}

#memos {
	margin-bottom: 5px;
}

#map {
	z-index: 0;
}

.acc {
	margin-bottom: 5px;
}
</style>

<script
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=aa960db744f1352b9127ac727d1ee646&libraries=services"></script>
<script>
	
	$(function() {
		var let = ${buyInfo.let};// // 주소-좌표 변환 객체를 생성합니다
		var longs = ${buyInfo.longs};
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
<script>
function abcdef(){	
		var ck = false;
		var id = {"id" : $("#id").val(), "productNo" : ${buyInfo.productNo} };
		var ckck = $("#ckck").val();
		if(ckck == "true"){
			return true;
		}
		
		$.ajax({
			type: "post",
			url: 'idcheck?${_csrf.parameterName}=${_csrf.token}',
			data: id,
		    dataType: "text",
		    async  : false, //이거 안하면 그냥 서브밋 날려줘서 동기식으로 바꿈
			success:function(result){
				if(result > 0){
					$(".add").text('이미 입찰을 하였습니다. 수정하시겠습니까 ?');
					$("#sbm").val("수정");
					$("#ckck").val("true");
					ck = true;
					$("#modalform").attr("action","/authority/tenderBuyUpdate");
				}		
			}
		});
		
		if(ck){
			return false;
		}else{
			return true;
		}
}


</script>
<script>

	
</script>
</head>

<body>

	<sec:authentication var="user" property="principal" />
	<input type="hidden" value="${user.username }" id="id" />
	<input type="hidden" id="ckck" value="false" />
	<div class="main2">
		<div class="col-md-3"></div>
		<div class="col-md-6 main2Sub text-center">
			<div class="align_wrap">
				<h2 class="en">상품 정보</h2>
				<c:if test="${buyInfo.id == user.username}">
					<div class="BTN">
						<input type="button" class="btn btn-primary" value="수정" />&nbsp;<input
							type="button" class="btn btn-danger" value="삭제" />
					</div>
				</c:if>
			</div>
			<table class="table table-bordered">

				<tr>
					<td>제목</td>
					<td colspan="3">${buyInfo.subject }</td>
				</tr>
				<tr>
					<td>구매자 ID</td>
					<td>${buyInfo.id }</td>
					<td>상품명</td>
					<td>${buyInfo.productName }</td>
				</tr>
				<tr>
					<td>카테고리</td>
					<td>${caName }</td>
					<td>마감일</td>
					<td>${buyInfo.endDate}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="3">${buyInfo.content }</td>
				</tr>
				<tr>
					<td>거래방법</td>
					<td>${buyInfo.tm }</td>
					<td>희망가격</td>
					<td>${buyInfo.price }</td>
				</tr>
				<tr>
					<td>거래 가능 장소</td>
					<td colspan="3">${buyInfo.place }</td>
				</tr>
				<tr>
					<td colspan="4">
						<div id="map" style="width: 100%; height: 350px;"></div>
					</td>
				</tr>
				<c:if test="${buyInfo.id != user.username }">
					<tr>
						<td colspan="4"><input type="button" value="입찰하기"
							class="btn btn-block btn-primary" data-toggle="modal"
							data-target="#myModal"> <!-- Modal -->
							<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<form id="modalform" action="/authority/tenderBuyInsert"
										method="post" onsubmit="return abcdef()">
										<input type='hidden' name='${_csrf.parameterName }'
											value='${_csrf.token }' /> <input type="hidden"
											name="productNo" value="${buyInfo.productNo }" />
										<!-- 상품번호 -->
										<input type="hidden" name="cano" value="${buyInfo.cano }" />

										<div class="modal-content">

											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title" id="myModalLabel">입찰 가격을 입력해
													주세요</h4>
											</div>
											<div class="modal-body">
												<input class="form-control" id="memos" name="memo"
													type="text" placeholder="간단한 메모를 작성해주세요" value="입찰합니다.">
												<div class="input-group acc">
													<span class="input-group-addon">￦</span> <input type="text"
														name="tenderPrice" class="form-control"
														placeholder="희망 가격 : ${buyInfo.price }" required>
												</div>


												<div class="add"></div>

											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">취소</button>
												<input type="submit" class="btn btn-primary" id="sbm"
													value="입찰등록">
											</div>
										</div>
									</form>
								</div>
							</div></td>
					</tr>
				</c:if>
			</table>
			<h2>입찰</h2>
			<table class="table table-bordered">
				<c:if test="${empty tender}">
					<tr>
						<td>입찰 내역이 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${!empty tender}">
					<c:forEach var="tender" items="${tender }">
						<tr>
							<td class="col-md-2">아이디</td>
							<td class="col-md-3 abcd" data-type="tenderId" id="hahahoho">${tender.id }</td>
							<td class="col-md-2">입찰가격</td>
							<td>${tender.tenderPrice }</td>

							<c:if test="${buyInfo.id == user.username}">
								<td class="col-md-1 kangtae"><a type="button"
									class="btn btn-info" data-toggle="modal"
									data-target="#${tender.id }">거래하기</a>

									<div class="modal fade" id="${tender.id }" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<form id="modalform" action="/authority/buyResult"
												method="post">
												<input type='hidden' name='${_csrf.parameterName }'
													value='${_csrf.token }' /> <input type="hidden"
													name="productNo" value="${buyInfo.productNo }" /> <input
													type="hidden" name="tenderId" value="${tender.id }" />
												<!-- 상품번호 -->
												<input type="hidden" name="cano" value="${buyInfo.cano }" />

												<div class="modal-content">

													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
														<h4 class="modal-title" id="myModalLabel">입찰자 정보 :
															아이디 [${tender.id }]</h4>
													</div>
													<div class="modal-body">
														<input class="form-control" id="memos" name="memo"
															type="text" placeholder="간단한 메모를 작성해주세요" value="입찰합니다."
															disabled="disabled">
														<div class="input-group">
															<span class="input-group-addon">￦</span> <input
																type="text" name="tenderPrice" class="form-control"
																placeholder="판매 가격 : ${tender.tenderPrice } 원"
																readonly="readonly">
														</div>
														<div class="input-group">
															<span class="input-group-addon">전화번호</span> <input
																type="text" name="tel" class="form-control" id="tel"
																value="${userm.tel }" readonly>
														</div>
														<div class="add"></div>

													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">취소</button>
														<input type="submit" class="btn btn-primary" id="sbm"
															value="수락">
													</div>
												</div>
											</form>
										</div>
									</div></td>
							</c:if>

						</tr>

					</c:forEach>
				</c:if>
			</table>
		</div>
		<div class="col-md-3"></div>
	</div>


</body>
</html>