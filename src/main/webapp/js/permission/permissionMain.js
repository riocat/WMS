/**
 * Created by rio on 2019/3/29.
 */
var ztree;

var setting = {
    view: {
        selectedMulti: false
    },
    edit: {
        enable: true,
        showRemoveBtn: false,
        showRenameBtn: false
    },
    data: {
        simpleData: {
            enable: true
        },
        keep: {
            parent:true,
            leaf:true
        }
    },
    callback: {
        beforeRemove: beforeRemove,
        beforeRename: beforeRename,
    }
};

function loadZtreeData(){
    $.ajax({
        url : 'permission/getZtreeData',
        method : 'GET',
        // dataType : 'json', 指回调函数参数类型 预期的服务器响应的数据类型
        contentType : 'application/json;charset=UTF-8',
        success : function(responseData) {
            if (responseData.result == 'success') {
                zTreeObj = $.fn.zTree.init($("#zTree"), setting, responseData.data);
            }
        }
    });
}

function beforeRemove(treeId, treeNode) {
    className = (className === "dark" ? "":"dark");
    showLog("[ "+getTime()+" beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
    return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
}

function beforeRename(treeId, treeNode, newName) {
    if (newName.length == 0) {
        alert("节点名称不能为空.");
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        setTimeout(function(){zTree.editName(treeNode)}, 10);
        return false;
    }
    return true;
}

$(function(){
    loadZtreeData();
/*    $("#addPermission").bind("click", {isParent:true}, add);
    $("#addLeaf").bind("click", {isParent:false}, add);
    $("#edit").bind("click", edit);
    $("#remove").bind("click", remove);*/
});
