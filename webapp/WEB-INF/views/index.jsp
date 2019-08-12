<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사관리시스템</title>

	<!-- bootstrap css -->
	<link href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- index css -->
	<link href="${pageContext.request.contextPath }/assets/css/index.css" rel="stylesheet">
	
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-xs-offset-3">
				<div class="row top">
					<div class="col-xs-5">
						<span class="top_title">IT & BIZ</span>
					</div>
					<div class="col-xs-1 col-xs-offset-4">
						<span class="top_menu">Home</span>
					</div>
					<div class="col-xs-1">
						<span class="top_menu">Input</span>
					</div>
					<div class="col-xs-1">
						<span class="top_menu">Search</span>
					</div>
				</div>
				<div class="row text-center contents">
					<span class="content_title">인사관리 시스템</span>
					<br><br>
					<span class="content_menu">인사정보를 입력하겠습니다. <a href="${pageContext.request.contextPath }/input" class="btn btn-default">입력</a></span>
					<br><br>
					<span class="content_menu">인사정보를 조회하겠습니다. <a href="${pageContext.request.contextPath }/search" class="btn btn-default">조회</a></span>
				</div>
				<div class="row text-center footer">
					<p>서울시 금천구 디지털로9길 46,306호(이엔씨드림타워7차)/ Tel. 02-6935-2288/Fax. 02-852-1848</p>
					<p>Copyright 2019. IT&BIZ.co.,LTD. All rights reserved. by kjbgo90@gmail.com</p>
				</div>
			</div>
		</div>
	</div>
	<!--jQuery -->
	<script src="${pageContext.request.contextPath }/assets/js/jquery-3.4.1.min.js"></script>
	
	<!--Bootstrap JS -->
	<script src="${pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>