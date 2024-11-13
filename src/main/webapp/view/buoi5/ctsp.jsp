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
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Tên màu sắc</th>
        <th>Tên DSP</th>
        <th>Tên NSX</th>
        <th>Năm Bảo Hành</th>
        <th>Mô Tả</th>
        <th>Số lượng tồn</th>
        <th>Giá nhập</th>
        <th>Giá bán</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${lists}" var="nv" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${nv.tenMauSac}</td>
            <td>${nv.tenDongSanPham}</td>
            <td>${nv.tenNSX}</td>
            <td>${nv.namBaoHanh}</td>
            <td>${nv.moTa}</td>
            <td>${nv.soLuongTon}</td>
            <td>${nv.giaBan}</td>
            <td>${nv.giaNhap}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<!-- Phân trang -->
<div>
    <%--    <c:if test="${currentPage > 1}">--%>
    <%--        <a href="/nhan-vien/hien-thi?page=${currentPage - 1}">Trang trước</a>--%>
    <%--    </c:if>--%>

    <c:forEach var="i" begin="1" end="${totalPages}">
        <c:choose>
            <c:when test="${i == currentPage}">
                <strong>${i}</strong>
            </c:when>
            <c:otherwise>
                <a href="/ctsp/hien-thi?page=${i}">${i}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <%--    <c:if test="${currentPage < totalPages}">--%>
    <%--        <a href="NhanVienPagination?page=${currentPage + 1}">Trang sau</a>--%>
    <%--    </c:if>--%>
</div>
</body>
</html>
