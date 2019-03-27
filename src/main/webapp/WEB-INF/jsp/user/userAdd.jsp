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
</head>
<body>
<div class="content" style="padding:3px;">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">

                <div class="card">
                    <div class="card-header bg-light">
                        新增用户
                    </div>

                    <div class="card-body">
                        <form id="userAddForm">
                        <div class="row">
                            <div class="col-md-2">
                                <div class="form-group">
                                    登录名：
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="form-group">
                                    <input id="loginid" name="loginid" class="form-control">
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
                                    <input id="name" name="name" class="form-control">
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
                                    <input id="password" name="password" class="form-control" type="password">
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
                                    <input id="passwordConfirm" name="passwordConfirm" class="form-control" type="password">
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
                                    <input id="email" name="email" class="form-control">
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
                                    <input id="phone" name="email"  class="form-control">
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
                                    <input id="address" name="address"  class="form-control">
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
                                <select id="user_type"  name="user_type"  class="form-control">
                                    <option value="" style="display: none">请选择用户类型</option>
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
                                    <textarea id="note" name="note"  class="form-control" rows="6"></textarea>
                                </div>
                            </div>
                            <div class="col-md-1">
                                <div class="form-group">
                                </div>
                            </div>
                        </div>
                        </form>

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
        </div>
    </div>
</div>
<script>

    function goBack(){
        location.href = "user/userPageList";
    }

    function init(){
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
                        $('#user_type').html("");
                        $('#user_type').append('<option value="">请选择用户类型</option>');
//                        $('#selectType').append('<option value="" style="display: none">请选择用户类型</option>');
                        var array = responseData.data;
                        var listHtml = '';
                        for(var i=0;i<array.length;i++){
                            listHtml += '<option value="' + array[i].value + '">' + array[i].note + '</option>';
                        }
                        $("#user_type").append(listHtml);
                    }else{
                        alert(responseData.message);
                    }
                } catch(e) {

                }
            }
        }).fail(function() {
            alert( "无法连接服务器，请稍后重试" );
        })
    }

    $(function() {

        init();

        $("#userAddForm").validate({
            rules: {
                loginid: {
                    required: true
                },
                name: {
                    required: true
                },
                password: {
                    required: true
                },
                passwordConfirm:{
                    required: true,
                    equalTo:'#password'
                },
                email:{
                    email:true
                }
            }
        });

        $('#addBtn').click(function() {

            var pass = $("#userAddForm").valid();
            if(!pass){
                return;
            }

//            $('#addBtn').disabled();
            var newuser = {};
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
                url: "user/addUser",
                data: JSON.stringify(newuser),
                async:true,
                dataType:"json",
                contentType:"application/json;charset=UTF-8",
                success: function (responseData) {
                    if (responseData.result == 'success') {
                        location.href = "user/userPageList";
                    }else{
                        alert(responseData.message);
                    }
                }
            }).fail(function() {
                alert( "无法连接服务器，请稍后重试" );
//                $('#addBtn').enabled();
            })
        });
    });
</script>
</body>
</html>