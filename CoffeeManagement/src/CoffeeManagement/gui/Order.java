package CoffeeManagement.gui;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Le Duc Hoa
 */
public class Order extends javax.swing.JFrame {

    /**
     * Creates new form Order
     */
    CoffeeManagement.server.DBHelper db = new CoffeeManagement.server.DBHelper();
    Connection con = db.getCon();
    PreparedStatement ps;
    ResultSet rs, rsIDOrder, rsIDProduct, rsEmp, rsPromotions, rsIDCus, rsSearch1, rsSearch2;
    DefaultTableModel tblModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    Vector row, rowSearch, vecIDOrder, vecIDProduct, vecEmp, vecPromotions, vecIDCus;

    public Order() {
        initComponents();
        //set icon cho jframe
        ImageIcon img = new ImageIcon("src/CoffeeManagement/image/Order.png");
        this.setIconImage(img.getImage());
        btnReset.setSize(30, 30);
        new SetImage().setImageButton(btnReset, "src/CoffeeManagement/image/refresh_256.png");
        btnSearch.setSize(30, 30);
        new SetImage().setImageButton(btnSearch, "src/CoffeeManagement/image/search-512.png");
        tblModel.addColumn("Mã đơn hàng");
        tblModel.addColumn("Mã sản phẩm");
        tblModel.addColumn("Mã khách hàng");
        tblModel.addColumn("Số lượng");
        tblModel.addColumn("CTKM");
        tblModel.addColumn("Thời gian");
        tblModel.addColumn("Ngày");
        tblModel.addColumn("Nhân viên");
        tblOrder.setModel(tblModel);
        ReloadTable();
        ReloadCombobox();
    }

