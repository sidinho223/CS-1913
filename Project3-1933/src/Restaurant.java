/**
 * Created by sidi  Diaby diaby002 on 11/8/2016.
 */
public class Restaurant extends Contact {
     private int rating;
         public int getRating(){
             return rating;
         }


    public void setRating(int rating){

        this.rating=rating;

    }
    public Restaurant(String name, long phone, String address, String comments, int rating){
        this.setName(name);
        this.setPhone(phone);
        this.setAddress(address);
        this.setComments(comments);
        this.rating=rating;


    }
    public String toString(){
        return super.toString()+"\n"+rating;

    }
}
