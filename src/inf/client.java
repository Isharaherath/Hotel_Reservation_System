
package inf;

import codes.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class client extends javax.swing.JFrame {
    
   Connection conn=null;
   PreparedStatement pst =null;
   ResultSet rs =null;

    public client() {
        initComponents();
        
         conn=DBconnection.connect();
        
        loadtable();
        
        idpanal.setVisible(false);
        
        
    }
    
    
    
     public void loadtable(){
        try {
            String sql="SELECT id AS ID,room_no AS 'Room No',name AS Name,contact AS Contact ,mail AS 'E-Mail',members AS Members,address AS Addrass,package AS Package,payment AS Payments From clients";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            clienttable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
     
     
     public void tabledataget(){
        int r = clienttable.getSelectedRow();
        
        String id =clienttable.getValueAt(r, 0).toString();
        String rname=clienttable.getValueAt(r, 2).toString();
        String rcontact=clienttable.getValueAt(r, 3).toString();
        String rmail= clienttable.getValueAt(r, 4).toString();
        String rmembers=clienttable.getValueAt(r, 5).toString();
        String raddress=clienttable.getValueAt(r, 6).toString();
        String rroom_no=clienttable.getValueAt(r, 1).toString();
        String rpackage=clienttable.getValueAt(r, 7).toString();
        String rpayment=clienttable.getValueAt(r, 8).toString();
        
        idlbl.setText(id);
        rnamebox.setText(rname);
        rmobilebox.setText(rcontact);
        rmailbox.setText(rmail);
        rmcbox.setText(rmembers);
        radrbox.setText(raddress);
        rroombox.setText(rroom_no);
        rpackagebox.setSelectedItem(rpackage);
        rpaymentbox.setText(rpayment);
         
       
        rn2.setText(rname);
        pn1.setText(rcontact);
        em1.setText(rmail);
        ad1.setText(raddress);
        rn1.setText(rroom_no);
        pk1.setText(rpackage);
        py1.setText(rpayment);
        
        
               
    }
     
     
     
     public void update(){
        
        
        String id, rname, rcontact,rmail,rmembers,raddress,rpackage;
        int rroom_no;
        float rpayment;
        
        id=idlbl.getText();
        rname=rnamebox.getText();
        rcontact=rmobilebox.getText();
        rmail=rmailbox.getText();
        rmembers=rmcbox.getText();
        raddress=radrbox.getText();
        rroom_no=Integer.parseInt(rroombox.getText());
        rpackage=rpackagebox.getSelectedItem().toString();
        rpayment=Float.parseFloat(rpaymentbox.getText());
        
      
        try {
            
            String sql ="UPDATE clients SET room_no='"+rroom_no+"', name='"+rname+"',contact='"+rcontact+"',mail='"+rmail+"',members='"+rmembers+"',address='"+raddress+"',package='"+rpackage+"',payment='"+rpayment+"' WHERE id='"+id+"' ";
            pst=conn.prepareStatement(sql);
            pst.execute();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
      
    }
     
     
     
      public void search1(){
        
        String src1=searchbox1.getText();
        try {
            String sql ="SELECT id AS ID,room_no AS 'Room No',name AS Name,contact AS Contact ,mail AS 'E-Mail',members AS Members,address AS Addrass,package AS Package,payment AS Payments  FROM clients WHERE  room_no LIKE '%"+src1+"%' OR name LIKE '%"+src1+"%' OR package LIKE '%"+src1+"%'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            clienttable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
      
      public void clear(){
          
          idlbl.setText("ID");
        rnamebox.setText("");
        rmobilebox.setText("");
        rmailbox.setText("");
        rmcbox.setText("");
        radrbox.setText("");
        rroombox.setText("");
        rpackagebox.setSelectedItem("Full Board");
        rpaymentbox.setText("");
        
        
          rn2.setText("...............");
        pn1.setText("...............");
        em1.setText("...............");
        ad1.setText("...............");
        rn1.setText("...............");
        pk1.setText("...............");
        py1.setText("...............");
        
        
      }
     
     
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        clienttable = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        rn2 = new javax.swing.JLabel();
        rn1 = new javax.swing.JLabel();
        pn1 = new javax.swing.JLabel();
        ad1 = new javax.swing.JLabel();
        pk1 = new javax.swing.JLabel();
        py1 = new javax.swing.JLabel();
        em1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel9 = new inf.PanelRound();
        jPanel4 = new javax.swing.JPanel();
        searchbox1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rnamebox = new javax.swing.JTextField();
        rmobilebox = new javax.swing.JTextField();
        rmailbox = new javax.swing.JTextField();
        rmcbox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        radrbox = new javax.swing.JTextArea();
        rpackagebox = new javax.swing.JComboBox<>();
        rpaymentbox = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rroombox = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        idpanal = new javax.swing.JPanel();
        idlbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        clienttable.setModel(new javax.swing.table.DefaultTableModel(
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
        clienttable.setGridColor(new java.awt.Color(255, 255, 255));
        clienttable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clienttableMouseClicked(evt);
            }
        });
        clienttable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clienttableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(clienttable);

        jPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 22, 790, 500));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("Clients");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 0, -1, 24));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 810, 530));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1024, 100));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Trajan Pro", 1, 30)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Queen Mary Resort");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 470, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 690, 100));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rn2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        rn2.setText("...............");
        jPanel8.add(rn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 47, 200, -1));

        rn1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        rn1.setText("...............");
        jPanel8.add(rn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 13, 200, -1));

        pn1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pn1.setText("...............");
        jPanel8.add(pn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 81, 200, -1));

        ad1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ad1.setText("...............");
        jPanel8.add(ad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 115, 630, -1));

        pk1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pk1.setText("...............");
        jPanel8.add(pk1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 220, -1));

        py1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        py1.setText("...............");
        jPanel8.add(py1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 220, -1));

        em1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        em1.setText("...............");
        jPanel8.add(em1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 320, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setText("Phone No           :");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 83, 140, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("Receiver Name  :");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 47, 140, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setText("Room No            :");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setText("Address              :");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 117, 150, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setText("Package  :");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setText("Payment :");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel15.setText("E-mail      :");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 590, 790, 170));

        jPanel9.setBackground(new java.awt.Color(0, 51, 102));
        jPanel9.setRoundBottomRight(50);
        jPanel9.setRoundTopRight(100);
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 51, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchbox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchbox1KeyReleased(evt);
            }
        });
        jPanel4.add(searchbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 220, 30));

        jPanel9.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 260, 80));

        jPanel5.setBackground(new java.awt.Color(0, 51, 102));
        jPanel5.setPreferredSize(new java.awt.Dimension(310, 410));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Receiver Name");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Phone No:");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 86, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("E-mail");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 50, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Member's Count");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 110, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Address");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 60, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Package");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Payment");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, -1, -1));
        jPanel5.add(rnamebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 190, -1));
        jPanel5.add(rmobilebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 190, -1));
        jPanel5.add(rmailbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 190, -1));

        rmcbox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel5.add(rmcbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 190, -1));

        radrbox.setColumns(20);
        radrbox.setRows(5);
        jScrollPane1.setViewportView(radrbox);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 190, 100));

        rpackagebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Full Board", "Half Board" }));
        jPanel5.add(rpackagebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 190, -1));
        jPanel5.add(rpaymentbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 190, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Room no:");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));
        jPanel5.add(rroombox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 190, -1));

        jPanel9.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 310, 480));

        jPanel6.setBackground(new java.awt.Color(0, 51, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 51, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 80, -1));

        jButton3.setBackground(new java.awt.Color(0, 51, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 80, -1));

        jButton4.setBackground(new java.awt.Color(0, 51, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 80, -1));

        idlbl.setText("id");

        javax.swing.GroupLayout idpanalLayout = new javax.swing.GroupLayout(idpanal);
        idpanal.setLayout(idpanalLayout);
        idpanalLayout.setHorizontalGroup(
            idpanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, idpanalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(idlbl)
                .addContainerGap())
        );
        idpanalLayout.setVerticalGroup(
            idpanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, idpanalLayout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(idlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.add(idpanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 83, -1, -1));

        jPanel9.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 320, 170));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 760));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        update();
        loadtable();
         JOptionPane.showMessageDialog(null, "Successfully Updated");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void clienttableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clienttableMouseClicked
        
        tabledataget();
    }//GEN-LAST:event_clienttableMouseClicked

    private void clienttableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clienttableKeyReleased
        
        tabledataget();
    }//GEN-LAST:event_clienttableKeyReleased

    private void searchbox1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchbox1KeyReleased
       search1();
    }//GEN-LAST:event_searchbox1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
        clear();
    }//GEN-LAST:event_jButton2ActionPerformed

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
                String sql ="DELETE FROM clients WHERE id='"+id+"'";
                pst= conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Deleted");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "faafafafef");
            }
        }
        loadtable();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ad1;
    private javax.swing.JTable clienttable;
    private javax.swing.JLabel em1;
    private javax.swing.JLabel idlbl;
    private javax.swing.JPanel idpanal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private inf.PanelRound jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel pk1;
    private javax.swing.JLabel pn1;
    private javax.swing.JLabel py1;
    private javax.swing.JTextArea radrbox;
    private javax.swing.JTextField rmailbox;
    private javax.swing.JTextField rmcbox;
    private javax.swing.JTextField rmobilebox;
    private javax.swing.JLabel rn1;
    private javax.swing.JLabel rn2;
    private javax.swing.JTextField rnamebox;
    private javax.swing.JComboBox<String> rpackagebox;
    private javax.swing.JTextField rpaymentbox;
    private javax.swing.JTextField rroombox;
    private javax.swing.JTextField searchbox1;
    // End of variables declaration//GEN-END:variables
}
