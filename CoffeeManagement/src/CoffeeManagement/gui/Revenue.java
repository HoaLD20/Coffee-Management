package CoffeeManagement.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Le Duc Hoa
 */
public class Revenue extends javax.swing.JFrame {

    /**
     * Creates new form Revenue
     */
    ResultSet rs;
    Connection con;
    PreparedStatement ps;
    CoffeeManagement.server.DBHelper db = new CoffeeManagement.server.DBHelper();
    DefaultTableModel tblModel;
    Vector row;
    SimpleDateFormat ft = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    NumberFormat formatter = new DecimalFormat("#,###");

    public Revenue() {
        initComponents();
        ImageIcon img = new ImageIcon("src/CoffeeManagement/image/pricing.png");
        this.setIconImage(img.getImage());
        btnRefresh.setSize(40, 40);
        new SetImage().setImageButton(btnRefresh, "src/CoffeeManagement/image/Refresh.png");
        btnPrint.setSize(87, 87);
        new SetImage().setImageButton(btnPrint, "src/CoffeeManagement/image/Printer-icon.png");
        tblModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblModel.addColumn("Mã");
        tblModel.addColumn("Ngày/tháng/năm");
        tblModel.addColumn("Tiền thu (VNĐ)");
        tblRevenue.setModel(tblModel);
        loadTable();
        btnPrint.setEnabled(false);
    }

    public void loadTable() {
        try {
            con = db.getCon();
            ps = con.prepareStatement("select * from Revenue order by IDRevenue DESC");
            rs = ps.executeQuery();
            while (rs.next()) {
                row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(formatter.format(rs.getInt(3)));
                tblModel.addRow(row);
            }
            tblRevenue.setModel(tblModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi: Không thể kết nối đến máy chủ");
        }
        int line = tblRevenue.getRowCount();
        int tong = 0;
        for (int i = 0; i < line; i++) {
            String price = (String) tblRevenue.getValueAt(i, 2);
            tong += Integer.parseInt(price.replaceAll(",", ""));
        }
        lbTong.setText(formatter.format(tong) + " VNĐ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("image//bgRevenue.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRevenue = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("src//image//back_glossy.png");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        lbLoi = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbTong = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý doanh thu");
        setResizable(false);

        tblRevenue.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tblRevenue.setModel(new javax.swing.table.DefaultTableModel(
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
        tblRevenue.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblRevenue);

        lbLoi.setBackground(new java.awt.Color(255, 255, 255));
        lbLoi.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lbLoi.setForeground(new java.awt.Color(255, 255, 255));

        txtDate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtDate.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtDateCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDate)
            .addComponent(lbLoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Tìm kiếm theo ngày:");

        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Thống kê:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Tổng số tiền:");

        lbTong.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbTong.setText("0 VNĐ");

        btnPrint.setPreferredSize(new java.awt.Dimension(50, 50));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbTong))))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbTong)))
                    .addComponent(btnPrint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDateCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtDateCaretUpdate
        while (true) {
            if (!txtDate.getText().trim().matches("([0-9]{0,2}/)?([0-9]{0,2}/)?[0-9]{4}")) {
                lbLoi.setText("Nhập đúng định dạng để tìm kiếm: dd/MM/yyyy, MM/yyyy hoặc yyyy.");
                btnPrint.setEnabled(false);
                return;
            } else {
                lbLoi.setText("");
                break;
            }
        }
        tblModel.getDataVector().removeAllElements();
        try {
            ps = con.prepareStatement("select * from Revenue where Date like ?");
            ps.setString(1, "%" + (String) txtDate.getText().trim());
            rs = ps.executeQuery();
            if (rs.next()) {
                ps = con.prepareStatement("select * from Revenue where Date like ?");
                ps.setString(1, "%" + (String) txtDate.getText().trim());
                rs = ps.executeQuery();
                while (rs.next()) {
                    row = new Vector();
                    row.add(rs.getString(1));
                    row.add(rs.getString(2));
                    row.add(formatter.format(rs.getInt(3)));
                    tblModel.addRow(row);
                }
                tblRevenue.setModel(tblModel);
                btnPrint.setEnabled(true);
            } else {
                lbLoi.setText("Không tìm thấy dữ liệu!");
                tblRevenue.removeAll();
                btnPrint.setEnabled(false);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi: Không thể kết nối đến máy chủ");
        }
        int line = tblRevenue.getRowCount();
        int tong = 0;
        for (int i = 0; i < line; i++) {
            String price = (String) tblRevenue.getValueAt(i, 2);
            tong += Integer.parseInt(price.replaceAll(",", ""));
        }
        lbTong.setText(formatter.format(tong) + " VNĐ");
    }//GEN-LAST:event_txtDateCaretUpdate

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        tblModel.getDataVector().removeAllElements();
        loadTable();
        btnPrint.setEnabled(false);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        //xóa file txt
        File file = new File("src//CoffeeManagement//Revenue.txt");
        file.delete();
        //Viết vào file txt
        try {
            Writer b = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src//CoffeeManagement//Revenue.txt"), "UTF8"));
            String a;
            Date now = new Date();

            b.write("The Coffee House\r\n\r\n");
            b.write("Địa chỉ: Can Tho\r\n");
            b.write("SĐT: 01212692802\r\n");
            b.write("Thời gian: " + ft.format(now) + "\r\n\r\n");
            if (txtDate.getText().trim().matches("[0-9]{0,2}/[0-9]{0,2}/[0-9]{4}")) {
                a = "ngày " + txtDate.getText().trim();
                b.write("\tBảng thống kê doanh thu (theo " + a + ")\r\n\r\n");
            } else if (txtDate.getText().trim().matches("[0-9]{0,2}/[0-9]{4}")) {
                a = "tháng " + txtDate.getText().trim();
                b.write("\tBảng thống kê doanh thu (theo " + a + ")\r\n\r\n");
            } else if (txtDate.getText().trim().matches("[0-9]{4}")) {
                a = "năm " + txtDate.getText().trim();
                b.write("\tBảng thống kê doanh thu (theo " + a + ")\r\n\r\n");
            }
            b.write("\t---------------------------------\r\n");
            b.write("\tID\tNgày thu\tSố tiền\r\n");
            b.write("\t---------------------------------\r\n");
            int line = tblRevenue.getRowCount();
            for (int i = 0; i < line; i++) {
                String id = (String) tblRevenue.getValueAt(i, 0);
                String date = (String) tblRevenue.getValueAt(i, 1);
                String money = (String) tblRevenue.getValueAt(i, 2);
                b.write("\t" + id + "\t" + date + "\t" + money + "\r\n");
            }
            b.write("\t---------------------------------\r\n");
            b.write("\tTổng tiền:\t\t" + lbTong.getText().trim() + "\r\n\r\n\r\n");
            b.write("Người lập (Ký và ghi rõ họ tên)");
            b.close();
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        //Mở file txt
        Runtime run = Runtime.getRuntime();
        try {
            run.exec("notepad Revenue.txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        btnRefreshActionPerformed(evt);
    }//GEN-LAST:event_btnPrintActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbLoi;
    private javax.swing.JLabel lbTong;
    private javax.swing.JTable tblRevenue;
    private javax.swing.JTextField txtDate;
    // End of variables declaration//GEN-END:variables
}
