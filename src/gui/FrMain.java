package gui;

import NhanVien.Login;
import NhanVien.NhanVien;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Windows
 */
public class FrMain extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public FrMain() {
        initComponents();
        setLocationRelativeTo(this);
        initRole();
        initModel();
        this.setResizable(false);
        this.setTitle("Quản Lý Kho.     Xin chào, " + new Login().findUser(new FrLogin().id) + " ^^!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grGender = new javax.swing.ButtonGroup();
        grNhapXuat = new javax.swing.ButtonGroup();
        pnMain = new javax.swing.JPanel();
        tbMain = new javax.swing.JTabbedPane();
        pnHomePage = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JLabel();
        txtTenDN = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        txtNgayThamGia = new javax.swing.JLabel();
        cboChucVu = new javax.swing.JComboBox();
        btnCapNhat = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        pnSanPham = new javax.swing.JPanel();
        pnPhieu = new javax.swing.JPanel();
        pnNSX = new javax.swing.JPanel();
        pnNhanVien = new javax.swing.JPanel();
        pnBaocao = new javax.swing.JPanel();
        lbBackGround = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnDangXuat = new javax.swing.JMenuItem();
        mnThoat = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnDoiMatKhau = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnAboutUs = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Kho");
        setPreferredSize(new java.awt.Dimension(950, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnMain.setPreferredSize(new java.awt.Dimension(950, 550));
        pnMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbMain.setBorder(new javax.swing.border.MatteBorder(null));
        tbMain.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tbMain.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbMain.setMinimumSize(new java.awt.Dimension(830, 540));
        tbMain.setRequestFocusEnabled(false);
        tbMain.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbMainStateChanged(evt);
            }
        });

