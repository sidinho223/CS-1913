/**
 * Created by sidi Diaby  diaby002 on 11/7/2016.
 */
public class LinkedList<T extends Comparable<T>> implements List<T> {

    Node node;

    public LinkedList() {
        this.node = new Node();

    }

    public boolean add(T element) {
        if (element == null) {
            return false;
        }
        if (isEmpty()) {
            this.node = new Node(element);

            return true;

        } else if (node.getNext() == null) {
            Node c = new Node(element);
            node.setNext(c);
            return true;
        } else {
            Node current = node;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            Node c = new Node(element);
            current.setNext(c);
            return true;

        }

    }

    public boolean add(int index, T element) {
        int i = 0;
        if (isEmpty()) {
            return false;
        }
        Node current = node;
        if (index == 0 && current != null) {
            Node temp = new Node(current.getData(), current.getNext());
            current.setData(element);
            current.setNext(temp);

        } else if (index >= size()) {
            return false;
        }
        else {
            Node previous = current;
            while (current.getNext() != null && i < index) {
                previous = current;
                current = current.getNext();
                i += 1;
            }
            Node temp = new Node(element, current);
            previous.setNext(temp);


        }
        return true;

    }


    public void clear() {
        this.node = new Node();
    }

    public boolean contains(T element) {
        Node current = node;
        while (current.getNext() != null) {
            if (current.getData().equals(element)) {
                return true;
            }
            current = current.getNext();

        }
        return false;
    }

    public T get(int index) {
        Node current = node;
        int i = 0;

        if (isEmpty()) {
            return null;
        } else if (index == 0) {
            return (T) current.getData();

        } else if (index >= size()) {
            return null;

        } else {
            while (current.getNext() != null && i < index) {
                current = current.getNext();


                i += 1;


            }

            return (T) current.getData();
        }

    }

    public int indexOf(T element) {
        Node current = node;
        int i = 0;
        while (current.getNext() != null) {
            if (current.getData().equals(element)) {
                return i;
            }
            current = current.getNext();
            i += 1;

        }
        return -1;

    }

    public boolean isEmpty() {
        return node.getData() == null;

    }

    public int lastIndexOf(T element) {
        Node current = node;
        int i = 0;
        int r = -1;
        while (current.getNext() != null) {
            if (current.getData().equals(element)) {
                r = i;
            }
            current = current.getNext();
            i += 1;

        }
        if (current.getData()!=null && current.getData().equals(element)) {
            r = i;
        }
        return r;

    }

    public T set(int index, T element) {
       add(index,element);
        return remove(index+1);

    }

    public int size() {
        int s = 1;
        if (isEmpty()) {
            return 0;
        }
        Node current = node;


        while (current.getNext() != null) {
            current = current.getNext();
            s += 1;
        }
        return s;
    }

    public void sort(boolean order) {
        Node current = node;
        Node next = current.getNext();
        Node previous = current;

        if (isEmpty()) {
            return;
        }
        if (order == true) {
            for(int i=0; i<size()-1;i++){
                T smallest=get(i);

                for (int j=i+1;j<size();j++){
                    if(get(j)!=null && smallest.compareTo(get(j))>0){

                        smallest=get(j);


                    }
                }
                T temp=smallest;
                add(i,temp);


                int tempi=lastIndexOf(smallest);
                remove(tempi);







            }

        }
        if (order == false) {
            for(int i=0; i<size()-1;i++){
                T smallest=get(i);

                for (int j=i+1;j<size();j++){
                    if(get(j)!=null && smallest.compareTo(get(j))<0){

                        smallest=get(j);


                    }
                }
                T temp=smallest;
                add(i,temp);


                int tempi=lastIndexOf(smallest);
                remove(tempi);







            }

        }
    }
    public boolean remove(T element) {
        Node current = node;
        if (isEmpty()) {
            return false;
        } else if (element == null) {
            return false;
        } else if (current.getData().equals(element) && current.getNext() == null) {
            current = new Node(null, null);
        }
        else if(current.getData().equals(element)&&current.getNext()!=null){
            current.setData(current.getNext().getData());
            current.setNext(current.getNext().getNext());
        }
        else {
            int i = 1;
            Node previous = current;
            while (current.getNext() != null && current.getData().equals(element) != true) {
                previous = current;
                current = current.getNext();
                i += 1;
            }
            if (i >= size()) {
                return false;
            }
            else {
                previous.setNext(current.getNext());


            }




        }
        return true;
    }


   public T remove(int index){
       Node current = node;
       int i = 0;
       T temp;

       if (isEmpty()) {

           return null;
       }
       else if (index >= size()) {
           return null;

       }
       else if (index == 0 && current.getNext()!=null) {
           temp=(T)current.getData();
            current.setData((T)current.getNext().getData());
           current.setNext(current.getNext().getNext());

       }
       else if (index == 0 && current.getNext()==null) {
           temp=(T)current.getData();
           current.setData(null);
           current.setNext(null);

       }
       else {
           while (current.getNext() != null && i < index) {
               current = current.getNext();


               i += 1;


           }

           if (index == i && current.getNext()!=null) {
               temp = (T) current.getData();
               current.setData((T) current.getNext().getData());
               current.setNext(current.getNext().getNext());
           }
               else {
                   temp=(T)current.getData();
                   current.setData(null);
                   current.setNext(null);

               }



       }

       return (T) temp;

   }




    public static void main(String[]args){
        LinkedList l=new LinkedList();


        l.add("b");
       l.add("a");
       l.add("z");
       l.add("d");
        l.add("m");
        l.add("l");
        l.add("g");
        l.add("h");



        l.add(6,"oo");
        l.sort(true);

        System.out.println(l.get(0));
        System.out.println(l.get(1));
        System.out.println(l.get(2));



        System.out.println(l.get(3));
        System.out.println(l.get(4));
        System.out.println(l.get(5));
        System.out.println(l.get(6));
        System.out.println(l.get(7));





        System.out.println(l.size());











    }
}
