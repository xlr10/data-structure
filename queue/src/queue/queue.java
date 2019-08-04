package queue;

import linkedList.linkedList;

public class queue <E> extends linkedList{


    //     Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.
    @Override
    public boolean add(Object o) {
        return super.add(o);
    }


    //      Retrieves, but does not remove, the head of this queue.
    public E element(){
        return (E)super.element();
    }

    //      Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
    public boolean offer(E e){
        return super.add(e);
    }

    //      Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
    public E peek(){
        E tmp = (E)super.element();
        if(tmp ==null) return null;
        else return tmp;
    }


    //      Retrieves and removes the head of this queue, or returns null if this queue is empty.
    public E poll(){
        return (E)super.poll();
    }

    //      Retrieves and removes the head of this queue.
    public E remove(){
        return (E)super.remove();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
