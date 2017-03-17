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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import sql.MyLib;

public class PhieuNX {

    private String MaPhieu, LoaiPhieu, MaNV, GhiChu;
    private String NgayLap;

    public PhieuNX() {
    }

    public PhieuNX(String MaPhieu, String LoaiPhieu, String MaNV, String GhiChu) {
        this.MaPhieu = MaPhieu;
        this.LoaiPhieu = LoaiPhieu;
        this.MaNV = MaNV;
        this.GhiChu = GhiChu;
    }

    public PhieuNX(String MaPhieu, String LoaiPhieu, String MaNV, String GhiChu, String NgayLap) {
        this.MaPhieu = MaPhieu;
        this.LoaiPhieu = LoaiPhieu;
        this.MaNV = MaNV;
        this.GhiChu = GhiChu;
        this.NgayLap = NgayLap;
    }

    public int insert() {
        int r = 0;
        Connection cn = MyLib.getcn();
        String sql = "insert into PhieuNX(LoaiPhieu,MaNV,GhiChu,NgayLap) values (?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareCall(sql);
            // pst.setString(1, MaPhieu);
            pst.setString(1, LoaiPhieu);
            pst.setString(2, MaNV);
            pst.setString(3, GhiChu);

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            NgayLap = dateFormat.format(date);

            pst.setString(4, NgayLap);
            r = pst.executeUpdate();
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Loi :" + ex.getMessage());
        }
        return r;
    }

    public int update_GhiChu(String maphieu, String ghichu) {
        int r = 1;
        Connection cn = MyLib.getcn();

        try {
            String sql = "update PhieuNX set GhiChu=? where MaPhieu='" + maphieu + "'";
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, ghichu);
            r = pst.executeUpdate();

            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());

            r = 0;
        }

        return r;
    }

    public ArrayList<PhieuNX> getList() {
        ArrayList<PhieuNX> ds = new ArrayList<>();
        Connection cn = MyLib.getcn();
        String sql = "Select * from PhieuNX";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                PhieuNX fk = new PhieuNX();
                fk.MaPhieu = rs.getString(1);
                fk.NgayLap = rs.getString(2);
                fk.LoaiPhieu = rs.getString(3);
                fk.MaNV = rs.getString(4);
                fk.GhiChu = rs.getString(5);
                ds.add(fk);
            }
        } catch (SQLException ex) {
            System.out.println("Loi : " + ex.getMessage());
        }

        return ds;
    }

    public ArrayList<PhieuNX> getIDPhieu() {
        ArrayList<PhieuNX> ds = new ArrayList<>();
        Connection cn = MyLib.getcn();
        String sql = "select top 1  *  from PhieuNX \n"
                + "order by MaPhieu desc";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                PhieuNX fk = new PhieuNX();
                fk.MaPhieu = rs.getString(1);
                ds.add(fk);
            }
        } catch (SQLException ex) {
            System.out.println("Loi : " + ex.getMessage());
        }

        return ds;
    }

    public String getMaPhieu() {
        return MaPhieu;
    }

    public String getLoaiPhieu() {
        return LoaiPhieu;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public Vector toVector() {
        Vector v = new Vector();
        v.add(MaPhieu);
        v.add(LoaiPhieu);
        v.add(MaNV);
        v.add(NgayLap);
        v.add(GhiChu);
        return v;
    }

    public boolean findID(String idd) {
        Connection cn = MyLib.getcn();
        String sql = "Select * From PhieuNX where MaPhieu=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, idd);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                MaPhieu = rs.getString(1);
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

    public int findNhanVien(String idd) {
        Connection cn = MyLib.getcn();
        String sql = "Select * From PhieuNX where MaNV=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, idd);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                MaNV = rs.getString("MaNV");
                rs.close();
                pst.close();
                cn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Loi ID : " + ex.getMessage());
        }

        return 0;
    }
}
