package stack;

public class Stack<T> {

    //최초 생성 : item은 int
    //refactoring -> 1. 제네릭
    ////             2. 생성자로 크기지정->리스트로 동적배열 구현

    private T [] stack_data;
    private int index = 0;  //push될 위치

    //스택 크기는 생성자로 지정
    public Stack(T[] arr) {
        System.out.println("Initial Stack");
        //stack_data = new T[size];     //제네릭 배열 문제.. 해결https://m.blog.naver.com/justkukaro/220875157548
                                        // 초기에 리스트로 구성하면 해결됨
        stack_data = arr;   //제네릭 외부에서 클래스 생성후 전달 (런타임에서 자료형 미결정 문제 해결)
    }

    //    해당 item을 Stack의 top에 삽입
    public void push(T item) {
        stack_data[index++] = item;
    }

    //    Stack의 top에 있는 item을 삭제하고 해당 item을 반환
    public T pop() {
        index--;
        T tmp = stack_data[index];
        stack_data[index] = null;
        return tmp;
    }

    //    Stack의 top에 있는 item을 삭제하지않고 해당 item을 반환
    public T peek() {

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
    public int search(T target) {

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
    public int size(){
        return index-1;
    }
}
