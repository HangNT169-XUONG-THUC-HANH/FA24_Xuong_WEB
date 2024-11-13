package com.poly.xuong.B5_PhanTrang.servlet;

import com.poly.xuong.B5_PhanTrang.service.ChiTietSanPhamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ChiTietSanPhamServlet", value = "/ctsp/hien-thi")
public class ChiTietSanPhamServlet extends HttpServlet {

    private ChiTietSanPhamService service = new ChiTietSanPhamService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageSize = 1;
        int totalPages = service.totalPages(pageSize);

        int page = 1;
        String pageParam = request.getParameter("page");
        if (pageParam != null) {
            page = Integer.parseInt(pageParam);
        }
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("lists", service.phanTrang(page, pageSize));
        request.getRequestDispatcher("/view/buoi5/ctsp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
