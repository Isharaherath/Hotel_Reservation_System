package pojos;
// Generated Aug 7, 2022 12:12:03 AM by Hibernate Tools 4.3.1



/**
 * AssistantePassword generated by hbm2java
 */
public class AssistantePassword  implements java.io.Serializable {


     private Integer id;
     private String username;
     private String hotelId;
     private String password;
     private String question1;
     private String question2;
     private String question3;
     private String ans1;
     private String ans2;
     private String ans3;

    public AssistantePassword() {
    }

    public AssistantePassword(String username, String hotelId, String password, String question1, String question2, String question3, String ans1, String ans2, String ans3) {
       this.username = username;
       this.hotelId = hotelId;
       this.password = password;
       this.question1 = question1;
       this.question2 = question2;
       this.question3 = question3;
       this.ans1 = ans1;
       this.ans2 = ans2;
       this.ans3 = ans3;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getHotelId() {
        return this.hotelId;
    }
    
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getQuestion1() {
        return this.question1;
    }
    
    public void setQuestion1(String question1) {
        this.question1 = question1;
    }
    public String getQuestion2() {
        return this.question2;
    }
    
    public void setQuestion2(String question2) {
        this.question2 = question2;
    }
    public String getQuestion3() {
        return this.question3;
    }
    
    public void setQuestion3(String question3) {
        this.question3 = question3;
    }
    public String getAns1() {
        return this.ans1;
    }
    
    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }
    public String getAns2() {
        return this.ans2;
    }
    
    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }
    public String getAns3() {
        return this.ans3;
    }
    
    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }




}


