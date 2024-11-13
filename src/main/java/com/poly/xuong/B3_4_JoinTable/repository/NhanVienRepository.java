package com.poly.xuong.B3_4_JoinTable.repository;

import com.poly.xuong.B3_4_JoinTable.entity.NhanVien;
import com.poly.xuong.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class NhanVienRepository {

    private Session s;

    public NhanVienRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<NhanVien> getAll() {
        return s.createQuery("FROM NhanVien ").getResultList();
    }

    public NhanVien getOne(Integer id) {
        return s.find(NhanVien.class, id);
    }

    public void add(NhanVien cate) {
        try {
            s.getTransaction().begin();
            s.persist(cate);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    public void update(NhanVien cate) {
        try {
            s.getTransaction().begin();
            s.merge(cate);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    public void delete(NhanVien cate) {
        try {
            s.getTransaction().begin();
            s.delete(cate);
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

}
