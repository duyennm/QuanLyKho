/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sql.MyLib;

/**
 *
 * @author Windows
 */
public class Login {

    String user;
    String pass;
    String Hoten;
    int id;
    int role;
    int trangthai;

    public Login(String user, String pass, int id, int role, int trangthai) {
        this.user = user;
        this.pass = pass;
        this.id = id;
        this.role = role;
        this.trangthai = trangthai;
    }

    public Login() {
    }

    public int isAuthentication(String usr, String pas) {
        Connection cn = MyLib.getcn();
        String sql = "Select TenDN,MatKhau,MaNV,QuanTri,TrangThai From NhanVien where TenDN=? AND MatKhau=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, usr);
            pst.setString(2, pas);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                user = rs.getString(1);
                pass = rs.getString(2);
                id = rs.getInt(3);
                role = rs.getInt(4);
                trangthai = rs.getInt(5);
                if (trangthai == 1) {
                    return 2;
                }

                return 1;

            }
            return 0;
        } catch (SQLException ex) {
            System.out.println("Loi Dang nhap: " + ex.getMessage());
        }
        return 0;
    }

    public int update() {
        int r = 0;
        Connection cn = MyLib.getcn();
        String sql = "Update NhanVien set MatKhau=? where MaNV=?";
        try {
            PreparedStatement pst = cn.prepareCall(sql);
            pst.setString(1, pass);
            pst.setInt(2, id);
            r = pst.executeUpdate();
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Loi :" + ex.getMessage());
        }
        return r;
    }

    public String findUser(int idd) {
        Connection cn = MyLib.getcn();
        String sql = "Select HoTenNV From NhanVien where MaNV=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idd);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Hoten = rs.getString(1);
                rs.close();
                pst.close();
                cn.close();
                return Hoten;
            }
        } catch (SQLException ex) {
            System.out.println("Loi ID : " + ex.getMessage());
        }
        return "";
    }

    public int updateTrangThai() {
        int r = 0;
        Connection cn = MyLib.getcn();
        String sql = "Update NhanVien set TrangThai=? where MaNV=?";
        try {
            PreparedStatement pst = cn.prepareCall(sql);
            pst.setInt(1, trangthai);
            pst.setInt(2, id);
            r = pst.executeUpdate();
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Loi updateTrangThai():" + ex.getMessage());
        }
        return r;
    }

    public int getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public int getRole() {
        return role;
    }

    public String getUser() {
        return user;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

}
