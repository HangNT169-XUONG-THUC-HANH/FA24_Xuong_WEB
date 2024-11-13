package com.poly.xuong.B1_2_CRUD1Bang.servlet;

import com.poly.xuong.B1_2_CRUD1Bang.entity.KhachHang;
import com.poly.xuong.B1_2_CRUD1Bang.service.KhachHangService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/hien-thi",
        "/khach-hang/update",
        "/khach-hang/add",
        "/khach-hang/detail",
        "/khach-hang/remove",
        "/khach-hang/search",
})
public class KhachHangServlet extends HttpServlet {

    private KhachHangService khachHangService = new KhachHangService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        switch (uri) {
            case "/khach-hang/hien-thi" -> {
                this.hienThiDuLieu(request, response);
            }
            case "/khach-hang/detail" -> {
                this.detailKhachHang(request, response);
            }
            case "/khach-hang/remove" -> {
                this.removeKhachHang(request, response);
            }
            case "/khach-hang/search" -> {
                this.searchKhachHang(request, response);
            }
            default -> {
                this.loi404(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        switch (uri) {
            case "/khach-hang/add" -> {
                this.addKhachHang(request, response);
            }
            case "/khach-hang/update" -> {
                this.updateKhachHang(request, response);
            }
            default -> {
                this.loi404(request, response);
            }
        }
    }

    private void loi404(HttpServletRequest request, HttpServletResponse response) {
    }

    private void removeKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        khachHangService.delete(id);
        response.sendRedirect("/khach-hang/hien-thi");
    }

    private void detailKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("kh", khachHangService.getOne(Integer.valueOf(request.getParameter("id"))));
        request.getRequestDispatcher("/view/buoi1/update-khach-hang.jsp").forward(request, response);
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listKhachHang", khachHangService.getAll());
        request.getRequestDispatcher("/view/buoi1/khach-hang.jsp").forward(request, response);
    }

    @SneakyThrows
    private void updateKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        KhachHang kh = khachHangService.getOne(Integer.valueOf(request.getParameter("id")));
        BeanUtils.populate(kh, request.getParameterMap());
        khachHangService.update(kh);
        response.sendRedirect("/khach-hang/hien-thi");
    }

    @SneakyThrows
    private void addKhachHang(HttpServletRequest request, HttpServletResponse response) {
        KhachHang kh = new KhachHang();
        BeanUtils.populate(kh, request.getParameterMap());
        khachHangService.add(kh);
        request.setAttribute("listKhachHang", khachHangService.getAll());
        request.getRequestDispatcher("/view/buoi1/khach-hang.jsp").forward(request, response);
    }

    private void searchKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        request.setAttribute("listKhachHang", khachHangService.searchByMa(ma));
        request.getRequestDispatcher("/view/buoi1/khach-hang.jsp").forward(request, response);
    }
}
