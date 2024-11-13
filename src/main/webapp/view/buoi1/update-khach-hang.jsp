<%--
  Created by IntelliJ IDEA.
  User: hangnt169
  Date: 13/11/24
  Time: 09:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Update khach hang</h1>
<form action="/khach-hang/update?id=${kh.id}" method="post">
    Ma: <input type="text" name="ma" value="${kh.ma}"/>
    <br/>
    Ho: <input type="text" name="ho" value="${kh.ho}"/>
    <br/>
    Ten dem: <input type="text" name="tenDem" value="${kh.tenDem}"/>
    <br/>
    Ten: <input type="text" name="ten" value="${kh.ten}"/>
    <br/>
    SDT: <input type="text" name="sdt" value="${kh.sdt}"/>
    <br/>
    Dia chi: <input type="text" name="diaChi" value="${kh.diaChi}"/>
    <br/>
    Thanh pho: <input type="text" name="thanhPho" value="${kh.thanhPho}"/>
    <br/>
    Quoc Gia: <input type="text" name="quocGia" value="${kh.quocGia}"/>
    <br/>
    <button type="submit">Update</button>
</form>
</body>
</html>
