<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
  	<head>
        <meta charset="utf-8">
        <title>学生信息</title>
		<!--css样式-->
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
        <!-- 界面风格-->
        <link rel="stylesheet" type="text/css" href="../css/theme.css">
        <!-- 显示图标-->
        <link rel="stylesheet" href="../css/font-awesome.css">
		<!-- js-->
        <script src="../js/jquery-1.7.2.min.js" type="text/javascript"></script>
        <script src="../js/bootstrap.js" ></script>
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
	    <!-- 顶部-->
	    <div class="navbar">

	        <div class="navbar-inner">
	       
	                <ul class="nav pull-right">
	                           
	                    <li id="fat-menu" class="dropdown">
	                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
	                            <i class="icon-user"></i>
	                             ${username} 
	                            <i class="icon-caret-down"></i>
	                        </a>

	                        <ul class="dropdown-menu">
	                            <li><a tabindex="-1" href="/droms/admin/loginform">退出</a></li>
	                             <li><a tabindex="-1" href="/droms/admin/exitaction">注销用户</a></li>
	                        </ul>
	                    </li>
	                    
	                </ul>

	                <a class="brand" href="/droms/student/listform"><span class="first">学生宿舍管理</span> <span class="second">系统</span></a>
	        </div>
	    </div>
    

		<!-- 左侧菜单 -->
    
    	<div class="sidebar-nav">
        	<a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-group"></i>学生信息管理</a>
        	<ul id="dashboard-menu" class="nav nav-list collapse in">
            	<li class="active"><a href="/droms/student/listform">学生信息</a></li>
            	<li >
            			<a href="/droms/student/addform">添加学生信息</a>
            	</li>
            	<li ><a href="#">修改学生信息</a></li>
        	</ul>

	        <a href="#legal-menu" class="nav-header" data-toggle="collapse"><i class="icon-legal"></i>宿舍楼管理</a>
	        <ul id="legal-menu" class="nav nav-list collapse">
	            <li ><a href="/droms/dromitory/listform">宿舍楼信息</a></li>
	            <li ><a href="/droms/dromitory/addform">添加宿舍楼</a></li>
	        </ul>

	        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>宿舍管理</a>
        	<ul id="accounts-menu" class="nav nav-list collapse">
	            <li ><a href="/droms/drom/listform">宿舍信息</a></li>
	            <li ><a href="/droms/drom/addform">添加宿舍</a></li>
	        </ul>
	        <a href="/droms/admin/adminform" class="nav-header" ><i class="icon-user"></i>账户管理</a>

	    </div>

		<!-- 主界面 -->    
	    <div class="content">
			<!-- 头部地址 -->
	        <ul class="breadcrumb">
	            <li><a href="">学生信息管理</a> <span class="divider">/</span></li>
	            <li class="active">学生信息</li>
	        </ul>
	      
	        <div class="container-fluid">
	            <div class="row-fluid">
					<div class="row-fluid">
						<hr>
						<!-- 查询 -->
						<div>
							 <form class="form-inline" action = "/droms/student/findaction" method="post">
	                    		<input class="input-xlarge" placeholder="请输入学生学号..." 
	                    		 type="text" name="studentid">
	                    		<button class="btn" type="submit"><i class="icon-search"></i> Go</button>
	                		</form>
						</div>
						<!-- 表格 -->
	 					<div class="well">
	    					<table class="table">
	     					 	<thead>
	        						<tr>
								        <th>学号</th>
								        <th>姓名</th>
								        <th>班级</th>
								        <th>手机号</th>
								        <th>入住时间</th>
								        <th>辅导员</th>
								        <th>寝室</th>
								        <th style="width: 26px;"></th>
								    </tr>
								</thead>
							    <tbody>
								<s:iterator value="list" >					
									<tr>
							          	<td><i><s:property value="studentID" /></i></td>
							          	<td><s:property value="name" /></td>
							          	<td><s:property value="classroom" /></td>
							          	<td><s:property value="phone" /></td>
							          	<td><s:property value="start_time" /></td>
							          	<td><s:property value="counselor" /></td>
							          	<td><s:property value="drom.dromitory.id" />#<s:property value="drom" /></td>
							          	<td>
							              	<a href="/droms/student/updateform?id=${id }"><i class="icon-pencil"></i></a>
							              	<a href="/droms/student/deleteaction?id=${id }"><i class="icon-remove"></i></a>
							          	</td>
							        </tr>	
								</s:iterator>
								
							    </tbody>
							</table>
						</div>
		            </div>
		        </div>
		    </div>
		</div>
  </body>
</html>