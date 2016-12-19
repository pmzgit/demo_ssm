<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/19
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${ctx}/static/css/tmp.css" type="text/css" rel="stylesheet" />
</head>
<body>
    <form method="post" id="detailForm" name="detailForm" action="${ctx}/users/save">
        <div class="modeDivTitleMin">联系方式</div>
        <div class="modeDivTitle">姓&nbsp;名：<input class="fonrmFrame name" type="text" name="receipt_address.name" value=""></div>
        <div class="modeDivTitle">密码：<input class="fonrmFrame phone" type="number"  name="receipt_address.phone" value=""></div>
        <div class="modeDivTitle">所在地区：<input class="fonrmFrame region" type="text" name="receipt_address.region" value=""></div>
        <div class="modeDivTitle">详细地址：<input class="fonrmFrame address" type="text" name="receipt_address.address" value=""></div>
        </div>
    </form>
</body>
</html>
