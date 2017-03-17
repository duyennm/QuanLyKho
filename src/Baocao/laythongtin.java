package Baocao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sql.MyLib;

public class laythongtin {

    int id;
    String hoten;

    public laythongtin() {
    }

    public laythongtin(int id, String hoten) {
        this.id = id;
        this.hoten = hoten;
    }

    public boolean hotenemno(int idd) {
        Connection cn = MyLib.getcn();
        String sql = "Select MaNV,HoTenNV from NhanVien where MaNV = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idd);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
                hoten = rs.getString(2);
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

    public int getId() {
        return id;
    }

    public String getHoten() {
        return hoten;
    }
}
