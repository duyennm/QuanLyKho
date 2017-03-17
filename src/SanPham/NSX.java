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
import javax.swing.JOptionPane;
import sql.MyLib;

public class NSX {

    private int MaNSX;
    private String TenNSX, Email, Website, logo;

    public NSX() {
    }

    public NSX(int MaNSX, String TenNSX, String Email, String Website, String logo) {
        this.MaNSX = MaNSX;
        this.TenNSX = TenNSX;
        this.Email = Email;
        this.Website = Website;
        this.logo = logo;
    }

    public NSX(String TenNSX, String Email, String Website, String logo) {
        this.TenNSX = TenNSX;
        this.Email = Email;
        this.Website = Website;
        this.logo = logo;
    }
    // --------------------------
    private static ResultSet rs;
    private static Connection cn;

    // khoi tao cn, rs 1 lan duy nhat
    // cho doi tuong dau tien cua lop Batch
    static {
        cn = MyLib.getcn();

        String sql = "select * from NSX";
        try {
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }
    //////////

    public void setMaNSX(int MaNSX) {
        this.MaNSX = MaNSX;
    }

    public void setTenNSX(String TenNSX) {
        this.TenNSX = TenNSX;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setWebsite(String Website) {
        this.Website = Website;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getMaNSX() {
        return MaNSX;
    }

    public String getTenNSX() {
        return TenNSX;
    }

    public String getEmail() {
        return Email;
    }

    public String getWebsite() {
        return Website;
    }

    public String getLogo() {
        return logo;
    }

    ////////
    public ArrayList<NSX> getList() {
        ArrayList<NSX> ds = new ArrayList<>();

        Connection cn = MyLib.getcn();

        try {
            String sql = "select * from NSX";
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                NSX b = new NSX();

                b.MaNSX = rs.getInt(1);
                b.TenNSX = rs.getString(2);
                b.Email = rs.getString(3);
                b.Website = rs.getString(4);
                b.logo = rs.getString(5);

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

    public Vector toVector() {
        Vector v = new Vector();

        v.add(MaNSX);
        v.add(TenNSX);
        v.add(Email);
        v.add(Website);
        v.add(logo);

        return v;
    }

    public boolean findID(String idd) {
        Connection cn = MyLib.getcn();
        String sql = "Select TenNSX,MaNSX From NSX where TenNSX=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, idd);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                TenNSX = rs.getString(1);
                MaNSX = rs.getInt(2);
                rs.close();
                pst.close();
                cn.close();
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Loi NSX : " + ex.getMessage());
        }

        return false;
    }

    public boolean findma(String idd) {
        Connection cn = MyLib.getcn();
        String sql = "Select MaNSX From NSX where MaNSX=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, idd);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                MaNSX = rs.getInt(1);

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

    public boolean findten(String iddd) {
        Connection cn = MyLib.getcn();
        String sql = "Select TenNSX From NSX where TenNSX=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, iddd);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                TenNSX = rs.getString(1);

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

    public int insert(NSX n) {
        int r = 1;
        Connection cn = MyLib.getcn();
        try {
            String sql = "insert NSX values(?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            //pst.setString(1, MaNSX);
            pst.setString(1, TenNSX);
            pst.setString(2, Email);
            pst.setString(3, Website);
            pst.setString(4, logo);

            r = pst.executeUpdate();

            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());

            r = 0;
        }

        return r;
    }

    public int update(NSX n) {
        int r = 1;
        // 1. tao kn -> db
        Connection cn = MyLib.getcn();

        try {
            // 2. tao duoi tuong statement chua linh update
            String sql = "update NSX set TenNSX=?, Email=?, Website=?, Logo=? where MaNSX=?";
            PreparedStatement pst = cn.prepareStatement(sql);

            // 3/fill gia tricua dt b cho cac tham so
            pst.setString(1, n.TenNSX);
            pst.setString(2, n.Email);
            pst.setString(3, n.Website);
            pst.setString(4, n.logo);
            pst.setInt(5, n.MaNSX);

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

    public int delete(NSX n) {
        int r = 1;

        // 1. tao kn -> db
        Connection cn = MyLib.getcn();

        try {

            // 2. tao duoi tuong statement chua linh delete
            String sql = "delete from NSX where MaNSX=?";
            PreparedStatement pst = cn.prepareStatement(sql);

            // 3/fill gia tricua dt b cho cac tham so
            pst.setInt(1, n.MaNSX);

            // 4. thi hanh lenh
            r = pst.executeUpdate();

            // 5. dong cac tai nguyen
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Đã nhập mặt hàng từ "+n.TenNSX);
            //System.out.println("Loi: " + ex.getMessage());
            //ex.printStackTrace();
            r = 0;
        }

        return r;
    }
}
