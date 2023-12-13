
package inf;

import codes.DBconnection;
import codes.Model;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class assistante_sign_up extends javax.swing.JFrame {
    
    
    Connection conn=null;
    PreparedStatement pst =null;
    ResultSet rs =null;
    
    ArrayList<String> as_id_list=new ArrayList<String>(); 

    public assistante_sign_up() {
        initComponents();
        
        conn=DBconnection.connect();
        
         
        
        
        
        
        
    }
    
    
     public void attache(){
         //image 
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f =chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        txt_filename.setText(filename);
       Image getAbsolutePath =null;
       ImageIcon icon =new ImageIcon(filename);
       Image image = icon.getImage().getScaledInstance(photo.getWidth(), photo.getHeight(),Image.SCALE_SMOOTH);
       photo.setIcon(icon);
        
    }
     
     
      public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    
    
    
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        uname = new javax.swing.JTextField();
        mobile = new javax.swing.JTextField();
        pword = new javax.swing.JPasswordField();
        email = new javax.swing.JTextField();
        oldpw = new javax.swing.JPasswordField();
        submit_btn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        oid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        offid = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_filename = new javax.swing.JTextField();
        attach = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        photo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 0, 79));
        kGradientPanel1.setkGradientFocus(400);
        kGradientPanel1.setkStartColor(new java.awt.Color(51, 0, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("New Assistant Sign Up");
        kGradientPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, -3, -1, 50));

        jPanel1.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 400, 50));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/293037492.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 270));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 190));

        jPanel4.setBackground(new java.awt.Color(0, 0, 81));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Full Name :");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 66, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User name :");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 98, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 133, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contact Number:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 176, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("E-mail Address:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 216, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Officer Password:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 296, -1, -1));
        jPanel4.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 63, 195, -1));
        jPanel4.add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 98, 195, -1));
        jPanel4.add(mobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 173, 195, -1));
        jPanel4.add(pword, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 133, 195, -1));
        jPanel4.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 213, 195, -1));
        jPanel4.add(oldpw, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 293, 196, -1));

        submit_btn.setBackground(new java.awt.Color(0, 0, 0));
        submit_btn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        submit_btn.setForeground(new java.awt.Color(255, 255, 255));
        submit_btn.setText("Submit");
        submit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_btnActionPerformed(evt);
            }
        });
        jPanel4.add(submit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 80, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 80, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Hotel Id :");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 26, -1, -1));
        jPanel4.add(oid, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 23, 195, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Officer Id:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 256, -1, -1));
        jPanel4.add(offid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 253, 196, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Image");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 336, -1, -1));
        jPanel4.add(txt_filename, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 333, 196, -1));

        attach.setBackground(new java.awt.Color(0, 0, 0));
        attach.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        attach.setForeground(new java.awt.Color(255, 255, 255));
        attach.setText("Attach");
        attach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachActionPerformed(evt);
            }
        });
        jPanel4.add(attach, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 100, 70));
        jPanel4.add(photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 100, 70));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Security Question");
        jButton1.setPreferredSize(new java.awt.Dimension(121, 23));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 400, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_btnActionPerformed
       
        
         String hoid,fname1,uname1,paword1,mobile1,email1,repano1,oldpw1,ofid;
         
        
         
         
         String q1 = null,q2 = null,q3 = null,a1 = null,a2 = null,a3 = null;
        
        try {
            
            
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM temquestion");
            while(rs.next()){
//          
             q1=rs.getString("question1");
             q2=rs.getString("question2");
             q3=rs.getString("question3");
             a1=rs.getString("ans1");
             a2=rs.getString("ans2");
             a3=rs.getString("ans3");
             
             
//           
           }
            
            
        } catch (Exception e) {
        }
        
         
         
         
          String image =txt_filename.getText();
       image=image.replace("\\","\\\\");
         
         
         
         
         
         
        
        hoid=oid.getText();
        fname1= fname.getText();
        uname1=uname.getText();
        paword1=pword.getText();
        mobile1=mobile.getText();
        email1=email.getText();
        ofid=offid.getText();
        oldpw1=oldpw.getText();
        
        if (hoid.isEmpty() || fname1.isEmpty() || uname1.isEmpty() || paword1.isEmpty() || mobile1.isEmpty() || email1.isEmpty() || ofid.isEmpty()
                || oldpw1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill the all fields!" );
            
        }else{
            if (isValid(email1)) {
                
            
            
        
        
         
        Statement stmt;
       String password2 = null;
         try {
            stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM officer_password where hotel_id='"+ofid+"'");
            while(rs.next()){
//          
             password2=rs.getString("password");
//           
           }
            
            stmt = conn.createStatement();
            ResultSet rs2=stmt.executeQuery("SELECT * FROM assistante_password ");
            while(rs2.next()){
//          
             as_id_list.add(rs2.getString("hotel_id"));
//           
           }
            
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
         
         
         
         
         
        
        if(oldpw1.equals(password2)){
            
            if(!as_id_list.contains(hoid)){
        
         try {
                String sql ="INSERT INTO assistante_details(hotel_id,name,contact,mail,officer_id,image)VALUES ('"+hoid+"','"+fname1+"','"+mobile1+"','"+email1+"','"+ofid+"','"+image+"')";
                pst= conn.prepareStatement(sql);
                pst.execute();

                
                
                   String sql1 ="INSERT INTO assistante_password(username,hotel_id,password,question1,question2,question3,ans1,ans2,ans3)VALUES ('"+uname1+"','"+hoid+"','"+paword1+"','"+q1+"','"+q2+"','"+q3+"','"+a1+"','"+a2+"','"+a3+"')";
                   pst= conn.prepareStatement(sql1);
                   pst.execute();
                
                String sql2 ="UPDATE current_assistante SET hotel_id='"+hoid+"',username='"+uname1+"',password='"+paword1+"'";
                 pst= conn.prepareStatement(sql2);
                 pst.execute();
                
                
                JOptionPane.showMessageDialog(null, "Welcome New Assistante. ");
                home hm = new home(); 
                hm.setVisible(true);
                this.dispose();


            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
         
                }else{
            JOptionPane.showMessageDialog(null, "Your Hotel Id is already in use" );
        }
        
        
        }  
        
         else{
            JOptionPane.showMessageDialog(null, "Please check officer Id and  password" );
        }
        }else{
                JOptionPane.showMessageDialog(null, "Please enter valid email" );
            }
        
        }
        
    }//GEN-LAST:event_submit_btnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        login lg= new login(); 
            lg.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void attachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachActionPerformed
       attache();
    }//GEN-LAST:event_attachActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        SQuestion sq= new SQuestion();
        sq.setVisible(true);

    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(assistante_sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(assistante_sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(assistante_sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(assistante_sign_up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new assistante_sign_up().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attach;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField mobile;
    private javax.swing.JTextField offid;
    private javax.swing.JTextField oid;
    private javax.swing.JPasswordField oldpw;
    private javax.swing.JLabel photo;
    private javax.swing.JPasswordField pword;
    private javax.swing.JButton submit_btn;
    private javax.swing.JTextField txt_filename;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
