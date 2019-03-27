<%@ page language="java" pageEncoding="utf-8"%>
<base href="<%=request.getContextPath()%>/">
<script src="js/angular.min.js"></script>
<script src="js/vendor/jquery/jquery.min.js"></script>
<script src="js/vendor/popper.js/popper.min.js"></script>
<script src="js/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="js/vendor/chart.js/chart.min.js"></script>
<script src="js/carbon.js"></script>
<script src="js/demo.js"></script>
<script src="js/vendor/jquery/jquery.validate.js"></script>
<script src="js/vendor/jquery/messages_zh.js"></script>
<script>
    var visiblePages = 10;
    var defaultPageSize = 10;

    function escapeHtml(string) {
        var entityMap = {
            "&": "&amp;",
            "<": "&lt;",
            ">": "&gt;",
            '"': '&quot;',
            "'": '&#39;',
            "/": '&#x2F;',
            "#": "%23",
        };
        return String(string).replace(/[&<>"'\/#]/g, function (s) {
            return entityMap[s];
        });
    }

    /*url转义函数 给get参数进行转义操作*/
    function escapeHtmlMax(string) {
        var entityMap = {
            " ": "%20",
            '"': "%22",
            "#": "%23",
            "%": "%25",
            "&": "%26",
            "(": "%28",
            ")": "%29",
            "+": "%2B",
            ",": "%2C",
            "/": "%2F",
            ":": "%3A",
            ";": "%3B",
            "<": "%3C",
            "=": "%3D",
            ">": "%3E",
            "?": "%3F",
            "@": "%40",
            "\\": "%5C",
            "|": "%7C "
        };
        return String(string).replace(/[\s"#%&()+,/:;<=>?@\\|]/g, function (s) {
            return entityMap[s];
        });
    }
</script>