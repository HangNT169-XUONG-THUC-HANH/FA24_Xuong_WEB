package com.poly.xuong.B5_PhanTrang.service;

import com.poly.xuong.B5_PhanTrang.entity.ChiTietSP;
import com.poly.xuong.B5_PhanTrang.repository.ChiTietSanPhamRepository;
import com.poly.xuong.B5_PhanTrang.response.ChiTietSanPhamResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ChiTietSanPhamService {

    private ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();

    public List<ChiTietSanPhamResponse> getAll() {
        List<ChiTietSP> nhanVienList = chiTietSanPhamRepository.getAll();
        return nhanVienList.stream().map(ChiTietSanPhamResponse::new).collect(Collectors.toList());
    }

    public Integer totalPages(Integer itemsPerPage) {
        Integer totalItems = chiTietSanPhamRepository.getAll().size();
        return (int) Math.ceil((double) totalItems / itemsPerPage);
    }

    public List<ChiTietSanPhamResponse> phanTrang(int pageNo, int pageSize) {
        List<ChiTietSP> nhanVienList = chiTietSanPhamRepository.phanTrang(pageNo, pageSize);
        return nhanVienList.stream().map(ChiTietSanPhamResponse::new).collect(Collectors.toList());
    }
}
