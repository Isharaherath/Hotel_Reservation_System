
package inf;

import codes.DBconnection;
import gui.DatePicker;
import java.awt.Color;
import java.awt.PageAttributes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import static org.hibernate.criterion.Projections.id;


public class home extends javax.swing.JFrame {

   Connection conn=null;
   PreparedStatement pst =null;
   ResultSet rs =null;
   String password1 = null;
   String password2 = null;

Color blueT=new Color(0, 30, 80);
Color noColour=new Color(0, 0, 0,0);
Color opColou=new Color(0, 51, 102);
    
    
    public home() {
       try {
           initComponents();
           
           conn=DBconnection.connect();
           
           loadtable();
           chackDate();
           
           offID.setText(current_officer.getText().toString());
           assID.setText(current_assistant.getText().toString());
           opwlabel.setVisible(false);
        opw.setVisible(false);
        apwLabel.setVisible(false);
           apw.setVisible(false);
           
           idpane.setVisible(false);
       } catch (ParseException ex) {
           Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        

    }

    
    
    

    
    SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
    
    public void tabledataget(){
        int r = tableroom.getSelectedRow();
        
        String id =tableroom.getValueAt(r, 0).toString();
        String rmno=tableroom.getValueAt(r, 1).toString();
        String type=tableroom.getValueAt(r, 2).toString();
        String received= tableroom.getValueAt(r, 3).toString();
        String acnac=tableroom.getValueAt(r, 4).toString();
        
        rmnobox.setText(rmno);
        typebox.setSelectedItem(type);
        receivebox.setSelectedItem(received);
        acbox.setSelectedItem(acnac);
        idlable.setText(id);
        
        rbox.setText(rmno);
        tbox.setText(type);
        rebox.setText(received);
         abox.setText(acnac);
         miniBar.setSelected(false);
         pool.setSelected(false);
         spa.setSelected(false);
         packageSelect.setSelected(false);
         
//         Single Room
//Double Room
//Twin Room
//Triple Room
//Family Room
//         
         
         if (tbox.getText().equals("Single Room")) {
            rmcountbox.setText("1");
             if (packageSelect.isSelected()) {
                 rpaymentbox.setText("3000");
             }else{
                 rpaymentbox.setText("5000");
             }
            
        }
         else if (tbox.getText().equals("Double Room")) {
            rmcountbox.setText("2");
             if (packageSelect.isSelected()) {
                 rpaymentbox.setText("5000");
             }else{
                 rpaymentbox.setText("9000");
             }
        }
          else if (tbox.getText().equals("Twin Room")) {
            rmcountbox.setText("2");
             if (packageSelect.isSelected()) {
                 rpaymentbox.setText("6000");
             }else{
                 rpaymentbox.setText("10000");
             }
        }
          else if (tbox.getText().equals("Triple Room")) {
            rmcountbox.setText("3");
             if (packageSelect.isSelected()) {
                 rpaymentbox.setText("8000");
             }else{
                 rpaymentbox.setText("16000");
             }
        }
         else if (tbox.getText().equals("Family Room")) {
            rmcountbox.setText("5");
             if (packageSelect.isSelected()) {
                 rpaymentbox.setText("10000");
             }else{
                 rpaymentbox.setText("25000");
             }
        }
         
         
         
         
         try {
              String day=java.time.LocalDate.now().toString();
             Date today=sdf.parse(day);
            String sql="SELECT * FROM reservation WHERE room_no='"+rmno+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            String book = "<html><body>";
            while(rs.next()){
                String d1=rs.getString("date_in");
                String d2=rs.getString("date_out");
                Date din=sdf.parse(d1);
                Date dout=sdf.parse(d2);
                 if ((din.after(today) || din.compareTo(today)==0) && dout.after(today)) {
                    book+=d1+" : "+d2+"<br>";
                    
                }
                
            }
             book+="</body></html>";
             bookins.setText(book);
        } catch (Exception e) {
        }
        
               
    }
    
    
    
    public void chackDate() throws ParseException {
        
        
        
         SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
              
               String day=java.time.LocalDate.now().toString();
               
//               Date date1=sdf.parse(d1);
               Date today=sdf.parse(day);
               
//               if (date1.before(date2)|| date1.compareTo(date2)==0) {
//                receivebox.setSelectedItem("Yes");
//           }else{
//                    receivebox.setSelectedItem("No");
//               }
        
        
        try {
            
              String sql= "SELECT * FROM reservation";
            pst= conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while (rs.next()) {
                Date din=sdf.parse(rs.getString("date_in"));
                Date dout=sdf.parse(rs.getString("date_out"));
                String roomNo=rs.getString("room_no");
//                System.out.println(roomNo);
//                System.out.println(din);
//                System.out.println(dout);
//                System.out.println(today);
                
                
                 if ((din.before(today) || din.compareTo(today)==0) && dout.after(today)) {
                     
                    String receive="Yes";
                    String sql2 ="UPDATE rooms SET received='"+receive+"' WHERE room_no='"+roomNo+"'";
                    pst=conn.prepareStatement(sql2);
                    pst.execute();
                }else{
                     
                     String receive="No";
                    String sql2 ="UPDATE rooms SET received='"+receive+"' WHERE room_no='"+roomNo+"'";
                    pst=conn.prepareStatement(sql2);
                    pst.execute();
                     
                 }
                
            }
            
        } catch (Exception e) {
        }
        
       loadtable();
         
      
    }
    
    

    
    public void update(){
        
        int rm_no;
        String id, type, receive,acnac;
        
        id=idlable.getText();
      rm_no=Integer.parseInt(rmnobox.getText());
      type=typebox.getSelectedItem().toString();
      receive=receivebox.getSelectedItem().toString();
      acnac=acbox.getSelectedItem().toString();
      
        try {
            
            String sql ="UPDATE rooms SET room_no='"+rm_no+"',type='"+type+"',received='"+receive+"',ac='"+acnac+"' WHERE id='"+id+"' ";
            pst=conn.prepareStatement(sql);
            pst.execute();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
      
    }
    
    
    
    public void clear(){
          
        idlable.setText("ID");
        rcnamebox.setText("");
        rpnomberbox.setText("");
        rmailbox.setText("");
        rmcountbox.setText("");
        radrbox.setText("");
        rmnobox.setText("");
        packageSelect.setSelected(false);
        rpaymentbox.setText("");
      }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        optionPanel = new inf.PanelRound();
        menu_open = new javax.swing.JLabel();
        menu_close = new javax.swing.JLabel();
        transPanel = new inf.PanelRound();
        today2 = new javax.swing.JLabel();
        off1 = new javax.swing.JLabel();
        off2 = new javax.swing.JLabel();
        off3 = new javax.swing.JLabel();
        allRooms = new javax.swing.JLabel();
        availableRooms = new javax.swing.JLabel();
        bookedRooms = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        current_assistant = new javax.swing.JLabel();
        current_officer = new javax.swing.JLabel();
        imagepanel = new inf.PanelRound();
        jLabel23 = new javax.swing.JLabel();
        hidePanel = new javax.swing.JPanel();
        offID = new javax.swing.JLabel();
        assID = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        reservationbtn = new javax.swing.JButton();
        clientbtn = new javax.swing.JButton();
        apwLabel = new javax.swing.JLabel();
        apw = new javax.swing.JPasswordField();
        opwlabel = new javax.swing.JLabel();
        opw = new javax.swing.JPasswordField();
        backbtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        addroombtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        acbox = new javax.swing.JComboBox<>();
        receivebox = new javax.swing.JComboBox<>();
        typebox = new javax.swing.JComboBox<>();
        rmnobox = new javax.swing.JTextField();
        cha_Ass_pwd = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cha_of_pwd1 = new javax.swing.JLabel();
        off_details = new javax.swing.JLabel();
        ass_details = new javax.swing.JLabel();
        payment = new javax.swing.JButton();
        today = new javax.swing.JLabel();
        panelRound2 = new inf.PanelRound();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rcnamebox = new javax.swing.JTextField();
        rpnomberbox = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rmailbox = new javax.swing.JTextField();
        rmcountbox = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rdatein = new javax.swing.JTextField();
        rdateout = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        radrbox = new javax.swing.JTextArea();
        insertbtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        rpaymentbox = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        DateOutPicker = new javax.swing.JLabel();
        dateInPicker = new javax.swing.JLabel();
        miniBar = new javax.swing.JCheckBox();
        pool = new javax.swing.JCheckBox();
        spa = new javax.swing.JCheckBox();
        packageSelect = new javax.swing.JToggleButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        idpane = new javax.swing.JPanel();
        fname = new javax.swing.JLabel();
        pnumber = new javax.swing.JLabel();
        mail1 = new javax.swing.JLabel();
        adr1 = new javax.swing.JLabel();
        rbox = new javax.swing.JLabel();
        tbox = new javax.swing.JLabel();
        rebox = new javax.swing.JLabel();
        abox = new javax.swing.JLabel();
        idlable = new javax.swing.JLabel();
        bookins = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableroom = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        allRoomsCbox = new javax.swing.JCheckBox();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        search1 = new javax.swing.JTextField();
        ll = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1420, 845));
        jPanel1.setPreferredSize(new java.awt.Dimension(1420, 845));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        optionPanel.setBackground(new java.awt.Color(255, 255, 255));
        optionPanel.setForeground(new java.awt.Color(255, 255, 255));
        optionPanel.setRoundTopRight(80);
        optionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu_open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/icons8-menu-rounded-48.png"))); // NOI18N
        menu_open.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_openMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu_openMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menu_openMouseExited(evt);
            }
        });
        optionPanel.add(menu_open, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3, -1, 40));

        menu_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/icons8-menu-rounded-48.png"))); // NOI18N
        menu_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menu_closeMouseExited(evt);
            }
        });
        optionPanel.add(menu_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 3, -1, 40));

        transPanel.setBackground(new java.awt.Color(220, 255, 20, 40)
        );

        today2.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        today2.setForeground(new java.awt.Color(255, 255, 255));
        today2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        today2.setText("2022-07-08");
        today2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        off1.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        off1.setForeground(new java.awt.Color(255, 255, 255));
        off1.setText("All Rooms");

        off2.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        off2.setForeground(new java.awt.Color(255, 255, 255));
        off2.setText("Available Rooms");

        off3.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        off3.setForeground(new java.awt.Color(255, 255, 255));
        off3.setText("Booked Rooms");

        allRooms.setFont(new java.awt.Font("Stencil", 0, 26)); // NOI18N
        allRooms.setForeground(new java.awt.Color(255, 255, 255));
        allRooms.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        allRooms.setText("1");

        availableRooms.setFont(new java.awt.Font("Stencil", 0, 26)); // NOI18N
        availableRooms.setForeground(new java.awt.Color(255, 255, 255));
        availableRooms.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        availableRooms.setText("1");

        bookedRooms.setFont(new java.awt.Font("Stencil", 0, 26)); // NOI18N
        bookedRooms.setForeground(new java.awt.Color(255, 255, 255));
        bookedRooms.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookedRooms.setText("1");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Logged in Officer ID      :");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Logged in Assistant ID  :");

        current_assistant.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        current_assistant.setForeground(new java.awt.Color(255, 255, 255));
        current_assistant.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        current_assistant.setText("Assistant Name");

        current_officer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        current_officer.setForeground(new java.awt.Color(255, 255, 255));
        current_officer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        current_officer.setText("Officer Name");

        javax.swing.GroupLayout transPanelLayout = new javax.swing.GroupLayout(transPanel);
        transPanel.setLayout(transPanelLayout);
        transPanelLayout.setHorizontalGroup(
            transPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(today2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transPanelLayout.createSequentialGroup()
                .addGroup(transPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(transPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(transPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(off2, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(off3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(transPanelLayout.createSequentialGroup()
                                .addComponent(off1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(transPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(availableRooms, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(allRooms, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bookedRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transPanelLayout.createSequentialGroup()
                        .addGroup(transPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(transPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(current_officer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(current_assistant, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))))
                .addContainerGap())
        );
        transPanelLayout.setVerticalGroup(
            transPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(today2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(transPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(current_officer))
                .addGap(13, 13, 13)
                .addGroup(transPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(current_assistant))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(transPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(off1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(allRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(transPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(off2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(availableRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(transPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(off3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookedRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        optionPanel.add(transPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 310, 780));

        imagepanel.setBackground(new java.awt.Color(0, 51, 102));
        imagepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/crop.jpg"))); // NOI18N
        jLabel23.setText("jLabel23");
        imagepanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 310, 870));

        optionPanel.add(imagepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 310, 780));

        hidePanel.setBackground(new java.awt.Color(0, 51, 102));

        offID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        offID.setForeground(new java.awt.Color(255, 255, 255));
        offID.setText("Office");

        assID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        assID.setForeground(new java.awt.Color(255, 255, 255));
        assID.setText("Assistante");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Office ID :");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Assistante ID :");

        javax.swing.GroupLayout hidePanelLayout = new javax.swing.GroupLayout(hidePanel);
        hidePanel.setLayout(hidePanelLayout);
        hidePanelLayout.setHorizontalGroup(
            hidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hidePanelLayout.createSequentialGroup()
                .addGroup(hidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hidePanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(hidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(offID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(assID, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        hidePanelLayout.setVerticalGroup(
            hidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hidePanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(hidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(offID)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(hidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assID)
                    .addComponent(jLabel17))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        optionPanel.add(hidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 290, 130));

        reservationbtn.setBackground(new java.awt.Color(0, 0, 0));
        reservationbtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        reservationbtn.setForeground(new java.awt.Color(255, 255, 255));
        reservationbtn.setText("Reservation");
        reservationbtn.setMaximumSize(new java.awt.Dimension(100, 25));
        reservationbtn.setMinimumSize(new java.awt.Dimension(100, 25));
        reservationbtn.setPreferredSize(new java.awt.Dimension(100, 25));
        reservationbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reservationbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reservationbtnMouseExited(evt);
            }
        });
        reservationbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservationbtnActionPerformed(evt);
            }
        });
        optionPanel.add(reservationbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 120, 30));

        clientbtn.setBackground(new java.awt.Color(0, 0, 0));
        clientbtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        clientbtn.setForeground(new java.awt.Color(255, 255, 255));
        clientbtn.setText("Clients");
        clientbtn.setMaximumSize(new java.awt.Dimension(100, 25));
        clientbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clientbtnMouseReleased(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clientbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clientbtnMouseExited(evt);
            }
        });
        clientbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientbtnActionPerformed(evt);
            }
        });
        optionPanel.add(clientbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 120, 30));

        apwLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        apwLabel.setForeground(new java.awt.Color(255, 255, 255));
        apwLabel.setText("Assistant Password");
        optionPanel.add(apwLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, -1, -1));
        optionPanel.add(apw, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 144, -1));

        opwlabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        opwlabel.setForeground(new java.awt.Color(255, 255, 255));
        opwlabel.setText("Officer Password");
        optionPanel.add(opwlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, -1, -1));

        opw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opwActionPerformed(evt);
            }
        });
        optionPanel.add(opw, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, 144, -1));

        backbtn.setBackground(new java.awt.Color(0, 0, 0));
        backbtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        backbtn.setForeground(new java.awt.Color(255, 255, 255));
        backbtn.setText("Back");
        backbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backbtnMouseExited(evt);
            }
        });
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });
        optionPanel.add(backbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 760, 100, -1));

        exitbtn.setBackground(new java.awt.Color(0, 0, 0));
        exitbtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        exitbtn.setForeground(new java.awt.Color(255, 255, 255));
        exitbtn.setText("Exit");
        exitbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitbtnMouseExited(evt);
            }
        });
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });
        optionPanel.add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 760, 100, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Room No:");
        optionPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 70, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Type:");
        optionPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Received");
        optionPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ac/Non Ac");
        optionPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        addroombtn.setBackground(new java.awt.Color(0, 0, 0));
        addroombtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        addroombtn.setForeground(new java.awt.Color(255, 255, 255));
        addroombtn.setText("Add room");
        addroombtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addroombtnActionPerformed(evt);
            }
        });
        optionPanel.add(addroombtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 260, -1, -1));

        updatebtn.setBackground(new java.awt.Color(0, 0, 0));
        updatebtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        updatebtn.setForeground(new java.awt.Color(255, 255, 255));
        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        optionPanel.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 79, -1));

        deletebtn.setBackground(new java.awt.Color(0, 0, 0));
        deletebtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        deletebtn.setForeground(new java.awt.Color(255, 255, 255));
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        optionPanel.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 80, -1));

        acbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "Non AC" }));
        optionPanel.add(acbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 145, -1));

        receivebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Yes" }));
        optionPanel.add(receivebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 145, -1));

        typebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single Room", "Double Room", "Twin Room", "Triple Room", "Family Room" }));
        optionPanel.add(typebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 145, -1));
        optionPanel.add(rmnobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 145, -1));

        cha_Ass_pwd.setBackground(new java.awt.Color(255, 255, 255));
        cha_Ass_pwd.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        cha_Ass_pwd.setForeground(new java.awt.Color(255, 255, 255));
        cha_Ass_pwd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cha_Ass_pwd.setText("Change Assistant Password");
        cha_Ass_pwd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cha_Ass_pwdMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cha_Ass_pwdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cha_Ass_pwdMouseExited(evt);
            }
        });
        optionPanel.add(cha_Ass_pwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 330, 40));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Today");
        optionPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 44, 108, 31));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(185, 1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        optionPanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 80, 250, 1));

        cha_of_pwd1.setBackground(new java.awt.Color(255, 255, 255));
        cha_of_pwd1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        cha_of_pwd1.setForeground(new java.awt.Color(255, 255, 255));
        cha_of_pwd1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cha_of_pwd1.setText("Change Officer Password");
        cha_of_pwd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cha_of_pwd1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cha_of_pwd1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cha_of_pwd1MouseExited(evt);
            }
        });
        optionPanel.add(cha_of_pwd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 330, 40));

        off_details.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        off_details.setForeground(new java.awt.Color(255, 255, 255));
        off_details.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        off_details.setText("Officer Details");
        off_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                off_detailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                off_detailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                off_detailsMouseExited(evt);
            }
        });
        optionPanel.add(off_details, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 710, 330, 40));

        ass_details.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        ass_details.setForeground(new java.awt.Color(255, 255, 255));
        ass_details.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ass_details.setText("Assistante Details");
        ass_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ass_detailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ass_detailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ass_detailsMouseExited(evt);
            }
        });
        optionPanel.add(ass_details, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 330, 40));

        payment.setBackground(new java.awt.Color(0, 0, 0));
        payment.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        payment.setForeground(new java.awt.Color(255, 255, 255));
        payment.setText("Payment");
        payment.setMaximumSize(new java.awt.Dimension(100, 25));
        payment.setPreferredSize(new java.awt.Dimension(100, 30));
        payment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paymentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paymentMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                paymentMouseReleased(evt);
            }
        });
        optionPanel.add(payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, -1, -1));

        today.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        today.setForeground(new java.awt.Color(255, 255, 255));
        today.setText("Date");
        optionPanel.add(today, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 160, 30));

        jPanel1.add(optionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 330, 830));

        panelRound2.setBackground(new java.awt.Color(0, 51, 102));
        panelRound2.setMinimumSize(new java.awt.Dimension(306, 633));
        panelRound2.setPreferredSize(new java.awt.Dimension(306, 633));
        panelRound2.setRoundTopLeft(150);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(180, 2));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelRound2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 220, -1));

        jLabel20.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Rooms Booking");
        panelRound2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Receiver Name");
        panelRound2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));
        panelRound2.add(rcnamebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 145, -1));
        panelRound2.add(rpnomberbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 145, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Phone No:");
        panelRound2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("E-mail");
        panelRound2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        panelRound2.add(rmailbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 145, -1));
        panelRound2.add(rmcountbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 145, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Member's Count");
        panelRound2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Date In");
        panelRound2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));
        panelRound2.add(rdatein, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 120, -1));

        rdateout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdateoutActionPerformed(evt);
            }
        });
        panelRound2.add(rdateout, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 120, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Date Out");
        panelRound2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Address");
        panelRound2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        radrbox.setColumns(20);
        radrbox.setRows(5);
        radrbox.setMinimumSize(new java.awt.Dimension(4, 18));
        radrbox.setPreferredSize(new java.awt.Dimension(132, 94));
        jScrollPane2.setViewportView(radrbox);

        panelRound2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 150, 142));

        insertbtn.setBackground(new java.awt.Color(0, 0, 0));
        insertbtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        insertbtn.setForeground(new java.awt.Color(255, 255, 255));
        insertbtn.setText("Insert");
        insertbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                insertbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                insertbtnMouseExited(evt);
            }
        });
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });
        panelRound2.add(insertbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, 109, -1));

        clearbtn.setBackground(new java.awt.Color(0, 0, 0));
        clearbtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        clearbtn.setForeground(new java.awt.Color(255, 255, 255));
        clearbtn.setText("Clear");
        clearbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearbtnMouseExited(evt);
            }
        });
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });
        panelRound2.add(clearbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 650, 116, -1));
        panelRound2.add(rpaymentbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 590, 145, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Payment");
        panelRound2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Package");
        panelRound2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, -1, -1));

        DateOutPicker.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DateOutPicker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/calander25.png"))); // NOI18N
        DateOutPicker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DateOutPickerMouseClicked(evt);
            }
        });
        panelRound2.add(DateOutPicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 30, 40));

        dateInPicker.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateInPicker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/calander25.png"))); // NOI18N
        dateInPicker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateInPickerMouseClicked(evt);
            }
        });
        panelRound2.add(dateInPicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 30, 40));

        miniBar.setBackground(new java.awt.Color(0, 51, 102));
        miniBar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        miniBar.setForeground(new java.awt.Color(255, 255, 255));
        miniBar.setText("Mini Bar");
        miniBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        miniBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miniBarMouseClicked(evt);
            }
        });
        miniBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miniBarActionPerformed(evt);
            }
        });
        panelRound2.add(miniBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, -1, -1));

        pool.setBackground(new java.awt.Color(0, 51, 102));
        pool.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pool.setForeground(new java.awt.Color(255, 255, 255));
        pool.setText("Pool");
        pool.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poolActionPerformed(evt);
            }
        });
        panelRound2.add(pool, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 530, 60, -1));

        spa.setBackground(new java.awt.Color(0, 51, 102));
        spa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        spa.setForeground(new java.awt.Color(255, 255, 255));
        spa.setText("Spa");
        spa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        spa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spaActionPerformed(evt);
            }
        });
        panelRound2.add(spa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, -1, -1));

        packageSelect.setBackground(new java.awt.Color(255, 255, 255));
        packageSelect.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        packageSelect.setText("Full Board");
        packageSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                packageSelectMouseClicked(evt);
            }
        });
        packageSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                packageSelectActionPerformed(evt);
            }
        });
        panelRound2.add(packageSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, 140, -1));

        jPanel1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 130, 340, 700));

        kGradientPanel1.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkGradientFocus(900);
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trajan Pro", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Queen Mary Resort");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 510, 40));

        jPanel1.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 50));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idpane.setBackground(new java.awt.Color(255, 255, 255));
        idpane.setForeground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout idpaneLayout = new javax.swing.GroupLayout(idpane);
        idpane.setLayout(idpaneLayout);
        idpaneLayout.setHorizontalGroup(
            idpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        idpaneLayout.setVerticalGroup(
            idpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel5.add(idpane, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 8, 70, 30));

        fname.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        fname.setText("Room No   :");
        jPanel5.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        pnumber.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        pnumber.setText("Type           :");
        jPanel5.add(pnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 88, -1));

        mail1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        mail1.setText("Recieved   :");
        jPanel5.add(mail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        adr1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        adr1.setText("Ac/Non Ac :");
        jPanel5.add(adr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        rbox.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        rbox.setText("..................");
        jPanel5.add(rbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 160, -1));

        tbox.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        tbox.setText("..................");
        jPanel5.add(tbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 160, -1));

        rebox.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        rebox.setText("..................");
        jPanel5.add(rebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 160, -1));

        abox.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        abox.setText("..................");
        jPanel5.add(abox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 160, -1));

        idlable.setForeground(new java.awt.Color(255, 255, 255));
        idlable.setText("ID");
        jPanel5.add(idlable, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 40, -1));

        bookins.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        bookins.setText("schedule");
        jPanel5.add(bookins, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 250, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Bookings");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        jPanel10.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 750, 270));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableroom.setModel(new javax.swing.table.DefaultTableModel(
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
        tableroom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableroomMouseClicked(evt);
            }
        });
        tableroom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableroomKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableroom);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 730, 330));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Available Rooms");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 150, 30));

        allRoomsCbox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        allRoomsCbox.setForeground(new java.awt.Color(0, 51, 102));
        allRoomsCbox.setText("All Rooms");
        allRoomsCbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allRoomsCboxActionPerformed(evt);
            }
        });
        jPanel4.add(allRoomsCbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel10.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 750, 410));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 800, 660));

        kGradientPanel2.setkEndColor(new java.awt.Color(100, 110, 255));
        kGradientPanel2.setkGradientFocus(800);
        kGradientPanel2.setkStartColor(new java.awt.Color(93, 87, 255));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel4.setBackground(new java.awt.Color(93, 87, 255));
        kGradientPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        kGradientPanel4.setkEndColor(new java.awt.Color(95, 90, 255));
        kGradientPanel4.setkGradientFocus(200);
        kGradientPanel4.setkStartColor(new java.awt.Color(93, 87, 255));

        search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        kGradientPanel2.add(kGradientPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 290, 80));

        ll.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        ll.setForeground(new java.awt.Color(255, 255, 255));
        ll.setText("Home");
        kGradientPanel2.add(ll, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, 20));

        jPanel1.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 1090, 120));

        jLabel18.setIcon(new javax.swing.ImageIcon("F:\\Lessons\\sem4\\RAPId\\RAD_Project\\Hotel_Reservation_System\\src\\Resourses\\crop.jpg")); // NOI18N
        jLabel18.setText("jLabel18");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(-170, 50, 480, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1399, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(1417, 875));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void opwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opwActionPerformed

    private void addroombtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addroombtnActionPerformed
        
        int rm_no;
        String type, receive,acnac;
        
      rm_no=Integer.parseInt(rmnobox.getText());
      type=typebox.getSelectedItem().toString();
      receive=receivebox.getSelectedItem().toString();
      acnac=acbox.getSelectedItem().toString();
      
        try {
            
            String sql= "INSERT INTO rooms (room_no,type,received,ac)VALUES ('"+rm_no+"','"+type+"','"+receive+"','"+acnac+"')";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Successfully inserted");
            loadtable();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
        
    }//GEN-LAST:event_addroombtnActionPerformed

    private void tableroomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableroomMouseClicked
       
        tabledataget();
        
    }//GEN-LAST:event_tableroomMouseClicked

    private void tableroomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableroomKeyReleased
         tabledataget();
    }//GEN-LAST:event_tableroomKeyReleased

    private void search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search1KeyReleased
        search1();
    }//GEN-LAST:event_search1KeyReleased

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        update();
        loadtable();
        
        JOptionPane.showMessageDialog(null, "Successfully Updated");
    }//GEN-LAST:event_updatebtnActionPerformed

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed
       String name,pnumber,email,address,rpackage;
       String mini_barF="No";
       String poolF="No";
       String spaF="No";
       int mcount,rm_no;
       int p_id=1000;
       int min = 10;
        int max = 10000;
        
       int payment;
