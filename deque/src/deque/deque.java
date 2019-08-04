package deque;

import linkedList.linkedList;

import java.util.Iterator;

public class deque <E> extends linkedList{

    //       Inserts the specified element into the queue represented by this deque (in other words, at the tail of this deque) if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.
    @Override
    public boolean add(Object o) {
        return super.add(o);
    }


    //      Inserts the specified element at the front of this deque if it is possible to do so immediately without violating capacity restrictions.
    @Override
    public void addFirst(Object o) {
        super.addFirst(o);
    }


    //      Inserts the specified element at the end of this deque if it is possible to do so immediately without violating capacity restrictions.
    @Override
    public void addLast(Object o) {
        super.add(o);
    }


    //      Returns true if this deque contains the specified element.
    public boolean contains(Object o){
        return super.contains(o);
    }


    //      Returns an iterator over the elements in this deque in reverse sequential order.
    public Iterator<E> descendingIterator(){
        return super.descendingIterator();
    }


    //      Retrieves, but does not remove, the head of the queue represented by this deque (in other words, the first element of this deque).
    public E element(){
        return (E)super.element();
    }


    //      Returns an iterator over the elements in this deque in proper sequence.
    public Iterator<E> iterator(){
        return super.iterator();
    }


    //      Retrieves, but does not remove, the head of the queue represented by this deque (in other words, the first element of this deque), or returns null if this deque is empty.
    public E peek(){
        return (E)super.element();
    }


    //      Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty.
    public E peekFirst(){
        return (E)super.element();
    }


    //      Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.
    public E peekLast(){
        E tmp = (E)super.getLast();
        if(tmp == null) return null;
        else return tmp;
    }


    //      Pops an element from the stack represented by this deque.
    public E pop(){
        return (E)super.poll();
    }


    //      Pushes an element onto the stack represented by this deque (in other words, at the head of this deque) if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.
    @Override
    public void push(Object o) {
        super.addFirst(o);
    }


    //      Retrieves and removes the head of the queue represented by this deque (in other words, the first element of this deque).
    public E remove(){
        return (E)super.remove();
    }


    //      Returns the number of elements in this deque.
    public int size(){
        return  super.size();
    }


}
