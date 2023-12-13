
package inf;

import codes.DBconnection;
import gui.DatePicker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class reservation extends javax.swing.JFrame {

   Connection conn=null;
   PreparedStatement pst =null;
   ResultSet rs =null;
   
    public reservation() {
        initComponents();
        conn=DBconnection.connect();
        datecheck();
        loadtable();
        idpanel.setVisible(false);
        
    }
    
      SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
    
    public void datecheck(){
        
        
        
               String day=java.time.LocalDate.now().toString();
               
       
        
        try {
             Date today=sdf.parse(day);
            String sql= "SELECT * FROM reservation";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while (rs.next()) {                
                Date dout=sdf.parse(rs.getString("date_out"));
                int id =rs.getInt("id");
//                System.out.println(dout);
//                System.out.println(today);
//                System.out.println(id);
                if(dout.before(today)){
                    String sql2="DELETE FROM reservation WHERE id='"+id+"'";
                    pst=conn.prepareStatement(sql2);
                    pst.execute();
//                     System.out.println(dout);
//                     System.out.println(today);
//                     System.out.println(id);
//                     System.out.println("**************");
                }
            }
            
        } catch (Exception e) {
        }
        loadtable();
        
    }
    
     public void loadtable(){
        try {
            String sql="SELECT id AS ID ,name AS Name,room_no AS 'Room No',date_in AS 'Date In',date_out 'Date Out',package AS Package,mini_bar AS 'Mini Bar',pool AS Pool, spa AS Spa From reservation";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            reservtable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
     
     
     
     public void tabledataget(){
        int r = reservtable.getSelectedRow();
        
        String id =reservtable.getValueAt(r, 0).toString();
        String rname=reservtable.getValueAt(r, 1).toString();
        String room_no=reservtable.getValueAt(r, 2).toString();
        String rdatein=reservtable.getValueAt(r, 3).toString();
        String rdateout=reservtable.getValueAt(r, 4).toString();
        String rpackage=reservtable.getValueAt(r, 5).toString();
        
      
        
        idlbl.setText(id);
        rnamebox.setText(rname);
        dateoutbox.setText(rdateout);
        dateinbox.setText(rdatein);
        rroombox.setText(room_no);
        rpackagebox.setSelectedItem(rpackage);
       
        
         
        rn1.setText(rname);
        dout1.setText(rdateout);
        din1.setText(rdatein);
        rn2.setText(room_no);
               
    }
     
     
     
     public void search1(){
        
        String src1=searchbox1.getText();
        try {
            String sql ="SELECT id AS ID ,name AS Name,room_no AS 'Room No',date_in AS 'Date In',date_out 'Date Out',package AS Package FROM reservation WHERE name LIKE '%"+src1+"%' OR room_no = '"+src1+"' OR date_in = '"+src1+"' OR date_out = '"+src1+"' OR package LIKE '%"+src1+"%'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            reservtable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
   
     
    
    public void update(){
        
        
        String id, rname,rpackage,rdatein,rdateout;
        int rroom_no;
        float rpayment;
        
        id=idlbl.getText();
        rname=rnamebox.getText();
        rroom_no=Integer.parseInt(rroombox.getText());
        rpackage=rpackagebox.getSelectedItem().toString();
        rdateout=dateoutbox.getText();
        rdatein=dateinbox.getText();
        
      
        try {
            
            String sql ="UPDATE reservation SET name='"+rname+"',room_no='"+rroom_no+"',date_in='"+rdatein+"',date_out='"+rdateout+"',package='"+rpackage+"' WHERE id='"+id+"' ";
            pst=conn.prepareStatement(sql);
            pst.execute();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
      
    }
    
    
    public void clear(){
        idlbl.setText("ID");
        rnamebox.setText("");
        dateoutbox.setText("");
        dateinbox.setText("");
        rroombox.setText("");
        rpackagebox.setSelectedItem("Full Board");
        
        
         rn1.setText("................");
        dout1.setText("................");
        din1.setText("................");
        rn2.setText("................");
        
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        llklk = new javax.swing.JPanel();
        ll = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new inf.PanelRound();
        jPanel4 = new javax.swing.JPanel();
        searchbox1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rnamebox = new javax.swing.JTextField();
        rroombox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rpackagebox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        dateinbox = new javax.swing.JTextField();
        dateoutbox = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        idpanel = new javax.swing.JPanel();
        idlbl = new javax.swing.JLabel();
        dateInPicker = new javax.swing.JLabel();
        DateOutPicker = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reservtable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rn2 = new javax.swing.JLabel();
        rn1 = new javax.swing.JLabel();
        din1 = new javax.swing.JLabel();
        dout1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Trajan Pro", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Queen Mary Resort");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 40));

        jPanel9.setBackground(new java.awt.Color(93, 87, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel9.add(llklk, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        ll.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        ll.setForeground(new java.awt.Color(255, 255, 255));
        ll.setText("Resevations");
        jPanel9.add(ll, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 730, 130));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 730, 170));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(0, 51, 102));
        jPanel8.setRoundTopRight(70);

        jPanel4.setBackground(new java.awt.Color(0, 51, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        searchbox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchbox1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchbox1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchbox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(0, 51, 102));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Receiver Name");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 36, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Room no");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 79, -1, -1));
        jPanel7.add(rnamebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 33, 154, -1));
        jPanel7.add(rroombox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 77, 154, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date In");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 116, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date Out");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 159, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Package");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 205, -1, -1));

        rpackagebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Full Board", "Half Board" }));
        jPanel7.add(rpackagebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 202, 152, -1));

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 51, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 74, -1));

        jButton3.setBackground(new java.awt.Color(0, 51, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));
        jPanel7.add(dateinbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 116, 130, -1));
        jPanel7.add(dateoutbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 156, 130, -1));

        jButton4.setBackground(new java.awt.Color(0, 51, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 332, 70, -1));

        idlbl.setText("ID");

        javax.swing.GroupLayout idpanelLayout = new javax.swing.GroupLayout(idpanel);
        idpanel.setLayout(idpanelLayout);
        idpanelLayout.setHorizontalGroup(
            idpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idpanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(idlbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        idpanelLayout.setVerticalGroup(
            idpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idpanelLayout.createSequentialGroup()
                .addComponent(idlbl)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7.add(idpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 390, 40, -1));

        dateInPicker.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateInPicker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/calander25.png"))); // NOI18N
        dateInPicker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateInPickerMouseClicked(evt);
            }
        });
        jPanel7.add(dateInPicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 30, 30));

        DateOutPicker.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DateOutPicker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/calander25.png"))); // NOI18N
        DateOutPicker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DateOutPickerMouseClicked(evt);
            }
        });
        jPanel7.add(DateOutPicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 30, 30));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 290, 610));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 620));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reservtable.setModel(new javax.swing.table.DefaultTableModel(
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
        reservtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reservtableMouseClicked(evt);
            }
        });
        reservtable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                reservtableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(reservtable);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 27, 706, 400));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 730, 440));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Receiver Name  :");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Room No           :");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        rn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rn2.setText("................");
        jPanel5.add(rn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        rn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rn1.setText("................");
        jPanel5.add(rn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        din1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        din1.setText("................");
        jPanel5.add(din1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, -1, -1));

        dout1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dout1.setText("................");
        jPanel5.add(dout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Date In     :");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Date Out   :");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 1020, 150));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         int check = JOptionPane.showConfirmDialog(null, "Do you want to delete");
        
        if(check ==0){
            
            String id = idlbl.getText();
            try {
                String sql ="DELETE FROM reservation WHERE id='"+id+"'";
                pst= conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Deleted");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "faafafafef");
            }
        }
        loadtable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       update();
       loadtable();
       JOptionPane.showMessageDialog(null, "Successfully Updated");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void reservtableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reservtableKeyReleased
        tabledataget();
    }//GEN-LAST:event_reservtableKeyReleased

    private void reservtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservtableMouseClicked
       tabledataget();
    }//GEN-LAST:event_reservtableMouseClicked

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

    private void dateInPickerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateInPickerMouseClicked
        // TODO add your handling code here:

        DatePicker datePicker= new DatePicker(this);
        

        dateinbox.setText(datePicker.setPickedDate());

    }//GEN-LAST:event_dateInPickerMouseClicked

    private void DateOutPickerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DateOutPickerMouseClicked
        // TODO add your handling code here:

        DatePicker datePicker= new DatePicker(this);
        dateoutbox.setText(datePicker.setPickedDate());

