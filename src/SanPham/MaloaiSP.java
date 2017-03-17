/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SanPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import sql.MyLib;

public class MaloaiSP {

    private String TenLoaiSP;
    private int MaLoaiSP;

    public MaloaiSP() {
    }

    public MaloaiSP(String TenLoaiSP) {
        this.TenLoaiSP = TenLoaiSP;
    }

    public MaloaiSP(String TenLoaiSP, int MaLoaiSP) {
        this.TenLoaiSP = TenLoaiSP;
        this.MaLoaiSP = MaLoaiSP;
    }

    public Vector toVector() {
        Vector v = new Vector();
        v.add(MaLoaiSP);
        v.add(TenLoaiSP);

        return v;
    }

    public ArrayList<MaloaiSP> getList() {
        ArrayList<MaloaiSP> ds = new ArrayList<>();

        Connection cn = MyLib.getcn();

        try {
            String sql = "select * from LoaiSanPham";
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                MaloaiSP m = new MaloaiSP();

                m.MaLoaiSP = rs.getInt(1);
                m.TenLoaiSP = rs.getString(2);

                ds.add(m);
            }

            rs.close();
            st.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        }
        return ds;
    }

    public boolean findID(String idd) {
        Connection cn = MyLib.getcn();
        String sql = "Select TenLoaiSP,MaLoaiSP From LoaiSanPham where TenLoaiSP=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, idd);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                TenLoaiSP = rs.getString(1);
                MaLoaiSP = rs.getInt(2);

                rs.close();
                pst.close();
                cn.close();
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Loi Maloai : " + ex.getMessage());
        }

        return false;
    }

    public int getMaLoaiSP() {
        return MaLoaiSP;
    }

    public String getTenLoaiSP() {
        return TenLoaiSP;
    }
    public int insertMaLoaiSP(MaloaiSP loaisp) {
        int r = 1;
        Connection cn = MyLib.getcn();
        try {
            String sql = "insert LoaiSanPham values(?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, TenLoaiSP);

            r = pst.executeUpdate();

            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Loi insertMaLoaiSP: " + ex.getMessage());
            r = 0;
        }
        return r;
    }
    
    public int update(MaloaiSP loaisp) {
        int r = 1;
        Connection cn = MyLib.getcn();
        try {
            String sql = "update LoaiSanPham set TenLoaiSP=? where MaLoaiSP=?";
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, loaisp.TenLoaiSP);
            pst.setInt(2, loaisp.MaLoaiSP);
            
            r = pst.executeUpdate();

            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Loi updateMaloaisp: " + ex.getMessage());
            r = 0;
        }
        return r;
    }
    
    public boolean findname(String iddd) {
        Connection cn = MyLib.getcn();
        String sql = "Select TenLoaiSP From LoaiSanPham where TenLoaiSP=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, iddd);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                TenLoaiSP = rs.getString(1);

                rs.close();
                pst.close();
                cn.close();
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Loi findname Maloaisp: " + ex.getMessage());
        }

        return false;
    }
    
    public int delete(MaloaiSP b) {
        int r = 1;
        Connection cn = MyLib.getcn();

        try {
            String sql = "delete from LoaiSanPham where MaLoaiSP=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, b.MaLoaiSP);
            r = pst.executeUpdate();
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Loi delete: " + ex.getMessage());
            r = 0;
        }
        return r;
    }
}