//       java.util.Date datein,dateout;
       String datein,dateout;
       
        rm_no=Integer.parseInt(rmnobox.getText());
        
       name=rcnamebox.getText();
//       phone number is a String.Because international mobile numbers are start with country code 
       pnumber=rpnomberbox.getText(); 
       email=rmailbox.getText();
       
       
       
       
       mcount=Integer.parseInt(rmcountbox.getText());
       
       datein=rdatein.getText();
       dateout=rdateout.getText();
       
       address=radrbox.getText();
//       rpackage=rpackagebox.getSelectedItem().toString();
       rpackage=packageSelect.getText();
        if (miniBar.isSelected()) {
            mini_barF="Yes";
        }if (pool.isSelected()) {
            poolF="Yes";
        }if (spa.isSelected()) {
            spaF="Yes";
        }
       
       payment=Integer.parseInt(rpaymentbox.getText());
       String booked="no";
       
       
        try {
            
            String sql_check="SELECT * FROM reservation Where room_no='"+rm_no+"' ";
            pst= conn.prepareStatement(sql_check);
            rs=pst.executeQuery();
                     
            Date dayIN=sdf.parse(datein);
            Date dayOUT=sdf.parse(dateout);
            while (rs.next()) {
                System.out.println(rs.getString("date_in"));
                Date inday=sdf.parse(rs.getString("date_in"));
                Date outday=sdf.parse(rs.getString("date_out"));
                System.out.println(inday);
                System.out.println(outday);
                if ((dayIN.after(inday) || inday.compareTo(dayIN)==0) && (dayIN.before(outday)|| dayIN.compareTo(outday)==0)) {
//                    JOptionPane.showMessageDialog(null,"Already Booked");
                    booked="yes";
                    
                }else if((dayOUT.after(inday) || inday.compareTo(dayOUT)==0) && (dayOUT.before(outday)|| dayOUT.compareTo(outday)==0)){
                    booked="yes";
                    
                }
                
                
               
                
            }
            System.out.println(dayIN);
            
        } catch (Exception e) {
        }
        
        
       
       
        if (receivebox.getSelectedItem().toString().equals("Yes") || booked.equals("yes")) {
            JOptionPane.showMessageDialog(null, "This room already booked!");
        }else{
            if (isValid(email)==true) {
                
                
                    
      
       try {
           
           
           
           p_id +=(int)Math.floor(Math.random()*(max-min+1)+min);;
           String paymentId="pay"+String.valueOf(p_id);
            
            String sql= "INSERT INTO clients (name,contact,mail,members,address,room_no,package,payment_id,payment)VALUES ('"+name+"','"+pnumber+"','"+email+"','"+mcount+"','"+address+"','"+rm_no+"','"+rpackage+"','"+paymentId+"','"+payment+"')";
            pst=conn.prepareStatement(sql);
            pst.execute();
           
            loadtable();
            
            
             String sql2= "INSERT INTO reservation (name,room_no,date_in,date_out,package,mini_bar,pool,spa) VALUES ('"+name+"','"+rm_no+"','"+datein+"','"+dateout+"','"+rpackage+"','"+mini_barF+"','"+poolF+"','"+spaF+"')";
             pst=conn.prepareStatement(sql2);
             pst.execute();
            
             
             
             String sql3= "INSERT INTO payment (package,room_no,customer,payment_id,payment) VALUES ('"+rpackage+"','"+rm_no+"','"+name+"','"+paymentId+"','"+payment+"')";
             pst=conn.prepareStatement(sql3);
             pst.execute();
              JOptionPane.showMessageDialog(null, "Successfully inserted");
              
              
              SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
              
               String d2=java.time.LocalDate.now().toString();
               
               Date date1=sdf.parse(d1);
               Date date2=sdf.parse(d2);
               
               if (date1.before(date2)|| date1.compareTo(date2)==0) {
                receivebox.setSelectedItem("Yes");
           }else{
                    receivebox.setSelectedItem("No");
               }
              
             
              
              update();
              loadtable();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
                
            }else{
                JOptionPane.showMessageDialog(null, "Please enter valid email address");
            }
   
        }
        
        
        
        
        
        
    }//GEN-LAST:event_insertbtnActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
       
        clear();
    }//GEN-LAST:event_clearbtnActionPerformed

    private void rdateoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdateoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdateoutActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
         login lg= new login(); 
            lg.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_backbtnActionPerformed

    private void reservationbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservationbtnActionPerformed
       

            reservation rs= new reservation(); 
            rs.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_reservationbtnActionPerformed

    private void clientbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientbtnActionPerformed
        client cl= new client(); 
            cl.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_clientbtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete");
        
        if(check ==0){
            
            String id = idlable.getText();
//            try {
//                String sql ="DELETE FROM rooms WHERE id='"+id+"'";
//                pst= conn.prepareStatement(sql);
//                pst.execute();
//                JOptionPane.showMessageDialog(null, "Deleted");
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "faafafafef");
//            }

