<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
      <head>
        <meta charset="utf-8">
        <title>注册</title>
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

      <body> 
        <div class="navbar">
            <div class="navbar-inner">
                    <ul class="nav pull-right">
                        
                    </ul>
                    <a class="brand" href=""><span class="first">宿舍信息管理</span> <span class="second">系统</span></a>
            </div>
        </div>
        
        <div class="row-fluid">
            <div class="dialog">
                <div class="block">
                    <p class="block-heading">注册</p>
                    <div class="block-body">
                        <form action="registaction" method="post">
                            <label>用户名</label>
                            <input type="text" class="span12" name = "admin.username" />
                            <label>姓名</label>
                            <input type="text" class="span12" name = "admin.name" />
                            <label>密码</label>
                            <input type="password" class="span12" name = "admin.password" />
                            <label >用户类型</label>
		                     <select class="form-control" name = "admin.dromitory.id">
								<option value="0" >系统管理员</option>
								<s:iterator value="list" id="id"> 
									<option value="${id }" >${id }楼管理员</option>
								</s:iterator>
							</select>
                            <button type="submit"  class="btn btn-primary pull-right">注 册</button>
                            <div class="clearfix"></div>
                            <p><a href="loginform">已有账户？</a></p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>


