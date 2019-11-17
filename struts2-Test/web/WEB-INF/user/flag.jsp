<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/16 0016
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="../tdl/struts-tags.tld" %>
<html>
  <head>
    <title>search</title>
  </head>
  <body>

  <s:if test="%{flag}">
    <div>flag is true</div>
  </s:if>
  <s:else>flag is not true</s:else>
  </body>
</html>
