<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>ADMIN</h1>
<%
out.println("admin");
Cookie[] cookies = request.getCookies();
for(Cookie cookie : cookies){

if(cookie.getName().equals("userType")){
out.println(cookie.getValue());
out.println("x");
}
}
%>
</body>
</html>