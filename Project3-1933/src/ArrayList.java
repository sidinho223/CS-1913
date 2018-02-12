import java.util.Arrays;

/**
 * Created by sidi Diaby diaby002 on 11/7/2016.
 */
public class ArrayList<T extends Comparable<T>> implements List<T> {

   private int size=2;
   private T [] a;
   public ArrayList(){
      this.a = (T[]) new Comparable[size];

   }
  public boolean add(T element){
      int last=-1;
      if(element == null){
         return false;
      }

      for (int i=0; i<a.length;i++){
        if(a[i]!=null){
           last=i;
        }
      }

     if(last== a.length-1){
        T [] b= (T []) new Comparable[2*a.length];

        for (int i=0;i<a.length;i++){
           b[i]=a[i];
        }
        a=b;


        a[last +1]=element;
        return true;
     }
      a[last+1]=element;
      return true;


   }

   public boolean add(int index, T element){
      if(element==null|| index<0|| index>= a.length){
         return false;
      }
      else if( a[index]==null){
         a[index]=element;
      }
      else{
         if(a[a.length-1]!=null){
            T[]b= (T[])new Comparable[2*size];
            for(int i=0;i<index;i++){
               b[i]=a[i];

            }
            b[index]=element;
            for(int i=index+1; i<b.length;i++){
               b[i]=a[i-1];
            }
            a=b;
            return true;
         }
         T[]b= (T[])new Comparable[a.length];

         for(int i=0;i<index;i++){
            b[i]=a[i];

         }
         b[index]=element;
         for(int i=index+1; i<b.length;i++){
            b[i]=a[i-1];
         }
         a=b;

      }
      return true;
   }

   public void clear(){
      a= (T []) new Comparable[2];

   }

   public boolean contains(T element){
      for(int i=0; i<a.length;i++){
         if(a[i].equals(element)){
            return true;
         }
      }
      return false;
   }
   public T get(int index){
      if(index<0||index>=a.length){
         return null;
      }
      return a[index];

   }

   public int indexOf(T element){
      if(element==null){
         return -1;
      }

      for (int i=0; i<a.length;i++){
         if(a[i].equals(element)){
            return i;
         }

      }
      return -1;


   }

   public boolean isEmpty(){
      for(int i=0; i<a.length;i++){
         if (a[i]!=null){
            return false;
         }

      }
      return true;

   }
   public int lastIndexOf(T element){
      if(indexOf(element)==-1){
         return -1;
      }
      else {
         int last=-1;
         for(int i=0;i<a.length;i++){
            if (a[i].equals(element)){
               last=i;
            }
         }
         return last;
      }


   }

   public T set(int index, T element){
      if(index<0|| index>=a.length|| element==null){
         return null;
      }
      T previous= get(index);
      a[index]=element;

      return previous;


   }
   public int size(){
      int count=0;
      for(int i=0;i<a.length;i++){
         if(a[i]!=null){
            count+=1;
         }
      }
      return count;
   }
   public void sort(boolean order) {
       if (isEmpty()) {
           return;
       }
       else {


           if (order == true)

               for (int i = 0; i < a.length-1; i++) {
                   T smallest = a[i];

                   for (int j = i + 1; j < a.length; j++) {
                       if ( a[i] != null && a[j] != null && smallest.compareTo(a[j]) > 0 ) {
                           smallest = a[j];

                       }


                   }

                   T temp = a[i];
                   int tempi = indexOf(smallest);


                   a[i] = smallest;

                   if(tempi>0&& tempi<a.length){
                   a[tempi] = null;
                   add(tempi, temp);
                   }
               }
           else{
               for (int i = 0; i < a.length-1; i++) {
                   T smallest = a[i];

                   for (int j = i + 1; j < a.length; j++) {
                       if ( a[i] != null && a[j] != null && smallest.compareTo(a[j]) < 0 ) {
                           smallest = a[j];

                       }


                   }

                   T temp = a[i];
                   int tempi = indexOf(smallest);


                   a[i] = smallest;

                   if(tempi>0&& tempi<a.length){
                       a[tempi] = null;
                       add(tempi, temp);
                   }
               }

           }

       }
   }
   public boolean remove(T element){
     int ind=indexOf(element);
      if(ind<0){
         return false;
      }
      for(int i=ind;i<a.length-1;i++){
         a[i]=a[i+1];
      }
      a[a.length-1]=null;
      return true;

   }
   public T remove(int index){
      T r=get(index);
      if(r==null){
         return null;
      }
      remove(r);
      return r;


   }
    public String toString(){
        String s="[";
        for(int i=0;i<a.length;i++){
            s+=" " + a[i];

        }
        s+=" ]";

    return s;
    }
    public static void main(String[]args){
      ArrayList t=new ArrayList();
      t.add("matieu");
      t.add("boolbi");
      t.add("sidi");
      t.add("steph");
      t.add("blla");

        System.out.println(t.toString());
        t.sort(true);
        System.out.println(t.toString());
        t.sort(false);
        System.out.println(t.toString());





   }
}