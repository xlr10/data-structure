import arrList.arrList;
import deque.deque;
import graph.graph;
import linkedList.linkedList;
import queue.queue;
import stack.Stack;

import java.util.Iterator;

/*
모듈간 import 문제 해결 shorturl.at/hjzQU

    Right click on project and select open module settings
    Go to dependencies tab
    click plus sign and add the module you want to use.
메이븐 사용하기?
 */

public class main{

    public static void main(String[] args) {
        System.out.println("Test Class..");

//        testStack();
//        System.out.println();
//
//        testArrayList();
//        System.out.println();
//
//        testLinkedList();
//        System.out.println();
//
//        testQueue();
//        System.out.println();
//
//        testDeque();
//        System.out.println();

        testGraph();
        System.out.println();











    }
    public static void testStack(){

        //  stack integer
        System.out.println("Stack Example(int)========================");
        Stack<Integer> tmp=new Stack();
        //Stack<Integer> tmp=new Stack();
        System.out.println("Is empty? "+tmp.empty());

        System.out.println("push : 1");
        tmp.push(1);
        System.out.println("Is empty? "+tmp.empty());

        System.out.println("peek");
        System.out.println("peek value : "+tmp.peek());

        System.out.println("pop");
        System.out.println("pop value : "+tmp.pop());

        System.out.println("search (push 2,3,4,1 and find 4)");
        tmp.push(2);
        tmp.push(3);
        tmp.push(4);
        tmp.push(4);
        tmp.push(4);
        tmp.push(4);
        tmp.push(1);
        System.out.println("position is "+tmp.search(4)+" (top:1, none:-1)");

        System.out.println(tmp);
        System.out.println();


        //stack string
        System.out.println("Stack Example(string)========================");
        Stack<String> tmp_string=new Stack();

        System.out.println("Is empty? "+tmp_string.empty());

        System.out.println("push :a");
        tmp_string.push("a");

        System.out.println("peek");
        System.out.println("peek value : "+tmp_string.peek());

        System.out.println("pop");
        System.out.println("pop value : "+tmp_string.pop());

        System.out.println("search (push b,c,d,a and find c)");
        tmp_string.push("b");
        tmp_string.push("c");
        tmp_string.push("d");
        tmp_string.push("a");
        System.out.println("position is "+tmp_string.search("c")+" (top:1, none:-1)");

        System.out.println(tmp_string);
        System.out.println();
    }

    public static void testArrayList(){
        //arrList int
        System.out.println("ArrayList Example(int)========================");
        arrList<Integer> arr_int=new arrList<Integer>();
        arr_int.add(1);
        arr_int.add(2);
        arr_int.add(3);
        arr_int.add(4);
        arr_int.add(5);
        System.out.println(arr_int);
        arr_int.add(6);
        //for(int a=0 ; a<100;a++){   arr_int.add(6+a);}
        System.out.println(arr_int);
        arr_int.add(4,45);
        System.out.println(arr_int);

        //arr_int.clear();
        //arr_int.print();

        System.out.println("Is 3 in here? "+arr_int.contains(3));
        System.out.println("get: "+arr_int.get(0));
        System.out.println(arr_int);
        System.out.println("Position 3 : "+arr_int.indexOf(3));
        System.out.println("Is empty? "+arr_int.isEmpty());
        arr_int.removeRange(0,6);
        System.out.println(arr_int);
        System.out.println(arr_int.isEmpty());
        System.out.println();
        System.out.println();


        //arrList string
        System.out.println("ArrayList Example(string)========================");
        arrList<String> arr_string=new arrList<String>();
        arr_string.add("asd");
        arr_string.add("bsd");
        arr_string.add("csd");
        arr_string.add("dsd");
        System.out.println(arr_string);
//        arr_string.add(3,"aaa");
//        arr_string.print();
//
//        System.out.println("Is asd in here? "+arr_string.contains("asd"));
//        System.out.println("get: "+arr_string.get(4));
//        arr_string.print();
//        System.out.println("Position aaa : "+arr_string.indexOf("aaa"));
//        System.out.println("Is empty? "+arr_string.isEmpty());
//        arr_string.removeRange(1,3);
//        arr_string.print();
//        System.out.println(arr_string.get(arr_string.size()));
//        System.out.println();
//        System.out.println();

        //String[] tmp=(String[])arr_string.toArray();
        Object[] tmp = arr_string.toArray();
        String[] arr_to_string=new String[arr_string.size()];
        for(int a=0;a<arr_to_string.length;a++){
            arr_to_string[a]=(String) tmp[a];
        }

        for(String e : arr_to_string){
            System.out.print(e+" ");
        }


    }

