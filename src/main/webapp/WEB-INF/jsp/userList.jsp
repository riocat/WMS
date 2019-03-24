<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>仓储管理系统</title>
    <%@include file="/com/script.jsp"%>
    <%@include file="/com/style.jsp"%>
    <script src="js/jqPaginator.js"></script>
    <link rel="stylesheet" href="css/jqPaginator.js.css">
</head>
<body>
<div class="content" style="padding:3px;">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header bg-light" style="padding: 0.3rem;">
                        用户列表
                    </div>

                    <div class="card-body" style="padding: 0.4rem;">

                        <div class="row">
                            <div class="col-md-3">
                                <div class="form-group" style="margin-bottom: 0.3rem;padding-top: .375rem;">
                                    <input id="selectName" class="form-control" placeholder="请输入用户名或登录名">
                                </div>
                            </div>

                            <div class="col-md-3 form-group" style="margin-bottom: 0.3rem;padding-top: .375rem;">
                                <select id="selectType" class="form-control">
                                    <option value="" style="display: none">请选择用户类型</option>
                                    <option value="">2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                </select>
                            </div>

                            <div class="col-md-1">
                                <div class="form-group" style="margin-bottom: 0.3rem;">
                                    <p class="form-control-plaintext"><button id="selectBtn" class="btn btn-primary" onclick="selectUsers()">查询</button></p>
                                </div>
                            </div>
                            <div class="col-md-1">
                                <div class="form-group" style="margin-bottom: 0.3rem;">
                                    <p class="form-control-plaintext"><button class="btn btn-primary" onclick="toUserAddPage()">新增</button></p>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="main-container">
    <div class="content" style="padding: 0px 18px 0px 18px;">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>登录名</th>
                                    <th>用户名</th>
                                    <th>所属库区</th>
                                    <th>所属仓库</th>
                                    <th>用户类型</th>
                                    <th>联系电话</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${userList}" var="user">
                                    <tr>
                                        <td>${user.loginid}</td>
                                        <td>${user.name}</td>
                                        <td>${user.store_region_name}</td>
                                        <td>${user.store_name}</td>
                                        <td>${user.user_type}</td>
                                        <td>${user.phone}</td>
                                        <td></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <ul class="pagination" id="pagination"></ul>
    </div>
</div>
</body>
<script>

    function toUserAddPage(){
        location.href = "redirectToJSP?jpsName=userAdd";
    }

    function selectUsers(){
        location.href = "user/userList?selectName=" + $('#selectName').val()+"&selectType"+$('#selectType').val()+"&pageSize="+defaultPageSize;
    }

    var a = ${totalPages};
    var b = ${currentPage};
    $.jqPaginator('#pagination', {
        totalPages : a,
        visiblePages : visiblePages,
        currentPage : b,
        onPageChange : function(num, type) {
            if(type!='init'){
                location.href = "user/userList?next=" + num + "&selectName=" + $('#selectName').val()+"&selectType"+$('#selectType').val()+"&pageSize="+defaultPageSize;
            }
        }
    });

    $(function() {

    });
</script>
</html>