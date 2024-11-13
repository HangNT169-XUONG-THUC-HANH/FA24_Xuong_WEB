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
<form action="/nhan-vien/add" method="post">
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
    Gioi tinh: <input type="radio" name="gioiTinh" value="Nam" checked/> Nam
    <input type="radio" name="gioiTinh" value="Nữ"/>Nu
    <br/>
    Ten chuc vu:
    <select name="chucVuID">
        <c:forEach items="${listChucVu}" var="chucVu">
            <option value="${chucVu.id}">${chucVu.ten}</option>
        </c:forEach>
    </select>
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
        <th>Giới tính</th>
        <th>Tên Chức Vụ</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listNhanVien}" var="nv" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${nv.ma}</td>
            <td>${nv.getHoVaTen()}</td>
            <td>${nv.sdt}</td>
            <td>${nv.diaChi}</td>
            <td>${nv.gioiTinh}</td>
            <td>${nv.tenChucVu}</td>
            <td>
                <a href="/nhan-vien/remove?id=${nv.id}">Delete</a>
                <a href="/nhan-vien/detail?id=${nv.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
