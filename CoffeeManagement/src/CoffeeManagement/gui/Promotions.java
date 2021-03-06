package CoffeeManagement.gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Le Duc Hoa
 */
public class Promotions extends javax.swing.JFrame {

    /**
     * Creates new form Promotions
     */
    Vector row;
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    DefaultTableModel tblModel;
    CoffeeManagement.server.DBHelper db = new CoffeeManagement.server.DBHelper();
    SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");

    public Promotions() {
        initComponents();
        con = db.getCon();
        ImageIcon img = new ImageIcon("src/CoffeeManagement/image/Promotions.jpg");
        this.setIconImage(img.getImage());
        btnAdd.setSize(20, 20);
        new SetImage().setImageButton(btnAdd, "src/CoffeeManagement/image/floating-toucher_icon.png");
        btnUpdate.setSize(20, 20);
        new SetImage().setImageButton(btnUpdate, "src/CoffeeManagement/image/Setting-icon.png");
        btnDel.setSize(20, 20);
        new SetImage().setImageButton(btnDel, "src/CoffeeManagement/image/cross.png");
        btnReset.setSize(20, 20);
        new SetImage().setImageButton(btnReset, "src/CoffeeManagement/image/3a4a6aea2a19c76c632a9092e7fd9a3f.png");
        tblModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblModel.addColumn("Mã");
        tblModel.addColumn("Tên chương trình");
        tblModel.addColumn("Chiết khấu (%)");
        tblModel.addColumn("Ngày bắt đầu");
        tblModel.addColumn("Ngày kết thúc");
        tblModel.addColumn("Mô tả");
        tblPromo.setModel(tblModel);
        ReloadTbl();
        btnResetActionPerformed(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblPromo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDis = new javax.swing.JTextField();
        lbID1 = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        DateStart = new com.toedter.calendar.JDateChooser();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DateEnd = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý chương trình khuyến mãi");
        setResizable(false);

        tblPromo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPromo.getTableHeader().setReorderingAllowed(false);
        tblPromo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPromoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPromo);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Thông tin chương trình");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tên chương trình (có thể ghi dấu):");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Chiếu khấu (%):");

        lbID1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbID1.setText("Mã:");