//Delete using Hibernate....................................................

            Session s= connection.Controller.getSessionFactory().openSession();
            Transaction tr =s.beginTransaction();
           pojos.Rooms rms=(pojos.Rooms)s.load(pojos.Rooms.class, Integer.parseInt(id));
           s.delete(rms);
          tr.commit();
          System.out.println("Deleted");
             JOptionPane.showMessageDialog(null, "Deleted Successfuly");
            
        }
        loadtable();
    }//GEN-LAST:event_deletebtnActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
         System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

    private void reservationbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservationbtnMouseEntered
        // TODO add your handling code here:
        reservationbtn.setForeground(Color.YELLOW);
//        reservationbtn.setBackground(Color.GREEN);

    }//GEN-LAST:event_reservationbtnMouseEntered

    private void cha_Ass_pwdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cha_Ass_pwdMouseClicked
        // TODO add your handling code here:
        hidePanel.setVisible(false);
         opwlabel.setVisible(false);
            opw.setVisible(false);
        if (apwLabel.isVisible()==false && apw.isVisible()==false) {
            
           apwLabel.setVisible(true);
           apw.setVisible(true);
        }else{
            
            
        

  Statement stmt;
        try {
            stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM current_assistante");
            while(rs.next()){
//             username1 =rs.getString("username");
            password1 =rs.getString("password");
//           
           }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
         
         try {
            stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM current_officer");
            while(rs.next()){
//           username2 =rs.getString("username");
             password2=rs.getString("password");
//           
           }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
        
        
        
        String apword,opword;
       
        opword=opw.getText();
        apword=apw.getText();
        
//        &&opword.equals(password2)
        if((apword.equals(password1))){
            as_password ap = new as_password(); 
            ap.setVisible(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Please check assistant password" );
        }
        
        }

    }//GEN-LAST:event_cha_Ass_pwdMouseClicked

    private void cha_Ass_pwdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cha_Ass_pwdMouseEntered
        // TODO add your handling code here:
cha_Ass_pwd.setForeground(Color.yellow);

JLabel label = (JLabel) evt.getSource();
label.setOpaque(true);
label.setBackground(blueT);





  

    }//GEN-LAST:event_cha_Ass_pwdMouseEntered

    private void cha_Ass_pwdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cha_Ass_pwdMouseExited
        // TODO add your handling code here:
JLabel label = (JLabel) evt.getSource();
label.setOpaque(false);
label.setForeground(Color.white);
label.setBackground(Color.white);

    }//GEN-LAST:event_cha_Ass_pwdMouseExited

    private void cha_of_pwd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cha_of_pwd1MouseClicked
        // TODO add your handling code here:
        hidePanel.setVisible(false);
            apwLabel.setVisible(false);
           apw.setVisible(false);
       
        if (!opwlabel.isVisible()==true && !opw.isVisible()==true ){
            opwlabel.setVisible(true);
            opw.setVisible(true);
            
//            try {
//                Thread.sleep(5000);
//              } catch (InterruptedException e) {
//                  //do things with exception
//                  opwlabel.setVisible(false);
//                  opw.setVisible(false);
//              }
            
        }else{
            
               Statement stmt;
       String password2 = null;
         try {
            stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM current_officer");
            while(rs.next()){
//          
             password2=rs.getString("password");
//           
           }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
        
        
        String opword;
       
        opword=opw.getText();
       
        if(opword.equals(password2)){
            of_password of = new of_password(); 
            of.setVisible(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Please check officer password" );
        }
            
            
        }
        
               





    }//GEN-LAST:event_cha_of_pwd1MouseClicked

    private void cha_of_pwd1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cha_of_pwd1MouseEntered
        // TODO add your handling code here:



JLabel label = (JLabel) evt.getSource();
label.setForeground(Color.YELLOW);
label.setOpaque(true);
label.setBackground(blueT);
    }//GEN-LAST:event_cha_of_pwd1MouseEntered

    private void cha_of_pwd1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cha_of_pwd1MouseExited
        // TODO add your handling code here:

