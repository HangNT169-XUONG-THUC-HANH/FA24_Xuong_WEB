package com.poly.xuong.B3_4_JoinTable.service;

import com.poly.xuong.B3_4_JoinTable.entity.ChucVu;
import com.poly.xuong.B3_4_JoinTable.repository.ChucVuRepository;

import java.util.List;

public class ChucVuService {

    private ChucVuRepository chucVuRepository = new ChucVuRepository();

    public List<ChucVu> getAll() {
        return chucVuRepository.getAll();
    }

    public ChucVu getOne(Integer id) {
        return chucVuRepository.getOne(id);
    }

}
