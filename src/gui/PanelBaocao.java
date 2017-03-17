/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Baocao.BaoCao;
import Baocao.laythongtin;
import Phieu.PhieuNX;
import Phieu.SanPham;
import SanPham.BaoCaoSP;
import SanPham.MaloaiSP;
import SanPham.Sanpham;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Windows
 */
public class PanelBaocao extends javax.swing.JPanel {

    TableRowSorter sorter;
    File fontFile = new File("fonts/times.ttf");
    ArrayList<SanPham> list_s;
    int max = 0;

    /**
     * Creates new form PanelBaocao
     */
    public PanelBaocao() {
        initComponents();

        initdata();

    }

    private void print() {
        Document document = new Document(PageSize.A4.rotate());
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
        int selectection = fc.showSaveDialog(new JFrame());
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        try {
            if (selectection == JFileChooser.APPROVE_OPTION) {
                if (!fc.getSelectedFile().getName().toString().endsWith(".pdf")) {
                    JOptionPane.showMessageDialog(null, "Đuôi file phải là .pdf");
                    return;
                }
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fc.getSelectedFile().getAbsolutePath()));
                writer.setPageEmpty(false);
                BaseColor myColor = WebColors.getRGBColor("#808080");
                writer.setBoxSize("art", new Rectangle(36, 54, 559, 788));
                BaseFont bf = BaseFont.createFont(fontFile.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                com.itextpdf.text.Font font = new com.itextpdf.text.Font(bf, 15);
                com.itextpdf.text.Font f2 = new com.itextpdf.text.Font(bf, 25);
                laythongtin l = new laythongtin();
                l.hotenemno(FrLogin.id);
                HeaderAndFooter event = new HeaderAndFooter("Hệ Thống Quản Lí Xuất Nhập Kho", "Người lập : " + l.getHoten());
                writer.setPageEvent(event);

                document.open();
                PdfPTable pdfTable = new PdfPTable(grThongKe.getColumnCount());
                pdfTable.setWidths(new int[]{50, 90, 200, 200, 80, 80, 80});
                PdfContentByte cb = writer.getDirectContent();

                cb.saveState();
                Paragraph datee = new Paragraph(dateFormat.format(date), font);
                datee.setAlignment(Element.TITLE);
                datee.setSpacingBefore(10);
                datee.setSpacingAfter(10);

                Paragraph ph = new Paragraph("PHIẾU THỐNG KÊ KHO", f2);
                ph.setAlignment(Element.TITLE);
                cb.restoreState();
                if (grThongKe.getRowCount() > 12) {
                    for (int i = 0; i < grThongKe.getColumnCount(); i++) {
                        PdfPCell cell = new PdfPCell(new Phrase(grThongKe.getModel().getColumnName(i).toString(), font));
                        cell.setBackgroundColor(myColor);
                        pdfTable.addCell(cell);
                    }
                    for (int rows = 0; rows < grThongKe.getRowCount(); rows++) {
                        for (int cols = 0; cols < grThongKe.getColumnCount(); cols++) {
                            pdfTable.addCell(new PdfPCell(new Phrase(grThongKe.getModel().getValueAt(rows, cols).toString(), font)));

                        }
                        if (rows != 0) {

                            if (rows % 11 == 0) {
                                document.add(ph);
                                document.add(datee);
                                document.add(pdfTable);
                                document.newPage();
                                pdfTable.deleteBodyRows();
                                for (int i = 0; i < grThongKe.getColumnCount(); i++) {
                                    PdfPCell cell = new PdfPCell(new Phrase(grThongKe.getModel().getColumnName(i).toString(), font));
                                    cell.setBackgroundColor(myColor);
                                    pdfTable.addCell(cell);
                                }
                            }

                        }
                    }
                    document.add(ph);
                    document.add(datee);
                    document.add(pdfTable);

                } else {
                    for (int i = 0; i < grThongKe.getColumnCount(); i++) {
                        PdfPCell cell = new PdfPCell(new Phrase(grThongKe.getModel().getColumnName(i).toString(), font));
                        cell.setBackgroundColor(myColor);
                        pdfTable.addCell(cell);
                    }
                    for (int rows = 0; rows < grThongKe.getRowCount(); rows++) {
                        for (int cols = 0; cols < grThongKe.getColumnCount(); cols++) {
                            pdfTable.addCell(new PdfPCell(new Phrase(grThongKe.getModel().getValueAt(rows, cols).toString(), font)));
                        }
                    }
                    document.add(ph);
                    document.add(datee);
                    document.add(pdfTable);
                }

                document.close();
                JOptionPane.showMessageDialog(null, "In hoàn tất vui lòng vào " + fc.getSelectedFile().getAbsolutePath() + " để xem thống kê ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi In báo cáo: " + e.getMessage());
        }
        document.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnBaocao = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMatHang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        grThongKe = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        cboLoaiSP = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        pnBaocaoSP = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        grThongKe1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTenSP1 = new javax.swing.JTextField();
        cboLoaiSP1 = new javax.swing.JComboBox();
        jButton7 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(727, 500));
        setLayout(new java.awt.BorderLayout());

