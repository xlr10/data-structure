import arrList.arrList;
import stack.Stack;
import test.test;
import test2.test2;


/*
모듈간 import 문제 해결 shorturl.at/hjzQU

    Right click on project and select open module settings
    Go to dependencies tab
    click plus sign and add the module you want to use.
메이븐 사용하기?
 */

public class main {

    public static void main(String[] args) {
        System.out.println("test");
        test.print();
        test2.print();
        System.out.println();
        System.out.println();


        //  stack integer
        Stack<Integer>tmp=new Stack(new Integer[4]);
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
        tmp.push(1);
        System.out.println("position is "+tmp.search(4)+" (top:1, none:-1)");

        tmp.print();
        System.out.println();


        //stack string
        Stack<String> tmp_string=new Stack(new String[4]);

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

        tmp_string.print();
        System.out.println();



//        int a[]={1,2,3,4,5,6};
//        int b[]=new int[2];
//        int c[]=new int[3];
//
//        b= Arrays.copyOfRange(a,0,2);
//        printA(b);
//
//        c=Arrays.copyOfRange(a,2,6);
//        printA(c);
//
//        System.out.println(a.length);

        arrList<Integer> arr_int=new arrList<Integer>();
        arr_int.add(1);
        arr_int.add(2);
        arr_int.add(3);
        arr_int.add(4);
        arr_int.add(5);
        arr_int.print();
        arr_int.add(6);
        arr_int.print();
        arr_int.add(4,45);
        arr_int.print();

        //arr_int.clear();
        //arr_int.print();

        System.out.println("Is 3 in here? "+arr_int.contains(3));

        System.out.println("get: "+arr_int.get(4));
        arr_int.print();

        System.out.println("Position 3 : "+arr_int.indexOf(3));
        System.out.println("Is empty? "+arr_int.isEmpty());

        arr_int.removeRange(1,3);
        arr_int.print();



    }

    public static void printA(int i[]){
        for(int e :i){
            System.out.print(e+" ");
        }
        System.out.println();
    }



}
