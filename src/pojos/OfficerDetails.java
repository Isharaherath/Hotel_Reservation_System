package pojos;
// Generated Aug 7, 2022 12:12:03 AM by Hibernate Tools 4.3.1



/**
 * OfficerDetails generated by hbm2java
 */
public class OfficerDetails  implements java.io.Serializable {


     private Integer id;
     private String hotelId;
     private String name;
     private String contact;
     private String mail;
     private String image;

    public OfficerDetails() {
    }

    public OfficerDetails(String hotelId, String name, String contact, String mail, String image) {
       this.hotelId = hotelId;
       this.name = name;
       this.contact = contact;
       this.mail = mail;
       this.image = image;
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
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getContact() {
        return this.contact;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getMail() {
        return this.mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }




}