        pnBaocao.setPreferredSize(new java.awt.Dimension(727, 500));

        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/print.png"))); // NOI18N
        jButton2.setText("In Báo Cáo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin tổng hợp"));

        jLabel1.setText("Số mặt hàng");

        txtMatHang.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMatHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jScrollPane1.setPreferredSize(new java.awt.Dimension(727, 500));

        grThongKe.setAutoCreateRowSorter(true);
        grThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Loại SP", "SL Nhập", "SL Xuất", "Tồn Kho"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grThongKe.setFocusCycleRoot(true);
        jScrollPane1.setViewportView(grThongKe);
        if (grThongKe.getColumnModel().getColumnCount() > 0) {
            grThongKe.getColumnModel().getColumn(0).setMinWidth(35);
            grThongKe.getColumnModel().getColumn(0).setPreferredWidth(35);
            grThongKe.getColumnModel().getColumn(0).setMaxWidth(35);
            grThongKe.getColumnModel().getColumn(2).setPreferredWidth(50);
            grThongKe.getColumnModel().getColumn(3).setPreferredWidth(50);
            grThongKe.getColumnModel().getColumn(4).setMinWidth(80);
            grThongKe.getColumnModel().getColumn(4).setPreferredWidth(80);
            grThongKe.getColumnModel().getColumn(4).setMaxWidth(80);
            grThongKe.getColumnModel().getColumn(5).setMinWidth(80);
            grThongKe.getColumnModel().getColumn(5).setPreferredWidth(80);
            grThongKe.getColumnModel().getColumn(5).setMaxWidth(80);
            grThongKe.getColumnModel().getColumn(6).setMinWidth(80);
            grThongKe.getColumnModel().getColumn(6).setPreferredWidth(80);
            grThongKe.getColumnModel().getColumn(6).setMaxWidth(80);
        }

        jLabel4.setText("Tên sản phẩm");

        jLabel5.setText("Loại sản phẩm");

        cboLoaiSP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất cả" }));

        jButton3.setText("Xoá tìm kiếm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/arrow_refresh.png"))); // NOI18N
        jButton4.setText("Cập nhật hệ thống");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBaocaoLayout = new javax.swing.GroupLayout(pnBaocao);
        pnBaocao.setLayout(pnBaocaoLayout);
        pnBaocaoLayout.setHorizontalGroup(
            pnBaocaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBaocaoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnBaocaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBaocaoLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnBaocaoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnBaocaoLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnBaocaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(pnBaocaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        pnBaocaoLayout.setVerticalGroup(
            pnBaocaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBaocaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnBaocaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBaocaoLayout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(12, 12, 12))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBaocaoLayout.createSequentialGroup()
                        .addGroup(pnBaocaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnBaocaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnBaocaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jTabbedPane1.addTab("Phiếu", pnBaocao);

        pnBaocaoSP.setPreferredSize(new java.awt.Dimension(727, 500));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        jButton5.setText("Tìm kiếm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/print.png"))); // NOI18N
        jButton6.setText("In Báo Cáo");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jScrollPane2.setPreferredSize(new java.awt.Dimension(727, 500));

        grThongKe1.setAutoCreateRowSorter(true);
        grThongKe1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên sản phẩm", "Loại sản phẩm", "Nhà sản xuất", "Email", "Quốc Gia", "Ngày nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grThongKe1.setFocusCycleRoot(true);
        jScrollPane2.setViewportView(grThongKe1);

        jLabel6.setText("Tên sản phẩm");

        jLabel7.setText("Loại sản phẩm");

        cboLoaiSP1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất cả" }));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/file.png"))); // NOI18N
        jButton7.setText("Xoá tìm kiếm");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBaocaoSPLayout = new javax.swing.GroupLayout(pnBaocaoSP);
        pnBaocaoSP.setLayout(pnBaocaoSPLayout);
        pnBaocaoSPLayout.setHorizontalGroup(
            pnBaocaoSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBaocaoSPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBaocaoSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnBaocaoSPLayout.createSequentialGroup()
                        .addGroup(pnBaocaoSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBaocaoSPLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(cboLoaiSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnBaocaoSPLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54)
                        .addGroup(pnBaocaoSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                        .addGap(98, 98, 98)
                        .addComponent(jButton6))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        pnBaocaoSPLayout.setVerticalGroup(
            pnBaocaoSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBaocaoSPLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(pnBaocaoSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTenSP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(5, 5, 5)
                .addGroup(pnBaocaoSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jLabel7)
                    .addComponent(cboLoaiSP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );

        jTabbedPane1.addTab("Sản phẩm", pnBaocaoSP);

        add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        sorter = (TableRowSorter) grThongKe.getRowSorter();
        ArrayList dk = new ArrayList();
        String s = txtTenSP.getText().trim();
        dk.add(javax.swing.RowFilter.regexFilter("(?i)" + s, 1));
        if (cboLoaiSP.getSelectedIndex() != 0) {
            dk.add(javax.swing.RowFilter.regexFilter(cboLoaiSP.getSelectedItem().toString().trim(), 2));
        }
        sorter.setRowFilter(javax.swing.RowFilter.andFilter(dk));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        print();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        sorter.setRowFilter(null);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) grThongKe.getModel();
        model.setRowCount(0);
        initdata();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        sorter = (TableRowSorter) grThongKe1.getRowSorter();
        ArrayList dk = new ArrayList();
        String s = txtTenSP1.getText().trim();
        dk.add(javax.swing.RowFilter.regexFilter("(?i)" + s, 1));
        if (cboLoaiSP1.getSelectedIndex() != 0) {
            dk.add(javax.swing.RowFilter.regexFilter(cboLoaiSP1.getSelectedItem().toString().trim(), 2));
        }
        sorter.setRowFilter(javax.swing.RowFilter.andFilter(dk));
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        printsp();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        txtTenSP1.setText("");
        sorter.setRowFilter(null);
    }//GEN-LAST:event_jButton7ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboLoaiSP;
    private javax.swing.JComboBox cboLoaiSP1;
    private javax.swing.JTable grThongKe;
    private javax.swing.JTable grThongKe1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnBaocao;
    private javax.swing.JPanel pnBaocaoSP;
    private javax.swing.JTextField txtMatHang;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTenSP1;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel model1;
    ArrayList<MaloaiSP> MaList;

    private void initdata() {
        DefaultTableModel model = (DefaultTableModel) grThongKe.getModel();
        // model.setRowCount(0);
        int stt = 1;
        BaoCao bc = new BaoCao();
        SanPham spt = new SanPham();
        cboLoaiSP.removeAllItems();
        cboLoaiSP.addItem("Tất cả");
        for (SanPham sp : spt.getLoaiSP()) {
            cboLoaiSP.addItem(sp.toVector().elementAt(3).toString());
        }

        bc.findSoLuongSP();  // tìm số luog sản phẩm

        Sanpham s = new Sanpham();
        List<Sanpham> list2 = s.getList();

        int r;
        for (int l = 0; l < list2.size(); l++) {
            r = Integer.parseInt(list2.get(l).getMaSP());

            bc.findSoLuongPhieu(r);

            String ten = null;
            int tonkho = 0;
            int xuat = 0;
            int nhap = 0;
            int toncuoi = 0;
            String MaSP  = null;
            String LoaiSP = null;
            for (BaoCao tete : bc.getListNew(r)) {

                String a = tete.toVector().elementAt(0).toString();
                MaSP = tete.toVector().elementAt(0).toString().trim();
                ten = tete.toVector().elementAt(2).toString();
                String loai = tete.toVector().elementAt(4).toString();
                tonkho = Integer.parseInt(tete.toVector().elementAt(5).toString());
                LoaiSP = tete.toVector().elementAt(6).toString().trim();
                switch (loai) {
                    case "Nhập":
                        int x = Integer.parseInt(tete.toVector().elementAt(3).toString());
                        nhap += x;
                        break;
                    case "Xuất":
                        int y = Integer.parseInt(tete.toVector().elementAt(3).toString());
                        xuat += y;
                        break;
                    default:
                        break;
                }
            }

            if (ten != null) {
                Vector v = new Vector();
                v.add(stt);
                v.add(MaSP);
                v.add(ten);
                v.add(LoaiSP);
                v.add(nhap);
                v.add(xuat);
                toncuoi = nhap - xuat;
                v.add(toncuoi);
                model.addRow(v);
                stt++;
            }
            //s++;

        }
        txtMatHang.setText(model.getRowCount() + "");
        model1 = (DefaultTableModel) grThongKe1.getModel();
        model1.setRowCount(0);
        BaoCaoSP bcsp = new BaoCaoSP();
        String ten = null;
        String loai = null;
        String nha = null;
        String mail = null;
        String tenqg = null;
        String ngay = null;
        int sttsp = 1;

        for (BaoCaoSP bc1 : bcsp.getList()) {
            ten = bc1.toVector().elementAt(0).toString();
            loai = bc1.toVector().elementAt(2).toString();
            nha = bc1.toVector().elementAt(1).toString();
            mail = bc1.toVector().elementAt(3).toString();
            tenqg = bc1.toVector().elementAt(4).toString();
            ngay = bc1.toVector().elementAt(5).toString();
            Vector v = new Vector();
            v.add(sttsp);
            v.add(ten);
            v.add(loai);
            v.add(nha);
            v.add(mail);
            v.add(tenqg);
            v.add(ngay);
            sttsp++;
            model1.addRow(v);
        }
        MaloaiSP mal = new MaloaiSP();
        MaList = new ArrayList<>();
        MaList.clear();
        MaList = mal.getList();
        cboLoaiSP1.removeAllItems();
        for (MaloaiSP m : MaList) {

            cboLoaiSP1.addItem(m.getTenLoaiSP());
        }
    }

    private void printsp() {

        Document document = new Document(PageSize.A4.rotate());
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
        int selectection = fc.showSaveDialog(new JFrame());
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        try {
            if (selectection == JFileChooser.APPROVE_OPTION) {
                if (!fc.getSelectedFile().getName().toString().endsWith(".pdf")) {
                    JOptionPane.showMessageDialog(null, "Đuôi file phải là .pdf");
                    return;
                }
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fc.getSelectedFile().getAbsolutePath()));
                writer.setPageEmpty(false);
                BaseColor myColor = WebColors.getRGBColor("#808080");
                writer.setBoxSize("art", new Rectangle(36, 54, 559, 788));
                BaseFont bf = BaseFont.createFont(fontFile.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                com.itextpdf.text.Font font = new com.itextpdf.text.Font(bf, 15);
                com.itextpdf.text.Font f2 = new com.itextpdf.text.Font(bf, 25);
                HeaderAndFooter evente = new HeaderAndFooter("Hệ Thống Quản Lí Xuất Nhập Kho", "");
                writer.setPageEvent(evente);

                document.open();
                PdfPTable pdfTable = new PdfPTable(grThongKe.getColumnCount());
                pdfTable.setWidths(new int[]{50, 160, 160, 120, 180, 90, 100});
                PdfContentByte cb = writer.getDirectContent();

                cb.saveState();
                Paragraph datee = new Paragraph(dateFormat.format(date), font);
                datee.setAlignment(Element.TITLE);
                datee.setSpacingBefore(10);
                datee.setSpacingAfter(10);

                Paragraph ph = new Paragraph("DANH SÁCH THỐNG KÊ SẢN PHẨM KHO", f2);
                ph.setAlignment(Element.TITLE);
                cb.restoreState();
                if (grThongKe1.getRowCount() > 9) {
                    for (int i = 0; i < grThongKe1.getColumnCount(); i++) {
                        PdfPCell cell = new PdfPCell(new Phrase(grThongKe1.getModel().getColumnName(i).toString(), font));
                        cell.setBackgroundColor(myColor);
                        pdfTable.addCell(cell);
                    }
                    for (int rows = 0; rows < grThongKe1.getRowCount(); rows++) {
                        for (int cols = 0; cols < grThongKe1.getColumnCount(); cols++) {
                            pdfTable.addCell(new PdfPCell(new Phrase(grThongKe1.getModel().getValueAt(rows, cols).toString(), font)));

                        }
                        if (rows != 0) {

                            if (rows % 8 == 0) {
                                document.add(ph);
                                document.add(datee);
                                document.add(pdfTable);
                                document.newPage();
                                pdfTable.deleteBodyRows();
                                for (int i = 0; i < grThongKe1.getColumnCount(); i++) {
                                    PdfPCell cell = new PdfPCell(new Phrase(grThongKe1.getModel().getColumnName(i).toString(), font));
                                    cell.setBackgroundColor(myColor);
                                    pdfTable.addCell(cell);
                                }
                            }

                        }
                    }
                    document.add(ph);
                    document.add(datee);
                    document.add(pdfTable);

                } else {
                    for (int i = 0; i < grThongKe1.getColumnCount(); i++) {
                        PdfPCell cell = new PdfPCell(new Phrase(grThongKe1.getModel().getColumnName(i).toString(), font));
                        cell.setBackgroundColor(myColor);
                        pdfTable.addCell(cell);
                    }
                    for (int rows = 0; rows < grThongKe1.getRowCount(); rows++) {
                        for (int cols = 0; cols < grThongKe1.getColumnCount(); cols++) {
                            pdfTable.addCell(new PdfPCell(new Phrase(grThongKe1.getModel().getValueAt(rows, cols).toString(), font)));
                        }
                    }
                    document.add(ph);
                    document.add(datee);
                    document.add(pdfTable);
                }
                document.close();
                JOptionPane.showMessageDialog(null, "In hoàn tất vui lòng vào " + fc.getSelectedFile().getAbsolutePath() + " để xem thống kê ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi : " + e.getMessage());
        }
        document.close();
    }
}
