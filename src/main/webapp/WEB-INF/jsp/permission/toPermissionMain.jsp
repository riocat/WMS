<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>仓储管理系统</title>
    <%@include file="/com/script.jsp" %>
    <%@include file="/com/style.jsp" %>
    <script src="js/jqPaginator.js"></script>
    <link rel="stylesheet" href="css/jqPaginator.js.css">
    <link rel="stylesheet" href="css/trbackground.css">
    <link rel="stylesheet" href="css/pageCard.css">
    <script src="js/permission/permissionMain.js"></script>
</head>
<body>
<div class="main-container">
    <div class="content" style="padding: 0px 18px 0px 18px;">
        <div class="card">
            <div class="card-header bg-light" style="padding: 0.3rem;">
                权限管理
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-md-3">
                        <div class="form-group" style="margin-bottom: 0.3rem;">
                            <p class="form-control-plaintext">
                                <input id="permissionSearch" name="permissionSearch" class="form-control"
                                       type="text" placeholder="请输入查询关键字">
                            </p>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group" style="margin-bottom: 0.3rem;">
                            <p class="form-control-plaintext">
                                <button class="btn btn-info btn-block" id="">查找权限</button>
                            </p>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group" style="margin-bottom: 0.3rem;">
                            <p class="form-control-plaintext">
                                <button class="btn btn-primary btn-block" id="">添加权限</button>
                            </p>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-group" style="margin-bottom: 0.3rem;">
                            <p class="form-control-plaintext">
                                <button class="btn btn-danger btn-block" id="">删除权限</button>
                            </p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-2">
                </div>
                <div class="col-md-8">
                    <div class="form-group">
                        <div id="zTree" class="ztree"
                             style="width: 100%;min-height: 460px;overflow: scroll;border-color: #333333;border-style: solid;border-width: thin;"></div>
                    </div>
                </div>
                <div class="col-md-2">
                </div>
            </div>
        </div>

    </div>
</div>
</div>
</div>
</body>
</html>