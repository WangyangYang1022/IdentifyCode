<%--
  Created by IntelliJ IDEA.
  User: Scc
  Date: 2017/12/28
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>��֤��</title>
  <script language="javascript">
      function myReload() {
          document.getElementById("CreateCheckCode").src = document
                  .getElementById("CreateCheckCode").src
              + "?nocache=" + new Date().getTime();
      }
  </script>
</head>

<body>
<form action="Check.jsp" method="post">
  <input name="checkCode" type="text" id="checkCode" title="��֤�����ִ�Сд"
         size="8" ,maxlength="4" />
  <img src="myself" id="CreateCheckCode" align="middle" onclick="myReload()">
  <a href="" onclick="myReload()"> ������,��һ��</a>
  <input type="submit" value="�ύ" />
</form>
</body>
</html>