JLabel label = (JLabel) evt.getSource();
label.setForeground(Color.white);
label.setOpaque(false);
label.setBackground(Color.white);

    }//GEN-LAST:event_cha_of_pwd1MouseExited

    private void ass_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ass_detailsMouseClicked
        // TODO add your handling code here:
        hidePanel.setVisible(false);
         opwlabel.setVisible(false);
            opw.setVisible(false);
            String apword;
             Statement stmt;
             
             
             if (apw.isVisible()==false && apwLabel.isVisible()==false) {
            apw.setVisible(true);
            apwLabel.setVisible(true);
        }else{
                 
             
        try {
            stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM current_assistante");
            while(rs.next()){
//             username1 =rs.getString("username");
            password1 =rs.getString("password");
//           
           }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
       
        
        apword=apw.getText();
        if((apword.equals(password1))){
            assistante_details asd = new assistante_details(); 
            asd.setVisible(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Please check assistant password" );
        }
        }
        
//        assistante_details as = new assistante_details(); 
//            as.setVisible(true);
//            this.dispose();

    }//GEN-LAST:event_ass_detailsMouseClicked

    private void ass_detailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ass_detailsMouseEntered
        // TODO add your handling code here:
JLabel label = (JLabel) evt.getSource();
label.setForeground(Color.YELLOW);
label.setOpaque(true);
label.setBackground(blueT);


    }//GEN-LAST:event_ass_detailsMouseEntered

    private void ass_detailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ass_detailsMouseExited
        // TODO add your handling code here:
