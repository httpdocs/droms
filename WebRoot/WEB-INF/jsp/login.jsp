<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
  	<head>
	    <meta charset="utf-8">
	    <title>登录</title>
	    <!--css样式-->
	    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
	    <!-- 界面风格-->
	    <link rel="stylesheet" type="text/css" href="../css/theme.css">
	    
	    <!-- 标题样式 -->

	    <style type="text/css">
	        #line-chart {
	            height:300px;
	            width:800px;
	            margin: 0px auto;
	            margin-top: 1em;
	        }
	        .brand { font-family: georgia, serif; }
	        .brand .first {
	            color: #ccc;
	            font-style: italic;
	        }
	        .brand .second {
	            color: #fff;
	            font-weight: bold;
	        }
		</style>
	</head>
	<body class=""> 
	    <div class="navbar">
	        <div class="navbar-inner">
	                <ul class="nav pull-right">
	                    
	                </ul>
	                <a class="brand" href="index.html"><span class="first">宿舍信息管理</span> <span class="second">系统</span></a>
	        </div>
	    </div>
	    
	    <div class="row-fluid">
		    <div class="dialog">
		        <div class="block">
		            <p class="block-heading">登录</p>
		            <div class="block-body">
		                 <form action="loginaction" method="post">
		                    <label>用户名</label>
		                    <input type="text" name = "admin.username" class="span12">
		                    <label>密码</label>
		                    <input type="password" name = "admin.password" class="span12"> 
							<button type="submit"  class="btn btn-primary pull-right">登 录</button>
		                    <div class="clearfix"></div>
		                    <p><a href="registform">没用账号?</a></p>
		                </form>
		            </div>
		        </div>
		    </div>
		</div>
	</body>
</html>
