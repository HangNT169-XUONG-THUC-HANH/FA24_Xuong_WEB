package com.poly.xuong.B3_4_JoinTable.response;

import com.poly.xuong.B3_4_JoinTable.entity.NhanVien;
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
public class NhanVienResponse {

    private Integer id;

    private String ma;

    private String ho;

    private String tenDem;

    private String ten;

    private String gioiTinh;

    private String diaChi;

    private String sdt;

    private Integer chucVuID;

    private String tenChucVu;

    public NhanVienResponse(NhanVien nv) {
        this.id = nv.getId();
        this.ma = nv.getMa();
        this.ho = nv.getHo();
        this.ten = nv.getTen();
        this.tenDem = nv.getTenDem();
        this.gioiTinh = nv.getGioiTinh();
        this.diaChi = nv.getDiaChi();
        this.sdt = nv.getSdt();
        if (nv.getChucVu() != null) {
            Hibernate.initialize(nv.getChucVu());
            this.chucVuID = nv.getChucVu().getId();
            this.tenChucVu = nv.getChucVu().getTen();
        }
    }

    public String getHoVaTen() {
        return this.ho + " " + this.tenDem + " " + this.ten;
    }
}