JLabel label = (JLabel) evt.getSource();
label.setForeground(Color.white);
label.setOpaque(false);
label.setBackground(Color.white);

    }//GEN-LAST:event_ass_detailsMouseExited

    private void off_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_off_detailsMouseClicked
        // TODO add your handling code here:
        hidePanel.setVisible(false);
         apwLabel.setVisible(false);
            apw.setVisible(false);
        
         if (!opwlabel.isVisible()==true && !opw.isVisible()==true ){
            opwlabel.setVisible(true);
            opw.setVisible(true);
            
//            try {
//                Thread.sleep(5000);
//              } catch (InterruptedException e) {
//                  //do things with exception
//                  opwlabel.setVisible(false);
//                  opw.setVisible(false);
//              }
            
        }else{

     Statement stmt;
       String password2 = null;
         try {
            stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM current_officer");
            while(rs.next()){
//          
             password2=rs.getString("password");
//           
           }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
        
        
        String opword;
       
        opword=opw.getText();
       
        if(opword.equals(password2)){
            officer_details od = new officer_details(); 
            od.setVisible(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Please check officer password" );
        }
         }

    }//GEN-LAST:event_off_detailsMouseClicked

    private void off_detailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_off_detailsMouseEntered
        // TODO add your handling code here:
        JLabel label = (JLabel) evt.getSource();
        label.setForeground(Color.yellow);
        label.setOpaque(true);
        label.setBackground(blueT);
    }//GEN-LAST:event_off_detailsMouseEntered

    private void off_detailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_off_detailsMouseExited
        // TODO add your handling code here:

