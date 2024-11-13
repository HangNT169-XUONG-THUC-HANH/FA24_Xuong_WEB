package com.poly.xuong.B5_PhanTrang.response;

import com.poly.xuong.B5_PhanTrang.entity.ChiTietSP;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ChiTietSanPhamResponse {

    private Integer id;

    private String tenMauSac;

    private String tenDongSanPham;

    private String tenNSX;

    private Integer namBaoHanh;

    private String moTa;

    private Integer soLuongTon;

    private Float giaBan;

    private Float giaNhap;

    public ChiTietSanPhamResponse(ChiTietSP ctsp) {
        this.id = ctsp.getId();
        this.namBaoHanh = ctsp.getNamBH();
        this.moTa = ctsp.getMoTa();
        this.soLuongTon = ctsp.getSoLuongTon();
        this.giaBan = ctsp.getGiaBan();
        this.giaNhap = ctsp.getGiaNhap();

        if (ctsp.getIdNsx() != null && ctsp.getIdMauSac() != null && ctsp.getIdDongSP() != null) {
            Hibernate.initialize(ctsp.getIdNsx());
            Hibernate.initialize(ctsp.getIdMauSac());
            Hibernate.initialize(ctsp.getIdDongSP());
            this.tenMauSac = ctsp.getIdMauSac().getTen();
            this.tenDongSanPham = ctsp.getIdDongSP().getTen();
            this.tenNSX = ctsp.getIdNsx().getTen();
        }

    }
}