        lbID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbID.setText("Tự động");

        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnReset.setText("Làm mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnDel.setText("Xóa");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        DateStart.setDateFormatString("yyyy/MM/dd");

        txtName.setDisabledTextColor(new java.awt.Color(0, 0, 204));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Ngày bắt đầu:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Ngày kết thúc:");

        DateEnd.setDateFormatString("yyyy/MM/dd");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Mô tả:");

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtDescription.setRows(5);
        txtDescription.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(txtDescription);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbID1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbID))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(29, 29, 29)
                                        .addComponent(txtDis, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(DateEnd, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                            .addComponent(DateStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(DateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbID1)
                            .addComponent(lbID))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDel)
                    .addComponent(btnReset))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtName.setText("");
        txtDis.setText("");
        txtDescription.setText("");
        btnDel.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnAdd.setEnabled(true);
        lbID.setVisible(false);
        lbID1.setVisible(false);
        txtName.setEnabled(true);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String name = txtName.getText().replaceAll("\\s+", " ");
        String descript = txtDescription.getText();
        String start = ft.format(DateStart.getDate());
        String end = ft.format(DateEnd.getDate());
        while (true) {
            if (name.trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Tên chương trình không được bỏ trống.");
                txtName.grabFocus();
                return;
            } else if (name.length() > 50) {
                JOptionPane.showMessageDialog(null, "Độ dài tối đa của tên chương trình là 50 ký tự.");
                txtName.grabFocus();
                return;
            } else {
                break;
            }
        }
        while (true) {
            if (txtDis.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Chiết khấu không được bỏ trống.");
                txtDis.grabFocus();
                return;
            } else if (!txtDis.getText().trim().matches("[0-9]+") || Integer.parseInt(txtDis.getText().trim()) > 100) {
                JOptionPane.showMessageDialog(null, "Chiết khấu phải là số nguyên dương và <= 100.");
                txtDis.grabFocus();
                return;
            } else {
                break;
            }
        }
        while (true) {
            if (start.compareTo(end) >= 0) {
                JOptionPane.showMessageDialog(null, "Thời gian bắt đầu phải nhỏ hơn thời gian kết thúc.");
                return;
            } else {
                break;
            }
        }
        while (true) {
            if (descript.trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Mô tả chương trình không được bỏ trống.");
                txtDescription.grabFocus();
                return;
            } else {
                break;
            }
        }
        try {
            ps = con.prepareStatement("Insert into Promotions values(?,?,?,?,?)");
            ps.setString(1, name);
            ps.setInt(2, Integer.parseInt(txtDis.getText().trim()));
            ps.setString(3, start);
            ps.setString(4, end);
            ps.setString(5, txtDescription.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm chương trình khuyến mãi thành công.");
            ReloadTbl();
            btnResetActionPerformed(evt);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi: Không thể kết nối đến máy chủ");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblPromoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPromoMouseClicked
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnDel.setEnabled(true);
        txtName.setEnabled(false);
        lbID.setVisible(true);
        lbID1.setVisible(true);
        try {
            int line = tblPromo.getSelectedRow();
            Date start = ft.parse((String) tblPromo.getValueAt(line, 3));
            Date end = ft.parse((String) tblPromo.getValueAt(line, 4));
            txtName.setText((String) tblPromo.getValueAt(line, 1));
            txtDis.setText((String) tblPromo.getValueAt(line, 2));
            lbID.setText((String) tblPromo.getValueAt(line, 0));
            txtDescription.setText((String) tblPromo.getValueAt(line, 5));
            DateStart.setDate(start);
            DateEnd.setDate(end);
        } catch (ParseException ex) {
        }
    }//GEN-LAST:event_tblPromoMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String descript = txtDescription.getText();
        String start = ft.format(DateStart.getDate());
        String end = ft.format(DateEnd.getDate());
        while (true) {
            if (txtDis.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Chiết khấu không được bỏ trống.");
                txtDis.grabFocus();
                return;
            } else if (!txtDis.getText().trim().matches("[0-9]+") || Integer.parseInt(txtDis.getText().trim()) > 100) {
                JOptionPane.showMessageDialog(null, "Chiết khấu phải là số nguyên và nhỏ hơn 100.");
                txtDis.grabFocus();
                return;
            } else {
                break;
            }
        }
        while (true) {
            if (start.compareTo(end) >= 0) {
                JOptionPane.showMessageDialog(null, "Thời gian bắt đầu phải nhỏ hơn thời gian kết thúc.");
                return;
            } else {
                break;
            }
        }
        while (true) {
            if (descript.trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Mô tả chương trình không được bỏ trống.");
                txtDescription.grabFocus();
                return;
            } else {
                break;
            }
        }
        try {
            ps = con.prepareStatement("Update Promotions set DiscountPromo=?, StartPromo=?, EndPromo=?, Description=? where IDPromo=?");
            ps.setString(1, txtDis.getText().trim());
            ps.setString(2, start);
            ps.setString(3, end);
            ps.setString(4, txtDescription.getText());
            ps.setString(5, lbID.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cập nhật chương trình thành công.");
            ReloadTbl();
            btnResetActionPerformed(evt);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi 101:: Không thể kết nối đến máy chủ");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        int click = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa chương trình này?");
        if (click == 0) {
            try {
                ps = con.prepareStatement("Delete from Promotions where IDPromo=?");
                ps.setString(1, lbID.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Xóa chương trình thành công.");
                ReloadTbl();
                btnResetActionPerformed(evt);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Lỗi 101:: Không thể kết nối đến máy chủ");
            }
        }
    }//GEN-LAST:event_btnDelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateEnd;
    private com.toedter.calendar.JDateChooser DateStart;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbID1;
    private javax.swing.JTable tblPromo;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtDis;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    private void ReloadTbl() {
        tblModel.getDataVector().removeAllElements();
        try {
            ps = con.prepareStatement("select * from Promotions");
            rs = ps.executeQuery();
            while (rs.next()) {
                row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
                row.add(rs.getString(6));
                tblModel.addRow(row);
            }
            tblPromo.setModel(tblModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi: Không thể kết nối đến máy chủ");
        }
    }
}
