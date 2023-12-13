/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf;

import codes.DBconnection;
import codes.Model;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Heshan
 */
public class officer_details extends javax.swing.JFrame {
    
    String Hot_id;
    
   

    Connection conn=null;
    PreparedStatement pst =null;
    ResultSet rs =null;
    
    
    
    public officer_details() {
        initComponents();
        conn=DBconnection.connect();
        
        tableload();
        idpanal.setVisible(false);
        
         
    }
    
    
    
    public void tableload(){
        try {
            String sql= "SELECT id AS ID ,hotel_id AS 'Hotel Id' ,name AS 'Full Name' ,contact AS 'Contact No',mail AS 'E-mail',image As 'Officer Photo' FROM officer_details";
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
           officer_table.setModel(DbUtils.resultSetToTableModel(rs));
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        update_btn.setVisible(false);
    }
    
     public void tabledataget(){
         
         photo.setVisible(true);
        int r = officer_table.getSelectedRow();
        
        String id =officer_table.getValueAt(r, 0).toString();
        String hid=officer_table.getValueAt(r, 1).toString();
        Hot_id=hid;
        String name=officer_table.getValueAt(r, 2).toString();
        String contact=officer_table.getValueAt(r, 3).toString();
        String mail=officer_table.getValueAt(r, 4).toString();
       String filename=officer_table.getValueAt(r, 5).toString();
       
       String current_hotel_id = null;
       
       Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM current_officer");
            while(rs.next()){
            current_hotel_id=rs.getString("hotel_id");
//           
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(officer_details.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(hid.equals(current_hotel_id)){
            update_btn.setVisible(true);
        }else
              update_btn.setVisible(false);
            update_btn.setVisible(true);
       
        
      
       
       
        
        idlbl.setText(id);
        hidbox.setText(hid);
        namebox.setText(name);
        contactbox.setText(contact);
        mailbox.setText(mail);
        
         txt_filename.setText(filename);
         
         Image getAbsolutePath =null;
       ImageIcon icon =new ImageIcon(filename);
       Image image = icon.getImage().getScaledInstance(photo.getWidth(), photo.getHeight(),Image.SCALE_SMOOTH);
       photo.setIcon(icon);
        
        
         hi1.setText(hid);
        fn1.setText(name);
        cn1.setText(contact);
        em1.setText(mail);
        
        
         
        
        
        
         
       
               
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
       photo.setVisible(true);
        
     }
     
     
      public void search1(){
        
        String src1=searchbox1.getText();
        try {
            String sql ="SELECT id AS ID ,hotel_id AS 'Hotel Id' ,name AS 'Full Name' ,contact AS 'Contact No',mail AS 'E-mail',image As 'Officer Photo' FROM officer_details WHERE hotel_id LIKE '%"+src1+"%' OR name LIKE '%"+src1+"%'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            officer_table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
     
     
     public void update(){
        
        
        String id, hid,name,contact,mail;
        
        
        id=idlbl.getText();
        hid=hidbox.getText();
        name=namebox.getText();
        contact=contactbox.getText();
        mail=mailbox.getText();
        
        
        String image =txt_filename.getText();
       image=image.replace("\\","\\\\");
        
      
        try {
            
            String sql ="UPDATE officer_details SET hotel_id='"+hid+"',name='"+name+"',contact='"+contact+"',mail='"+mail+"',image='"+image+"' WHERE id='"+id+"' ";
            pst=conn.prepareStatement(sql);
            pst.execute();
            
            String sql2="UPDATE officer_password SET hotel_id='"+hid+"' WHERE id='"+id+"'";
            pst=conn.prepareStatement(sql2);
            pst.execute();
            
             String sql3="UPDATE current_officer SET hotel_id='"+hid+"'";
            pst=conn.prepareStatement(sql3);
            pst.execute();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
      
    }
     
     
       public void clear(){
           
           
        idlbl.setText("ID");
        hidbox.setText("");
        namebox.setText("");
        contactbox.setText("");
        mailbox.setText("");
           
        hi1.setText("..............");
        fn1.setText("..............");
        cn1.setText("..............");
        em1.setText("..............");
        photo.setVisible(false);
        
       }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        idpanal = new javax.swing.JPanel();
        idlbl = new javax.swing.JLabel();
        hi1 = new javax.swing.JLabel();
        fn1 = new javax.swing.JLabel();
        cn1 = new javax.swing.JLabel();
        em1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        photo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        officer_table = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        llklk = new javax.swing.JPanel();
        ll = new javax.swing.JLabel();
        jPanel3 = new inf.PanelRound();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hidbox = new javax.swing.JTextField();
        namebox = new javax.swing.JTextField();
        contactbox = new javax.swing.JTextField();
        mailbox = new javax.swing.JTextField();
        update_btn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Attach = new javax.swing.JButton();
        txt_filename = new javax.swing.JTextField();
        searchbox = new javax.swing.JPanel();
        searchbox1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel9.setText("Queen Mary Resort");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 200, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 700, 40));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idlbl.setText("ID");

        javax.swing.GroupLayout idpanalLayout = new javax.swing.GroupLayout(idpanal);
        idpanal.setLayout(idpanalLayout);
        idpanalLayout.setHorizontalGroup(
            idpanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idpanalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(idlbl))
        );
        idpanalLayout.setVerticalGroup(
            idpanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(idlbl)
        );

        jPanel5.add(idpanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(929, 0, -1, -1));

        hi1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        hi1.setText("..............");
        jPanel5.add(hi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 75, -1, -1));

        fn1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        fn1.setText("..............");
        jPanel5.add(fn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 113, -1, -1));

        cn1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        cn1.setText("..............");
        jPanel5.add(cn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 151, -1, -1));

