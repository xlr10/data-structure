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

        Stack tmp=new Stack(4);
        System.out.println(tmp.empty());
        System.out.println();

        System.out.println("push");
        tmp.push(1);
        System.out.println(tmp.empty());
        System.out.println();

        System.out.println("peek");
        System.out.println(tmp.peek());
        System.out.println();

        System.out.println("pop");
        System.out.println(tmp.pop());
        System.out.println(tmp.empty());
        System.out.println();

        System.out.println("search");
        tmp.push(2);
        tmp.push(3);
        tmp.push(4);
        tmp.push(1);
        System.out.println(tmp.search(4));

        tmp.print();



    }
}
