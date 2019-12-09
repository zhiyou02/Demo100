<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0052)http://localhost:8080/Voids/controller/courseShow.do -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<!--<base href="http://localhost:8080/Voids/">--><base href=".">
		
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>智游教育</title>
		
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}/js/jquery-1.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/confirm.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/message_cn.js"></script>

		<style type="text/css">
		th {
			text-align: center;
		}
		</style>
	</head>

	<body>
<nav class="navbar-inverse">
	<div class="container">
		
		<div class="navbar-header">
			<a class="navbar-brand">视频管理系统</a>
		</div>

		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
			<ul class="nav navbar-nav">
				<li class="active"><a href="VideoSelect">视频管理</a></li>
				<li><a href="SpeakerSelect">主讲人管理</a></li>
				<li><a href="selectAll">课程管理</a></li>
			</ul>
			<p class="navbar-text navbar-right">
				<span>${admin.accounts }</span> <i class="glyphicon glyphicon-log-in" aria-hidden="true"></i>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.jsp" class="navbar-link">退出</a>
			</p>
		</div>
		<!-- /.navbar-collapse -->


	</div>
	<!-- /.container-fluid -->
</nav>

	
	
		
	
    
    <div class="jumbotron" style="padding-top: 15px;padding-bottom: 15px;">
	  <div class="container">
	          <h2>课程管理</h2>
	  </div>
	</div>
	
	<div class="container">
	    <button onclick="showAddPage()" type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		      添加
		</button>
		
		<button onclick="deleteAll()" type="submit" id="btn" class="btn btn-info dropdown-toggle">
		      批量删除
		</button>
	</div>
	<div class="container">
		<form action="VideoSelect">
			<input class="btn btn-info dropdown-toggle" type="text" name="title" placeholder="输入你要查询的讲师的姓名">
			<input class="btn btn-info dropdown-toggle" type="submit" value="搜索">
		</form>
	</div>
	<div class="container" style="margin-top: 20px;">
		
		<table class="table table-bordered table-hover" style="text-align: center;table-layout:fixed;">
      <thead>
        <tr class="active">
          <th><input type="checkbox" onchange="a()" id="all"></th>
          <th>序号</th>
          <th style="width:20%">名称</th>
          <th style="width:30%">简介</th>
          <th>播放次数</th>
          <th>讲师名字</th>
          <th>观看次数</th>
          <th>编辑</th>
          <th>删除</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${list}" var="list">
        <tr>
          <td><input type="checkbox" name="c" value="${list.video_id}"></td>
          <td>${list.video_id}</td>
          <td>${list.title }</td>
          <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${list.detail}</td>
          <td>${list.time }</td>
          <c:choose>
				<c:when test="${list.speaker_id==7}">
					<td>赵桂丹</td>
				</c:when>	
				<c:when test="${list.speaker_id==8}">
					<td>张强</td>				
				</c:when>	
				<c:when test="${list.speaker_id==9}">
					<td>田园惠子</td>
				</c:when>	
				<c:when test="${list.speaker_id==10}">
					<td>邢志勇</td>
				</c:when> 
				<c:when test="${list.speaker_id==11}">
					<td>宋伟</td>
				</c:when> 
				<c:when test="${list.speaker_id==15}">
					<td>孙航</td>
				</c:when>
				<c:otherwise>
					<td></td>
				</c:otherwise>
			</c:choose>
          <td>${list.play_num }</td>
          <td><a href="updateVideoshow?video_id=${list.video_id}&&id=${list.speaker_id}&&course_id=${list.course_id}">✎</a></td>
          <td><a onclick="delCourseById('${list.video_id}','${list.title}')" >X</a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    ${title}
    		<div>
				共有 ${count}条记录，第 ${page }
				<c:if test="${count %5==0}">
					<c:set value="${count/5}" var="zpage"></c:set>
				</c:if>
				<c:if test="${count %5!=0}">
					<c:set value="${count/5+1}" var="zpage"></c:set>
					<fmt:parseNumber value="${count/5+1}" var="zpage"
						integerOnly="true"></fmt:parseNumber>
				</c:if>
				页 / 共${zpage}页
			</div>
			<div>
				<ul class="pagination">
					<c:if test="${page>1 }">
						<li class="paginate_button previous disabled }"><a
							href="VideoSelect?page=${page-1 }&title=${title}">上一页</a></li>
					</c:if>
					<li class="paginate_button active"><a href="VideoSelect?page=${page}&title=${title}">${page }</a></li>
					<c:if test="${page<zpage }">
						<li class="paginate_button next disabled"><a
							href="VideoSelect?page=${page+1}&title=${title}">下一页</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	<script type="text/javascript">
		function showAddPage(){
			location.href="insertVideo";
		}
		function delCourseById(id,title){

			Confirm.show('温馨提示：', '确定要删除'+title+'么？', {
				'Delete': {
					'primary': true,
					'callback': function() {
						var param={"id":id};
						$.post("deleteVideo",param,function(data){
							if(data=='success'){
								Confirm.show('温馨提示：', '删除成功');
								document.location.reload();
							}else{
								Confirm.show('温馨提示：', '操作失败');
							}
						});
					}
				}
			});
		}
		function a() {
		    var stuts=document.getElementById("all").checked;
		    var c=document.getElementsByName("c");
		     for(var i=0;i<c.length;i++){
		          c[i].checked=stuts;
		      }
		    }
		function deleteAll(){
            var checkedNum  = $("input[name='c']:checked").length;
			  var userIds = new Array();
              $("input[name='c']:checked").each(function(){
                  userIds.push($(this).val());
              });
            	if(confirm("确定删除所选项？")){
                 $.post("delAllVideo",{userIds:userIds},
                    function(data){
  					if(data=='success'){
  						Confirm.show('温馨提示：', '删除成功');
  						document.location.reload();
  					}else{
  						Confirm.show('温馨提示：', '操作失败');
  					}
                 	 });
            	}
         }
	</script>
  

<div id="modal-background" class=""></div><div id="confirm-modal" class="modal fade role=" dialog"="" tabindex="-1"><div class="modal-dialog modal-undefined"><div class="modal-content"><div class="modal-header"><button id="modal-upper-close" class="close modal-close" aria-label="Close" type="button"><span aria-hidden="true">×</span></button><h4 id="modal-title" class="modal-title">Modal Title</h4></div><div id="modal-body" class="modal-body"> Modal Message </div><div id="modal-footer" class="modal-footer"></div></div></div></div><div id="modal-background" class=""></div></body></html>