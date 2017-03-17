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
import sql.MyLib;

public class Quocgia {

    private String TenQuocGia;
    private int MaQuocGia;

    public Quocgia() {
    }

    public Quocgia(String TenQuocGia, int MaQuocGia) {
        this.TenQuocGia = TenQuocGia;
        this.MaQuocGia = MaQuocGia;
    }

    public Vector toVector() {
        Vector v = new Vector();
        v.add(MaQuocGia);
        v.add(TenQuocGia);

        return v;
    }

    public ArrayList<Quocgia> getList() {
        ArrayList<Quocgia> ds = new ArrayList<>();

        Connection cn = MyLib.getcn();

        try {
            String sql = "select * from QuocGia";
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Quocgia qg = new Quocgia();

                qg.MaQuocGia = rs.getInt(1);
                qg.TenQuocGia = rs.getString(2);

                ds.add(qg);
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
        String sql = "Select TenQuocGia,MaQuocGia From QuocGia where TenQuocGia=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, idd);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                TenQuocGia = rs.getString(1);
                MaQuocGia = rs.getInt(2);

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

    public String getTenQuocGia() {
        return TenQuocGia;
    }

    public int getMaQuocGia() {
        return MaQuocGia;
    }

    public void setTenQuocGia(String TenQuocGia) {
        this.TenQuocGia = TenQuocGia;
    }

    public void setMaQuocGia(int MaQuocGia) {
        this.MaQuocGia = MaQuocGia;
    }

}