        em1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        em1.setText("..............");
        jPanel5.add(em1, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 190, -1, -1));

        jPanel7.setBackground(new java.awt.Color(0, 51, 102));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        photo.setBackground(new java.awt.Color(255, 255, 255));
        photo.setForeground(new java.awt.Color(255, 255, 255));
        photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photo.setAutoscrolls(true);
        photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102), 8));
        jPanel7.add(photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 277));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Hotel Id      :");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 77, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Full Name   :");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 115, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Contact No:");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 153, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("E-mail         :");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 192, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 1020, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        officer_table.setModel(new javax.swing.table.DefaultTableModel(
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
        officer_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                officer_tableMouseClicked(evt);
            }
        });
        officer_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                officer_tableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(officer_table);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 676, 360));

        jPanel10.setBackground(new java.awt.Color(93, 87, 255));

        llklk.setBackground(new java.awt.Color(255, 255, 255));
        llklk.setPreferredSize(new java.awt.Dimension(250, 1));

        javax.swing.GroupLayout llklkLayout = new javax.swing.GroupLayout(llklk);
        llklk.setLayout(llklkLayout);
        llklkLayout.setHorizontalGroup(
            llklkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        llklkLayout.setVerticalGroup(
            llklkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        ll.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        ll.setForeground(new java.awt.Color(255, 255, 255));
        ll.setText("Officer's Details");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ll)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(llklk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(290, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addComponent(ll, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(llklk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 80));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 700, 470));

        jPanel3.setBackground(new java.awt.Color(0, 51, 102));
        jPanel3.setRoundTopRight(70);

        jPanel4.setBackground(new java.awt.Color(0, 51, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hotel Id");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Full Name");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Conact");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("E-mail");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));
        jPanel4.add(hidbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 30, 180, -1));
        jPanel4.add(namebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 180, -1));
        jPanel4.add(contactbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 180, -1));
        jPanel4.add(mailbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 180, -1));

        update_btn.setBackground(new java.awt.Color(255, 255, 255));
        update_btn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        update_btn.setText("Update");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });
        jPanel4.add(update_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 88, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 89, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 88, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 89, -1));

        Attach.setText("Attach");
        Attach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttachActionPerformed(evt);
            }
        });
        jPanel4.add(Attach, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        jPanel4.add(txt_filename, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 220, 80, -1));

        searchbox.setBackground(new java.awt.Color(0, 51, 102));
        searchbox.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        searchbox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchbox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchbox1KeyReleased(evt);
            }
        });
        searchbox.add(searchbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 30, 250, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addComponent(searchbox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 320, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void officer_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_officer_tableKeyReleased
       tabledataget();
    }//GEN-LAST:event_officer_tableKeyReleased

    private void officer_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_officer_tableMouseClicked
        
        tabledataget();
    }//GEN-LAST:event_officer_tableMouseClicked

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        update();
        tableload();
        JOptionPane.showMessageDialog(null, "Successfully Updated");
    }//GEN-LAST:event_update_btnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchbox1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbox1KeyReleased
       search1();
    }//GEN-LAST:event_searchbox1KeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            home hm= new home(); 
            hm.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete");
        
        if(check ==0){
            
            String id = idlbl.getText();
            try {
                String sql ="DELETE FROM officer_details WHERE id='"+id+"'";
                pst= conn.prepareStatement(sql);
                pst.execute();
                
                 String sql2 ="DELETE FROM officer_password WHERE id='"+id+"'";
                pst= conn.prepareStatement(sql2);
                pst.execute();
                
                
                JOptionPane.showMessageDialog(null, "Deleted");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "faafafafef");
            }
        }
        tableload();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void AttachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttachActionPerformed
       
        attache();
    }//GEN-LAST:event_AttachActionPerformed

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
            java.util.logging.Logger.getLogger(officer_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(officer_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(officer_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(officer_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new officer_details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Attach;
    private javax.swing.JLabel cn1;
    private javax.swing.JTextField contactbox;
    private javax.swing.JLabel em1;
    private javax.swing.JLabel fn1;
    private javax.swing.JLabel hi1;
    private javax.swing.JTextField hidbox;
    private javax.swing.JLabel idlbl;
    private javax.swing.JPanel idpanal;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private inf.PanelRound jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel ll;
    private javax.swing.JPanel llklk;
    private javax.swing.JTextField mailbox;
    private javax.swing.JTextField namebox;
    private javax.swing.JTable officer_table;
    private javax.swing.JLabel photo;
    private javax.swing.JPanel searchbox;
    private javax.swing.JTextField searchbox1;
    private javax.swing.JTextField txt_filename;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
