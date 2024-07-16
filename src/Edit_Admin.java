
import java.sql.*;
import javax.swing.*;

public class Edit_Admin extends javax.swing.JFrame {

    
    public Edit_Admin() {
        initComponents();
        setDefaultCloseOperation(Edit_Admin.DISPOSE_ON_CLOSE);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        columnlist = new javax.swing.JComboBox<>();
        update = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EDIT");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 81, 201, 35));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ENTER UPDATED VALUE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 231, 201, 35));
        getContentPane().add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 232, 313, 35));

        columnlist.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        columnlist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User ID", "Name", "Password", "Contact" }));
        getContentPane().add(columnlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 81, 313, 35));

        update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 330, 119, 37));

        cancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 119, 37));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Thiết kế chưa có tên (1).png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 0, 810, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        
        String url = "jdbc:mysql://localhost:3306/library";
        String mysqlUser = "root";
        String mysqlPwd = "1357910";
        String column = columnlist.getSelectedItem().toString();
        String id = t1.getText();
        String query = "update admin set "+column+"='"+id+"';";
        try
        {
            Connection conn = DriverManager.getConnection(url, mysqlUser, mysqlPwd);
            Statement stmnt = conn.createStatement();
            int rows = stmnt.executeUpdate(query);
            
            // Check if any rows were affected
            if(rows>0)
            {
                JOptionPane.showMessageDialog(this, "Credentials updated successfully!");
            }
            
            // Clear the text field t1
            t1.setText(" ");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_updateActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox<String> columnlist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField t1;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
