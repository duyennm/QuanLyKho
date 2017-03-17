/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanPham;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import sql.*;

public class Sanpham {

    private String MaSP, TenSP, MaNSX, Mota;
    public String NgayNhap;
    private int TonKho, MaloaiSP, MaQuocGia, gia, TrangThai;

    public int getMaloaiSP() {
        return MaloaiSP;
    }

    public void setMaloaiSP(int MaloaiSP) {
        this.MaloaiSP = MaloaiSP;
    }

    public Sanpham() {
    }

    public Sanpham(String MaSP, String TenSP, String MaNSX, int MaloaiSP, int MaQuocGia, String Mota, String NgayNhap, int TonKho, int gia, int trangthai) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.MaNSX = MaNSX;
        this.MaloaiSP = MaloaiSP;
        this.MaQuocGia = MaQuocGia;
        this.Mota = Mota;
        this.NgayNhap = NgayNhap;
        this.TonKho = TonKho;
        this.gia = gia;
        this.TrangThai = trangthai;
    }

    public Sanpham(String TenSP, String MaNSX, int MaloaiSP, int MaQuocGia, String Mota, String NgayNhap, int TonKho, int gia) {
        this.TenSP = TenSP;
        this.MaNSX = MaNSX;
        this.MaloaiSP = MaloaiSP;
        this.MaQuocGia = MaQuocGia;
        this.Mota = Mota;
        this.NgayNhap = NgayNhap;
        this.TonKho = TonKho;
        this.gia = gia;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public Sanpham(String MaSP) {
        this.MaSP = MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public void setMaNSX(String MaNSX) {
        this.MaNSX = MaNSX;
    }

    public void setMaQuocGia(int MaQuocGia) {
        this.MaQuocGia = MaQuocGia;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public void setTonKho(int TonKho) {
        this.TonKho = TonKho;
    }

    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public String getMaSP() {
        return MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public String getMaNSX() {
        return MaNSX;
    }

    public int getMaQuocGia() {

        return MaQuocGia;
    }

    public String getMota() {
        return Mota;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public int getTonKho() {
        return TonKho;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    // --------------------------
    private static ResultSet rs;
    private static Connection cn;

    // khoi tao cn, rs 1 lan duy nhat
    // cho doi tuong dau tien cua lop Batch
    static {
        Connection cn = MyLib.getcn();

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
        v.add(MaSP);
        v.add(TenSP);
        v.add(MaNSX);
        v.add(MaloaiSP);
        v.add(MaQuocGia);
        v.add(TonKho);
        v.add(NgayNhap);
        v.add(gia);
        v.add(TrangThai);
        v.add(Mota);
        return v;
    }

    public ArrayList<Sanpham> getList() {
        ArrayList<Sanpham> ds = new ArrayList<>();
        Connection cn = MyLib.getcn();
        try {
            String sql = "select * from SanPham";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Sanpham b = new Sanpham();
                b.MaSP = rs.getString(1);
                b.TenSP = rs.getString(2);
                b.MaNSX = rs.getString(3);
                b.MaQuocGia = rs.getInt(4);
                b.MaloaiSP = rs.getInt(5);
                b.Mota = rs.getString(6);
                b.TonKho = rs.getInt(7);
                b.NgayNhap = rs.getString(8);
                b.TrangThai = rs.getInt(9);
                b.gia = rs.getInt(10);
                ds.add(b);
            }
            rs.close();
            st.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        }
        return ds;
    }

    public boolean findname(String iddd) {
        Connection cn = MyLib.getcn();
        String sql = "Select TenSP From SanPham where TenSP=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, iddd);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                TenSP = rs.getString(1);

                rs.close();
                pst.close();
                cn.close();
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Loi ID : " + ex.getMessage());
        }

        return false;
    }

    public boolean findID(String idd) {
        Connection cn = MyLib.getcn();
        String sql = "Select MaSP From SanPham where MaSP=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, idd);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                MaSP = rs.getString(1);

                rs.close();
                pst.close();
                cn.close();
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Loi ID : " + ex.getMessage());
        }

        return false;
    }
    public boolean findMaloaisp(int maloaisp) {
        Connection cn = MyLib.getcn();
        String sql = "Select MaLoaiSP From SanPham where MaLoaiSP=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, maloaisp);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                TenSP = rs.getString(1);

                rs.close();
                pst.close();
                cn.close();
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Loi findMaloaisp : " + ex.getMessage());
        }

        return false;
    }
    public int insert(Sanpham b) {
        int r = 1;
        Connection cn = MyLib.getcn();
        try {
            String sql = "insert into SanPham(TenSP,MaNSX,MaloaiSP,MaQuocGia,MoTa,NgayNhap,TonKho,Gia) values(?,?,?,?,?,?,?,?) ";
            PreparedStatement pst = cn.prepareStatement(sql);
            // 3/fill gia tricua dt b cho cac tham so
            // pst.setString(1, b.MaSP);
            pst.setString(1, b.TenSP);
            pst.setString(2, b.MaNSX);
            pst.setInt(3, b.MaloaiSP);
            pst.setInt(4, b.MaQuocGia);
            pst.setString(5, b.Mota);
            pst.setString(6, b.NgayNhap);
            pst.setInt(7, b.TonKho);
            pst.setInt(8, b.gia);
            r = pst.executeUpdate();

            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());

            r = 0;
        }

        return r;
    }

    public int update(Sanpham b) {
        int r = 1;

        // 1. tao kn -> db
        Connection cn = MyLib.getcn();

        try {
            // 2. tao duoi tuong statement chua linh update

            String sql = "update SanPham set TenSP=?, MaNSX=?, MaLoaiSP=?, MaQuocGia=?, Mota=?, TonKho=?, Gia=?, TrangThai=? where MaSP=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            // 3/fill gia tricua dt b cho cac tham so
            pst.setString(1, b.TenSP);
            pst.setString(2, b.MaNSX);
            pst.setInt(3, b.MaloaiSP);
            pst.setInt(4, b.MaQuocGia);
            pst.setString(5, b.Mota);
            pst.setInt(6, b.TonKho);
            pst.setInt(7, b.gia);
            pst.setInt(8, b.TrangThai);
            pst.setString(9, b.MaSP);

            // 4. thi hanh lenh
            r = pst.executeUpdate();

            // 5. dong cac tai nguyen
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());

            r = 0;
        }

        return r;
    }

    // xoa doi tuong b trong bang tbBatch
    public int delete(Sanpham b) {
        int r = 1;

        // 1. tao kn -> db
        Connection cn = MyLib.getcn();

        try {
            // 2. tao duoi tuong statement chua linh delete
            String sql = "delete from SanPham where MaSP=?";
            PreparedStatement pst = cn.prepareStatement(sql);

            // 3/fill gia tricua dt b cho cac tham so
            pst.setString(1, b.MaSP);

            // 4. thi hanh lenh
            r = pst.executeUpdate();

            // 5. dong cac tai nguyen
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Xoá thất bại, do đã nhập hoặc xuất phiêu");
            System.out.println("Loi delete: " + ex.getMessage());
            //ex.printStackTrace();
            r = 0;
        }

        return r;
    }

    public ArrayList<Sanpham> getListSP_NSX(String idd) {
        ArrayList<Sanpham> ds = new ArrayList<>();

        Connection cn = MyLib.getcn();
        String sql = "Select MaSP,TenSP From SanPham where MaNSX=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, idd);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Sanpham b = new Sanpham();
                b.MaSP = rs.getString(1);
                b.TenSP = rs.getString(2);
                ds.add(b);
            }
            rs.close();
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Loi getListSP_NSX : " + ex.getMessage());
        }
        return ds;
    }
}