JLabel label = (JLabel) evt.getSource();
label.setForeground(Color.white);
label.setOpaque(false);
label.setBackground(Color.white);
    }//GEN-LAST:event_off_detailsMouseExited

    private void paymentMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentMouseReleased

    private void paymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentMouseClicked
        // TODO add your handling code here:
        
        Statement stmt;
        String offPasword=null;
        
         try {
            stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM current_officer");
            while(rs.next()){
//          
             offPasword=rs.getString("password");
//           
           }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
         
         
         
         String opword;
       
        opword=opw.getText();
       
        if(opword.equals(offPasword)){
            Payment pay= new Payment(); 
            pay.setVisible(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Please check your user name and password" );
        }
        
        
       
    }//GEN-LAST:event_paymentMouseClicked

    private void paymentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentMouseEntered
        // TODO add your handling code here:
        payment.setForeground(Color.yellow);
        
        
        
    }//GEN-LAST:event_paymentMouseEntered

    private void paymentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentMouseExited
        // TODO add your handling code here:
        payment.setForeground(Color.white);
    }//GEN-LAST:event_paymentMouseExited

    private void clientbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientbtnMouseEntered
        // TODO add your handling code here:
        
         clientbtn.setForeground(Color.yellow);
        
    }//GEN-LAST:event_clientbtnMouseEntered

    private void clientbtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientbtnMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_clientbtnMouseReleased

    private void clientbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientbtnMouseExited
        // TODO add your handling code here:
        clientbtn.setForeground(Color.white);
        
    }//GEN-LAST:event_clientbtnMouseExited

    private void reservationbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservationbtnMouseExited

        reservationbtn.setForeground(Color.white);        // TODO add your handling code here:
    }//GEN-LAST:event_reservationbtnMouseExited

    private void backbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbtnMouseEntered
        // TODO add your handling code here:
        backbtn.setForeground(Color.yellow);
    }//GEN-LAST:event_backbtnMouseEntered

    private void backbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbtnMouseExited
        // TODO add your handling code here:
        backbtn.setForeground(Color.white);
    }//GEN-LAST:event_backbtnMouseExited

    private void exitbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbtnMouseEntered
        // TODO add your handling code here:
        exitbtn.setForeground(Color.yellow);
    }//GEN-LAST:event_exitbtnMouseEntered

    private void exitbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbtnMouseExited
        // TODO add your handling code here:
        exitbtn.setForeground(Color.white);
    }//GEN-LAST:event_exitbtnMouseExited

    private void insertbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertbtnMouseEntered
        // TODO add your handling code here:
        insertbtn.setForeground(Color.yellow);
    }//GEN-LAST:event_insertbtnMouseEntered

    private void insertbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertbtnMouseExited
        // TODO add your handling code here:
        insertbtn.setForeground(Color.white);
    }//GEN-LAST:event_insertbtnMouseExited

    private void clearbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearbtnMouseEntered
        // TODO add your handling code here:
        clearbtn.setForeground(Color.yellow);
    }//GEN-LAST:event_clearbtnMouseEntered

    private void clearbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearbtnMouseExited
        // TODO add your handling code here:
        clearbtn.setForeground(Color.white);
    }//GEN-LAST:event_clearbtnMouseExited

    String d1;
    private void dateInPickerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateInPickerMouseClicked
        // TODO add your handling code here:
        
       
        DatePicker datePicker= new DatePicker(this);
       d1=datePicker.setPickedDate();
        
        rdatein.setText(datePicker.setPickedDate());
        
    }//GEN-LAST:event_dateInPickerMouseClicked

    private void DateOutPickerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DateOutPickerMouseClicked
        // TODO add your handling code here:
        
        DatePicker datePicker= new DatePicker(this);
        rdateout.setText(datePicker.setPickedDate());
        
      
  
        int d2= Integer.valueOf(rdateout.getText().substring(Math.max(rdateout.getText().length() - 2, 0)));
       
         int d1= Integer.valueOf(rdatein.getText().substring(Math.max(rdatein.getText().length() - 2, 0)));
      
        int pay=Integer.valueOf(rpaymentbox.getText().toString());
        int finalPay=pay*(d2-d1);
