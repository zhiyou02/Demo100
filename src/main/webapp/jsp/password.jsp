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
<meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程"><meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
    
<link rel="stylesheet" href="http://localhost:8080/Job100/css/base.css">
<link rel="stylesheet" href="http://localhost:8080/Job100/css/profile.css">
<link rel="icon" href="http://localhost:8080/Job100/img/avatar_lg.png" type="image/png">

<title>修改密码</title>
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
			      <img id="avatar" src="http://localhost:8080/Job100/img/avatar_lg.png">
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
                    <li><a href="chartUp?id=${user.id}">更改头像</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="#">密码安全</a></li>
                </ul>
                <div class="proflle_tab_body">
                    <div class="proflle_tab_workplace clearfix">
                        <div class="profile_avatar_area">
                        <c:if test="${!empty user.imgurl }">
                                <img id="avatar"  src="${user.imgurl }" width="200px;">
                        </c:if>
                        <c:if test="${empty user.imgurl }">
                                 <img id="avatar" width="200px;" src="http://localhost:8080/Job100/img/avatar_lg.png">
                        </c:if>	
                        </div>
                        <div class="profile_ifo_area">
                            <form action="updatepassword" method="post" id="regPswAgain">
                                <input name="id" value="${user.id}" type="hidden">
                                <div class="form_group">
                                    <span class="dd">旧　密　码：</span>
                                    <input id="oldMsg"  type="password"><span id="oldMsg1"></span>
                                </div>
                                <div class="form_group">
                                    <span class="dd">新　密　码：</span>
                                    <input id="newMsg" name="password" type="password"><span id="newMsg1"></span>
                                </div>
                                <div class="form_group">
                                    <span class="dd">确认新密码：</span>
                                    <input id="NewMsgAgain" type="password"><span id="passMsg"></span>
                                </div>
                                <div class="form_submit dd">
                                <!--onclick="return commitForm();"  -->
                                    <input  value="保　存" type="submit" >
                                    <a >取消</a>
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
			<li><img src="img/footer_logo.png" alt="" id="foot_logo"></li>
			<li>版权所有：智游3G教育　　　©&nbsp;www.zhiyou100.com</li>
			<li><img src="img/a.png" alt="" id="wxgzh"></li>
		</ul>
	</div>
</footer>

<script src="js/jquery-1.js"></script>
<script src="js/gVerify.js"></script>
<script src="js/index.js"></script>
<script src="js/jquery.js"></script>

<script type="text/javascript">
var regIsCommitPsw=false;
var regIsCommitPsw1=false;
var regIsCommitPsw2=false;
//1.输入旧密码与当前密码相同
$("#oldMsg").blur(function(){
      var pass01= $("#oldMsg").val();
      if(null==pass01 || ""==pass01 ){
          $("#oldMsg1").text("密码不能为空").css("color","red");
          regIsCommitPsw =false;
      }else{
    	  if(pass01 != ${user.password}){
    		  $("#oldMsg1").text("密码错误").css("color","red");
    		  regIsCommitPsw =false;
    	  }else{
    		  regIsCommitPsw=true;
	          $("#oldMsg1").text("");
    	  }
      }
});

$("#newMsg").blur(function(){
	 var pass03= $("#oldMsg").val();
     var pass01= $("#newMsg").val();
     if(null==pass01 || ""==pass01  ){
         $("#newMsg1").text("密码不能为空").css("color","red");
         regIsCommitPsw1 =false;
     }else{
    	 if(pass03==pass01){
    		 regIsCommitPsw1 =false;
    	   $("#newMsg1").text("新密码不能和旧密码相同").css("color","red");
    	   }else{
    		   regIsCommitPsw1=true;
               $("#newMsg1").text("");
    	   }
     }
});


$("#newMsgAgain").blur(function(){
      var pass01= $("#newMsg").val();
      var pass02= $("#newMsgAgain").val();
   
      if(null==pass01 || ""==pass01 || null==pass02 || ""==pass02){
          $("#passMsg").text("密码不能为空").css("color","red");
          regIsCommitPsw2 =false;
      }else{
          if(pass01!=pass02){
        	  regIsCommitPsw2=false;
              $("#passMsg").text("两次密码输入不一致，请重新输入").css("color","red");
          }else{
        	  regIsCommitPsw2=true;
              $("#passMsg").text("");
          }
      }
});

function commitForm(){

	if(regIsCommitPsw==true&& regIsCommitPsw1==true&&regIsCommitPsw2==true){
		return  true;
	}else{
		return  false;
	}
	
}
</script>
</body>
</html>