package com.poly.xuong.B1_2_CRUD1Bang.repository;

import com.poly.xuong.B1_2_CRUD1Bang.entity.KhachHang;
import com.poly.xuong.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class KhachHangRepository {

    private Session s;

    public KhachHangRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<KhachHang> getAll() {
        System.out.println("aaa");
        return s.createQuery("FROM KhachHang ").list();
    }

    public KhachHang getOne(Integer id) {
        return s.find(KhachHang.class, id);
    }

    public void add(KhachHang cate) {
        try {
            // Lay ra tran o thoi diem hien tai
            s.getTransaction().begin();
            // Them => save / saveOrUpdate / persit
            s.persist(cate);
            // Gui yeu cau di
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    public void update(KhachHang cate) {
        try {
            // Lay ra tran o thoi diem hien tai
            s.getTransaction().begin();
            // Update =>  saveOrUpdate / merge
            s.merge(cate);
            // Gui yeu cau di
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    public void delete(KhachHang cate) {
        try {
            // Lay ra tran o thoi diem hien tai
            s.getTransaction().begin();
            // Delete => delete
            s.delete(cate);
            // Gui yeu cau di
            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    public List<KhachHang> searchByMa(String ma) {
        Query query = s.createQuery("FROM KhachHang kh WHERE kh.ma = ?1");
        query.setParameter(1, ma);
        return query.getResultList();
    }
}
