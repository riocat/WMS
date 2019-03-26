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
</head>
<body>
<div class="page-wrapper flex-row align-items-center">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card p-4">
                    <div class="card-header text-center text-uppercase h4 font-weight-light">
                        广通仓储管理系统
                    </div>

                    <div class="card-body py-5">
                        <div class="form-group">
                            <label class="form-control-label">用户名</label>
                            <input id="username" type="text" class="form-control">
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">密码</label>
                            <input id="password" type="password" class="form-control">
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">验证码</label>
                            <input type="password" class="form-control">
                        </div>

                    </div>

                    <div class="card-footer">
                        <div class="row">
                            <div class="col-12">
                                <button id="loginBut" type="submit" class="btn btn-primary px-5" style="width: 100%;">登录</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(function() {
        $('#loginBut').click(function() {
            $.ajax({
                method: "POST",
                url: "login",
                data: JSON.stringify({name: $('#username').val(), password: $('#password').val()}),
                async:true,
                dataType:"json",
                contentType:"application/json;charset=UTF-8",
                success: function (responseData) {
                    if (responseData.result == 'success') {
                        location.href = "logined/main";
                    }
                }
            }).fail(function() {
                alert( "无法连接服务器，请稍后重试" );
            })
        });
    });

    /* https://blog.csdn.net/lp1052843207/article/details/77982458 */
    if(window !=top){
        top.location.href=location.href;
    }
</script>
</body>
</html>
