/**
 * Created by sidi Diaby diaby002 on 11/7/2016.
 */
public class Friend extends Contact {
    private int birthday;
    public Friend(String name, long phone, String address, String comments, int birthday){
        this.setName(name);
        this.setPhone(phone);
        this.setAddress(address);
        this.setComments(comments);
        this.birthday=birthday;

    }

         public int getBirthday(){
             return birthday;
         }

    public void setBirthday(int birthday){
                 this.birthday=birthday;

        }

    public String toString(){
     return super.toString()+"\n"+birthday;

    }

}
