/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import NhanVien.NhanVien;
import Phieu.PhieuNX;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class PanelNhanVien extends javax.swing.JPanel {

    //String MaNV;
    /**
     * Creates new form PanelNhanVien
     */
    public PanelNhanVien() {
        initComponents();
        init();
        filldatafromtable();
        txtMaNV.setVisible(false);
       // btnCapNhatNV.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpGioiTinh = new javax.swing.ButtonGroup();
        pnNhanVien = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grNhanVien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnThemNV = new javax.swing.JButton();
        btnCapNhatNV = new javax.swing.JButton();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        txtTenDN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboTrangThai = new javax.swing.JComboBox();
        txtMaNV = new javax.swing.JTextField();
        txtNgayVaoLam = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        cboChucVu = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        pnNhanVien.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 255)));
        pnNhanVien.setMaximumSize(new java.awt.Dimension(670, 550));
        pnNhanVien.setMinimumSize(new java.awt.Dimension(670, 550));
        pnNhanVien.setPreferredSize(new java.awt.Dimension(727, 500));

        grNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Tên đăng nhập", "Họ và tên", "Địa chỉ", "Ngày sinh", "Giới tính", "SDT", "Chức vụ", "Ngày vào làm", "Online"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(grNhanVien);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Họ và tên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Giới tính");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Số điện thoại");

        txtTen.setEnabled(false);
        txtTen.setMaximumSize(new java.awt.Dimension(6, 20));

        txtSDT.setEnabled(false);
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Ngày sinh");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Địa chỉ");

        btnThemNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThemNV.setText("Thêm");
        btnThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNVActionPerformed(evt);
            }
        });

        btnCapNhatNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCapNhatNV.setText("Cập nhật");
        btnCapNhatNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatNVActionPerformed(evt);
            }
        });

        grpGioiTinh.add(rdNam);
        rdNam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdNam.setSelected(true);
        rdNam.setText("Nam");
        rdNam.setEnabled(false);
        rdNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNamActionPerformed(evt);
            }
        });

        grpGioiTinh.add(rdNu);
        rdNu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdNu.setText("Nữ");
        rdNu.setEnabled(false);

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        txtDiaChi.setEnabled(false);
        jScrollPane4.setViewportView(txtDiaChi);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Tên đăng nhập");

        txtTenDN.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Trạng thái:");

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Offline", "Online", "Tài khoản đã xóa" }));
        cboTrangThai.setEnabled(false);

        txtMaNV.setEnabled(false);

        txtNgayVaoLam.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Ngày vào làm");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Huỷ bỏ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtNgaySinh.setDateFormatString("yyyy-MM-dd\n");
        txtNgaySinh.setEnabled(false);
        txtNgaySinh.setMaxSelectableDate(new java.util.Date(946663309000L));
        txtNgaySinh.setMinSelectableDate(new java.util.Date(631130509000L));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Xoá");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cboChucVu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Quản trị", "Nhân viên" }));
        cboChucVu.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Chức vụ");

        javax.swing.GroupLayout pnNhanVienLayout = new javax.swing.GroupLayout(pnNhanVien);
        pnNhanVien.setLayout(pnNhanVienLayout);
        pnNhanVienLayout.setHorizontalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE))
            .addGroup(pnNhanVienLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel2))
                .addGap(5, 5, 5)
                .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnNhanVienLayout.createSequentialGroup()
                        .addComponent(btnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCapNhatNV)
                        .addGap(12, 12, 12)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(pnNhanVienLayout.createSequentialGroup()
                        .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnNhanVienLayout.createSequentialGroup()
                                .addComponent(rdNam)
                                .addGap(18, 18, 18)
                                .addComponent(rdNu))
                            .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cboTrangThai, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
                        .addGap(59, 59, 59)
                        .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnNhanVienLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnNhanVienLayout.createSequentialGroup()
                                .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnNhanVienLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(62, 62, 62)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnNhanVienLayout.createSequentialGroup()
                                        .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnNhanVienLayout.setVerticalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(pnNhanVienLayout.createSequentialGroup()
                        .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18))
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtNgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdNam)
                            .addComponent(jLabel4)
                            .addComponent(rdNu)
                            .addComponent(jLabel3)
                            .addComponent(cboChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnNhanVienLayout.createSequentialGroup()
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)))
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemNV)
                    .addComponent(btnCapNhatNV)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void grNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grNhanVienMouseClicked
        setnullfield();
        filldatafromtable();
    }//GEN-LAST:event_grNhanVienMouseClicked

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void btnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNVActionPerformed

        if (btnThemNV.getText() == "Thêm") {
            setnullfield();
            btnThemNV.setText("Lưu");
            btnCapNhatNV.setEnabled(false);  // Cap nhat
            txtMaNV.setEnabled(false);
            txtTenDN.setEnabled(true);
            txtTen.setEnabled(true);
            txtSDT.setEnabled(true);
            txtNgaySinh.setEnabled(true);
            txtDiaChi.setEnabled(true);
            rdNam.setEnabled(true);
            rdNu.setEnabled(true);
            cboTrangThai.setEnabled(true);
            cboChucVu.setEnabled(true);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            txtNgayVaoLam.setText(sdf.format(date));

            NhanVien nv = new NhanVien();
           
        } else {
            NhanVien pnx = new NhanVien();
            pnx.findID(txtMaNV.getText().trim());

            pnx.findUser(txtTenDN.getText().trim());
            if (txtTenDN.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Không được bỏ trống tên đăng nhập");
                txtTenDN.requestFocus();
                return;
            }
            if (!txtTenDN.getText().trim().matches("[a-zA-Z0-9]+")) {
                JOptionPane.showMessageDialog(null, "Tên đăng nhập chỉ được là chữ cái và số");
                return;
            }
            if (pnx.findUser(txtTenDN.getText().toString())) {
                JOptionPane.showMessageDialog(null, "Tên đăng nhập đã tồn tại");
                return;
            }

            if (txtTen.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Không được bỏ trống họ và tên");
                txtTen.requestFocus();
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
            String ngaysinh = ((JTextField) txtNgaySinh.getDateEditor().getUiComponent()).getText();

            if (ngaysinh.isEmpty() && ngaysinh.trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Không được bỏ trống ngày sinh");
                return;
            }
            if (txtDiaChi.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Không được bỏ trống địa chỉ");
                txtDiaChi.requestFocus();
                return;
            }
            NhanVien fal = new NhanVien(txtTenDN.getText(), txtTen.getText(), txtDiaChi.getText().trim(), ngaysinh, txtSDT.getText(), rdNam.isSelected() ? "1" : "0", cboTrangThai.getSelectedIndex(), txtNgayVaoLam.getText(), 0);
            if (fal.insert() > 0) {
                setnullfield();
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                model.setRowCount(0);
                init();
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại");
            }
            btnCapNhatNV.setEnabled(true);  // Cap nhat
            txtMaNV.setEnabled(false);
            txtTenDN.setEnabled(false);
            txtTen.setEnabled(false);
            txtSDT.setEnabled(false);
            txtNgaySinh.setEnabled(false);
            txtDiaChi.setEnabled(false);
            txtNgayVaoLam.setEnabled(false);
            cboChucVu.setEnabled(false);
            cboTrangThai.setEnabled(false);
            rdNam.setEnabled(false);
            rdNu.setEnabled(false);
            btnThemNV.setText("Thêm");
        }
    }//GEN-LAST:event_btnThemNVActionPerformed

    private void btnCapNhatNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatNVActionPerformed
        if (grNhanVien.getSelectedRow() >= 0) {
            if (txtMaNV.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Có lỗi trong lúc chọn dòng vui lòng chọn lại");
                return;
            }
            if (btnCapNhatNV.getText() == "Cập nhật") {
                btnCapNhatNV.setText("Lưu");
                btnThemNV.setEnabled(false);
                txtMaNV.setEnabled(false);
                txtTen.setEnabled(true);
                txtSDT.setEnabled(true);
                txtNgaySinh.setEnabled(true);
                txtDiaChi.setEnabled(true);
                txtNgayVaoLam.setEnabled(true);
                rdNam.setEnabled(true);
                rdNu.setEnabled(true);
                cboChucVu.setEnabled(true);
                cboTrangThai.setEnabled(true);
              //  System.out.println("gui.PanelNhanVien.btnCapNhatNVActionPerformed()"+ txtMaNV.getText().toString());
            } else {
                if (txtMaNV.getText().trim().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Không được bỏ trống mã nhân viên");
                    txtMaNV.requestFocus();
                    return;
                }
                if (txtTenDN.getText().trim().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Không được bỏ trống tên đăng nhập");
                    txtTenDN.requestFocus();
                    return;
                }
                if (txtTen.getText().trim().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Không được bỏ trống họ và tên");
                    txtTen.requestFocus();
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
                String ngaysinh = ((JTextField) txtNgaySinh.getDateEditor().getUiComponent()).getText();

                if (ngaysinh.isEmpty() && ngaysinh.trim().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Không được bỏ trống ngày sinh");
                    return;
                }
                if (txtDiaChi.getText().trim().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Không được bỏ trống địa chỉ");
                    txtDiaChi.requestFocus();
                    return;
                }
                
                NhanVien nv = new NhanVien(Integer.parseInt(txtMaNV.getText().toString()), txtTen.getText(), txtDiaChi.getText().trim(), ngaysinh, txtSDT.getText(), rdNam.isSelected() ? "1" : "0", cboChucVu.getSelectedIndex(), cboTrangThai.getSelectedIndex());

                if (nv.update() > 0) {
                    setnullfield();
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                    model.setRowCount(0);
                    init();
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
                }
                btnThemNV.setEnabled(true);
                rdNam.setEnabled(false);
                rdNu.setEnabled(false);
                cboChucVu.setEnabled(false);
                cboTrangThai.setEnabled(false);
                txtTenDN.setEnabled(false);
                txtTen.setEnabled(false);
                txtSDT.setEnabled(false);
                txtNgaySinh.setEnabled(false);
                txtDiaChi.setEnabled(false);
                txtNgayVaoLam.setEnabled(false);
                btnCapNhatNV.setText("Cập nhật");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Chưa chọn dòng nào");
            return;
        }
    }//GEN-LAST:event_btnCapNhatNVActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cboTrangThai.setEnabled(false);
        cboChucVu.setEnabled(false);
        rdNam.setEnabled(false);
        rdNu.setEnabled(false);
        txtTen.setEnabled(false);
        txtDiaChi.setEnabled(false);
        txtMaNV.setEnabled(false);
        txtNgaySinh.setEnabled(false);
        txtNgayVaoLam.setEnabled(false);
        txtSDT.setEnabled(false);
        txtTenDN.setEnabled(false);
        btnThemNV.setEnabled(true);
        btnThemNV.setText("Thêm");
        btnCapNhatNV.setEnabled(true);  // Cap nhat
        btnCapNhatNV.setText("Cập nhật");
        setnullfield();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int a = grNhanVien.getSelectedRow();
        NhanVien nx = new NhanVien();
        if (a < 0) {
            JOptionPane.showMessageDialog(null, "Chưa chọn dòng nào ");
            return;
        }
        if (txtMaNV.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Có lỗi trong lúc chọn dòng vui lòng chọn lại");
            return;
        }
        int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá ? ", "Xoá", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            PhieuNX pnx = new PhieuNX();
            pnx.findNhanVien(txtMaNV.getText());
            //System.out.println(pnx.getMaNV());
            if (pnx.getMaNV() != null) {
                JOptionPane.showMessageDialog(null, "Nhân viên này đã từng tạo phiếu \n Xoá thất bại");
                return;
            }
            if (nx.delete(Integer.parseInt(txtMaNV.getText().toString())) > 0) {
                JOptionPane.showMessageDialog(null, "Xoá nhân viên thành công");
                model.setRowCount(0);
                init();
                return;

            } else {
                JOptionPane.showMessageDialog(null, "Xoá nhân viên thất bại");
                return;
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rdNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdNamActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatNV;
    private javax.swing.JButton btnThemNV;
    private javax.swing.JComboBox cboChucVu;
    private javax.swing.JComboBox cboTrangThai;
    private javax.swing.JTable grNhanVien;
    private javax.swing.ButtonGroup grpGioiTinh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pnNhanVien;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtMaNV;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtNgayVaoLam;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenDN;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel model;

    private void init() {
        model = (DefaultTableModel) grNhanVien.getModel();
        NhanVien o = new NhanVien();
        for (NhanVien nv : o.getList()) {
            model.addRow(nv.toVector());
        }
    }

    private void filldatafromtable() {
        int i = grNhanVien.getSelectedRow();

        if (i < 0) {
            return;
        }

        txtMaNV.setText(grNhanVien.getValueAt(i, 0).toString());
        txtTenDN.setText(grNhanVien.getValueAt(i, 1).toString());
        txtTen.setText(grNhanVien.getValueAt(i, 2).toString());
        txtSDT.setText(grNhanVien.getValueAt(i, 6).toString());
        ((JTextField) txtNgaySinh.getDateEditor().getUiComponent()).setText(grNhanVien.getValueAt(i, 4).toString());
        txtDiaChi.setText(grNhanVien.getValueAt(i, 3).toString());
        cboChucVu.setSelectedIndex(Integer.parseInt(grNhanVien.getValueAt(i, 7).toString()));
        txtNgayVaoLam.setText(grNhanVien.getValueAt(i, 8).toString());

        if (grNhanVien.getValueAt(i, 5).toString().equalsIgnoreCase("1")) {
            rdNam.setSelected(true);
        } else {
            rdNu.setSelected(true);
        }
        cboTrangThai.setSelectedIndex(Integer.parseInt(grNhanVien.getValueAt(i, 9).toString()));
    }

    private void setnullfield() {
        txtTen.setText(null);
        txtMaNV.setText(null);
        txtNgaySinh.setDate(null);
        txtNgayVaoLam.setText(null);
        txtSDT.setText(null);
        txtTenDN.setText(null);
        txtDiaChi.setText(null);
        rdNam.setSelected(true);
        cboChucVu.setSelectedIndex(0);
        cboTrangThai.setSelectedIndex(0);
    }

}