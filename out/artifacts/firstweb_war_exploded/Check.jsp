<%--
  Created by IntelliJ IDEA.
  User: Scc
  Date: 2017/12/28
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<html>
<head>
    <title>验证码校验</title>
</head>

<body>
<%
    String checkcode=request.getParameter("checkCode");
    if(checkcode.equals("")||checkcode==null){
        out.print("<script>alert('请输入验证码');window.location.href('index.jsp')</script>");
    }else{
        if(!checkcode.equalsIgnoreCase((String)session.getAttribute("verifyCode"))){
            out.print("<script>alert('验证码不正确,请重新输入');history.back(-1);</script>");
        }else{
            out.print("登录成功");
        }
    }
%>
</body>
</html>
