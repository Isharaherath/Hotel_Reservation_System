package pojos;
// Generated Aug 7, 2022 12:12:03 AM by Hibernate Tools 4.3.1



/**
 * CurrentOfficer generated by hbm2java
 */
public class CurrentOfficer  implements java.io.Serializable {


     private Integer id;
     private String hotelId;
     private String username;
     private String password;

    public CurrentOfficer() {
    }

    public CurrentOfficer(String hotelId, String username, String password) {
       this.hotelId = hotelId;
       this.username = username;
       this.password = password;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getHotelId() {
        return this.hotelId;
    }
    
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


