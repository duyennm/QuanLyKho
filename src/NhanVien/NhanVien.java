package NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import sql.MyLib;

public class NhanVien {

    int id;
    String user, ten, diachi, ngaysinh, sdt, gioitinh, ngayvaolam;
    int chucvu, trangthai;

    public NhanVien() {
    }

    public NhanVien(String user, String ten, String diachi, String ngaysinh, String sdt, String gioitinh, int chucvu, String ngayvaolam, int trangthai) {
        this.user = user;
        this.ten = ten;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.chucvu = chucvu;
        this.ngayvaolam = ngayvaolam;
        this.trangthai = trangthai;
    }

    public NhanVien(String user, String ten, String diachi, String ngaysinh, String sdt, String gioitinh, int chucvu, int trangthai) {
        this.user = user;
        this.ten = ten;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.chucvu = chucvu;
        this.trangthai = trangthai;
    }

    public NhanVien(int id, String ten, String diachi, String ngaysinh, String sdt, String gioitinh, int chucvu, int trangthai) {
        this.id = id;
        this.ten = ten;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.chucvu = chucvu;
        this.trangthai = trangthai;
    }

    public boolean findID(String idd) {
        Connection cn = MyLib.getcn();
        String sql = "Select MaNV, TenDN From NhanVien where MaNV=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, idd);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
                user = rs.getString(2);
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

    

    public int insert() {
        int r = 0;
        Connection cn = MyLib.getcn();
        String sql = "Insert into NhanVien(TenDN,HoTenNV,NgaySinh,DiaChi,SDT,GioiTinh,QuanTri,MatKhau,NgayVaoLam) values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareCall(sql);
            //pst.setInt(1, id);
            pst.setString(1, user);
            pst.setString(2, ten);
            pst.setString(3, ngaysinh);
            pst.setString(4, diachi);
            pst.setString(5, sdt);
            pst.setString(6, gioitinh);
            pst.setInt(7, chucvu);
            pst.setString(8, user);
            pst.setString(9, ngayvaolam);
            r = pst.executeUpdate();
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int update() {
        int r = 0;
        Connection cn = MyLib.getcn();
        String sql = "Update NhanVien set HoTenNV=?, NgaySinh=?, DiaChi=?, SDT=?, QuanTri=?, TrangThai=?,GioiTinh=?  where MaNV=?";
        try {
            PreparedStatement pst = cn.prepareCall(sql);

            pst.setString(1, ten);
            pst.setString(2, ngaysinh);
            pst.setString(3, diachi);
            pst.setString(4, sdt);
            pst.setInt(5, chucvu);
            pst.setInt(6, trangthai);
            pst.setString(7, gioitinh);
            pst.setInt(8, id);
            r = pst.executeUpdate();
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
        return r;
    }

    public Vector toVector() {
        Vector v = new Vector();
        v.add(id);
        v.add(user);
        v.add(ten);
        v.add(diachi);
        v.add(ngaysinh);
        v.add(gioitinh);
        v.add(sdt);
        v.add(chucvu);
        v.add(ngayvaolam);
        v.add(trangthai);
        return v;
    }

    public ArrayList<NhanVien> getList() {
        ArrayList<NhanVien> ds = new ArrayList<>();
        Connection cn = MyLib.getcn();
        String sql = "Select MaNV, TenDN, HoTenNV, NgaySinh, DiaChi, SDT, GioiTinh, QuanTri, NgayVaoLam, TrangThai From NhanVien";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                NhanVien fk = new NhanVien();
                fk.id = rs.getInt(1);
                fk.user = rs.getString(2);
                fk.ten = rs.getString(3);
                fk.ngaysinh = rs.getString(4);
                fk.diachi = rs.getString(5);
                fk.sdt = rs.getString(6);
                fk.gioitinh = rs.getString(7);
                fk.chucvu = rs.getInt(8);
                fk.ngayvaolam = rs.getString(9);
                fk.trangthai = rs.getInt(10);
                ds.add(fk);
            }
        } catch (SQLException ex) {
            System.out.println("Loi : " + ex.getMessage());
        }
        return ds;
    }
    public boolean findUser(String idd) {
        Connection cn = MyLib.getcn();
        String sql = "Select TenDN From NhanVien where TenDN=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, idd);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                user = rs.getString(1);
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
    public ArrayList<NhanVien> findNhanVien(int id) {
        ArrayList<NhanVien> ds = new ArrayList<>();
        Connection cn = MyLib.getcn();
        String sql = "Select MaNV, TenDN, HoTenNV, NgaySinh, DiaChi, SDT, GioiTinh, QuanTri, NgayVaoLam, TrangThai From NhanVien where MaNV=?";
        Statement st;
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                NhanVien fk = new NhanVien();
                fk.id = rs.getInt(1);
                fk.user = rs.getString(2);
                fk.ten = rs.getString(3);
                fk.ngaysinh = rs.getString(4);
                fk.diachi = rs.getString(5);
                fk.sdt = rs.getString(6);
                fk.gioitinh = rs.getString(7);
                fk.chucvu = rs.getInt(8);
                fk.ngayvaolam = rs.getString(9);
                fk.trangthai = rs.getInt(10);
                ds.add(fk);
            }
        } catch (SQLException ex) {
            System.out.println("Loi : " + ex.getMessage());
        }
        return ds;
    }
    public int getID() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diachi;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgayvaolam() {
        return ngayvaolam;
    }

    public void setNgayvaolam(String ngayvaolam) {
        this.ngayvaolam = ngayvaolam;
    }

    public int getChucvu() {
        return chucvu;
    }

    public void setChucvu(int chucvu) {
        this.chucvu = chucvu;
    }

    public int delete(int idd) {
        int r = 0;
        Connection cn = MyLib.getcn();
        String sql = "Delete from NhanVien where MaNV=?";
        try {
            PreparedStatement pst = cn.prepareCall(sql);
            pst.setInt(1, idd);
            r = pst.executeUpdate();
            pst.close();
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Loi : " + ex.getMessage());
        }
        return r;
    }
}
