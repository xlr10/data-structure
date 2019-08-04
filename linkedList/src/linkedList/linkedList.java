package linkedList;

import java.util.Arrays;
import java.util.Iterator;


//기본 개념
//[HEAD]->[#1 node]->[#2 node]-> ... ->[#n node]<-[TAIL]

public class linkedList<E> implements Cloneable{
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size=0;

    public linkedList(){

    }

    //  Appends the specified element to the end of this list.
    public boolean add(E e) {
        Node new_node = new Node(e);
        if(size == 0){
            head=new_node;      //head의 next는 첫 노드
            tail=new_node;      //tail의 next는 마지막 노드
            new_node.next=null;
        }else{
            //for문 필요없이 마지막 노드 가르키는 객체로 접근
            tail.next=new_node; //tail은 마지막 노드를 가르킴 = tail.next == 마지막노드.next
            tail=new_node;      //마지막 노드가 추가되었으므로 tail 변경
        }
        size++;
        return true;
    }

    //  Inserts the specified element at the specified position in this list.
    public void add(int index, E element) {
        Node new_node = new Node(element);
        if(index>size){
            System.out.println("Out of Range!, list.length : "+size);
        }else if(index == size){
            add(element);
        }else {
            Node prev_node=head;    //insert될 노드의 앞노드
            Node next_node;         //  "       뒷노드

            for(int a=1; a<index; a++){ //insert 위치로 이동
                prev_node = prev_node.next;
            }
            next_node=prev_node.next;
            prev_node.next=new_node;
            new_node.next=next_node;
            size++;
        }
        return;
    }


    //  Inserts the specified element at the beginning of this list.
    public void addFirst(E e) {
        if(head==null) return;

        Node second_node = head;
        Node new_node = new Node(e);

        head=new_node;
        new_node.next=second_node;
        size++;
        return;
    }

    //  Appends the specified element to the end of this list.
    public void addLast(E e) {
        add(e);
        return;
    }

    //  Removes all of the elements from this list.
    public void clear() {
        head=tail=null;
        return;
    }

    //  Returns a deep copy of this LinkedList .
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //  Returns true if this list contains the specified element.
    public boolean contains(Object o) {
        Iterator<E> iter=this.iterator();
        while (iter.hasNext()){
            if(iter.next() == o)    return true;
        }
        return false;
    }

    //  ?   Returns an iterator over the elements in this deque in reverse sequential order.
    public Iterator<E> descendingIterator() {
        return new Iterator<E>() {
            int index=0;
            @Override
            public boolean hasNext() {
                return index<size;
            }
            @Override
            public E next() {
                index++;
                return get((size-index+1));
            }
        };
    }

    //Retrieves, but does not remove, the head (first element) of this list.
    public E element() {
        if(head==null) return null;

        return head.get();
    }

    //   Returns the element at the specified position in this list.
    public E get(int index) {
        if(head==null) return null;

        Node <E> prev_node=head;
        for(int a=1; a<index; a++){ prev_node = prev_node.next;}
        return prev_node.get();
    }

    //  Returns the first element in this list.
    public E getFirst() {
        return element();
    }

    //  Returns the last element in this list.
    public E getLast() {
        return tail.get();
    }

