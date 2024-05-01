<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
    <title>Form Response</title>
</head>
<body>
    <h1>Received Parameters</h1>
    <ul>
        <%
            Enumeration<String> paramNames = request.getAttributeNames();
            while (paramNames.hasMoreElements()) {
                String paramName = paramNames.nextElement();
                if (!paramName.startsWith("jakarta.servlet.forward.")) { // 내부 정보 제외
                    Object paramValue = request.getAttribute(paramName);// Object로 받기
                    %>
                    <li><%= paramName %>: <%= paramValue != null ? paramValue.toString() : "null" %></li> <%-- 안전하게 처리 --%>
                    <%
                }
            }
        %>
    </ul>
</body>
</html>