//        int d2= Integer.valueOf(rdateout.getText().substring(Math.max(rdateout.getText().length() - 2, 0)));
//
//        int d1= Integer.valueOf(rdatein.getText().substring(Math.max(rdatein.getText().length() - 2, 0)));
//
//        Float pay=Float.valueOf(rpaymentbox.getText());
//        Float finalPay=pay*(d2-d1);
//        rpaymentbox.setText(finalPay.toString());

    }//GEN-LAST:event_DateOutPickerMouseClicked

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
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateOutPicker;
    private javax.swing.JLabel dateInPicker;
    private javax.swing.JTextField dateinbox;
    private javax.swing.JTextField dateoutbox;
    private javax.swing.JLabel din1;
    private javax.swing.JLabel dout1;
    private javax.swing.JLabel idlbl;
    private javax.swing.JPanel idpanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private inf.PanelRound jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel ll;
    private javax.swing.JPanel llklk;
    private javax.swing.JTable reservtable;
    private javax.swing.JLabel rn1;
    private javax.swing.JLabel rn2;
    private javax.swing.JTextField rnamebox;
    private javax.swing.JComboBox<String> rpackagebox;
    private javax.swing.JTextField rroombox;
    private javax.swing.JTextField searchbox1;
    // End of variables declaration//GEN-END:variables
}
