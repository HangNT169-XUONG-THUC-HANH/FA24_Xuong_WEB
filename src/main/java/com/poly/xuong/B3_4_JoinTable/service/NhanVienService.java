package com.poly.xuong.B3_4_JoinTable.service;

import com.poly.xuong.B3_4_JoinTable.entity.ChucVu;
import com.poly.xuong.B3_4_JoinTable.entity.NhanVien;
import com.poly.xuong.B3_4_JoinTable.repository.ChucVuRepository;
import com.poly.xuong.B3_4_JoinTable.repository.NhanVienRepository;
import com.poly.xuong.B3_4_JoinTable.request.NhanVienRequest;
import com.poly.xuong.B3_4_JoinTable.response.NhanVienResponse;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class NhanVienService {

    private NhanVienRepository nhanVienRepository = new NhanVienRepository();
    private ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Transactional
    public List<NhanVienResponse> getAll() {
        List<NhanVien> nhanVienList = nhanVienRepository.getAll();
        return nhanVienList.stream().map(NhanVienResponse::new).collect(Collectors.toList());
    }

    public void addNhanVien(NhanVienRequest request) {
        nhanVienRepository.add(convertNhanVienFromRequest(request));
    }

    @SneakyThrows
    private NhanVien convertNhanVienFromRequest(NhanVienRequest request) {
        NhanVien nhanVien = new NhanVien();
        BeanUtils.copyProperties(nhanVien, request);
        if (request.getChucVuID() != null) {
            ChucVu cv = chucVuRepository.getOne(request.getChucVuID());
            nhanVien.setChucVu(cv);
        }
        return nhanVien;
    }

    public void removeNhanVien(Integer id) {
        NhanVien nv = nhanVienRepository.getOne(id);
        nhanVienRepository.delete(nv);
    }

    @SneakyThrows
    public void updateNhanVien(NhanVienResponse nv) {
        // convert response -> request
        NhanVienRequest request = new NhanVienRequest();
        BeanUtils.copyProperties(request, nv);
        nhanVienRepository.update(convertNhanVienFromRequest(request));
    }

    public NhanVienResponse getOne(Integer id) {
        NhanVien nv = nhanVienRepository.getOne(id);
        return new NhanVienResponse(nv);
    }
}
