<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hangnt169
  Date: 13/11/24
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">Update nhan vien</h1>
<form action="/nhan-vien/update?id=${nv.id}" method="post">
    Ma: <input type="text" name="ma" value="${nv.ma}"/>
    <br/>
    Ho: <input type="text" name="ho" value="${nv.ho}"/>
    <br/>
    Ten dem: <input type="text" name="tenDem" value="${nv.tenDem}"/>
    <br/>
    Ten: <input type="text" name="ten" value="${nv.ten}"/>
    <br/>
    SDT: <input type="text" name="sdt" value="${nv.sdt}"/>
    <br/>
    Dia chi: <input type="text" name="diaChi" value="${nv.diaChi}"/>
    <br/>
    Gioi tinh: <input type="radio" name="gioiTinh" value="Nam" ${nv.gioiTinh == "Nam" ?"checked":""}/> Nam
    <input type="radio" name="gioiTinh" value="Nữ" ${nv.gioiTinh == "Nữ" ?"checked":""}/>Nu
    <br/>
    Ten chuc vu:
    <select name="chucVuID">
        <c:forEach items="${listChucVu}" var="chucVu">
            <option value="${chucVu.id}" ${nv.chucVuID == chucVu.id ?"selected":""} >${chucVu.ten}</option>
        </c:forEach>
    </select>
    <br/>
    <button type="submit">Update</button>
</form>
</body>
</html>
