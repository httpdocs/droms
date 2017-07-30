<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="utf-8">
    <title>Bootstrap Admin</title>
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
                             ${username }
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a tabindex="-1" href="/droms/admin/loginform">退出</a></li>
                        </ul>
                    </li>
                    
                </ul>

                <a class="brand" href="/droms/student/listform"><span class="first">学生宿舍管理</span> <span class="second">系统</span></a>
        </div>
    </div>
    
    <!-- 左侧菜单 -->
    <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>学生信息管理</a>
        <ul id="dashboard-menu" class="nav nav-list collapse">
            <li ><a href="/droms/student/listform">学生信息</a></li>
            <li ><a href="/droms/student/addform">添加学生信息</a></li>
            <li ><a href="">修改学生信息</a></li>
            
        </ul>

        <a href="#legal-menu" class="nav-header" data-toggle="collapse"><i class="icon-legal"></i>宿舍楼管理</a>
        <ul id="legal-menu" class="nav nav-list collapse in">
            <li ><a href="/droms/dromitory/listform">宿舍楼信息</a></li>
            <li ><a href="/droms/dromitory/addform">添加宿舍楼信息</a></li>
            <li class="active"><a href="">修改宿舍楼信息</a></li>
        </ul>
        
        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>宿舍管理</a>
        <ul id="accounts-menu" class="nav nav-list collapse">
            <li ><a href="/droms/drom/listform">宿舍信息</a></li>
            <li ><a href="/droms/drom/addform">添加宿舍</a></li>
            <li ><a href="">修改宿舍信息</a></li>
        </ul>
    </div>
    

    <!-- 主界面-->
    <div class="content">
      <!-- 路径 -->
      <ul class="breadcrumb">
        <li><a href="/droms/dromstory/listform">宿舍楼管理</a> <span class="divider">/</span></li>
        <li class="active">修改宿舍楼</li>
      </ul>
      <!--  主体 -->
      <div class="container-fluid">
        <hr/>
        <div class="row-fluid">   
          <!--表格-->
          <div class="well">
            <!--整个表单-->
            <form action="">
                <div class="tab-pane active in" id="home">
                    <label>楼号</label>
                    <input type="text" class="input-xlarge" name = "dromitory.id"value="${dromitory.id }">
                    <label>楼类型</label>
                    <input type="text" class="input-xlarge" name = "dromitory.id" value="${dromitory.type }">
                    <div>
                        <button type="submit" class="btn btn-primary">确认</button>
                    </div>
                </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    
    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>