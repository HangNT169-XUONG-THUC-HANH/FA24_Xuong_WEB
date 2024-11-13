package com.poly.xuong.B3_4_JoinTable.servlet;

import com.poly.xuong.B3_4_JoinTable.request.NhanVienRequest;
import com.poly.xuong.B3_4_JoinTable.response.NhanVienResponse;
import com.poly.xuong.B3_4_JoinTable.service.ChucVuService;
import com.poly.xuong.B3_4_JoinTable.service.NhanVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/add",
        "/nhan-vien/update",
        "/nhan-vien/remove",
        "/nhan-vien/detail"
})
public class NhanVienServlet extends HttpServlet {

    private NhanVienService nhanVienService = new NhanVienService();
    private ChucVuService chucVuService = new ChucVuService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        switch (uri) {
            case "/nhan-vien/hien-thi" -> {
                this.hienThiDuLieu(request, response);
            }
            case "/nhan-vien/detail" -> {
                this.detailNhanVien(request, response);
            }
            case "/nhan-vien/remove" -> {
                this.removeNhanVien(request, response);
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
            case "/nhan-vien/add" -> {
                this.addNhanVien(request, response);
            }
            case "/nhan-vien/update" -> {
                this.updateNhanVien(request, response);
            }
            default -> {
                this.loi404(request, response);
            }
        }
    }

    @SneakyThrows
    private void updateNhanVien(HttpServletRequest request, HttpServletResponse response)throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        NhanVienResponse nhanVienResponse = nhanVienService.getOne(id);
        BeanUtils.populate(nhanVienResponse, request.getParameterMap());
        nhanVienService.updateNhanVien(nhanVienResponse);
        response.sendRedirect("/nhan-vien/hien-thi");
    }

    @SneakyThrows
    private void addNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        NhanVienRequest nhanVienRequest = new NhanVienRequest();
        BeanUtils.populate(nhanVienRequest, request.getParameterMap());
        nhanVienService.addNhanVien(nhanVienRequest);
        response.sendRedirect("/nhan-vien/hien-thi");
    }

    private void loi404(HttpServletRequest request, HttpServletResponse response) {
    }

    private void removeNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        nhanVienService.removeNhanVien(id);
        response.sendRedirect("/nhan-vien/hien-thi");
    }

    private void detailNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("nv",nhanVienService.getOne(Integer.valueOf(request.getParameter("id"))));
        request.setAttribute("listChucVu", chucVuService.getAll());
        request.getRequestDispatcher("/view/buoi2_3/update-nhan-vien.jsp").forward(request, response);
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listNhanVien", nhanVienService.getAll());
        request.setAttribute("listChucVu", chucVuService.getAll());
        request.getRequestDispatcher("/view/buoi2_3/nhan-vien.jsp").forward(request, response);
    }
}
