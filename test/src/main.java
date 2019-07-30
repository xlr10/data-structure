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

        Stack tmp=new Stack(4);


    }
}
