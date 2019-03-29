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
    <link rel="stylesheet" href="css/trbackground.css">
    <link rel="stylesheet" href="css/pageCard.css">
</head>
<body>
<div class="content" style="padding:3px;">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header bg-light" style="padding: 0.3rem;">
                        用户管理
                    </div>

                    <div class="card-body" style="padding: 0.4rem;">

                        <div class="row">
                            <div class="col-md-3">
                                <div class="form-group" style="margin-bottom: 0.3rem;padding-top: .375rem;">
                                    <input id="selectName" class="form-control" placeholder="请输入用户名或登录名">
                                </div>
                            </div>

                            <div class="col-md-3 form-group" style="margin-bottom: 0.3rem;padding-top: .375rem;">
                                <select id="userType" class="form-control" >
                                    <option value="" style="display: none">请选择用户类型</option>
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
                <div class="card myCardMargin">
                    <div class="card-body myCardbodyMargin">
                        <div class="table-responsive">
                            <table class="table table-bordered table-striped-row myTableMargin" style="word-wrap: break-word;">
                                <thead>
                                    <th max-width="10%">登录名</th>
                                    <th max-width="10%">用户名</th>
                                    <th max-width="20%">所属库区</th>
                                    <th max-width="20%">所属仓库</th>
                                    <th max-width="10%">用户类型</th>
                                    <th max-width="20%">联系电话</th>
                                    <th max-width="10%">操作</th>
                                </thead>
                                <tbody>
                                <c:forEach items="${userList}" var="user">
                                    <tr>
                                        <td max-width="10%">${user.loginid}</td>
                                        <td max-width="10%">${user.name}</td>
                                        <td max-width="20%">${user.store_region_name}</td>
                                        <td max-width="20%">${user.store_name}</td>
                                        <td max-width="10%">${user.user_type}</td>
                                        <td max-width="20%">${user.phone}</td>
                                        <td max-width="10%">
                                            <button class="btn btn-info btn-sm btn-group-sm-padding" onclick="userDetail('${user.id}')">详情</button>
                                            <button class="btn btn-warning btn-sm btn-group-sm-padding" onclick="updateUser('${user.id}')">修改</button>
                                            <button class="btn btn-danger btn-sm btn-group-sm-padding" onclick="deleteUser('${user.id}')">删除</button>
                                        </td>
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

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="min-width: 80%;">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">详情</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            </div>
            <div class="modal-body">
                <div class="content" style="padding:3px;">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-header bg-light">
                                        修改用户
                                    </div>

                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-md-2">
                                                <div class="form-group">
                                                    登录名：
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <span id="detail_loginid"></span>
                                                </div>
                                            </div>

                                            <div class="col-md-2">
                                                <div class="form-group">
                                                    用户名：
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <span id="detail_name"></span>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-2">
                                                <div class="form-group">
                                                    联系邮箱：
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <span id="detail_email"></span>
                                                </div>
                                            </div>

                                            <div class="col-md-2">
                                                <div class="form-group">
                                                    联系电话：
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                <div class="form-group">
                                                    <span id="detail_phone"></span>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-2">
                                                <div class="form-group">
                                                    联系地址：
                                                </div>
                                            </div>
                                            <div class="col-md-10">
                                                <div class="form-group">
                                                    <span id="detail_address"></span>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-2">
                                                <div class="form-group">
                                                    用户类型：
                                                </div>
                                            </div>
                                            <div class="col-md-10">
                                                <div class="form-group">
                                                    <span id="detail_user_type_name"></span>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-2">
                                                <div class="form-group">
                                                    备注：
                                                </div>
                                            </div>
                                            <div class="col-md-10">
                                                <div class="form-group">
                                                    <div id="detail_note" class="card-body">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
</body>
<script>

    function toUserAddPage(){
        location.href = "redirectToJSP?jpsName=user/userAdd";
    }

    function selectUsers(){
        location.href = "user/userPageList?selectName=" + escapeHtmlMax($('#selectName').val())+"&userType="+$('#userType').val()+"&pageSize="+defaultPageSize;
    }

    var a = ${totalPages};
    var b = ${currentPage};
    var selectName = '${selectName}'=='selectName'?'':'${selectName}';
    var selectType = '${selectType}'=='selectType'?'':'${selectType}';
    $.jqPaginator('#pagination', {
        totalPages : a,
        visiblePages : visiblePages,
        currentPage : b,
        onPageChange : function(num, type) {
            if(type!='init'){
                location.href = "user/userPageList?next=" + num + "&selectName=" + escapeHtmlMax($('#selectName').val())+"&userType="+$('#userType').val()+"&pageSize="+defaultPageSize;
            }
        }
    });

    $(function() {
        $.ajax({
            method: "POST",
            url: "sysCode/getSysCodeList",
            data: JSON.stringify({type:'5'}),
            async:true,
            dataType:"json",
            contentType:"application/json;charset=UTF-8",
            success: function (responseData) {
                try {
                    if(responseData.result == 'success') {
                        $('#userType').html("");
                        $('#userType').append('<option value="">请选择用户类型</option>');
//                        $('#selectType').append('<option value="" style="display: none">请选择用户类型</option>');
                        var array = responseData.data;
                        var listHtml = '';
                        for(var i=0;i<array.length;i++){
                            listHtml += '<option value="' + array[i].value + '">' + array[i].note + '</option>';
                        }
                        $("#userType").append(listHtml);
                    }else{
                        alert(responseData.message);
                    }
                } catch(e) {

                }

                $('#selectName').val(selectName);
                $("#userType").val(String(selectType));
            }
        }).fail(function() {
            alert( "无法连接服务器，请稍后重试" );
        })
    });

    function userDetail(userId){

        $('#detail_loginid').html('');
        $('#detail_name').html('');
        $('#detail_email').html('');
        $('#detail_phone').html('');
        $('#detail_address').html('');
        $('#detail_user_type_name').html('');
        $('#detail_note').html('');

        $.ajax({
            method: "POST",
            url: "user/getUserById?id="+userId,
            async:true,
            contentType:"application/json;charset=UTF-8",
            success: function (responseData) {
                if (responseData.result == 'success') {
                    var userData = responseData.data;
                    $('#detail_loginid').html(userData.loginid);
                    $('#detail_name').html(userData.name);
                    $('#detail_email').html(userData.email);
                    $('#detail_phone').html(userData.phone);
                    $('#detail_address').html(userData.address);
                    $('#detail_user_type_name').html(userData.user_type_name);
                    $('#detail_note').html(userData.note);

                    $('#myModal').modal('show');
                }else{
                    alert(responseData.message);
                }
            }
        }).fail(function() {
            alert( "无法连接服务器，请稍后重试" );
        })
    }

    function closeModal(){
        $('#myModal').modal('hide');
    }

    function updateUser(userId){
        location.href = "user/toUserUpdate?id="+userId;
    }

    function deleteUser(userId){
        location.href = "user/deleteUserById?id="+userId;
    }
</script>
</html>