    public static void testLinkedList(){

        linkedList<Integer> tmp=new linkedList<Integer>();
        tmp.add(1);
        tmp.add(2);
        tmp.add(3);
        tmp.add(4);
        tmp.add(5);
        System.out.println(tmp);

        tmp.add(2,2);
        System.out.println(tmp);

        linkedList copytest;
        try {
            copytest=(linkedList)tmp.clone();
            System.out.println("deep copy "+copytest.toString());
            copytest.add(23);
            System.out.println("deep copy "+copytest.toString());
            System.out.println("tmp: "+tmp.toString());
        }catch (Exception e){
            System.out.println("Clone Excoption");
        }

        System.out.println("get index '6': "+tmp.get(6));

        System.out.println(tmp);
        System.out.println("Iterator Loop");
        Iterator<Integer> iter=tmp.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next()+" ");
        }
        System.out.println();

        System.out.println("Is '3' here? "+tmp.contains(3));
        System.out.println("Is '9' here? "+tmp.contains(9));

        System.out.println("Iterator revers order");
        Iterator<Integer> reiter=tmp.descendingIterator();
        while (reiter.hasNext()){
            System.out.print(reiter.next()+" ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Set starting iterator point");
        Iterator<Integer> test=tmp.listIterator(2);
        while (test.hasNext()){
            System.out.print(test.next()+" ");
        }
        System.out.println();

        System.out.println("remove test to index");
        System.out.println(tmp);
        System.out.println("remove index:2 and value:"+tmp.remove(2));
        System.out.println(tmp);

        System.out.println("set(replace) test : 32");
        System.out.println("return : "+tmp.set(2,32));
        System.out.println(tmp);

        System.out.println();
        System.out.println("toArray test(Object)");
        Object[] ob_tmp=tmp.toArray();
        for(Object e : ob_tmp){
            System.out.print(e.toString()+" ");
        }
        System.out.println();

        //https://stackoverflow.com/questions/15422161/java-list-t-t-toarrayt-a-implementation      ???
        System.out.println();
        System.out.println("toArray test(Generic)");
        Integer[] n=new Integer[10];
        n=tmp.toArray(n);
        for(Integer e:n){
            System.out.print(e+" ");
        }
        System.out.println();

//
//        System.out.println("remove");
//        tmp.remove();
//        System.out.println(tmp);


        linkedList<Integer>asd=new linkedList<Integer>();
        System.out.println(asd);

        System.out.println("linkelist.addfirst()");
        tmp.addFirst(333);
        System.out.println(tmp);


    }

    public static void testQueue(){
        queue<Integer> tmp=new queue<Integer>();
        tmp.offer(1);
        tmp.offer(2);
        tmp.offer(3);
        tmp.offer(4);
        tmp.offer(5);
        System.out.println(tmp);

        System.out.println("queue.element() test: "+tmp.element());
        System.out.println("queue.peek(): "+tmp.peek());
        System.out.println("queue.poll(): "+tmp.poll());
        System.out.println(tmp);
        System.out.println("queue.poll(): "+tmp.poll());
        System.out.println(tmp);
        System.out.println("queue.poll(): "+tmp.poll());
        System.out.println(tmp);
        System.out.println("queue.poll(): "+tmp.poll());
        System.out.println(tmp);
        System.out.println("queue.poll(): "+tmp.poll());
        System.out.println(tmp);

        System.out.println("queue.remove()");
        tmp.remove();
        System.out.println(tmp);
    }

    public static void testDeque(){
        deque<Integer> tmp=new deque<Integer>();
        System.out.println("deque.add(): 1~4");
        tmp.add(1);
        tmp.add(2);
        tmp.add(3);
        tmp.add(4);
        System.out.println(tmp);

        System.out.println("deque.push(): 11~44");
        tmp.push(11);
        tmp.push(22);
        tmp.push(33);
        tmp.push(44);
        System.out.println(tmp);

        System.out.println("deque.contain(33): "+tmp.contains(33));
        System.out.println("deque.element(): "+tmp.element());
        System.out.println("deque.peek(): "+tmp.peek());
        System.out.println("deque.peekFirst(): "+tmp.peekFirst());
        System.out.println("deque.peekLast(): "+tmp.peekLast());
        System.out.println("deque.pop(): "+tmp.pop());
        System.out.println(tmp);
        System.out.println("deque.size(): "+tmp.size());


        System.out.println("deque.itertator(): ");
        Iterator<Integer>iter=tmp.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next()+" ");
        }
        System.out.println();

        System.out.println("deque.descendingIterator()");
        Iterator<Integer>deiter=tmp.descendingIterator();
        while (deiter.hasNext()){
            System.out.print(deiter.next()+" ");
        }
        System.out.println();


        System.out.println("deque.remove(): "+tmp.remove());
        System.out.println(tmp);
    }

    public static void testGraph(){
        graph tmp=new graph("input1.txt");
        tmp=new graph("input2.txt");
    }
}



