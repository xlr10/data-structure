import arrList.arrList;
import stack.Stack;

/*
모듈간 import 문제 해결 shorturl.at/hjzQU

    Right click on project and select open module settings
    Go to dependencies tab
    click plus sign and add the module you want to use.
메이븐 사용하기?
 */

public class main {

    public static void main(String[] args) {
        System.out.println("Test Class..");

        testStack();

        //testArrayList();

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

        tmp.print();
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

        tmp_string.print();
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
        arr_int.print();
        arr_int.add(6);
        //for(int a=0 ; a<100;a++){   arr_int.add(6+a);}
        arr_int.print();
        arr_int.add(4,45);
        arr_int.print();

        //arr_int.clear();
        //arr_int.print();

        System.out.println("Is 3 in here? "+arr_int.contains(3));
        System.out.println("get: "+arr_int.get(0));
        arr_int.print();
        System.out.println("Position 3 : "+arr_int.indexOf(3));
        System.out.println("Is empty? "+arr_int.isEmpty());
        arr_int.removeRange(0,6);
        arr_int.print();
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
        arr_string.print();
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

    public static void printA(int i[]){
        for(int e :i){
            System.out.print(e+" ");
        }
        System.out.println();
    }



}

