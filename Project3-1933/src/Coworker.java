/**
 * Created by sidi Diaby diaby002 on 11/8/2016.
 */
public class Coworker extends Contact{
    private String email;
    public String getEmail(){
    return email;}
 public void setEmail(String email){
     this.email=email;
 }
    public Coworker(String name, long phone, String address, String comments, String email){
        this.setName(name);
        this.setPhone(phone);
        this.setAddress(address);
        this.setComments(comments);
        this.email=email;


    }
    public String toString(){

       return super.toString()+"\n"+ email;


    }
}