    //https://mainia.tistory.com/367    Iterator 구현 //익명클래스
    public Iterator<E> iterator(){
        return new Iterator<E>() {
            int index=1;
            @Override
            public boolean hasNext() {
                return index <= size;
            }
            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    //  Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
    public int indexOf(Object o) {
        if(head==null) return -1;

        Iterator<E> iter=this.iterator();
        int a=0;
        while (iter.hasNext()){
            a++;
            if(iter.next() == o )   return a;
        }
        return -1;
    }

    //Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
    public int lastIndexOf(Object o) {
        if(head==null) return -1;

        Iterator<E> reiter=this.descendingIterator();
        int a=size;
        while (reiter.hasNext()){
            if(reiter.next() == o )   return a;
        }
        return 0;
    }

    //Returns a list-iterator of the elements in this list (in proper sequence), starting at the specified position in the list.
    public Iterator<E> listIterator(int index) {
        Iterator<E> iter=this.iterator();
        for(int a=1; a<index; a++){ iter.next();}
        return iter;
    }


    //  Retrieves and removes the head (first element) of this list.
    public E poll() {
        if(head==null) return null;

        E tmp=getFirst();
        head=head.next;
        size--;
        return tmp;
    }

    //  Retrieves and removes the first element of this list, or returns null if this list is empty.
    public E pollFirst() {
        return poll();
    }

    //  Retrieves and removes the last element of this list, or returns null if this list is empty.
    public E pollLast() {
        if(head==null) return null;

        E tmp=getLast();
        Node tmpN=head;
        for(int a=1; a<size-1;a++){
            tmpN=tmpN.next;
        }
        tmpN.next=tail;

        return tmp;
    }

    //  Pops an element from the stack represented by this list.
    public E pop() {
        return pollLast();
    }

    //  Pushes an element onto the stack represented by this list.
    public void push(E e) {
        add(e);
    }

    //  Retrieves and removes the head (first element) of this list.
    public E remove() {
        if(head==null) return null;

        E tmp=getFirst();
        head=null;
        return tmp;
    }

    //  Removes the element at the specified position in this list.
    public E remove(int index) {
        if(head==null) return null;

        Node<E> prevNode=head;
        Node<E> nextNode;
        E tmp=null;

        if(index>size){
            System.out.println("Out of Range!, list.length : "+size);
        }else if(index == size){
            pop();
        }else {
            Iterator<E> iter = this.iterator();
            while (iter.hasNext()) {
                tmp=get(index);
                if (iter.next() == tmp) break;
                prevNode = prevNode.next;
            }
            nextNode = prevNode.next.next;
            prevNode.next=nextNode;
        }
        return tmp;
    }

    //  Removes the first occurrence of the specified element from this list, if it is present.
    public boolean remove(Object o) {
        if(head==null) return false;
        if(remove(indexOf(o))!=null)    return true;
        else                            return false;
    }

    //  Removes and returns the first element from this list.
    public E removeFirst() {
        return pollFirst();
    }

    //  Removes the first occurrence of the specified element in this list (when traversing the list from head to tail).
    public boolean removeFirstOccurrence(Object o) {
        if(head==null) return false;
        if(remove(indexOf(o))!=null)    return true;
        else                            return false;
    }

    //  Removes and returns the last element from this list.
    public E removeLast() {
        return pop();
    }

    //  Removes the last occurrence of the specified element in this list (when traversing the list from head to tail).
    public boolean removeLastOccurrence(Object o) {
        if(head==null) return false;
        if(remove(lastIndexOf(o))!=null)    return true;
        else                                return false;
    }

    //  Replaces the element at the specified position in this list with the specified element.
    public E set(int index, E element) {
        if(head==null) return null;
        Node <E> prev_node=head;
        E tmp=null;
        for(int a=1; a<index; a++){ prev_node = prev_node.next;}
        tmp=prev_node.get();
        prev_node.set(element);
        return tmp;
    }

    //  Returns the number of elements in this list.
    public int size() {
        return size;
    }

    //  Returns an array containing all of the elements in this list in proper sequence (from first to last element).
    public Object[] toArray() {
        if(head==null) return null;

        Object[] tmp=new Object[size];
        Iterator<E>iter = this.iterator();
        int a=0;

        while (iter.hasNext()){
            tmp[a++]=iter.next();
        }
        return tmp;
    }

    //  Returns an array containing all of the elements in this list in proper sequence (from first to last element); the runtime type of the returned array is that of the specified array.
    public <T> T[] toArray(T[] a) {
        return (T[])Arrays.copyOf(this.toArray(),size,a.getClass());
    }


    @Override
    public String toString() {
        Node tmp =head;
        if(tmp == null){    return "This list is empty ";}

        String str="";
        for(int a=0; a<size;a++){
            if(a+1 !=size) str+=tmp+" -> ";
            else str+=tmp;
            tmp=tmp.next;
        }
        str+="\n";
        return str;
    }
}

