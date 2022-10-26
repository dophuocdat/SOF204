/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DAO.HocVienDAO;
import DAO.NguoiHocDAO;
import Helper.ConnectionDb;
import Helper.DialogHelper;
import Helper.imageHelper;
import Model.HocVien;
import Model.NguoiHoc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author datdo
 */
public class QuanLyHocVien extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyHocVien
     * @param MaKH
     */
    public QuanLyHocVien(int MaKH) {
        initComponents();
        fillTableNguoiHoc();
        this.MaKH = MaKH;
        init();
    }
    Integer MaKH;
    HocVienDAO hvDAO = new HocVienDAO();
    NguoiHocDAO nhDAO = new NguoiHocDAO();

    private void init() {
        setIconImage(imageHelper.APP_ICON);
        setLocationRelativeTo(null);
        tblNguoiHoc.setDefaultEditor(Object.class, null);
    }

    private void fillTableNguoiHoc() {
        DefaultTableModel model = (DefaultTableModel) tblNguoiHoc.getModel();
        model.setRowCount(0);
        // ResultSet rs = null;
        String keyword = txtTimKiem.getText();
        try {
            List<NguoiHoc> list = nhDAO.selectByCourse(MaKH, keyword);
            for (NguoiHoc nh : list) {
                model.addRow(new Object[]{
                    nh.getMaNH(),
                    nh.getHoTen(),
                    nh.isGioiTinh() ? "Nam" : "Nữ",
                    nh.getNgaySinh(),
                    nh.getDienThoai(),
                    nh.getEmail()
                });

            }
        } catch (Exception e) {
        }
    }

    private void fillTableHocVien() {
        DefaultTableModel model = (DefaultTableModel) tblView.getModel();
        model.setRowCount(0);
        ResultSet rs = null;
        try {
            //lấy về MaHV, MaKH, MaNH, Diem, HoTen từ các bảng trong CSDL của các học viên thuộc 
            //khóa học (theo maKH)
            String sql = "Select hv.*, nh.HoTen From HocVien hv "
                    + "inner join NguoiHoc nh on nh.MaNH = hv.MaNH Where MaKH =?";
            rs = ConnectionDb.executeQuery(sql, MaKH);
            while (rs.next()) {
                double diem = rs.getDouble("Diem");
                Object[] row = {
                    rs.getInt("MaHV"),
                    rs.getString("MaNH"),
                    rs.getString("HoTen"),
                    diem,
                    false
                };
                model.addRow(row);
               
            }
        } catch (SQLException ex) {
            DialogHelper.alert(this, "Lỗi truy vấn học viên");
        } finally {
            try {
                rs.getStatement().getConnection().close();
            } catch (SQLException e) {
                throw new RuntimeException();
            }
        }
    }

    private void insertHocVien() {

        for (int row : tblNguoiHoc.getSelectedRows()) {
            HocVien hv = new HocVien();
            hv.setMaKH(MaKH);

            hv.setDiem(0);
            hv.setMaNH((String) tblNguoiHoc.getValueAt(row, 0));
            hvDAO.insert(hv);
        }
        fillTableHocVien();
        tabs.setSelectedIndex(0);
    }

    private void update() {

        int a = 0, b = 0;
        for (int i = 0; i < tblView.getRowCount(); i++) {
            Integer maHV = (Integer) tblView.getValueAt(i, 0);
            String maNh = (String) tblView.getValueAt(i, 1);
            Double diem = (Double) tblView.getValueAt(i, 3);
            boolean isdelete = (boolean) tblView.getValueAt(i, 4);
            if (isdelete) {
                a++;
            }
            if (isdelete && imageHelper.USER.isVaiTro()) {
                hvDAO.delete(maHV);
            } else {
                if (imageHelper.USER.isVaiTro() == false) {
                    tblView.setValueAt(false, i, 3);

                }
                if (diem >= 0 && diem <= 10 || diem == -1) {
                    HocVien model = new HocVien();
                    model.setMaHV(maHV);
                    model.setMaKH(MaKH);
                    model.setMaNH(maNh);
                    model.setDiem(diem);
                    hvDAO.update(model);
                } else {
                    b++;
                }
            }

        }
        fillTableHocVien();
        fillTableNguoiHoc();
        if (a > 0 && imageHelper.USER.isVaiTro() == false) {
            DialogHelper.alert(this, "Chỉ trưởng phòng mới được xóa học viên\n Bạn chỉ được thêm học viên và điểm.");
            return;
        }
        if (b > 0) {
            DialogHelper.alert(this, "Điểm phải llaf số thực từ 0-10 hoặc chưa nhập (-1).");
            return;
        }
        DialogHelper.alert(this, "Cập nhật thành công!");
    }

    private void searchTable(){
        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(tblNguoiHoc.getModel());
       tblNguoiHoc.setRowSorter(sorter);
       if(txtTimKiem.getText().length() != 0){
           sorter.setRowFilter(RowFilter.regexFilter("(?i)"+txtTimKiem.getText()));
       }else{
           sorter.setRowFilter(null);
       }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblView = new javax.swing.JTable();
        btnCapNhat = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNguoiHoc = new javax.swing.JTable();
        btnThemNguoiHoc = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tblView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MÃ HV", "MÃ NH", "HỌ VÀ TÊN", "ĐIỂM (edit)", "Xóa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblView);
        if (tblView.getColumnModel().getColumnCount() > 0) {
            tblView.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblView.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblView.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblView.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Save as.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCapNhat)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapNhat)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        tabs.addTab("Học Viên", jPanel1);

        tblNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã NH", "Họ và Tên", "Giới Tính", "Ngày Sinh", "Điện Thoại", "Email"
            }
        ));
        jScrollPane2.setViewportView(tblNguoiHoc);
        if (tblNguoiHoc.getColumnModel().getColumnCount() > 0) {
            tblNguoiHoc.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblNguoiHoc.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblNguoiHoc.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblNguoiHoc.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblNguoiHoc.getColumnModel().getColumn(4).setPreferredWidth(60);
        }

        btnThemNguoiHoc.setText("Thêm người học");
        btnThemNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNguoiHocActionPerformed(evt);
            }
        });

        jButton2.setText("Tìm Kiếm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThemNguoiHoc))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThemNguoiHoc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Người Học", jPanel2);

        jLabel2.setBackground(new java.awt.Color(102, 102, 255));
        jLabel2.setFont(new java.awt.Font("sansserif", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÝ HỌC VIÊN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabs)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 457, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        update();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnThemNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNguoiHocActionPerformed
        // TODO add your handling code here:
        insertHocVien();
    }//GEN-LAST:event_btnThemNguoiHocActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        searchTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        fillTableHocVien();
        fillTableNguoiHoc();
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(QuanLyHocVien0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(QuanLyHocVien0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(QuanLyHocVien0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(QuanLyHocVien0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new QuanLyHocVien0().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThemNguoiHoc;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblNguoiHoc;
    private javax.swing.JTable tblView;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
