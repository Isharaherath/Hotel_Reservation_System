/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

import org.hibernate.Session;
import org.hibernate.Transaction;





/**
 *
 * @author Heshan
 */
public class testHib {
    
    public static void main(String[] args) {
        
        Session s= connection.Controller.getSessionFactory().openSession();
        Transaction tr= s.beginTransaction();
        
        pojos.Rooms rms=(pojos.Rooms)s.load(pojos.Rooms.class, 4);
        rms.setAc("Non AC");
        rms.setReceived("Yes");
        rms.setRoomNo(2);
        
        s.update(rms);
        tr.commit();
        
        System.out.println("Updated");
        
        s.close();
        tr=null;
        
    }
    
}
