package com.poly.xuong.B3_4_JoinTable.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class NhanVienRequest {

    private Integer id;

    private String ma;

    private String ho;
    private String tenDem;
    private String ten;

    private String gioiTinh;

    private String diaChi;

    private String sdt;

    private Integer chucVuID;

}
