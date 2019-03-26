<%@ page language="java" pageEncoding="utf-8"%>
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
    <script>
        var targetId = '${targetId}';
    </script>
</head>
<body>
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
                            <div class="col-md-3">
                                <div class="form-group">
                                    <input id="loginid" class="form-control">
                                </div>
                            </div>
                            <div class="col-md-1">
                                <div class="form-group">
                                </div>
                            </div>

                            <div class="col-md-2">
                                <div class="form-group">
                                    用户名：
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <input id="name" class="form-control">
                                </div>
                            </div>
                            <div class="col-md-1">
                                <div class="form-group">
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-2">
                                <div class="form-group">
                                    密码：
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <input id="password" class="form-control" type="password">
                                </div>
                            </div>
                            <div class="col-md-1">
                                <div class="form-group">
                                </div>
                            </div>

                            <div class="col-md-2">
                                <div class="form-group">
                                    密码确认：
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <input id="passwordConfirm" class="form-control" type="password">
                                </div>
                            </div>
                            <div class="col-md-1">
                                <div class="form-group">
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-2">
                                <div class="form-group">
                                    联系邮箱：
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <input id="email" class="form-control">
                                </div>
                            </div>
                            <div class="col-md-1">
                                <div class="form-group">
                                </div>
                            </div>

                            <div class="col-md-2">
                                <div class="form-group">
                                    联系电话：
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <input id="phone" class="form-control">
                                </div>
                            </div>
                            <div class="col-md-1">
                                <div class="form-group">
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-2">
                                <div class="form-group">
                                    联系地址：
                                </div>
                            </div>
                            <div class="col-md-9">
                                <div class="form-group">
                                    <input id="address" class="form-control">
                                </div>
                            </div>
                            <div class="col-md-1">
                                <div class="form-group">
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-2">
                                <div class="form-group">
                                    用户类型：
                                </div>
                            </div>
                            <div class="col-md-9 form-group" style="margin-bottom: 0.3rem;padding-top: .375rem;">
                                <select id="user_type" class="form-control">
                                    <option value="" style="display: none">请选择用户类型</option>
                                    <option value="">2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                </select>
                            </div>
                            <div class="col-md-1">
                                <div class="form-group">
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-2">
                                <div class="form-group">
                                    备注：
                                </div>
                            </div>
                            <div class="col-md-9">
                                <div class="form-group">
                                    <textarea id="note" class="form-control" rows="6"></textarea>
                                </div>
                            </div>
                            <div class="col-md-1">
                                <div class="form-group">
                                </div>
                            </div>
                        </div>


                        <div class="row">
                            <div class="col-md-2">
                                <div class="form-group" style="margin-bottom: 0.3rem;">

                                </div>
                            </div>
                            <div class="col-md-6">
                                <button id="addBtn" class="btn btn-primary">保存</button>
                                <button id="returnBtn" class="btn btn-secondary" onclick="goBack()">返回</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>

    function goBack(){
        location.href = "user/userPageList";
    }

    function init(){
        $.ajax({
            method: "POST",
            url: "user/getUserById?id="+targetId,
            async:true,
            contentType:"application/json;charset=UTF-8",
            success: function (responseData) {
                if (responseData.result == 'success') {
                    var userData = responseData.data;
                    $('#loginid').val(userData.loginid);
                    $('#name').val(userData.name);
                    $('#password').val(userData.password);
                    $('#passwordConfirm').val(userData.password);
                    $('#email').val(userData.email);
                    $('#phone').val(userData.phone);
                    $('#address').val(userData.address);
                    $('#user_type').val(userData.user_type);
                    $('#note').val(userData.note);
                }
            }
        }).fail(function() {
            alert( "无法连接服务器，请稍后重试" );
        })
    }

    $(function() {
        init();

        $('#addBtn').click(function() {
            var newuser = {};
            newuser.id = targetId;
            newuser.loginid = $('#loginid').val();
            newuser.name = $('#name').val();
            newuser.password = $('#password').val();
            newuser.email = $('#email').val();
            newuser.phone = $('#phone').val();
            newuser.address = $('#address').val();
            newuser.user_type = $('#user_type').val();
            newuser.note = $('#note').val();
            $.ajax({
                method: "POST",
                url: "user/updateUser",
                data: JSON.stringify(newuser),
                async:true,
                dataType:"json",
                contentType:"application/json;charset=UTF-8",
                success: function (responseData) {
                    if (responseData.result == 'success') {
                        location.href = "user/userPageList";
                    }
                }
            }).fail(function() {
                alert( "无法连接服务器，请稍后重试" );
            })
        });
    });
</script>
</html>