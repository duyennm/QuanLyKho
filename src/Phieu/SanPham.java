/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Phieu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import sql.MyLib;

/**
 *
 * @author Windows
 */
public class SanPham {

    private int MaSP;
    private String TenSP;
    private int TonKho;
    private String TenLoaiSP;
    private int TrangThai;
    public SanPham() {
    }

    public SanPham(int MaSP, String TenSP, String TenNSX, int TonKho) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.TonKho = TonKho;
    }

    public ArrayList<SanPham> getList() {
        ArrayList<SanPham> ds = new ArrayList<>();
        ds.clear();
        Connection cn = MyLib.getcn();
        String sql = "select MaSP,TenSP,TonKho,TrangThai from SanPham";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                SanPham fk = new SanPham();
                fk.MaSP = rs.getInt(1);
                fk.TenSP = rs.getString(2);
                fk.TonKho = rs.getInt(3);
                fk.TrangThai = rs.getInt(4);
                if (fk.TrangThai <= 1) {
                    ds.add(fk);
                }
                
            }
        } catch (SQLException ex) {
            System.out.println("Loi : " + ex.getMessage());
        }

        return ds;
    }

    public int update() {
        try {
            Connection cn = MyLib.getcn();
            String sql = "update SanPham set TonKho =? where MaSP=?";
            PreparedStatement st = cn.prepareCall(sql);
            st.setInt(1, TonKho);
            st.setInt(2, MaSP);
            int n = st.executeUpdate();
            st.close();
            cn.close();
            return n;
        } catch (SQLException ex) {
            System.out.println("Loi : " + ex.getMessage());
        }

        return 0;
    }

    public int getMaSP() {
        return MaSP;
    }

    public String getTenSP() {
        return TenSP;
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

    public ArrayList<SanPham> getLoaiSP() {
        ArrayList<SanPham> ds = new ArrayList<>();
        Connection cn = MyLib.getcn();
        String sql = "Select TenLoaiSP from LoaiSanPham";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                SanPham fk = new SanPham();
                fk.TenLoaiSP = rs.getString(1);
                ds.add(fk);
            }
        } catch (SQLException ex) {
            System.out.println("Loi : " + ex.getMessage());
        }

        return ds;
    }

    public Vector toVector() {
        Vector v = new Vector();
        v.add(MaSP);
        v.add(TenSP);
        v.add(TonKho);
        v.add(TenLoaiSP);
        return v;
    }
}
