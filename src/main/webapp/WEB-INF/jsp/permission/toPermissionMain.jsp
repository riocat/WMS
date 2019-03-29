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
                        权限管理
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="main-container">
    <div class="content" style="padding: 0px 18px 0px 18px;">
        <div class="card-body">
            <div class="row">
                <div class="col-md-5">
                    <div class="form-group">

                    </div>
                </div>
                <form id="userAddForm">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="form-group">
                                    权限名：
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <input id="loginid" name="loginid" class="form-control">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>


            <div class="row">
                <div class="col-md-2">
                    <div class="form-group" style="margin-bottom: 0.3rem;">

                    </div>
                </div>
                <div class="col-md-6">
                    <button id="addBtn" class="btn btn-primary">保存</button>
                    <!--<button id="restBtn" class="btn btn-warning">重置</button>-->
                    <button id="returnBtn" class="btn btn-secondary" onclick="goBack()">返回</button>
                </div>
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