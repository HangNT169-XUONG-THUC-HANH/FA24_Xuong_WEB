package com.poly.xuong.B5_PhanTrang.repository;

import com.poly.xuong.B5_PhanTrang.entity.ChiTietSP;
import com.poly.xuong.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class ChiTietSanPhamRepository {

    private Session s;

    public ChiTietSanPhamRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<ChiTietSP> getAll() {
        return s.createQuery("FROM ChiTietSP ").list();
    }

    public List<ChiTietSP> phanTrang(int pageNo, int pageSize) {
        String hql = "SELECT ctsp FROM ChiTietSP ctsp ORDER By ctsp.id ";
        Query query = s.createQuery(hql);
        query.setMaxResults(pageSize);
        query.setFirstResult((pageNo - 1) * pageSize);
        return query.getResultList();
    }

    public static void main(String[] args) {
        System.out.println(new ChiTietSanPhamRepository().getAll());
    }
}
