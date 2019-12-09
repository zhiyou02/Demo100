<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
                
<meta name="renderer" content="webkit">
<meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
<meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
    
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.css">

<title>修改头像</title>
</head>
<body class="w100">
<header>
	<div class="container top_bar clearfix">
		<img src="img/logo.png" alt="智游">
		<div id="tele">
			<span>4006-371-555</span>
			<span>0371-88888598</span>
		</div>
	</div>
	<menu>
		<div class="container clearfix">
			<ul class="clearfix f_left">
				<li><a href="index?id=${user.id}">首页</a></li>				
				<li class="menu_active"><a href="user?id=${user.id}">个人中心</a></li>
			</ul>			
			<div id="user_bar">
				<a>
			    <c:if test="${!empty user.imgurl }">
                   <img id="avatar" src="${user.imgurl }">
			    </c:if>
			    <c:if test="${empty user.imgurl }">
			      <img id="avatar" src="${pageContext.request.contextPath}/img/avatar_lg.png">
			     </c:if>					
				</a>
				<a id="lay_out" href="index?id=${user.id}">退出</a>
			</div>
		</div>
	</menu>
</header>
    <main>
        <div class="container">
            <h2>我的资料</h2>
            <div id="profile_tab">
                <ul class="profile_tab_header f_left clearfix">
                    <li><a href="userUp?id=${user.id}">更改资料</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="#">更改头像</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="passwordUp?id=${user.id}">密码安全</a></li>
                </ul>
                <div class="proflle_tab_body">
                    <div class="proflle_tab_workplace clearfix">
                        <div class="profile_avatar_area">
                           <c:if test="${!empty user.imgurl }">
                                <img id="avatar"  src="${user.imgurl }" width="200px;">
                            </c:if>
                            <c:if test="${empty user.imgurl }">
                                 <img id="avatar" width="200px;" src="${pageContext.request.contextPath}/img/avatar_lg.png">
                            </c:if>	
                            <p style="text-align: center;">当前头像</p>
                        </div>
                        <div class="profile_ifo_area">
                            <form id="upload_form" action="upload" method="post" enctype="multipart/form-data">
                                <input name="id" value="${user.id}" type="hidden">
                                <!-- hidden crop params -->                              
                                <p>第一步：请选择图像文件</p>
                                <div><input name="image_file" id="image_file" onchange="fileSelectHandler()" type="file"></div>
                                <div class="error"></div>
                                <div class="step2">
                                <p>第二步：请确定,然后按上传</p>                            
                                <input value="上传" type="submit">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
     </main>
<footer>
	<div class="container">
		<ul>
			<li><img src="${pageContext.request.contextPath}/img/footer_logo.png" alt="" id="foot_logo"></li>
			<li>版权所有：智游3G教育　　　©&nbsp;www.zhiyou100.com</li>
			<li><img src="${pageContext.request.contextPath}/img/a.png" alt="" id="wxgzh"></li>
		</ul>
	</div>
</footer>




<script src="${pageContext.request.contextPath}/js/jquery-1.js"></script>
<script src="${pageContext.request.contextPath}/js/gVerify.js"></script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/Jcrop_upload.js"></script>

</body>
</html>