//        rpaymentbox.setText(finalPay.toString());
rpaymentbox.setText(String.valueOf(finalPay));
        
        
    }//GEN-LAST:event_DateOutPickerMouseClicked

    private void menu_openMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_openMouseClicked
        // TODO add your handling code here:
        hidePanel.setVisible(true);
         opwlabel.setVisible(false);
            opw.setVisible(false);
            apwLabel.setVisible(false);
           apw.setVisible(false);
        
        optionPanel.setBackground(opColou);
        transPanel.setVisible(false);
        imagepanel.setVisible(false);
        menu_open.setVisible(false);
        menu_close.setVisible(true);
        
        
        ass_details.setVisible(true);
        off_details.setVisible(true);
        cha_Ass_pwd.setVisible(true);
        cha_of_pwd1.setVisible(true);
    }//GEN-LAST:event_menu_openMouseClicked

    private void menu_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_closeMouseClicked
        // TODO add your handling code here:
        optionPanel.setBackground(Color.WHITE);
        transPanel.setVisible(true);
        imagepanel.setVisible(true);
        menu_open.setVisible(true);
        menu_close.setVisible(false);
        
        ass_details.setVisible(false);
        off_details.setVisible(false);
        cha_Ass_pwd.setVisible(false);
        cha_of_pwd1.setVisible(false);
        
    }//GEN-LAST:event_menu_closeMouseClicked

    private void menu_openMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_openMouseEntered
        // TODO add your handling code here:
//             optionPanel.setBackground(opColou);
//        transPanel.setVisible(false);
//        imagepanel.setVisible(false);
//        menu_open.setVisible(false);
//        menu_close.setVisible(true);
//        
//        
//        ass_details.setVisible(true);
//        off_details.setVisible(true);
//        cha_Ass_pwd.setVisible(true);
//        cha_of_pwd1.setVisible(true);
    }//GEN-LAST:event_menu_openMouseEntered

    private void menu_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_closeMouseEntered
        // TODO add your handling code here:
//            optionPanel.setBackground(Color.WHITE);
//        transPanel.setVisible(true);
//        imagepanel.setVisible(true);
//        menu_open.setVisible(true);
//        menu_close.setVisible(false);
//        
//        ass_details.setVisible(false);
//        off_details.setVisible(false);
//        cha_Ass_pwd.setVisible(false);
//        cha_of_pwd1.setVisible(false);
    }//GEN-LAST:event_menu_closeMouseEntered

    private void menu_openMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_openMouseExited
        // TODO add your handling code here:
//                optionPanel.setBackground(opColou);
//        transPanel.setVisible(false);
//        imagepanel.setVisible(false);
//        menu_open.setVisible(false);
//        menu_close.setVisible(true);
//        
//        
//        ass_details.setVisible(true);
//        off_details.setVisible(true);
//        cha_Ass_pwd.setVisible(true);
//        cha_of_pwd1.setVisible(true);
    }//GEN-LAST:event_menu_openMouseExited

    private void menu_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_closeMouseExited
        // TODO add your handling code here:
