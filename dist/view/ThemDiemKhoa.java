/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import DAO.HocVienDAO;
import DAO.NguoiHocDAO;
import Helper.DateHelper;
import Model.NguoiHoc;
import Model.HocVien;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author datdo
 */
public class ThemDiemKhoa extends javax.swing.JInternalFrame {

    /**
     * Creates new form ThemDiemKhoa
     */
    public ThemDiemKhoa() {
        initComponents();
        fillComboBox();

    }
    NguoiHocDAO dao = new NguoiHocDAO();
    HocVienDAO hvdao = new HocVienDAO();

    void fillComboBox() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbxMaNH.getModel();
        model.removeAllElements();
        List<String> list = dao.allMaNguoiHoc();
        for (String s : list) {
            model.addElement(s);
        }
        cbxMaNH.setSelectedIndex(0);
    }

    void addDiem() {
        // String sql = "insert into HocVien ( MaKH, MaNH, Diem) value (?,?,?)";
        HocVien model = getmodel();
        hvdao.insert(model);

    }

    private HocVien getmodel() {
        HocVien model = new HocVien();
        model.setMaKH(Integer.parseInt(txtMaKh.getText()));
        model.setMaNH((String) cbxMaNH.getSelectedItem());
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        
        model.setDiem(Float.parseFloat(df.format(txtDiem.getText())));
        return model;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaKh = new javax.swing.JTextField();
        txtDiem = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cbxMaNH = new javax.swing.JComboBox<>();

        jLabel1.setText("jLabel1");

        jLabel2.setText("M?? KH");

        jLabel3.setText("M?? NH");

        jLabel4.setText("??i???m");

        txtDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiemActionPerformed(evt);
            }
        });

        jButton1.setText("Th??m");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbxMaNH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxMaNH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jButton1)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxMaNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        addDiem();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxMaNH;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtMaKh;
    // End of variables declaration//GEN-END:variables
}
