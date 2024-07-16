
import java.sql.*;
import javax.swing.*;
public class Remove_Staff extends javax.swing.JFrame {

   
    public Remove_Staff() {
        initComponents();
        setDefaultCloseOperation(Remove_Book.DISPOSE_ON_CLOSE);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ENTER STAFF ID OR STAFF NAME TO DELETE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 410, 44));

        t1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 410, 43));

        delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 124, 41));

        cancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 124, 41));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Thiết kế chưa có tên (1).png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, -30, 860, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        String url = "jdbc:mysql://localhost:3306/library";
        String mysqlUser = "root";
        String mysqlPwd = "1357910";
        String input = t1.getText();
        String query = "delete from STAFFS where staff_id='"+input+"' or name='"+input+"'; ";
        
        try
        {
            Connection conn = DriverManager.getConnection(url, mysqlUser, mysqlPwd);
            Statement stm = conn.createStatement();
            int rows = stm.executeUpdate(query);
            
            // Check if any rows were affected
            if(rows>0)
                JOptionPane.showMessageDialog(this, "Staff removed from library!");
            else
                JOptionPane.showMessageDialog(this, "No such staff present!");
            
            // Close the statement object
            stm.close();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Remove_Staff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField t1;
    // End of variables declaration//GEN-END:variables
}
