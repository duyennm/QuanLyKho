/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanPham;

import java.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import sql.MyLib;

public class BaoCaoSP {

    private String MaSP, TenSP, TenNSX, TenloaiSP, TenQuocGia, NgayNhap, Email;

    public BaoCaoSP() {
    }

    public BaoCaoSP(String MaSP, String TenSP, String TenNSX, String TenloaiSP, String TenQuocGia, String NgayNhap, String Email) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.TenNSX = TenNSX;
        this.TenloaiSP = TenloaiSP;
        this.TenQuocGia = TenQuocGia;
        this.NgayNhap = NgayNhap;
        this.Email = Email;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public void setTenNSX(String TenNSX) {
        this.TenNSX = TenNSX;
    }

    public void setTenloaiSP(String TenloaiSP) {
        this.TenloaiSP = TenloaiSP;
    }

    public void setTenQuocGia(String TenQuocGia) {
        this.TenQuocGia = TenQuocGia;
    }

    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTenSP() {
        return TenSP;
    }

    public String getTenNSX() {
        return TenNSX;
    }

    public String getTenloaiSP() {
        return TenloaiSP;
    }

    public String getTenQuocGia() {
        return TenQuocGia;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public String getMaSP() {
        return MaSP;
    }

    public String getEmail() {
        return Email;
    }

    // --------------------------
    private static ResultSet rs;
    private static Connection cn;

    // khoi tao cn, rs 1 lan duy nhat
    // cho doi tuong dau tien cua lop Batch
    static {
        cn = MyLib.getcn();

        String sql = "select * from SanPham";
        try {
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    public Vector toVector() {

        Vector v = new Vector();

        v.add(TenSP);
        v.add(TenNSX);
        v.add(TenloaiSP);
        v.add(Email);
        v.add(TenQuocGia);
        v.add(NgayNhap);

        return v;

    }

    public ArrayList<BaoCaoSP> getList() {
        ArrayList<BaoCaoSP> ds = new ArrayList<>();

        Connection cn = MyLib.getcn();

        try {
            String sql = "select A.TenSP,A.NgayNhap,B.TenQuocGia,C.TenNSX,C.Email,D.TenLoaiSP from SanPham A,QuocGia B,NSX C,LoaiSanPham D where A.MaQuocGia=b.MaQuocGia and A.MaNSX=C.MaNSX and A.MaLoaiSP=D.MaLoaiSP";
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                BaoCaoSP bc = new BaoCaoSP();

                bc.TenSP = rs.getString(1);
                bc.NgayNhap = rs.getString(2);
                bc.TenQuocGia = rs.getString(3);
                bc.TenNSX = rs.getString(4);
                bc.Email = rs.getString(5);
                bc.TenloaiSP = rs.getString(6);

                ds.add(bc);
            }

            rs.close();
            st.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        }
        return ds;
    }

}
