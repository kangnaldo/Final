<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page import="java.util.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<jsp:include page="/WEB-INF/views/module/mainNav.jsp"></jsp:include>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=aa960db744f1352b9127ac727d1ee646&libraries=services,clusterer"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<%-- <sec:authentication var="user" property="principal"/> --%>
<style>
.main1 {
	background-image: url(/resources/img/1.gif);
	background-size: contain;
	height: -webkit-fill-available;
	background-position-x: 120px;
}

.main1Sub {
	height: -webkit-fill-available;
	background: rgba(0, 0, 0, 0.6);
}

.main1Sub2 {
	text-align: center;
	padding-top: 20%;
	font-size: 50px;
}

.main2 {
	background-image: url(/resources/img/2.gif);
	background-size: contain;
	height: -webkit-fill-available;
	background-position-x: 120px;
}

.main2Sub {
	height: -webkit-fill-available;
	background: rgba(0, 0, 0, 0.8);
}

.main2Sub2 {
	text-align: center;
	padding-top: 20%;
}

.subject {
	font-size: 50px;
}

.glyphicon-user:before {
	content: "\e008";
	font-size: 40px;
}

.pencil {
	font-size: 40px;
}

.main3 {
	background-image: url(/resources/img/3.gif);
	background-size: cover;
	height: -webkit-fill-available;
	/* background-position-x: 140px; */
}

.main3Sub {
	text-align: center;
	height: -webkit-fill-available;
	background: rgba(0, 0, 0, 0.8);
	height: -webkit-fill-available;
}

.mainSub2 {
	padding-top: 150px;
}

.subject {
	color: white;
}

.loginTable {
	color: white;
}

.table>tbody>tr>td {
	background: rgba(0, 0, 0, 0.7);
}

.td1 {
	padding-top: 13px !important;
}

.td2 {
	padding-top: 13px !important;
	color: white;
}

.addr1 {
	padding-right: 0px !important;
	padding-left: 0px !important;
}

.marginb1 {
	margin-bottom: 6px;
}
#map{
     z-index: 0;
}
</style>

<!-- <script>
	
	$(function() {
		
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center : new daum.maps.LatLng(37.50436375510194, 126.87744332374989), //지도의 중심좌표.
			level : 3
		//지도의 레벨(확대, 축소 정도)
		};

		var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴

		var geocoder = new daum.maps.services.Geocoder();
		
		var coords;
		var marker = [];
		 var bean = [];
		alert(${buyBean.size()});
		for(var i = 0 ; i < ${buyBean.size()}; i++){
			bean[i] = ${buyBean.get(i)}
		} 
		alert(bean[0].getLat()); 
 		var a = ${buyBean}
	 $.each(a, function(index, value) {
			alert(value.place);
			geocoder.addr2coord(value.place, function(status, result) {
				if (status === daum.maps.services.Status.OK) {
					coords = new daum.maps.LatLng(result.lat, result.lng);
					marker = new daum.maps.Marker({
						map : map,
						position : coords
					});
				}
			}
		});  
		
		
	});
	

	
</script>  -->
<script>
$(function() {
	$("#homelogin").click(function() {
		var section2 = $("#section2").offset();
		$('html,body').animate({
			scrollTop : section2.top
		}, 500);
	});
	$("#homeRg").click(function() {
		var section2 = $("#section3").offset();
		$('html,body').animate({
			scrollTop : section2.top
		}, 500);
	});
});
</script>
</head>

