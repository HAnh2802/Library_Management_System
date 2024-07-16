
import java.sql.*;
import javax.swing.*;
public class Add_Staff extends javax.swing.JFrame {

    
    public Add_Staff() {
        initComponents();
        setDefaultCloseOperation(Add_Staff.DISPOSE_ON_CLOSE);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        t3 = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STAFF ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 96, 145, 33));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("NAME");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 192, 145, 33));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CONTACT");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 290, 145, 33));
        getContentPane().add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 96, 311, 33));
        getContentPane().add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 192, 311, 33));
        getContentPane().add(t3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 311, 33));

        add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 130, 40));

        cancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 130, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Thiết kế chưa có tên (1).png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, -40, 780, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        
        String url = "jdbc:mysql://localhost:3306/library";
        String mysqlUser = "root";
        String mysqlPwd = "1357910";
        String query = "INSERT INTO STAFFS VALUES (?, ?, ?)";
        String id = t1.getText();
        String name = t2.getText();
        int contact = Integer.parseInt(t3.getText());
        try
        {
            Connection conn = DriverManager.getConnection(url, mysqlUser, mysqlPwd);
            PreparedStatement stm = conn.prepareCall(query);
            
            // Set the values for the prepared statement
            stm.setString(1, id);
            stm.setString(2, name);
            stm.setInt(3, contact);
            
            // Execute the prepared statement
            stm.execute();
            JOptionPane.showMessageDialog(this, "One staff added successfully!");
            
             // Clear the text fields
            t1.setText(null);
            t2.setText(null);
            t3.setText(null);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_addActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Staff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    // End of variables declaration//GEN-END:variables
}
