<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>仓储管理系统</title>
    <%@include file="/com/script.jsp"%>
    <%@include file="/com/style.jsp"%>
    <style type="text/css">
        .subitem:hover{
            background-color: #889db1;
        }
    </style>
    <script src="js/angular.min.js"></script>
    <script>
        function changeIframe(url){
            $('#mainIframe').attr("src",url);
        }

        /*function init(){
            $.ajax({
                method: "GET",
                url: "role/getMenuByRole",
                async:true,
                dataType:"json",
                contentType:"application/json;charset=UTF-8",
                success: function (responseData) {
                    if (responseData.result == 'success') {
                        var html = '';
                        var permissions = responseData.data;
                        for(var i =0;i<permissions.length;i++){
                            html += '<li class="nav-item nav-dropdown open">';
                            html += '<a href="javascript:void(0)" class="nav-link nav-dropdown-toggle">';
                            html += '<i class="icon icon-target"></i> '+permissions[i].name+' <i class="fa fa-caret-left"></i>';
                            html += '</a>';
                            var subPermission = permissions[i].subPermissions;
                            if(subPermission.length>0){
                                html += '<ul class="nav-dropdown-items">';
                                for(var j =0 ;j<subPermission.length;j++){
                                    html += '<li class="nav-item">';
                                    html += '<a onclick="changeIframe("'+subPermission[j].url+'")" class="nav-link">';
                                    html += '<i class="icon icon-target"></i> '+subPermission[j].name;
                                    html += '</a>';
                                    html += '</li>';
                                }
                                html += '</ul>';
                            }
                            html += '</li>';
                        }

                        $('#menuUl').html(html);
                    }
                }
            }).fail(function() {
                alert( "无法连接服务器，请稍后重试" );
            })
        }*/

        $(function() {
//            init();
        });
    </script>
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <nav class="navbar page-header">
        <a href="#" class="btn btn-link sidebar-mobile-toggle d-md-none mr-auto">
            <i class="fa fa-bars"></i>
        </a>

        <a class="navbar-brand" href="#">
            <img src="imgs/logo.png" alt="logo">
        </a>

        <a href="#" class="btn btn-link sidebar-toggle d-md-down-none">
            <i class="fa fa-bars"></i>
        </a>

        <a ></a>

        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <img src="imgs/avatar-1.png" class="avatar avatar-sm" alt="logo">
                    <span class="small ml-1 d-md-down-none">${user.name}</span>
                </a>

                <div class="dropdown-menu dropdown-menu-right">
                    <a href="logined/loginOut" class="dropdown-item">
                        <i class="fa fa-lock"></i> Logout
                    </a>
                </div>
            </li>
        </ul>
    </nav>

    <div class="main-container">
        <div class="sidebar">
            <nav class="sidebar-nav">
                <ul id="menuUl" class="nav">

                    ${menuHtml}

    <%--<li class="nav-item nav-dropdown">
        <a href="javascript:void(0)" class="nav-link nav-dropdown-toggle">
            <i class="icon icon-target"></i> 人员管理
            <i class="fa fa-caret-left"></i>
        </a>
        <ul class="nav-dropdown-items">
            <li class="nav-item"><a onclick="changeIframe('user/userPageList')" class="nav-link">
                <i class="icon icon-target"></i> 用户管理
            </a>
            </li>
            <li class="nav-item">
                <a onclick="changeIframe('/login')" class="nav-link">
                    <i class="icon icon-target"></i> 用户角色关联
                </a>
            </li>
        </ul>
    </li>
    <li class="nav-item nav-dropdown">
        <a href="javascript:void(0)" class="nav-link nav-dropdown-toggle">
            <i class="icon icon-target"></i> 所属机构
            <i class="fa fa-caret-left"></i>
        </a>
    </li>
    <li class="nav-item nav-dropdown">
        <a href="javascript:void(0)" class="nav-link nav-dropdown-toggle">
            <i class="icon icon-target"></i> 系统信息
            <i class="fa fa-caret-left"></i>
        </a>
    </li>--%>

                </ul>
            </nav>
        </div>

        <div class="content" style="padding: 2px;">
            <iframe id="mainIframe" height="100%" width="100%" src="user/userPageList" scrolling="true" frameborder="0">
            </iframe>
        </div>
    </div>
</div>
</body>
</html>
