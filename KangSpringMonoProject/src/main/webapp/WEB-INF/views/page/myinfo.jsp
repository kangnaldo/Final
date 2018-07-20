<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/WEB-INF/views/module/mainNav.jsp"></jsp:include>
<style>
body{
	width:100%;
}
.main2 {
	background: url(/resources/img/b.jpg) left top no-repeat;
	background-size: 100% 100%;
	/* height: -webkit-fill-available; */
	width:100%;
}
.main2Sub{
	padding-top:100px;
}
.hoho{
	border:1px solid black;
	width:355px;
	height:238px;
}
.aaa{
	width: 100%;
    height: 100%;
}
#input-file{
	width:355px;
}
</style>
<script>
	$(function(){
		$("#input-file").on("change",function(event){
			var file = $("#input-file")[0].files[0];
			var formData = new FormData();
			formData.append("file", file);
			event.preventDefault(); 
			$.ajax({
		        type: "post",
		        url: 'process?${_csrf.parameterName}=${_csrf.token}',
		        data: formData,
		        dataType: "text",
		        contentType: false,
		        processData: false,
				success:function(result){
					$(".hoho").html("<img class='aaa' src='/resources/upload/"+result+"'/>");					
				}
			});
		});
	});
	
</script>
</head>
<body>
	<div class="main2">
		<div class="col-md-3">
		</div>
		
		<div class="col-md-6 main2Sub">
			<form enctype="multipart/form-data">
			<div class="col-md-6">
				<div class="hoho">
				
				</div>
				<input type="file" name="file" id="input-file"  class="btn btn-default ">
			</div>
			<div class="col-md-6">
			aaaaaaaaaaaaaaaaaa
			</div>
				
			</form>
		</div>
		<div class="col-md-3">
		</div>
	</div>
</body>
</html>