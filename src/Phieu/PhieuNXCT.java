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
import java.util.logging.Level;
import java.util.logging.Logger;
import sql.MyLib;

public class PhieuNXCT {

    private String MaPhieu, MaSP, TenSP, GhiChu;
    private int SoLuong;

    public PhieuNXCT() {
    }

    public PhieuNXCT(String MaPhieu, String MaSP, int SoLuong) {
        this.MaPhieu = MaPhieu;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
    }

    public PhieuNXCT(String MaPhieu, String MaSP, int SoLuong, String GhiChu) {
        this.MaPhieu = MaPhieu;
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
        this.GhiChu = GhiChu;
    }

    public PhieuNXCT(String MaSP, int SoLuong) {
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
    }

    /* public int insert2() {
        int r = 0;
        Connection cn = MyLib.getcn();
        String sql = "Insert into PhieuNXCT (MaPhieu,MaSP,SoLuong,GhiChu) values(SCOPE_IDENTITY(),?,?,?)";
        try {
            PreparedStatement pst = cn.prepareCall(sql);
           // pst.setString(1, MaPhieu);
            pst.setString(1, MaSP);
            pst.setInt(2, SoLuong);
            pst.setString(3, GhiChu);
            r = pst.executeUpdate();
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Loi :" + ex.getMessage());
        }
        return r;
    }*/
    public int insert() {
        int r = 0;
        Connection cn = MyLib.getcn();
        String sql = "Insert into PhieuNXCT (MaPhieu,MaSP,SoLuong,GhiChu) values(IDENT_CURRENT( 'PhieuNX' ) ,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareCall(sql);
            pst.setString(1, MaSP);
            pst.setInt(2, SoLuong);
            pst.setString(3, GhiChu);
            r = pst.executeUpdate();
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Loi :" + ex.getMessage());
        }
        return r;
    }

    public int update(String maphieu, String masp, int soluong) {
        int r = 1;
        Connection cn = MyLib.getcn();

        try {
            String sql = "update PhieuNXCT set SoLuong=? where MaPhieu='" + maphieu + "' and MaSP='" + masp + "'";
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, soluong);
            r = pst.executeUpdate();

            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());

            r = 0;
        }

        return r;
    }

    public ArrayList<PhieuNXCT> getList(String idd) {
        ArrayList<PhieuNXCT> ds = new ArrayList<>();
        ds.clear();
        Connection cn = MyLib.getcn();
        String sql = "select A.MaPhieu,A.MaSP,B.TenSP,A.SoLuong\n"
                + "from PhieuNXCT A, SanPham B\n"
                + "where A.MaSP = B.MaSP\n"
                + "and MaPhieu =?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, idd);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                PhieuNXCT fk = new PhieuNXCT();
                fk.MaPhieu = rs.getString(1);
                fk.MaSP = rs.getString(2);
                fk.TenSP = rs.getString(3);
                fk.SoLuong = rs.getInt(4);

                ds.add(fk);
            }
        } catch (SQLException ex) {
            System.out.println("Loi : " + ex.getMessage());
        }

        return ds;
    }

    public boolean findmasp(String idd) {
        Connection cn = MyLib.getcn();
        String sql = "Select MaSP From PhieuNXCT where MaSP=?";
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
            // System.out.println("Loi ID : " + ex.getMessage());
        }

        return false;
    }

    public Vector toVector() {
        Vector v = new Vector();
        v.add(MaSP);
        v.add(TenSP);
        v.add(SoLuong);
        return v;
    }

    public int delete(String maphieu) {
        int r = 1;
        Connection cn = MyLib.getcn();

        try {
            String sql = "delete from PhieuNXCT where MaPhieu=?";
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, maphieu);
            r = pst.executeUpdate();

            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());

            r = 0;
        }

        return r;
    }

    public String getMaPhieu() {
        return MaPhieu;
    }

    public void setMaPhieu(String MaPhieu) {
        this.MaPhieu = MaPhieu;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

}
