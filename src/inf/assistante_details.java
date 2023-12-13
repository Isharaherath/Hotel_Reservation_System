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
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Heshan
 */
public class assistante_details extends javax.swing.JFrame {

    static void setModel(TableModel resultSetToTableModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     Connection conn=null;
    PreparedStatement pst =null;
    ResultSet rs =null;
    
    public assistante_details() {
        initComponents();
        conn=DBconnection.connect();
        
        tableload();
        idpanal.setVisible(false);
         Model model= new Model();
//         System.out.println(model.getHotelId());
//         System.out.println(model.getUsername());
//         System.out.println(model.getPassword());
         update_btn.setVisible(false);
        
    }
    
     public void tableload(){
        try {
            String sql= "SELECT id AS ID ,hotel_id AS 'Hotel Id' ,name AS 'Full Name' ,contact AS 'Contact No',mail AS 'E-mail',officer_id AS 'Officer Id',image AS 'Assistante Photo' FROM assistante_details";
            pst=conn.prepareStatement(sql);
            rs= pst.executeQuery();
           assistante_details.setModel(DbUtils.resultSetToTableModel(rs));
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
     
     
     public void tabledataget(){
        int r = assistante_details.getSelectedRow();
        
        String id =assistante_details.getValueAt(r, 0).toString();
        String hid=assistante_details.getValueAt(r, 1).toString();
        String name=assistante_details.getValueAt(r, 2).toString();
        String contact=assistante_details.getValueAt(r, 3).toString();
        String mail=assistante_details.getValueAt(r, 4).toString();
         String ofid=assistante_details.getValueAt(r, 5).toString();
       String filename=assistante_details.getValueAt(r, 6).toString();
        
      
        
        idlbl.setText(id);
        hidbox.setText(hid);
        namebox.setText(name);
        contactbox.setText(contact);
        mailbox.setText(mail);
        txt_filename.setText(filename);
        
        
        String current_hotel_id = null;
       
       Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM current_assistante");
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
        
        
        
        
        Image getAbsolutePath =null;
       ImageIcon icon =new ImageIcon(filename);
       Image image = icon.getImage().getScaledInstance(photo.getWidth(), photo.getHeight(),Image.SCALE_SMOOTH);
       photo.setIcon(icon);
        
        
       hi1.setText(hid);
        fn1.setText(name);
        cn1.setText(contact);
        em1.setText(mail);
        offid.setText(ofid);
        photo.setVisible(true);
        
       
               
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
            
            String sql ="UPDATE assistante_details SET hotel_id='"+hid+"',name='"+name+"',contact='"+contact+"',mail='"+mail+"',image='"+image+"' WHERE id='"+id+"' ";
            pst=conn.prepareStatement(sql);
            pst.execute();
            
            String sql2="UPDATE assistante_password SET hotel_id='"+hid+"' WHERE id='"+id+"'";
            pst=conn.prepareStatement(sql2);
            pst.execute();
            
             String sql3="UPDATE current_assistante SET hotel_id='"+hid+"'";
            pst=conn.prepareStatement(sql3);
            pst.execute();
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
                     
    }
       
       
        public void search1(){
        
        String src1=searchbox.getText();
        try {
            String sql ="SELECT id AS ID ,hotel_id AS 'Hotel Id' ,name AS 'Full Name' ,contact AS 'Contact No',mail AS 'E-mail',officer_id AS 'Officer Id',image AS 'Assistante Photo' FROM assistante_details WHERE hotel_id LIKE '%"+src1+"%' OR name LIKE '%"+src1+"%'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            assistante_details.setModel(DbUtils.resultSetToTableModel(rs));
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
        
        
        hi1.setText("............");
        fn1.setText("............");
        cn1.setText("............");
        em1.setText("............");
        offid.setText("............");
        photo.setVisible(false);
       }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        hidbox = new javax.swing.JTextField();
        namebox = new javax.swing.JTextField();
        contactbox = new javax.swing.JTextField();
        mailbox = new javax.swing.JTextField();
        update_btn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel9 = new inf.PanelRound();
        jPanel4 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        idpanal = new javax.swing.JPanel();
        idlbl = new javax.swing.JLabel();
        hi1 = new javax.swing.JLabel();
        fn1 = new javax.swing.JLabel();
        cn1 = new javax.swing.JLabel();
        em1 = new javax.swing.JLabel();
        offid = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        photo = new javax.swing.JLabel();
        txt_filename = new javax.swing.JTextField();
        attach = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        assistante_details = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        llklk = new javax.swing.JPanel();
        ll = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(0, 51, 102));
        jLabel11.setFont(new java.awt.Font("Trajan Pro", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 102));
        jLabel11.setText("QueeN Mary Resort");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 190, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 720, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(0, 51, 102));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hotel Id");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 32, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Full Name");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 72, -1, -1));
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 138, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contact No:");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 109, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("E-mail");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 148, -1, -1));
        jPanel7.add(hidbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 29, 170, -1));
        jPanel7.add(namebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 69, 170, -1));
        jPanel7.add(contactbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 109, 171, -1));
        jPanel7.add(mailbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 145, 171, -1));

        update_btn.setBackground(new java.awt.Color(153, 255, 255));
        update_btn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        update_btn.setText("Update");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });
        jPanel7.add(update_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 218, -1, -1));

        jButton2.setBackground(new java.awt.Color(153, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 218, 75, -1));

        jButton3.setBackground(new java.awt.Color(153, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 261, 79, -1));

        jButton4.setBackground(new java.awt.Color(153, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 261, 79, -1));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 300, 360));

        jPanel9.setBackground(new java.awt.Color(0, 51, 102));
        jPanel9.setRoundTopRight(70);

        jPanel4.setBackground(new java.awt.Color(0, 51, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });
        jPanel4.add(searchbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 31, 240, -1));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 300, 130));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 500));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idlbl.setText("ID");

        javax.swing.GroupLayout idpanalLayout = new javax.swing.GroupLayout(idpanal);
        idpanal.setLayout(idpanalLayout);
        idpanalLayout.setHorizontalGroup(
            idpanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idpanalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idlbl)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        idpanalLayout.setVerticalGroup(
            idpanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idpanalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idlbl)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel5.add(idpanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(932, 0, -1, -1));

        hi1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        hi1.setText("............");
        jPanel5.add(hi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 260, -1));

        fn1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        fn1.setText("............");
        jPanel5.add(fn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 250, -1));

        cn1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        cn1.setText("............");
        jPanel5.add(cn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 230, -1));

        em1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        em1.setText("............");
        jPanel5.add(em1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 240, -1));

        offid.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        offid.setText("............");
        jPanel5.add(offid, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 270, -1));

        jPanel8.setBackground(new java.awt.Color(0, 51, 102));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        photo.setBackground(new java.awt.Color(255, 255, 255));
        photo.setForeground(new java.awt.Color(255, 255, 255));
        photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photo.setAutoscrolls(true);
        photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 102), 8));
        jPanel8.add(photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 300, 280));

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel5.add(txt_filename, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 14, 83, -1));

        attach.setText("Attach");
        attach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachActionPerformed(evt);
            }
        });
        jPanel5.add(attach, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 13, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Hotel Id                     :");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 160, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Full Name                   :");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 160, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Contact No                :");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 160, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("E-mail                         :");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 160, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("AuthorizedOfficer Id :");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 160, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 1020, 270));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        assistante_details.setModel(new javax.swing.table.DefaultTableModel(
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
        assistante_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                assistante_detailsMouseClicked(evt);
            }
        });
        assistante_details.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                assistante_detailsKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(assistante_details);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 696, 350));

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
        ll.setText("Assistant's Details");

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

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 720, 460));

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        clear();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void assistante_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assistante_detailsMouseClicked
        tabledataget();
    }//GEN-LAST:event_assistante_detailsMouseClicked

    private void assistante_detailsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_assistante_detailsKeyReleased
        tabledataget();
        
    }//GEN-LAST:event_assistante_detailsKeyReleased

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
       
        update();
        tableload();
        JOptionPane.showMessageDialog(null, "Successfully Updated");
    }//GEN-LAST:event_update_btnActionPerformed

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
       search1();
    }//GEN-LAST:event_searchboxKeyReleased

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
                String sql ="DELETE FROM assistante_details WHERE id='"+id+"'";
                pst= conn.prepareStatement(sql);
                pst.execute();
                
                
                String sql2= "DELETE FROM assistante_password WHERE id='"+id+"'";
                pst=conn.prepareStatement(sql2);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Deleted");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "faafafafef");
            }
        }
        tableload();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void attachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachActionPerformed
       attache();
    }//GEN-LAST:event_attachActionPerformed

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
            java.util.logging.Logger.getLogger(assistante_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(assistante_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(assistante_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(assistante_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new assistante_details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable assistante_details;
    private javax.swing.JButton attach;
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
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private inf.PanelRound jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel ll;
    private javax.swing.JPanel llklk;
    private javax.swing.JTextField mailbox;
    private javax.swing.JTextField namebox;
    private javax.swing.JLabel offid;
    private javax.swing.JLabel photo;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTextField txt_filename;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
