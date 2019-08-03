package linkedList;

public class Node <T> {
    private T data;
    public Node next;
    //public Node prev;

    public Node(T input) {
        this.data = input;
        this.next = null;
        //this.prev = null;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

    public T get(){
        return this.data;
    }
    public void set(T input){
        this.data=input;
    }
}
