package com.poly.xuong.B1_2_CRUD1Bang.service;

import com.poly.xuong.B1_2_CRUD1Bang.entity.KhachHang;
import com.poly.xuong.B1_2_CRUD1Bang.repository.KhachHangRepository;

import java.util.List;

public class KhachHangService {

    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    public List<KhachHang> getAll() {
        return khachHangRepository.getAll();
    }

    public void add(KhachHang kh) {
        khachHangRepository.add(kh);
    }

    public KhachHang getOne(Integer id) {
        return khachHangRepository.getOne(id);
    }

    public void delete(Integer id) {
        KhachHang kh = khachHangRepository.getOne(id);
        khachHangRepository.delete(kh);
    }

    public void update(KhachHang kh) {
        khachHangRepository.update(kh);
    }

    public List<KhachHang> searchByMa(String ma) {
        return khachHangRepository.searchByMa(ma);
    }
}
