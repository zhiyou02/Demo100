<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">    
<meta name="renderer" content="webkit">
<meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
<meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
<meta name="author" content="司好">

<link rel="stylesheet" href="http://localhost:8080/Job100/css/base.css">
<link rel="stylesheet" href="http://localhost:8080/Job100/css/profile.css">
<link rel="icon" href="http://localhost:8080/Job100/img/avatar_lg.png" type="image/png">
<title>个人中心</title>
</head>
<body>


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
			     <c:if test="${!empty user.imgurl }">
				<a href="chartUp?id=${user.id}">						
					<img id="avatar" src="${user.imgurl }" alt="" width="30px;">
				</a>
				</c:if>
				
				<c:if test="${empty user.imgurl }">
				  <a href="chartUp?id=${user.id}">						
					<img id="avatar" src="img/avatar_lg.png" alt="" width="30px;">
				  </a>
				</c:if>
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
                    <li><a href="chartUp?id=${user.id}">更改头像</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="passwordUp?id=${user.id}">密码安全</a></li>
                </ul>
                <div class="proflle_tab_body">                   
                    <div class="proflle_tab_workplace clearfix">
                        <div class="profile_avatar_area">
                            <c:if test="${!empty user.imgurl }">
                                <img id="avatar" alt="图片走丢了" src="${user.imgurl }" width="200px;">
                            </c:if>
                            <c:if test="${empty user.imgurl }">
                                 <img id="avatar" width="200px;" src="http://localhost:8080/Job100/img/avatar_lg.png" alt="">
                            </c:if>		                         		                                                                                           						    
                          <p>欢迎回来！</p>
                        </div>
                        <ul class="profile_ifo_area">
                            <li><span class="dd">昵　称：${user.nickname}</span></li>                                                                                                                                         
                            <li><span class="dd">性　别：${user.sex}</span></li>                                                                                            
                            <li><span class="dd">生　日：${user.birthday}</span></li>
                            <li><span class="dd">邮　箱：${user.accounts}</span></li>
                            <li><span class="dd">所在地：${user.address}</span> </li>
                            
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <footer>
        <div class="container">
            <ul>
                <li><img src="img/footer_logo.png" alt="" id="foot_logo"></li>
                <li>版权所有：智游3G教育　　　©&nbsp;www.zhiyou100.com</li>
                <li><img src="img/a.png" alt="" id="wxgzh"></li>
            </ul>
        </div>
    </footer>

</body>
</html>