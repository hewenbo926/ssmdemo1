<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
  <script>
    function del() {
        var elementsByName = document.getElementsByName("ids");
        var arr = new Array();
        for (var i = 0; i < elementsByName.length; i++) {
            if (elementsByName[i].checked ){
                arr.push(elementsByName[i].value);
            }
        }
        window.location.href="${pageContext.request.contextPath}/student/del?ids="+arr;

    }
  </script>
</head>
<body>
  <h1>学生信息列表</h1>
  <a href="/add.jsp">新增</a>     
  &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
  <button onclick="del()" >批量删除</button>
  
  <table border="1" cellspacing="0">
    <tr>
      <th></th>
      <th>学生id</th>
      <th>学生名称</th>
      <th>学生性别</th>
      <th>学生年龄</th>
      <th>居住地址</th>
      <th>操作</th>
    </tr>
    <c:forEach items="${studentList}" var="student">
    <tr>
      <td><input type="checkbox" name="ids" value="${student.id}"></td>
      <td>${student.id}</td>
      <td>${student.name}</td>
      <td>${student.sex}</td>
      <td>${student.age}</td>
      <td>${student.address}</td>
      <td>
          <a href="${pageContext.request.contextPath}/student/findOne?id=${student.id}">修改</a>
          &nbsp;&nbsp;
          <a href="${pageContext.request.contextPath}/student/del?ids=${student.id}">删除</a>
        </td>
    </tr>
    </c:forEach>
  </table>
</body>
</html>
