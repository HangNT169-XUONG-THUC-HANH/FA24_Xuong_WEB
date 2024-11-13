package com.poly.xuong.B3_4_JoinTable.repository;

import com.poly.xuong.B3_4_JoinTable.entity.ChucVu;
import com.poly.xuong.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ChucVuRepository {
    private Session session;

    public ChucVuRepository() {
        session = HibernateUtil.getFACTORY().openSession();
    }

    public List<ChucVu> getAll() {
        return session.createQuery("FROM ChucVu ").list();
    }

    public ChucVu getOne(Integer id) {
        return session.find(ChucVu.class, id);
    }
}
