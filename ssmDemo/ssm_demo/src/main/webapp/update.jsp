<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
  <h1>修改页面</h1>
  <form action="${pageContext.request.contextPath}/student/update" method="post">
     <input type="hidden"  value="${student.id}" name="id">
    学生姓名：<input type="text" value="${student.name}" name="name"><br/>
    学生性别：<input type="text"  value="${student.sex}" name="sex"><br/>
    学生年龄：<input type="text"  value="${student.age}" name="age"><br/>
    学生地址：<input type="text"  value="${student.address}" name="address"><br/>
    <button type="submit">修改</button>
  </form>
</body>
</html>