        pnHomePage.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 255)));
        pnHomePage.setMaximumSize(new java.awt.Dimension(550, 550));
        pnHomePage.setMinimumSize(new java.awt.Dimension(550, 550));
        pnHomePage.setPreferredSize(new java.awt.Dimension(727, 500));

        jLabel2.setText("Mã nhân viên:");

        jLabel3.setText("Ngày tham gia:");

        jLabel4.setText("Loại tài khoản:");

        jLabel5.setText("Tên đăng nhập:");

        jLabel6.setText("Họ tên:");

        jLabel7.setText("Địa chỉ:");

        jLabel8.setText("Ngày sinh:");

        jLabel9.setText("Giới tính:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("THÔNG TIN TÀI KHOẢN");

        txtMaNV.setText("MaNV");

        txtTenDN.setText("TenDN");

        txtHoTen.setMaximumSize(new java.awt.Dimension(6, 20));

        txtDiaChi.setMaximumSize(new java.awt.Dimension(6, 20));

        txtNgaySinh.setDateFormatString("yyyy-MM-dd\n");
        txtNgaySinh.setMaxSelectableDate(new java.util.Date(946663309000L));
        txtNgaySinh.setMinSelectableDate(new java.util.Date(631130509000L));

        grGender.add(rdNam);
        rdNam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdNam.setSelected(true);
        rdNam.setText("Nam");
        rdNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNamActionPerformed(evt);
            }
        });

        grGender.add(rdNu);
        rdNu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdNu.setText("Nữ");

        txtNgayThamGia.setText("NgayThamGia");

        cboChucVu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Quản trị", "Nhân viên" }));
        cboChucVu.setEnabled(false);

        btnCapNhat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        jLabel11.setText("Số điện thoại:");

        txtSDT.setMaximumSize(new java.awt.Dimension(6, 20));

        javax.swing.GroupLayout pnHomePageLayout = new javax.swing.GroupLayout(pnHomePage);
        pnHomePage.setLayout(pnHomePageLayout);
        pnHomePageLayout.setHorizontalGroup(
            pnHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHomePageLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(pnHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11))
                .addGap(36, 36, 36)
                .addGroup(pnHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCapNhat)
                    .addGroup(pnHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaNV)
                        .addComponent(txtTenDN)
                        .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnHomePageLayout.createSequentialGroup()
                        .addComponent(rdNam)
                        .addGap(18, 18, 18)
                        .addComponent(rdNu))
                    .addComponent(txtNgayThamGia)
                    .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(243, Short.MAX_VALUE))
        );
        pnHomePageLayout.setVerticalGroup(
            pnHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHomePageLayout.createSequentialGroup()
                .addGroup(pnHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnHomePageLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel2))
                    .addGroup(pnHomePageLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaNV)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenDN)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdNam)
                    .addComponent(rdNu)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNgayThamGia))
                .addGap(9, 9, 9)
                .addGroup(pnHomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCapNhat)
                .addContainerGap(189, Short.MAX_VALUE))
        );

        tbMain.addTab("Trang Chủ        ", new javax.swing.ImageIcon(getClass().getResource("/Image/home.png")), pnHomePage); // NOI18N

        pnSanPham.setBorder(new javax.swing.border.MatteBorder(null));
        pnSanPham.setMaximumSize(new java.awt.Dimension(600, 550));
        pnSanPham.setMinimumSize(new java.awt.Dimension(600, 550));
        pnSanPham.setPreferredSize(new java.awt.Dimension(727, 500));
        pnSanPham.setLayout(new java.awt.BorderLayout());
        tbMain.addTab("Sản phẩm        ", new javax.swing.ImageIcon(getClass().getResource("/Image/product.png")), pnSanPham); // NOI18N

        pnPhieu.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 255)));
        pnPhieu.setMaximumSize(new java.awt.Dimension(670, 550));
        pnPhieu.setMinimumSize(new java.awt.Dimension(670, 550));
        pnPhieu.setPreferredSize(new java.awt.Dimension(727, 500));
        pnPhieu.setLayout(new java.awt.BorderLayout());
        tbMain.addTab("Phiếu                  ", new javax.swing.ImageIcon(getClass().getResource("/Image/rsz_bill.png")), pnPhieu); // NOI18N

        pnNSX.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 255)));
        pnNSX.setMaximumSize(new java.awt.Dimension(670, 550));
        pnNSX.setMinimumSize(new java.awt.Dimension(670, 550));
        pnNSX.setPreferredSize(new java.awt.Dimension(727, 500));
        pnNSX.setLayout(new java.awt.BorderLayout());
        tbMain.addTab("Nhà sản xuất    ", new javax.swing.ImageIcon(getClass().getResource("/Image/factory.png")), pnNSX); // NOI18N

        pnNhanVien.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 255)));
        pnNhanVien.setMaximumSize(new java.awt.Dimension(670, 550));
        pnNhanVien.setMinimumSize(new java.awt.Dimension(670, 550));
        pnNhanVien.setPreferredSize(new java.awt.Dimension(727, 500));
        pnNhanVien.setLayout(new java.awt.BorderLayout());
        tbMain.addTab("Nhân viên       ", new javax.swing.ImageIcon(getClass().getResource("/Image/rsz_administrator.png")), pnNhanVien); // NOI18N

        pnBaocao.setBorder(new javax.swing.border.MatteBorder(null));
        pnBaocao.setLayout(new java.awt.BorderLayout());
        tbMain.addTab("Báo cáo            ", new javax.swing.ImageIcon(getClass().getResource("/Image/Task Report.png")), pnBaocao); // NOI18N

        pnMain.add(tbMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 105, 897, 500));

        lbBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Landscape wallpaper 1920x1080 (3).jpg"))); // NOI18N
        pnMain.add(lbBackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo-poly.png"))); // NOI18N
        jLabel1.setText("         QUẢN LÝ KHO");
        pnMain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 890, 90));

        getContentPane().add(pnMain, java.awt.BorderLayout.LINE_START);

        jMenu1.setText("Hệ Thống");

        mnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logout-512.png"))); // NOI18N
        mnDangXuat.setText("Đăng xuất");
        mnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDangXuatActionPerformed(evt);
            }
        });
        jMenu1.add(mnDangXuat);

        mnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/exit.png"))); // NOI18N
        mnThoat.setText("Thoát");
        mnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnThoatActionPerformed(evt);
            }
        });
        jMenu1.add(mnThoat);

        Menu.add(jMenu1);

        jMenu2.setText("Cài Đặt");

        mnDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/system_config_rootpassword.png"))); // NOI18N
        mnDoiMatKhau.setText("Đổi mật khẩu");
        mnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDoiMatKhauActionPerformed(evt);
            }
        });
        jMenu2.add(mnDoiMatKhau);

        Menu.add(jMenu2);

        jMenu3.setText("Trợ Giúp ");

        mnAboutUs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/the_get_info_icon.png"))); // NOI18N
        mnAboutUs.setText("Thông Tin");
        mnAboutUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAboutUsActionPerformed(evt);
            }
        });
        jMenu3.add(mnAboutUs);

        Menu.add(jMenu3);

        setJMenuBar(Menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDangXuatActionPerformed
        // TODO add your handling code here:
        FrLogin fr = new FrLogin();
        Login l = new Login();
        l.setId(new FrLogin().id);
        l.setTrangthai(0);
        l.updateTrangThai();
        fr.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_mnDangXuatActionPerformed

    private void mnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDoiMatKhauActionPerformed
        // TODO add your handling code here:
        DlChangePass fr = new DlChangePass(this, rootPaneCheckingEnabled);
        fr.setVisible(true);
        fr.setLocationRelativeTo(fr);

    }//GEN-LAST:event_mnDoiMatKhauActionPerformed

    private void mnAboutUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAboutUsActionPerformed
        // TODO add your handling code here:
        DialogAbout about = new DialogAbout(this, rootPaneCheckingEnabled);
        about.setVisible(true);
        about.setLocationRelativeTo(null);
    }//GEN-LAST:event_mnAboutUsActionPerformed

    private void mnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnThoatActionPerformed

        save();
    }//GEN-LAST:event_mnThoatActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_formWindowClosing

    private void tbMainStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbMainStateChanged
        // TODO add your handling code here:
        int index = tbMain.getSelectedIndex();
        int role = FrLogin.role;
        switch (role) {
            case 0:
                // Tab Trang chủ
                if (index == 0) {
                }
                // Tab sản phẩm
                if (index == 1) {
                    pnSanPham.removeAll();
                    pnSanPham.add(new PanelSanPham());
                }
                // Tab Phiếu
                if (index == 2) {
                    pnPhieu.removeAll();
                    pnPhieu.add(new PanelPhieu());
                }
                // Tab NSX
                if (index == 3) {
                    pnNSX.removeAll();
                    pnNSX.add(new PanelNSX());
                }
                // Tab Nhân viên
                if (index == 4) {
                    pnNhanVien.removeAll();
                    pnNhanVien.add(new PanelNhanVien());
                }
                // Tab Báo cáo
                if (index == 5) {
                    pnBaocao.removeAll();
                    pnBaocao.add(new PanelBaocao());
                }
                break;
            case 1:
                // Tab Trang chủ
                if (index == 0) {
                }
                // Tab sản phẩm
                if (index == 1) {
                    pnSanPham.removeAll();
                    pnSanPham.add(new PanelSanPham());
                }
                // Tab Phiếu
                if (index == 2) {
                    pnPhieu.removeAll();
                    pnPhieu.add(new PanelPhieu());
                }
                // Tab NSX
                if (index == 3) {
                    pnNSX.removeAll();
                    pnNSX.add(new PanelNSX());
                }
                // Tab Báo cáo
                if (index == 4) {
                    pnBaocao.removeAll();
                    pnBaocao.add(new PanelBaocao());
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Vui lòng liên hệ admin ");
                break;
        }

    }//GEN-LAST:event_tbMainStateChanged

    private void rdNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdNamActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed

        if (txtHoTen.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không được bỏ trống họ và tên");
            txtHoTen.requestFocus();
            return;
        }
        if (txtDiaChi.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không được bỏ trống địa chỉ");
            txtDiaChi.requestFocus();
            return;
        }

        String ngaysinh = ((JTextField) txtNgaySinh.getDateEditor().getUiComponent()).getText();

        if (ngaysinh.isEmpty() && ngaysinh.trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không được bỏ trống ngày sinh");
            return;
        }
        do {
            Pattern p = null;
            Matcher m = null;
            p = Pattern.compile("^\\d{8,12}$", Pattern.CASE_INSENSITIVE);
            m = p.matcher(txtSDT.getText());
            if (!m.matches()) {
                JOptionPane.showMessageDialog(null, "Nhập sai định dạng của số điện thoại");
                return;
            }
            break;
        } while (true);
        NhanVien nv = new NhanVien(Integer.parseInt(txtMaNV.getText().toString()), txtHoTen.getText(), txtDiaChi.getText().trim(), ngaysinh, txtSDT.getText(), rdNam.isSelected() ? "1" : "0", cboChucVu.getSelectedIndex(), 1);

        if (nv.update() > 0) {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            initModel();
        } else {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Menu;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JComboBox cboChucVu;
    private javax.swing.ButtonGroup grGender;
    private javax.swing.ButtonGroup grNhapXuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JLabel lbBackGround;
    private javax.swing.JMenuItem mnAboutUs;
    private javax.swing.JMenuItem mnDangXuat;
    private javax.swing.JMenuItem mnDoiMatKhau;
    private javax.swing.JMenuItem mnThoat;
    private javax.swing.JPanel pnBaocao;
    private javax.swing.JPanel pnHomePage;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnNSX;
    private javax.swing.JPanel pnNhanVien;
    private javax.swing.JPanel pnPhieu;
    private javax.swing.JPanel pnSanPham;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTabbedPane tbMain;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JLabel txtMaNV;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JLabel txtNgayThamGia;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JLabel txtTenDN;
    // End of variables declaration//GEN-END:variables

    private void initRole() {
        int role = FrLogin.role;
        switch (role) {
            case 0:
                pnSanPham.removeAll();
                pnSanPham.add(new PanelSanPham());
                pnPhieu.removeAll();
                pnPhieu.add(new PanelPhieu());
                pnNSX.removeAll();
                pnNSX.add(new PanelNSX());
                pnNhanVien.removeAll();
                pnNhanVien.add(new PanelNhanVien());
                pnBaocao.removeAll();
                pnBaocao.add(new PanelBaocao());
                break;
            case 1:
                //System.out.println(role);
                pnSanPham.removeAll();
                pnSanPham.add(new PanelSanPham());
                pnPhieu.removeAll();
                pnPhieu.add(new PanelPhieu());
                pnNSX.removeAll();
                pnNSX.add(new PanelNSX());
                pnBaocao.removeAll();
                pnBaocao.add(new PanelBaocao());
                tbMain.remove(4);
                break;
            default:
                tbMain.removeAll();
                Menu.removeAll();
                JOptionPane.showMessageDialog(null, "Vui lòng liên hệ admin ");
                break;
        }
    }

    public void save() {
        JOptionPane.showMessageDialog(this, "Bạn đã đăng xuất khỏi hệ thống?", "Xác nhận", JOptionPane.OK_OPTION);
        Login login = new Login();
        login.setId(new FrLogin().id);
        login.setTrangthai(0);
        login.updateTrangThai();
        System.exit(0);
    }

    private void initModel() {
        NhanVien o = new NhanVien();
        List<NhanVien> list = o.findNhanVien(new FrLogin().id);
        NhanVien nv = list.get(0);
        txtMaNV.setText("" + nv.getID());
        txtTenDN.setText("" + nv.getUser());
        txtHoTen.setText("" + nv.getTen());
        txtDiaChi.setText("" + nv.getDiaChi());
        txtNgayThamGia.setText("" + nv.getNgayvaolam());
        txtSDT.setText("" + nv.getSdt());
        ((JTextField) txtNgaySinh.getDateEditor().getUiComponent()).setText(nv.getNgaysinh());
        if (nv.getGioitinh().toString().equalsIgnoreCase("1")) {
            rdNam.setSelected(true);
        } else {
            rdNu.setSelected(true);
        }
        cboChucVu.setSelectedIndex(nv.getChucvu());
    }
}
