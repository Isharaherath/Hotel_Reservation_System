package pojos;
// Generated Aug 7, 2022 12:12:03 AM by Hibernate Tools 4.3.1



/**
 * Rooms generated by hbm2java
 */
public class Rooms  implements java.io.Serializable {


     private Integer id;
     private int roomNo;
     private String type;
     private String received;
     private String ac;

    public Rooms() {
    }

    public Rooms(int roomNo, String type, String received, String ac) {
       this.roomNo = roomNo;
       this.type = type;
       this.received = received;
       this.ac = ac;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getRoomNo() {
        return this.roomNo;
    }
    
    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public String getReceived() {
        return this.received;
    }
    
    public void setReceived(String received) {
        this.received = received;
    }
    public String getAc() {
        return this.ac;
    }
    
    public void setAc(String ac) {
        this.ac = ac;
    }




}


