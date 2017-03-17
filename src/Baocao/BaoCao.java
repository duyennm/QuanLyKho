/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Baocao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Logger;
import sql.MyLib;

/**
 *
 * @author Windows
 */
public class BaoCao {

    public int MaSP, MaPhieu;
    public String LoaiPhieu, TenSP, LoaiSP;
    public int countMaSP, countsoluongsp, SoLuong, TonKho;

    public BaoCao() {
    }

    public BaoCao(int MaPhieu, int MaSP, String TenSP, int SoLuong, String LoaiPhieu) {
        this.MaPhieu = MaPhieu;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.LoaiPhieu = LoaiPhieu;
    }

    public int getMaSP() {
        return MaSP;
    }

    public String getLoaiPhieu() {
        return LoaiPhieu;
    }

    public String getTenSP() {
        return TenSP;
    }

    public int getCountMaSP() {
        return countMaSP;
    }

    public int getCountsoluongsp() {
        return countsoluongsp;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public ArrayList<BaoCao> getIDPhieu(String idd) {
        ArrayList<BaoCao> ds = new ArrayList<>();
        ds.clear();
        Connection cn = MyLib.getcn();
        String sql = "select C.MaSP,A.MaPhieu,C.TenSP,A.SoLuong,B.LoaiPhieu,C.TonKho,D.TenLoaiSP from PhieuNXCT A, PhieuNX B,SanPham C,LoaiSanPham D where A.MaSP = ? and A.MaPhieu = B.MaPhieu and A.MaSP = C.MaSP and C.MaLoaiSP = D.MaLoaiSP \n"
                + "order by MaPhieu";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, idd);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                BaoCao fk = new BaoCao();
                fk.MaSP = rs.getInt(1);
                fk.MaPhieu = rs.getInt(2);
                fk.TenSP = rs.getString(3);
                fk.SoLuong = rs.getInt(4);
                fk.LoaiPhieu = rs.getString(5);
                fk.TonKho = rs.getInt(6);
                fk.LoaiSP = rs.getString(7);
                ds.add(fk);
            }
        } catch (SQLException ex) {
            System.out.println("Loi : " + ex.getMessage());
        }

        return ds;
    }

    public ArrayList<BaoCao> getListNew(int idd) {
        ArrayList<BaoCao> ds = new ArrayList<>();
        ds.clear();
        Connection cn = MyLib.getcn();
        String sql = "select A.MaSP,A.MaPhieu,C.TenSP,A.SoLuong,B.LoaiPhieu,C.TonKho,D.TenLoaiSP from PhieuNXCT A, PhieuNX B,SanPham C,LoaiSanPham D where A.MaSP =" + idd + " and (A.MaPhieu = B.MaPhieu) and (A.MaSP = C.MaSP) and C.MaLoaiSP = D.MaLoaiSP GROUP BY A.MaSP,A.MaPhieu,C.TenSP,A.SoLuong,B.LoaiPhieu,C.TonKho,D.TenLoaiSP;";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            //pst.setString(1, idd);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                BaoCao fk = new BaoCao();
                fk.MaSP = rs.getInt(1);
                fk.MaPhieu = rs.getInt(2);
                fk.TenSP = rs.getString(3);
                fk.SoLuong = rs.getInt(4);
                fk.LoaiPhieu = rs.getString(5);
                fk.TonKho = rs.getInt(6);
                fk.LoaiSP = rs.getString(7);
                ds.add(fk);
            }
        } catch (SQLException ex) {
            System.out.println("Loi : " + ex.getMessage());
        }

        return ds;
    }

    public boolean findSoLuongPhieu(int idd) {
        Connection cn = MyLib.getcn();
        String sql = "select count(*) as countma  from PhieuNXCT where MaSP = ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idd);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                MaSP = rs.getInt(1);
                countMaSP = rs.getInt("countma");
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

    public int getMaPhieu() {
        return MaPhieu;
    }
    private static final Logger LOG = Logger.getLogger(BaoCao.class.getName());

    public boolean findSoLuongSP() {
        Connection cn = MyLib.getcn();
        String sql = "select count(*) as countsoluongsp from SanPham ";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                countsoluongsp = rs.getInt("countsoluongsp");
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

    public Vector toVector() {
        Vector v = new Vector();
        v.add(MaSP);
        v.add(MaPhieu);
        v.add(TenSP);
        v.add(SoLuong);
        v.add(LoaiPhieu);
        v.add(TonKho);
        v.add(LoaiSP);
        return v;
    }

    public int updateTonKho(int soluong) {
        try {
            Connection cn = MyLib.getcn();
            String sql = "update SanPham set TonKho =? where MaSP=?";
            PreparedStatement st = cn.prepareCall(sql);
            st.setInt(1, soluong);
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

}
