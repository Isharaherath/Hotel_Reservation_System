
package inf;

import codes.DBconnection;
import codes.Model;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class login extends javax.swing.JFrame {
    
    Connection conn=null;
    PreparedStatement pst =null;
    ResultSet rs =null;
    
    
    
    
    

  
    public login() {

       
        initComponents();

        
         conn=DBconnection.connect();
         
//      
         
    }
    
    
    


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        hotelId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        login_btn = new javax.swing.JButton();
        As_sign = new javax.swing.JButton();
        of_sign = new javax.swing.JButton();
        pw = new javax.swing.JPasswordField();
        forgotPWLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 255, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/293037492.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 400, 360));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 400, 250));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 400, 240));

        kGradientPanel1.setkEndColor(new java.awt.Color(51, 51, 51));
        kGradientPanel1.setkGradientFocus(600);
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 51, 153));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Trajan Pro", 1, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("queen mary Resort");
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 17, 400, 36));

        jPanel1.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 70));

        kGradientPanel2.setkEndColor(new java.awt.Color(0, 0, 0));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 51, 153));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hotel Id");
        kGradientPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 125, 20));
        kGradientPanel2.add(hotelId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 157, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        kGradientPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 91, 20));

        login_btn.setBackground(new java.awt.Color(0, 0, 0));
        login_btn.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        login_btn.setForeground(new java.awt.Color(255, 255, 255));
        login_btn.setText("Login");
        login_btn.setMinimumSize(new java.awt.Dimension(69, 29));
        login_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                login_btnMouseExited(evt);
            }
        });
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });
        login_btn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                login_btnKeyReleased(evt);
            }
        });
        kGradientPanel2.add(login_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 75, 30));

        As_sign.setBackground(new java.awt.Color(0, 0, 0));
        As_sign.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        As_sign.setForeground(new java.awt.Color(255, 255, 255));
        As_sign.setText("Assistant sign up");
        As_sign.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                As_signMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                As_signMouseExited(evt);
            }
        });
        As_sign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                As_signActionPerformed(evt);
            }
        });
        kGradientPanel2.add(As_sign, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, 30));

        of_sign.setBackground(new java.awt.Color(0, 0, 0));
        of_sign.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        of_sign.setForeground(new java.awt.Color(255, 255, 255));
        of_sign.setText("Officer sign up");
        of_sign.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                of_signMouseReleased(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                of_signMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                of_signMouseExited(evt);
            }
        });
        of_sign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                of_signActionPerformed(evt);
            }
        });
        kGradientPanel2.add(of_sign, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 145, 30));
        kGradientPanel2.add(pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 157, -1));

        forgotPWLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        forgotPWLabel.setForeground(new java.awt.Color(255, 255, 255));
        forgotPWLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forgotPWLabel.setText("Forgot Password ?");
        forgotPWLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotPWLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forgotPWLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgotPWLabelMouseExited(evt);
            }
        });
        kGradientPanel2.add(forgotPWLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 200, 140, -1));

        jPanel1.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 400, 250));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = -4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
       
         loginHome();
        
    }//GEN-LAST:event_login_btnActionPerformed

    private void As_signActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_As_signActionPerformed
        assistante_sign_up asp = new assistante_sign_up(); 
                asp.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_As_signActionPerformed

    private void of_signActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_of_signActionPerformed
         officer_sign_up osp = new officer_sign_up(); 
                osp.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_of_signActionPerformed

    private void login_btnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_login_btnKeyReleased
        // TODO add your handling code here:
    if (evt.getKeyCode()==KeyEvent.VK_ENTER){       
            loginHome();
        }
    }//GEN-LAST:event_login_btnKeyReleased

    private void login_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_btnMouseEntered
        // TODO add your handling code here:

        login_btn.setForeground(Color.YELLOW);
    }//GEN-LAST:event_login_btnMouseEntered

    private void login_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_btnMouseExited
       login_btn.setForeground(Color.WHITE);
    }//GEN-LAST:event_login_btnMouseExited

    private void As_signMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_As_signMouseEntered
        // TODO add your handling code here:
    As_sign.setForeground(Color.YELLOW);
    }//GEN-LAST:event_As_signMouseEntered

    private void of_signMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_of_signMouseEntered
        // TODO add your handling code here:
        of_sign.setForeground(Color.YELLOW);
    }//GEN-LAST:event_of_signMouseEntered

    private void As_signMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_As_signMouseExited
        // TODO add your handling code here:
    As_sign.setForeground(Color.WHITE);
    }//GEN-LAST:event_As_signMouseExited

    private void of_signMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_of_signMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_of_signMouseReleased

    private void of_signMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_of_signMouseExited
        // TODO add your handling code here:
        of_sign.setForeground(Color.WHITE);
    }//GEN-LAST:event_of_signMouseExited

    private void forgotPWLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPWLabelMouseClicked
        // TODO add your handling code here:
        resetPw rstpw= new resetPw();
        rstpw.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_forgotPWLabelMouseClicked

    private void forgotPWLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPWLabelMouseEntered
        // TODO add your handling code here:
        forgotPWLabel.setForeground(Color.yellow);
    }//GEN-LAST:event_forgotPWLabelMouseEntered

    private void forgotPWLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPWLabelMouseExited
        // TODO add your handling code here:
        forgotPWLabel.setForeground(Color.white);
    }//GEN-LAST:event_forgotPWLabelMouseExited

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }



public void loginHome(){

String hot_id,pword;
        hot_id=hotelId.getText();
        pword=pw.getText();
        
         String password1 = null,hotelId1 = null , username1=null;
         Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM assistante_password where hotel_id ='"+hot_id+"'");
            while(rs.next()){
             hotelId1 =rs.getString("hotel_id");
             username1 = rs.getString("username");
             password1 =rs.getString("password");
                System.out.println(password1);
                    
           }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
        
//        
        String password2 = null,hotelId2 = null, username2= null;
         try {
            stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM officer_password WHERE hotel_id='"+hot_id+"'");
            while(rs.next()){
            hotelId2 =rs.getString("hotel_id");
            username2=rs.getString("username");
            password2=rs.getString("password");
//           
           }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
        
        
       
        if((pword.equals(password2))){
             try {
                 home hm = new home();
                 hm.setVisible(true);
                 
                 String sql1 ="UPDATE current_officer SET hotel_id='"+hotelId2+"',username='"+username2+"',password='"+password2+"'";
                 pst= conn.prepareStatement(sql1);
                 pst.execute();
                 this.dispose();
             } catch (SQLException ex) {
                 Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
             }
            
           
          }
        else if((pword.equals(password1))){
             try {
                 home hm = new home();
                 hm.setVisible(true);
                 String sql1 ="UPDATE current_assistante SET hotel_id='"+hotelId1+"',username='"+username1+"',password='"+password1+"'";
                 pst= conn.prepareStatement(sql1);
                 pst.execute();
                 
                 this.dispose();
             } catch (SQLException ex) {
                 Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
             }
            }
        
        else{
            JOptionPane.showMessageDialog(null, "Please check your hotel ID name and password" );
        }
       
        



}




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton As_sign;
    private javax.swing.JLabel forgotPWLabel;
    private javax.swing.JTextField hotelId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JButton login_btn;
    private javax.swing.JButton of_sign;
    private javax.swing.JPasswordField pw;
    // End of variables declaration//GEN-END:variables
}
