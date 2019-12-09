<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
<meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">

<link rel="stylesheet" href="http://localhost:8080/Job100/css/base.css">
<link rel="stylesheet" href="http://localhost:8080/Job100/css/css.css">
<link rel="icon" href="http://localhost:8080/Job100/img/favicon.png" type="image/png">
<title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>
</head>
<body>

<!--登录注册弹出框-->
<div class="mask " id="login">
	<div class="mask_content">
		<div class="mask_content_header">
			<img src="img/logo.png" alt="" class="ma">
		</div>
		<div class="mask_content_body">
			<form id="loginForm" action="selectAll" method="post">
			<!-- 登录  提交到login -->
				<h3>快速登录</h3>
				<input id="loginEmail" placeholder="请输入邮箱"  name="accounts" type="email"> <span id="msg"></span>
				<input id="loginPassword" placeholder="请输入密码" name="password" type="password"><span id="accMsg"></span>
				<div id="forget">
				<!-- 忘记密码 跳到forgetpassword 后台获取当前输入框中 -->
				  
					<a href="http://localhost:8080/Job100/jsp/forgetPassword1.jsp">忘记密码？</a>
				</div>
				
				<!-- 有一个点击事件 获取到输入框输入的邮箱密码 进行Ajax验证  -->
				<input onclick="return result();"  value="登　录" type="submit">
			</form>
		</div>
		<div class="mask_content_footer">
			<span id="login_close">关　闭</span>
		</div>
	</div>
</div>


    
<script src="http://localhost:8080/Job100/js/jquery-1.js"></script>
<script src="http://localhost:8080/Job100/js/gVerify.js"></script>
<script type="text/javascript">
$('#login_close').click(function(){
 
    window.location.href="http://localhost:8080/Job100/index.jsp";
});


</script>

<script type="text/javascript">

//登录用到的ajax验证
var flag="false";

$("#loginEmail").blur(function(){
  var account= $("#loginEmail").val();
  if(null==account || "" ==account ){
      $("#msg").text("账号不能为空").css("color","red");
      flag =false;
  }else{
	  $("#msg").text("");
	  flag =true;
  }
});

var flag1="false";
$("#loginPassword").blur(function(){
	 
	  var pwd= $("#loginPassword").val();
	  if(null==pwd || "" ==pwd ){
			  $("#accMsg").text("密码不能为空").css("color","red");
		      flag1 =false; 
	  }else{
			  	$("#accMsg").text("");
			  	 flag1 =true;
		  }
});

var flag2="false";
function result(){
		$.ajax({
			    type:"post",
			    url:"admin",
			    data:{
			    accounts:$("#loginEmail").val(),
			    pwd: $("#loginPassword").val(),
			          },
			    success:function(data){
			    if(data=="false"){
			          $("#accMsg").text("账号不存在").css("color","red");
			          flag2 =false;
			    }else{
			         $("#accMsg").text("");
			         flag2 =true;
			         }
			       }
			  })
		  
	
  if(flag==true&&flag1==true&&flag2==true){
      return true;
  }else{
      return false;
  }
}

</script>
</body>
</html>