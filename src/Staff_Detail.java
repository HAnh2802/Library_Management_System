


import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
public class Staff_Detail extends javax.swing.JFrame {

    
    public Staff_Detail() {
        initComponents();
        setDefaultCloseOperation(Staff_Detail.DISPOSE_ON_CLOSE);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        fetch = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STAFF ID", "NAME", "CONTACT"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 694, 311));

        fetch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fetch.setText("FETCH");
        fetch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fetchActionPerformed(evt);
            }
        });
        getContentPane().add(fetch, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 117, 44));

        exit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 117, 44));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Thiết kế chưa có tên (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 1080, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fetchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fetchActionPerformed
      
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        String url = "jdbc:mysql://localhost:3306/library";
        String mysqlUser = "root";
        String mysqlPwd = "1357910";
        String query = "select * from STAFFS;";
        try
        {
            Connection conn = DriverManager.getConnection(url, mysqlUser, mysqlPwd);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
             // Iterate through the result set
            while(rs.next())
            {
                // Retrieve the staff details from the result set
                String staffid = rs.getString("STAFF_ID");
                String name = rs.getString("NAME");
                int contact = rs.getInt("CONTACT");
                model.addRow(new Object[] {staffid, name, contact});
            }
            // Close the result set and statement objects
            rs.close();
            stm.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_fetchActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Staff_Detail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JButton fetch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