<body>
	<sec:authentication var="user" property="principal"/>
	<sec:authorize access="hasRole('ROLE_USER')">
		<div id="section1" class="main1 maps">
			<div id="map" class="main1Sub">
				<div class="main1Sub2">
					<span class="glyphicon glyphicon-heart subjectimg"
						style="color: forestgreen;" aria-hidden="true"></span>&nbsp;<label
						class="subject">안녕하세요 ${user.username } 님!</label>
				<!-- 	<p>
						<input type="button" class="btn btn-lg btn-primary"
							id="loginateg2" value="로그인"> <input type="button"
							class="btn btn-lg btn-success" id="loginateg3" value="회원가입">
					</p> -->
				</div>
			</div>

		</div>
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<div id="section1" class="main1">
			<div class="main1Sub">
				<div class="main1Sub2">
					<span class="glyphicon glyphicon-leaf subjectimg"
						style="color: forestgreen;" aria-hidden="true"></span>&nbsp;<label
						class="subject">로그인을 해야 중고시장의 기능을 사용할 수 있습니다.</label>
					<p>
						<input type="button" class="btn btn-lg btn-primary"
							id="homelogin" value="로그인"> <input type="button"
							class="btn btn-lg btn-success" id="homeRg" value="회원가입">
					</p>
				</div>
			</div>

		</div>
		<div id="section2" class="main2">
			<div class="main2Sub">
				<div class="col-md-4"></div>
				<div class="main2Sub2 col-md-4">
					<span class="glyphicon glyphicon-user" style="color: #587ca2e0;"
						aria-hidden="true"></span>&nbsp;<label class="subject">로그인</label>
					<p style="color: red">${error }</p>
					<form action="/login" method="post">
						<input type='hidden' name='${_csrf.parameterName }'
							value='${_csrf.token }' />
						<table class="table loginTable table-bordered">

							<tr>
								<td class="td1"><label for="id" class="control-label">아이디</label></td>
								<td><input id="id" name="id" class="form-control"
									type="text" placeholder="아이디를 입력해 주세요"></td>
							</tr>
							<tr>
								<td class="td1"><label for="password" class="control-label">비밀번호</label></td>
								<td><input id="password" name="password"
									class="form-control" placeholder="비밀번호를 입력해 주세요" type="text"></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit"
									class="btn btn-primary" value="로그인" /> <input type="reset"
									class="btn btn-success" value="취소" /></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
		<div id="section3" class="main3">
			<div class="main3Sub">
				<div class="col-md-4"></div>
				<div class="col-md-4 mainSub2">
					<span class="glyphicon glyphicon-pencil pencil"
						style="color: #587ca2e0;" aria-hidden="true"></span>&nbsp;<label
						class="subject">회원가입</label>
					<form action="/register" method="post">
					<input type='hidden' name='${_csrf.parameterName }'
							value='${_csrf.token }' />
						<table class="table table-bordered">
							<tr>
								<td class="td2"><label for="id" class="control-label">아이디</label></td>
								<td><input type="text" id="id" name="id"
									class="form-control" placeholder="아이디를 입력 해 주세요"></td>
							</tr>
							<tr>
								<td class="td2"><label for="password" class="control-label">비밀번호</label></td>
								<td><input type="password" id="password" name="password"
									class="form-control" placeholder="비밀번호를 입력해 주세요"></td>
							</tr>
							<tr>
								<td class="td2"><label for="password2"
									class="control-label">비밀번호 확인</label></td>
								<td><input type="password" id="password2" name="password2"
									class="form-control" placeholder="위와 같은 비밀번호를 입력해 주세요"></td>
							</tr>
							<tr>
								<td class="td2"><label for="name" class="control-label">이름</label></td>
								<td><input type="text" id="name" name="name"
									class="form-control" placeholder="이름을 입력해 주세요"></td>
							</tr>
							<tr>
								<td class="td2"><label for="addr1" class="control-label">주소</label></td>
								<td>
									<div class="rows">
										<div class="col-md-8 addr1">
											<input type="text" id="addr1" name="addr1"
												class="form-control marginb1" placeholder="주소를 입력해 주세요">
										</div>
										<input type="button" class="btn btn-success" value="주소 검색" />
									</div> <input type="text" id="addr2" name="addr2"
									class="form-control marginb1" placeholder="주소를 입력해 주세요">
									<input type="text" id="addr3" name="addr3" class="form-control"
									placeholder="주소를 입력해 주세요">
								</td>
							</tr>
							<tr>
								<td class="td2"><label for="tel" class="control-label">전화번호</label></td>
								<td><input type="text" id="tel" name="tel"
									class="form-control" placeholder="전화번호를 입력해 주세요"></td>
							</tr>
							<tr class="text-center">
								<td colspan="2"><input type="submit"
									class="btn btn-primary" value="등록">&nbsp;<input
									type="reset" class="btn btn-success" value="다시쓰기"></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
	</sec:authorize>
</body>
</html>
