import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by sidi Diaby diaby002 on 11/8/2016.
 */
public class ContactDatabase {
    private List<Contact> list;

    public ContactDatabase(String type){
        if (type.compareTo("array")==0||type.compareTo("Array")==0){
            this.list = new ArrayList<Contact>();
        }
        else if(type.compareTo("linked")==0|| type.compareTo("Linked")==0){

            this.list = new LinkedList <Contact>();

        }

    }
    public boolean add(Contact c){
        return list.add(c);
    }
    public Contact find(String name){
        int i=0;
       while( list.get(i)!=null){
           if (list.get(i).getName().contains(name)){
               return list.get(i);
           }
           i++;


       }
        return null;
    }

    public Contact remove(int index){
        return list.remove(index);
    }
    public Contact get(int index){
        return list.get(index);
    }
    public void sort(){
        list.sort(true);
    }
    public Contact[] getContactsByType(String type){
        Contact [] c= new Contact[1];
        if (type=="friend"|| type=="Friend"){
            int i=0;
            int j=0;
        while (list.get(i)!=null){

            if(list.get(i) instanceof Friend){

                if(j>=c.length){
                    Contact[] d= new Contact[c.length+1];
                    for (int l=0;l<c.length;l++){
                        d[l]=c[l];
                    }
                    c=d;
                }

                c[j]=list.get(i);
                j++;
            }
            i++;

            }
        }
      else  if (type=="coworker"|| type=="Coworker"){
            int i=0;
            int j=0;
            while (list.get(i)!=null){
                if(list.get(i) instanceof Coworker){
                    if(j==c.length){
                        Contact[] d= new Contact[c.length+1];
                        for (int l=0;l<c.length;l++){
                            d[l]=c[l];
                        }
                        c=d;
                    }
                    c[j]=list.get(i);
                    j++;
                }
                i++;

            }
        }
       else if (type=="Restaurant"|| type=="Restaurant"){
            int i=0;
            int j=0;
            while (list.get(i)!=null){
                if(list.get(i) instanceof Restaurant){
                    if(j==c.length){
                        Contact[] d= new Contact[c.length+1];
                        for (int l=0;l<c.length;l++){
                            d[l]=c[l];
                        }
                        c=d;
                    }
                    c[j]=list.get(i);
                    j++;
                }
                i++;

            }
        }
        else {
            return null;
        }


    return c;
    }
    public Contact getOldestFriend(){
        Contact [] m = getContactsByType("friend");
        Friend []c = new Friend[m.length];
        for (int i=0;i<c.length;i++){
            c[i]=(Friend)m[i];
        }

        if(c.length==0){
            return null;
        }
        else {
            Friend smallest=c[0];
            for (int i=0;i<c.length;i++){
                if(c[i].getBirthday()<smallest.getBirthday()){
                    smallest=c[i];
                }
            }
            return smallest;
        }
    }
    public String getMailToLink(){
        Contact [] m = getContactsByType("coworker");
        Coworker []c = new Coworker[m.length];
        for (int i=0;i<c.length;i++){
            c[i]=(Coworker) m[i];
        }

        if(c.length==0){
            return null;
        }

        else {
            String s="";
            for(int i=0; i<c.length-1;i++){
                s+=c[i].getEmail()+",";
            }
            s+=c[c.length-1].getEmail();
            return s;
        }
    }
    public Contact[] getTopKRestaurants(int k){
        Contact [] m = getContactsByType("Restaurant");
        Restaurant []c = new Restaurant[m.length];
        for (int i=0;i<c.length;i++){
            c[i]=(Restaurant) m[i];
        }

        if(c.length==0){
            return null;
        }
        else if (c.length<k){
            return c;
        }
        else {
            Restaurant [] d= new Restaurant[k];

            for(int i=0; i<k;i++){
                d[i]=c[i];

            }
            return d;
        }

    }
    public static void main(String[] args){
        ContactDatabase a = new ContactDatabase("array");
        ContactDatabase l = new ContactDatabase("linked");
        Contact c= new Contact("alex",404,"river driver","alloh!!");
        Friend d= new Friend("batman", 911, "bat mobile","Darkness",4);
        Coworker e =new Coworker("superman",1000,"krypton","save the world","superman@ff.net");
        Coworker f = new Coworker("geto",663,"mini","jfkfjf","mail@nonsense.com");
        Friend g= new Friend("sidechick",111,"home2","don't call",11144);
        Restaurant h =new Restaurant("sporty's",4454,"closeby","good burger",4);
        Restaurant i = new Restaurant("joe's",4457,"close to me","good food",5);
        Restaurant k =new Restaurant("disney", 885,"far away","hate it",1);

        l.add(c);
        l.add(d);
        l.add(e);
        l.add(f);
        l.add(g);
        l.add(h);
        l.add(i);

        System.out.println(l.find("superman"));
       System.out.println(l.getOldestFriend());
        System.out.println(l.getMailToLink());
        System.out.println(Arrays.deepToString(l.getTopKRestaurants(2)));



    }
}