    public void ReloadTable() {
        tblModel.getDataVector().removeAllElements();
        try {
            ps = con.prepareStatement("select * from OrderDetails join [Order] on OrderDetails.IDOrder=[Order].IDOrder Order by OrderDetails.IDOrder DESC");
            rs = ps.executeQuery();
            while (rs.next()) {
                row = new Vector();
                row.add(rs.getString("IDOrder"));
                row.add(rs.getString("IDProduct"));
                row.add(rs.getString("CusName"));
                row.add(rs.getString("Quantity"));
                row.add(rs.getString("NamePromo"));
                row.add(rs.getString("TimeOrder"));
                row.add(rs.getString("DateOrder"));
                row.add(rs.getString("UsernameEmp"));
                tblModel.addRow(row);
            }
            tblOrder.setModel(tblModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi: Không thể kết nối đến máy chủ");
        }
    }

    public void ReloadCombobox() {
        cbIDOrder.removeAllItems();
        cbIDProduct.removeAllItems();
        cbNameEmp.removeAllItems();
        cbPromotions.removeAllItems();
        cbIDCus.removeAllItems();
        try {
            String url = "Select IDOrder from [Order] Order by IDOrder DESC";
            ps = con.prepareStatement(url);
            rsIDOrder = ps.executeQuery();
            vecIDOrder = new Vector();
            while (rsIDOrder.next()) {
                vecIDOrder.add(rsIDOrder.getString("IDOrder"));
            }
            JTextField text = (JTextField) cbIDOrder.getEditor().getEditorComponent();
            text.setText("");
            text.addKeyListener(new ComboListener(cbIDOrder, vecIDOrder));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi: Không thể kết nối đến máy chủ");
        }
        try {
            String url = "Select IDProduct from Product Order by IDProduct DESC";
            ps = con.prepareStatement(url);
            rsIDProduct = ps.executeQuery();
            vecIDProduct = new Vector();
            while (rsIDProduct.next()) {
                vecIDProduct.add(rsIDProduct.getString("IDProduct"));
            }
            JTextField text = (JTextField) cbIDProduct.getEditor().getEditorComponent();
            text.setText("");
            text.addKeyListener(new ComboListener(cbIDProduct, vecIDProduct));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi: Không thể kết nối đến máy chủ");
        }
        try {
            String url = "Select UsernameEmp from Employee where UsernameEmp != 'null'";
            ps = con.prepareStatement(url);
            rsEmp = ps.executeQuery();
            vecEmp = new Vector();
            while (rsEmp.next()) {
                vecEmp.add(rsEmp.getString("UsernameEmp"));
            }
            JTextField text = (JTextField) cbNameEmp.getEditor().getEditorComponent();
            text.setText("");
            text.addKeyListener(new ComboListener(cbNameEmp, vecEmp));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi: Không thể kết nối đến máy chủ");
        }
        try {
            String url = "Select NamePromo from Promotions Order by IDPromo DESC";
            ps = con.prepareStatement(url);
            rsPromotions = ps.executeQuery();
            vecPromotions = new Vector();
            while (rsPromotions.next()) {
                vecPromotions.add(rsPromotions.getString("NamePromo"));
            }
            JTextField text = (JTextField) cbPromotions.getEditor().getEditorComponent();
            text.setText("");
            text.addKeyListener(new ComboListener(cbPromotions, vecPromotions));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi: Không thể kết nối đến máy chủ");
        }
        try {
            String url = "Select IDCus from Customer Order by IDCus DESC";
            ps = con.prepareStatement(url);
            rsIDCus = ps.executeQuery();
            vecIDCus = new Vector();
            vecIDCus.add("Khách vãng lai");
            while (rsIDCus.next()) {
                vecIDCus.add(rsIDCus.getString("IDCus"));
            }
            JTextField text = (JTextField) cbIDCus.getEditor().getEditorComponent();
            text.setText("");
            text.addKeyListener(new ComboListener(cbIDCus, vecIDCus));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi: Không thể kết nối đến máy chủ");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        cbIDOrder = new javax.swing.JComboBox();
        cbIDCus = new javax.swing.JComboBox();
        cbNameEmp = new javax.swing.JComboBox();
        cbIDProduct = new javax.swing.JComboBox();
        cbPromotions = new javax.swing.JComboBox();
        lbTimeError = new javax.swing.JLabel();
        lbDateError = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý hóa đơn");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        tblOrder.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblOrder.setAutoscrolls(false);
        tblOrder.setFocusable(false);
        tblOrder.setOpaque(false);
        tblOrder.setRequestFocusEnabled(false);
        tblOrder.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblOrder);

        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Mã đơn hàng:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Mã sản phẩm:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mã khách hàng:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Thời gian:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Nhân viên:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Ngày:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Chương trình khuyến mãi:");

        txtTime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        cbIDOrder.setEditable(true);
        cbIDOrder.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cbIDCus.setEditable(true);
        cbIDCus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cbNameEmp.setEditable(true);
        cbNameEmp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cbIDProduct.setEditable(true);
        cbIDProduct.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cbPromotions.setEditable(true);
        cbPromotions.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Thông tin tìm kiếm:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbIDProduct, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbNameEmp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbIDOrder, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbIDCus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbPromotions, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtTime)
                                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbTimeError)
                            .addComponent(lbDateError))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbPromotions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbIDCus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbIDOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cbIDProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbNameEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTimeError)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDateError)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        ReloadTable();
        cbIDCus.setSelectedIndex(-1);
        cbIDOrder.setSelectedIndex(-1);
        cbIDProduct.setSelectedIndex(-1);
        cbNameEmp.setSelectedIndex(-1);
        cbPromotions.setSelectedIndex(-1);
        txtTime.setText("");
        txtDate.setText("");
        lbTimeError.setText("");
        lbDateError.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        tblModel.getDataVector().removeAllElements();
        String s1 = (String) cbIDOrder.getSelectedItem();
        String s2 = (String) cbIDProduct.getSelectedItem();
        String s3 = (String) cbIDCus.getSelectedItem();
        String s4 = (String) cbPromotions.getSelectedItem();
        String s5 = txtDate.getText().trim();
        String s6 = txtTime.getText().trim();
        String s7 = (String) cbNameEmp.getSelectedItem();
        if (!txtDate.getText().trim().equals("")) {
            while (true) {
                if (!txtDate.getText().trim().matches("([0-9]{0,2}/)?([0-9]{0,2}/)?[0-9]{4}")) {
                    lbDateError.setText("Ngày có dạng: dd/MM/yyyy, MM/yyyy hoặc yyyy.");
                    lbDateError.setForeground(Color.red);
                    tblOrder.removeAll();
                    return;
                } else {
                    lbDateError.setText("");
                    break;
                }
            }
        } else {
            lbDateError.setText("");
        }
        if (!txtTime.getText().trim().equals("")) {
            while (true) {
                if (!txtTime.getText().trim().matches("[0-9]{0,2}:?[0-9]{0,2}?")) {
                    lbTimeError.setText("Thời gian có dạng: hh hoặc hh:mm.");
                    lbTimeError.setForeground(Color.red);
                    tblOrder.removeAll();
                    return;
                } else {
                    lbTimeError.setText("");
                    break;
                }
            }
        } else {
            lbTimeError.setText("");
        }
        String ss = "select * from OrderDetails join [Order] on OrderDetails.IDOrder=[Order].IDOrder where OrderDetails.IDOrder LIKE ? and OrderDetails.IDProduct LIKE ? and OrderDetails.CusName LIKE ? and OrderDetails.NamePromo LIKE ? and [Order].DateOrder LIKE ? and [Order].TimeOrder LIKE ? and [Order].UsernameEmp LIKE ? Order by OrderDetails.IDOrder DESC";
        try {
            ps = con.prepareStatement(ss);
            if (cbIDOrder.getSelectedIndex() == -1) {
                ps.setString(1, "%");
            } else {
                ps.setString(1, s1);
            }
            if (cbIDProduct.getSelectedIndex() == -1) {
                ps.setString(2, "%");
            } else {
                ps.setString(2, s2);
            }
            if (cbIDCus.getSelectedIndex() == -1) {
                ps.setString(3, "%");
            } else {
                ps.setString(3, s3);
            }
            if (cbPromotions.getSelectedIndex() == -1) {
                ps.setString(4, "%");
            } else {
                ps.setString(4, s4);
            }
            if (txtDate.getText().trim().equals("")) {
                ps.setString(5, "%");
            } else {
                ps.setString(5, "%" + s5);
            }
            if (txtTime.getText().trim().equals("")) {
                ps.setString(6, "%");
            } else {
                ps.setString(6, s6 + "%");
            }
            if (cbNameEmp.getSelectedIndex() == -1) {
                ps.setString(7, "%");
            } else {
                ps.setString(7, s7);
            }
            rsSearch1 = ps.executeQuery();
            if (rsSearch1.next()) {
                ps = con.prepareStatement(ss);
                if (cbIDOrder.getSelectedIndex() == -1) {
                    ps.setString(1, "%");
                } else {
                    ps.setString(1, s1);
                }
                if (cbIDProduct.getSelectedIndex() == -1) {
                    ps.setString(2, "%");
                } else {
                    ps.setString(2, s2);
                }
                if (cbIDCus.getSelectedIndex() == -1) {
                    ps.setString(3, "%");
                } else {
                    ps.setString(3, s3);
                }
                if (cbPromotions.getSelectedIndex() == -1) {
                    ps.setString(4, "%");
                } else {
                    ps.setString(4, s4);
                }
                if (txtDate.getText().trim().equals("")) {
                    ps.setString(5, "%");
                } else {
                    ps.setString(5, "%" + s5);
                }
                if (txtTime.getText().trim().equals("")) {
                    ps.setString(6, "%");
                } else {
                    ps.setString(6, s6 + "%");
                }
                if (cbNameEmp.getSelectedIndex() == -1) {
                    ps.setString(7, "%");
                } else {
                    ps.setString(7, s7);
                }
                rsSearch2 = ps.executeQuery();
                while (rsSearch2.next()) {
                    rowSearch = new Vector();
                    rowSearch.add(rsSearch2.getString("IDOrder"));
                    rowSearch.add(rsSearch2.getString("IDProduct"));
                    rowSearch.add(rsSearch2.getString("CusName"));
                    rowSearch.add(rsSearch2.getString("Quantity"));
                    rowSearch.add(rsSearch2.getString("NamePromo"));
                    rowSearch.add(rsSearch2.getString("TimeOrder"));
                    rowSearch.add(rsSearch2.getString("DateOrder"));
                    rowSearch.add(rsSearch2.getString("UsernameEmp"));
                    tblModel.addRow(rowSearch);
                }
                tblOrder.setModel(tblModel);
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu.");
                btnResetActionPerformed(evt);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi: Không thể kết nối đến máy chủ");
        }
    }//GEN-LAST:event_btnSearchActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cbIDCus;
    private javax.swing.JComboBox cbIDOrder;
    private javax.swing.JComboBox cbIDProduct;
    private javax.swing.JComboBox cbNameEmp;
    private javax.swing.JComboBox cbPromotions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDateError;
    private javax.swing.JLabel lbTimeError;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables
}