//                    optionPanel.setBackground(Color.WHITE);
//        transPanel.setVisible(true);
//        imagepanel.setVisible(true);
//        menu_open.setVisible(true);
//        menu_close.setVisible(false);
//        
//        ass_details.setVisible(false);
//        off_details.setVisible(false);
//        cha_Ass_pwd.setVisible(false);
//        cha_of_pwd1.setVisible(false);
    }//GEN-LAST:event_menu_closeMouseExited

    private void allRoomsCboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allRoomsCboxActionPerformed
        // TODO add your handling code here:
        
        if (allRoomsCbox.isSelected()) {
            try {
                 String sql="SELECT id AS ID,room_no AS 'Room No',type AS Type,received AS Received ,ac AS 'AC/Non AC' From rooms";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tableroom.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch (Exception e) {
            }
        }else{
            try {
                
                 String sql="SELECT id AS ID,room_no AS 'Room No',type AS Type,received AS Received ,ac AS 'AC/Non AC' From rooms where received='No'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tableroom.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_allRoomsCboxActionPerformed

    private void miniBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniBarMouseClicked
        // TODO add your handling code here:
        

        
    }//GEN-LAST:event_miniBarMouseClicked

    private void miniBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miniBarActionPerformed
        // TODO add your handling code here:
        int price=Integer.parseInt(rpaymentbox.getText().toString());
        if (miniBar.isSelected()) {
          
            rpaymentbox.setText(String.valueOf(price+5000));
        }else{
             
            rpaymentbox.setText(String.valueOf(price-5000));
        }
        
    }//GEN-LAST:event_miniBarActionPerformed

    private void poolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poolActionPerformed
        int price=Integer.parseInt(rpaymentbox.getText().toString());
        if (pool.isSelected()) {
          
            rpaymentbox.setText(String.valueOf(price+6000));
        }else{
             
            rpaymentbox.setText(String.valueOf(price-6000));
        }
    }//GEN-LAST:event_poolActionPerformed

    private void spaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spaActionPerformed
         int price=Integer.parseInt(rpaymentbox.getText().toString());
        if (spa.isSelected()) {
          
            rpaymentbox.setText(String.valueOf(price+10000));
        }else{
             
            rpaymentbox.setText(String.valueOf(price-10000));
        }
    }//GEN-LAST:event_spaActionPerformed

    private void packageSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_packageSelectMouseClicked
       // TODO add your handling code here:
     

    }//GEN-LAST:event_packageSelectMouseClicked

    private void packageSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_packageSelectActionPerformed
        // TODO add your handling code here:
        int mcount=0;
        int price=0;
        if (!rmcountbox.getText().toString().isEmpty() && !rpaymentbox.getText().toString().isEmpty()) {
                   mcount=Integer.valueOf(rmcountbox.getText().toString());
          price=Integer.parseInt(rpaymentbox.getText().toString());
                
                if(mcount!=0 && price!=0){
                    int price2=(price+(2000*mcount));
                    int price3=(price-(2000*mcount));
                    if (packageSelect.isSelected()) {
                        packageSelect.setText("Half Board");
                       rpaymentbox.setText(String.valueOf(price3));
            
                    }else{
                         packageSelect.setText("Full Board");
                         rpaymentbox.setText(String.valueOf(price2));
                    }
                }
        }else{
              if (packageSelect.isSelected()) {
                   packageSelect.setText("Half Board");
              }else{
                  packageSelect.setText("Full Board");
              }
        }
 
               
    
    }//GEN-LAST:event_packageSelectActionPerformed

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
         hidePanel.setVisible(true);
         opwlabel.setVisible(false);
            opw.setVisible(false);
            apwLabel.setVisible(false);
           apw.setVisible(false);
        
        
    }//GEN-LAST:event_jPanel5MouseClicked

    /**
     * @param args the command line arguments*****************************************************************************************************************
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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
                
                
            }
        });
        
        
    }
    
    
    
        public void search1(){
        
        String src1=search1.getText();
        try {
            String sql ="SELECT id AS ID,room_no AS 'Room No',type AS Type,received AS Received ,ac AS 'AC/Non AC' FROM rooms  WHERE ac ='"+src1+"' OR room_no LIKE '%"+src1+"%' OR type LIKE '%"+src1+"%' OR received LIKE '%"+src1+"%'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tableroom.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        
        
        
        public void loadtable(){
            
            today.setText((java.time.LocalDate.now()).toString());
         today2.setText((java.time.LocalDate.now()).toString());
            
//            ass_details.setVisible(false);
//            off_details.setVisible(false);
//            cha_Ass_pwd.setVisible(false);
//            cha_of_pwd1.setVisible(false);
            
            
            
        try {
            String sql="SELECT id AS ID,room_no AS 'Room No',type AS Type,received AS Received ,ac AS 'AC/Non AC' From rooms where received='No'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tableroom.setModel(DbUtils.resultSetToTableModel(rs));
            
            String sql2= "SELECT * from current_officer";
            pst= conn.prepareStatement(sql2);
            rs=pst.executeQuery();
            while (rs.next()) {
                current_officer.setText(rs.getString("hotel_id"));
                
            }
            
            
            String sql3= "SELECT * from current_assistante";
            pst= conn.prepareStatement(sql3);
            rs=pst.executeQuery();
            while (rs.next()) {
                current_assistant.setText(rs.getString("hotel_id"));
                
            }
            
            String sql4="SELECT * FROM rooms";
            pst= conn.prepareStatement(sql4);
            rs=pst.executeQuery();
            int tot=0;
             while (rs.next()) {
               rs.getString("id");
                tot+=1;
            }
             
             String sql5="SELECT * FROM rooms WHERE received='No'";
            pst= conn.prepareStatement(sql5);
            rs=pst.executeQuery();
            int tot2=0;
             while (rs.next()) {
               rs.getString("id");
                tot2+=1;
            }
             
            
             allRooms.setText(String.valueOf(tot));
             availableRooms.setText(String.valueOf(tot2));
             bookedRooms.setText(String.valueOf(tot-tot2));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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
    
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateOutPicker;
    private javax.swing.JLabel abox;
    private javax.swing.JComboBox<String> acbox;
    private javax.swing.JButton addroombtn;
    private javax.swing.JLabel adr1;
    private javax.swing.JLabel allRooms;
    private javax.swing.JCheckBox allRoomsCbox;
    private javax.swing.JPasswordField apw;
    private javax.swing.JLabel apwLabel;
    private javax.swing.JLabel assID;
    private javax.swing.JLabel ass_details;
    private javax.swing.JLabel availableRooms;
    private javax.swing.JButton backbtn;
    private javax.swing.JLabel bookedRooms;
    private javax.swing.JLabel bookins;
    private javax.swing.JLabel cha_Ass_pwd;
    private javax.swing.JLabel cha_of_pwd1;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton clientbtn;
    private javax.swing.JLabel current_assistant;
    private javax.swing.JLabel current_officer;
    private javax.swing.JLabel dateInPicker;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton exitbtn;
    private javax.swing.JLabel fname;
    private javax.swing.JPanel hidePanel;
    private javax.swing.JLabel idlable;
    private javax.swing.JPanel idpane;
    private inf.PanelRound imagepanel;
    private javax.swing.JButton insertbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel4;
    private javax.swing.JLabel ll;
    private javax.swing.JLabel mail1;
    private javax.swing.JLabel menu_close;
    private javax.swing.JLabel menu_open;
    private javax.swing.JCheckBox miniBar;
    private javax.swing.JLabel off1;
    private javax.swing.JLabel off2;
    private javax.swing.JLabel off3;
    private javax.swing.JLabel offID;
    private javax.swing.JLabel off_details;
    private inf.PanelRound optionPanel;
    private javax.swing.JPasswordField opw;
    private javax.swing.JLabel opwlabel;
    private javax.swing.JToggleButton packageSelect;
    private inf.PanelRound panelRound2;
    private javax.swing.JButton payment;
    private javax.swing.JLabel pnumber;
    private javax.swing.JCheckBox pool;
    private javax.swing.JTextArea radrbox;
    private javax.swing.JLabel rbox;
    private javax.swing.JTextField rcnamebox;
    private javax.swing.JTextField rdatein;
    private javax.swing.JTextField rdateout;
    private javax.swing.JLabel rebox;
    private javax.swing.JComboBox<String> receivebox;
    private javax.swing.JButton reservationbtn;
    private javax.swing.JTextField rmailbox;
    private javax.swing.JTextField rmcountbox;
    private javax.swing.JTextField rmnobox;
    private javax.swing.JTextField rpaymentbox;
    private javax.swing.JTextField rpnomberbox;
    private javax.swing.JTextField search1;
    private javax.swing.JCheckBox spa;
    private javax.swing.JTable tableroom;
    private javax.swing.JLabel tbox;
    private javax.swing.JLabel today;
    private javax.swing.JLabel today2;
    private inf.PanelRound transPanel;
    private javax.swing.JComboBox<String> typebox;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
