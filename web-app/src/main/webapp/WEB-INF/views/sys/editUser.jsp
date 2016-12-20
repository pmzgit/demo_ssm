<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp" %>
<html>
<head>
    <title>Title</title>
    <link href="${ctx}/static/css/tmp.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div>${ctx}</div>
    <form method="post" id="detailForm" name="detailForm" action="${ctx}/users/save">
        <div class="modeDivTitleMin">联系方式</div>
        <div class="modeDivTitle">姓&nbsp;名：<input class="fonrmFrame name" type="text" name="name" value=""></div>
        <div class="modeDivTitle">密码：<input class="fonrmFrame phone" type="number"  name="pwd" value=""></div>
        <input type="submit" value="提交">
    </form>
</body>
</html>
