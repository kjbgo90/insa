<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사관리시스템</title>

	<!-- bootstrap css -->
	<link href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- bootstrap datepicker -->
	<link href="${pageContext.request.contextPath }/assets/css/datepicker3.css" rel="stylesheet">
	
</head>

<body>
	<div class="container">
		<div class="row">
			<form class="form-horizontal">
				<div class="form-group">
					<label class="h2">직원 리스트</label>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">사번</label>
					<div class="col-xs-2">
						<input type="text" class="form-control" name="sabun">
					</div>
					<label class="col-xs-1 control-label">성명</label>
					<div class="col-xs-2">
						<input type="text" class="form-control" name="name">
					</div>
					<label class="col-xs-1 control-label">입사구분</label>
					<div class="col-xs-2">
						<select id="join-selector" class="form-control" name="join_gbn_code">
	  						<option value="00">(선택)</option>
	  						<c:forEach items="${commonMap.joinList }" var="vo" >
	  							<option value="${vo.code }">${vo.name }</option>
	  						</c:forEach>
						</select>
					</div>
					<label class="col-xs-1 control-label">투입여부</label>
					<div class="col-xs-2">
						<select class="form-control" name="put_yn">
	  						<option value="00">(선택)</option>
	  						<option value="Y">Y</option>
	  						<option value="N">N</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-1 control-label">직위</label>
					<div class="col-xs-2">
						<select id="pos-selector" class="form-control" name="pos_gbn_code">
	  						<option value="00">(선택)</option>
	  						<c:forEach items="${commonMap.posList }" var="vo" >
	  							<option value="${vo.code }">${vo.name }</option>
	  						</c:forEach>
						</select>
					</div>
					<label class="col-xs-1 control-label">입사일자</label>
					<div class="col-xs-2">
						<input type="text" class="form-control dateRangePicker" name="join_day">
					</div>
					<label class="col-xs-1 control-label">퇴사일자</label>
					<div class="col-xs-2">
						<input type="text" class="form-control dateRangePicker" name="retire_day">
					</div>
					<label class="col-xs-1 control-label">직종분류</label>
					<div class="col-xs-2">
						<select id="job-selector" class="form-control" name="job_type">
	  						<option value="00">(선택)</option>
	  						<c:forEach items="${commonMap.jobList }" var="vo" >
	  							<option value="${vo.code }">${vo.name }</option>
	  						</c:forEach>
						</select>
					</div>
				</div>
			</form>
		</div>
		<div class="row">
			<br>
			<div class="col-xs-offset-10">
				<button type="button" class="btn btn-primary" id="searchBtn">검색</button>
				<a href="${pageContext.request.contextPath }/search" class="btn btn-primary">초기화</a>
				<a href="${pageContext.request.contextPath }/index" class="btn btn-primary">이전</a>
			</div>
			<hr>
		</div>
		
		<div class="row">
			<table class="table table-bordered table-hover" style="table-layout:fixed; ">
				<thead>
					<tr>
						<th class="text-center">사번</th>
						<th class="text-center">성명</th>
						<th class="text-center">주민번호</th>
						<th class="text-center">핸드폰번호</th>
						<th class="text-center">직위</th>
						<th class="text-center">입사일자</th>
						<th class="text-center">퇴사일자</th>
						<th class="text-center">투입여부</th>
						<th class="text-center">연봉</th>
					</tr>
				</thead>
				<tbody id="insa-table-body">
					<tr>
						<td colspan="9" class="text-center">검색된 데이터가 없습니다.</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!--jQuery -->
	<script src="${pageContext.request.contextPath }/assets/js/jquery-3.4.1.min.js"></script>
	
	<!--Bootstrap JS -->
	<script src="${pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.min.js"></script>
	
	<!-- Bootstrap datepicker JS -->
	<script src="${pageContext.request.contextPath }/assets/js/bootstrap-datepicker.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/bootstrap-datepicker.kr.js"></script>
	
</body>
<script type="text/javascript">

	$('.dateRangePicker').datepicker({
		format: "yyyy-mm-dd",
		language: "kr"
	});
	
	$("#searchBtn").on("click", function(){
		var sabun = $("[name=sabun]").val();
		if("" == sabun){
			sabun = 0;
		}
		var name = $("[name=name]").val();
		var join_gbn_code = $("[name=join_gbn_code]").val();
		var put_yn = $("[name=put_yn]").val();
		var pos_gbn_code = $("[name=pos_gbn_code]").val();
		var join_day = $("[name=join_day]").val();
		var retire_day = $("[name=retire_day]").val();
		var job_type = $("[name=job_type]").val();
		
		$.ajax({
			url : "${pageContext.request.contextPath }/search/insasearch",		
			type : "post",
			data : {sabun : sabun, 
					name: name, 
					join_gbn_code: join_gbn_code, 
					put_yn: put_yn, 
					pos_gbn_code:pos_gbn_code, 
					join_day: join_day, 
					retire_day: retire_day,
					job_type:job_type},
			dataType : "json",
			success : function(srVoList){
				$("#insa-table-body").empty();
				if(srVoList.length != 0){
					for(var i = 0; i < srVoList.length; i++){
						tableRender(srVoList[i]);
					}
				}
				else{
					str = "";
					str += "<tr>";
					str += "	<td colspan='9' class='text-center'>검색된 데이터가 없습니다.</td>";
					str += "</tr>";
					$("#insa-table-body").append(str);					
				}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	});
	
	$("#insa-table-body").on("click", ".insarow", function(){
		var $this = $(this);
		var sabun = $this.data("sabun");
		
		location.replace("${pageContext.request.contextPath }/modify?sabun=" + sabun);
	});
	
	function tableRender(srVo){
		var str = "";
		
		str += "<tr data-sabun='" + srVo.sabun + "' class='insarow'>";
		str += "	<td class='text-center'>" + srVo.sabun + "</td>";
		str += "	<td class='text-center'>" + srVo.name + "</td>";
		if(srVo.reg_no != null){
			str += "<td class='text-center'>" + srVo.reg_no + "</td>";
		} else{
			str += "<td class='text-center'></td>";
		}
		if(srVo.phone != null){
			str += "<td class='text-center'>" + srVo.phone + "</td>";		
		}else{
			str += "<td class='text-center'></td>";
		}
		if(srVo.pos_name != null){
			str += "<td class='text-center'>" + srVo.pos_name + "</td>";
		}else{
			str += "<td class='text-center'></td>";
		}
		if(srVo.join_day != null){
			str += "<td class='text-center'>" + srVo.join_day + "</td>";
		}else{
			str += "<td class='text-center'></td>";
		}
		if(srVo.retire_day != null){
			str += "<td class='text-center'>" + srVo.retire_day + "</td>";
		}else{
			str += "<td class='text-center'></td>";
		}
		if(srVo.put_yn != '00'){
			str += "<td class='text-center'>" + srVo.put_yn + "</td>";
		}else{
			str += "<td class='text-center'></td>";
		}
		if(srVo.salary != 0){
			str += "<td class='text-center'>" + srVo.salary + "</td>";
		}else{
			str += "<td class='text-center'></td>";
		}
		str += "</tr>";
		
		$("#insa-table-body").append(str);
	}
</script>
</html>