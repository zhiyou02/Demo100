<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
          
<meta name="renderer" content="webkit">
<meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
<meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
    
<link rel="stylesheet" href="http://localhost:8080/Job100/css/base.css">
<link rel="stylesheet" href="http://localhost:8080/Job100/css/profile.css">
<link rel="icon" href="http://localhost:8080/Job100/img/favicon.png" type="image/png">
<title>忘记密码</title>
</head>
<body class="w100">
<header>
	<div class="container top_bar clearfix">
		<img src="../img/logo.png" alt="智游">
		<div id="tele">
			<span>4006-371-555</span>
			<span>0371-88888598</span>
		</div>
	</div>
	<menu>
		<div class="container clearfix">
			<ul class="clearfix f_left">
				<li><a href="http://localhost:8080/Job100/index.jsp">首页</a></li>
				<li class="menu_active"><a>忘记密码</a></li>
			</ul>
			<div id="user_bar">
				<a>
					<img id="avatar" src="../img/avatar_lg.png">
				</a>
				<a href="http://localhost:8080/Job100/index.jsp">退出</a>
			</div>
		</div>
	</menu>
</header>

   <main>
        <div class="container">
            <h2>忘记密码</h2>
            <div id="profile_tab">
                <ul class="profile_tab_header f_left clearfix">
                    <li><a> </a></li>
                    <li class="profile_tab_line"></li>
                    <li><a> </a></li>
                    <li class="profile_tab_line"></li>
                    <li><a> </a></li>
                </ul>
                <div class="proflle_tab_body">
                    <div class="proflle_tab_workplace clearfix">
                        <div class="profile_avatar_area">
                           <img id="avatar" width="150px;" src="http://localhost:8080/Job100/img/avatar_lg.png">
		                </div>
                        <div class="profile_ifo_area">
                        
                            <form action="updatepassword" method="post" id="forgetpwd">
                                <div class="form_group">
                                    <span class="dd">用　户　名：</span>
                                    <input  type="text" id="accounts">
                                </div>
                                <div class="form_group">
                                    <span class="dd">新　密　码：</span>
                                    <input  type="password" id="password1">
                                </div>
                                <div class="form_group">
                                    <span class="dd">确认新密码：</span>
                                    <input  type="password" id="password2"><span id="oldMsg"></span>
                                </div>
                                <div class="form_submit dd">
                                    <input value="保　存" type="submit">
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
			<li><img src="../img/footer_logo.png" alt="" id="foot_logo"></li>
			<li>版权所有：智游3G教育　　　©&nbsp;www.zhiyou100.com</li>
			<li><img src="../img/a.png" alt="" id="wxgzh"></li>
		</ul>
	</div>

<script type="text/javascript">
		$("#forgetpwd").blur(function(){
		    var pass01= $("#password1").val();
		    var pass02= $("#password2").val();
		    if(null==pass01 || ""==pass01 || null==pass02 || ""==pass02){
		        $("#oldMsg").text("密码不能为空").css("color","red");
		        regIsCommitPsw =false;
		    }else{
		        if(pass01!=pass02){
		            regIsCommitPsw=false;
		            $("#oldMsg").text("两次密码输入不一致，请重新输入").css("color","red");
		        }else{
		            regIsCommitPsw=true;
		            $("#oldMsg").text("");
		        }
		    }
		    
		});
</script>
	
</footer>
</body>
</html>