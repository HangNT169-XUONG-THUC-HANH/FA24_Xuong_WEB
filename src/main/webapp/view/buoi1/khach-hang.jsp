<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hangnt169
  Date: 13/11/24
  Time: 09:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/khach-hang/search">
    Search Ma:<input type="text" name="ma"/>
    <button type="submit">Search</button>
</form>
<form action="/khach-hang/add" method="post">
    Ma: <input type="text" name="ma"/>
    <br/>
    Ho: <input type="text" name="ho"/>
    <br/>
    Ten dem: <input type="text" name="tenDem"/>
    <br/>
    Ten: <input type="text" name="ten"/>
    <br/>
    SDT: <input type="text" name="sdt"/>
    <br/>
    Dia chi: <input type="text" name="diaChi"/>
    <br/>
    Thanh pho: <input type="text" name="thanhPho"/>
    <br/>
    Quoc Gia: <input type="text" name="quocGia"/>
    <br/>
    <button type="submit">Add</button>
</form>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã</th>
        <th>Họ và tên</th>
        <th>Số điện thoại</th>
        <th>Địa chỉ</th>
        <th>Thành phố</th>
        <th>Quốc gia</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listKhachHang}" var="kh" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${kh.ma}</td>
            <td>${kh.ho} ${kh.tenDem} ${kh.ten}</td>
            <td>${kh.sdt}</td>
            <td>${kh.diaChi}</td>
            <td>${kh.thanhPho}</td>
            <td>${kh.quocGia}</td>
            <td>
                <a href="/khach-hang/remove?id=${kh.id}">Delete</a>
                <a href="/khach-hang/detail?id=${kh.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
