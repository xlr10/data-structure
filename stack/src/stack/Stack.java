package stack;

public class Stack {

    //최초 생성 : item은 int
    //refactoring -> 자료형 무관/ 생성자로 크기지정->리스트로 동적배열 구현

    private int[] stack_data;
    private int index = 0;  //push될 위치

    //스택 크기는 생성자로 지정
    public Stack(int size) {
        System.out.println("Initial Stack");
        stack_data = new int[size];
    }

    //    해당 item을 Stack의 top에 삽입
    public void push(int item) {
        stack_data[index++] = item;
    }

    //    Stack의 top에 있는 item을 삭제하고 해당 item을 반환
    public int pop() {
        index--;
        int tmp = stack_data[index];
        stack_data[index] = 0;
        return tmp;
    }

    //    Stack의 top에 있는 item을 삭제하지않고 해당 item을 반환
    public int peek() {
        return stack_data[index - 1];
    }

    //    Stack이 비어있으면 true를 반환 그렇지않으면 false를 반환
    public boolean empty() {
        if (index == 0)
            return true;
        else
            return false;
    }

    //    해당 Object의 위치를 반환 Stack의 top 위치는 1, 해당 Object가 없으면 -1을 반환
    public int search(int target) {

        for (int a = 0; a < index; a++) {
            if (stack_data[a] == target)
                return index - a; //012 321
        }
        System.out.println("No Object");
        return -1;
    }

    public void print() {
        System.out.println("___");
        for (int a = index - 1; a >= 0; a--) {
            System.out.println("|" + stack_data[a] + "|");
        }
        System.out.println("---");

    }
}
