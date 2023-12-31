/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf;

import codes.DBconnection;
import codes.Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Heshan
 */
public class SQuestion extends javax.swing.JFrame {
    
//    Connection conn=null;
//    PreparedStatement pst =null;
//    ResultSet rs =null;

    /**
     * Creates new form SQuestion
     */
    public SQuestion() {
        initComponents();
//         conn=DBconnection.connect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new inf.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        q1cbox = new javax.swing.JComboBox<>();
        a1 = new javax.swing.JTextField();
        a2 = new javax.swing.JTextField();
        q2cbox = new javax.swing.JComboBox<>();
        q3cbox = new javax.swing.JComboBox<>();
        a3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 102), 10));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 0, 102));
        jPanel3.setRoundBottomLeft(40);
        jPanel3.setRoundBottomRight(40);

        jLabel1.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Security Questions");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        q1cbox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        q1cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "When is your birthday ", "Your first school name", "Your husbands/wifes name", "Your first pets name", "Your university name" }));
        jPanel2.add(q1cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 200, 25));
        jPanel2.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 200, -1));
        jPanel2.add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 200, -1));

        q2cbox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        q2cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "When is your birthday ", "Your first school name", "Your husbands/wifes name", "Your first pets name", "Your university name" }));
        jPanel2.add(q2cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 200, 25));

        q3cbox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        q3cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "When is your birthday ", "Your first school name", "Your husbands/wifes name", "Your first pets name", "Your university name" }));
        jPanel2.add(q3cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 200, 25));
        jPanel2.add(a3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 200, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Save");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 70, -1));

        Cancel.setBackground(new java.awt.Color(255, 255, 255));
        Cancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Cancel.setText("Cancel");
        Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelMouseClicked(evt);
            }
        });
        jPanel2.add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 370, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        savedata();
       
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void CancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_CancelMouseClicked

      
    
    public void savedata(){
        
        //Save data usinng Hibernate ........................................................................................................
        String q1 = null,q2 = null,q3 = null;
            String ans1 = null,ans2 = null,ans3 = null;
            
             q1= String.valueOf(q1cbox.getSelectedItem());
            q2= String.valueOf(q2cbox.getSelectedItem());
            q3= String.valueOf(q3cbox.getSelectedItem());
            ans1=a1.getText().toLowerCase();
            ans2=a2.getText().toLowerCase();
            ans3=a3.getText().toLowerCase();
            
            if (!ans1.isEmpty() && !ans2.isEmpty() && !ans3.isEmpty()) {
                Session s= connection.Controller.getSessionFactory().openSession();
                Transaction tr= s.beginTransaction();
                pojos.Temquestion tmp=(pojos.Temquestion)s.load(pojos.Temquestion.class, 1);
                tmp.setQuestion1(q1);
                tmp.setQuestion2(q2);
                tmp.setQuestion3(q3);

                tmp.setAns1(ans1);
                tmp.setAns2(ans2);
                tmp.setAns3(ans3);

                s.update(tmp);
                tr.commit();
                System.out.println("Done");
                s.close();
                tr=null;
                this.setVisible(false);
        }
            
//        try {
//            
//            q1= String.valueOf(q1cbox.getSelectedItem());
//            q2= String.valueOf(q2cbox.getSelectedItem());
//            q3= String.valueOf(q3cbox.getSelectedItem());
//            ans1=a1.getText().toLowerCase();
//            ans2=a2.getText().toLowerCase();
//            ans3=a3.getText().toLowerCase();
//            
//            if (!ans1.isEmpty() && !ans2.isEmpty() && !ans3.isEmpty()) {
//
//                String sql2 ="UPDATE temquestion SET question1='"+q1+"',question2='"+q2+"',question3='"+q3+"',question3='"+q3+"',ans1='"+ans1+"',ans2='"+ans2+"',ans3='"+ans3+"'";
//                pst= conn.prepareStatement(sql2);
//                pst.execute();
//                this.setVisible(false);
//            }
//            else{
//                JOptionPane.showMessageDialog(null, "Please answer the questions");
//            }
//           
//        } catch (SQLException ex) {
//            Logger.getLogger(SQuestion.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
        
//           pojos.Rooms rms=(pojos.Rooms)s.load(pojos.Rooms.class, 2);
//        rms.setAc("Non AC");
//        rms.setReceived("Yes");
//        rms.setRoomNo(2);
//        
//        s.update(rms);
//        tr.commit();
//        
//        System.out.println("Updated");
//        
//        s.close();
//        tr=null;
        
        
        
        
       
        
     
        
    }
   
    
    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SQuestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JTextField a1;
    private javax.swing.JTextField a2;
    private javax.swing.JTextField a3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private inf.PanelRound jPanel3;
    private javax.swing.JComboBox<String> q1cbox;
    private javax.swing.JComboBox<String> q2cbox;
    private javax.swing.JComboBox<String> q3cbox;
    // End of variables declaration//GEN-END:variables
}
