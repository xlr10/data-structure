package stack;

import arrList.arrList;

public class Stack<T> {

    //최초 생성 : item은 int
    //refactoring -> 1. 제네릭
    ////             2. 생성자로 크기지정->리스트로 동적배열 구현 (완료 8/2 \DataStructure\arrList\arrList.class 사용)
    

    private arrList<T>stack_data=new arrList<T>();

    //    해당 item을 Stack의 top에 삽입
    public void push(T item) {
        stack_data.add(item);
    }

    //    Stack의 top에 있는 item을 삭제하고 해당 item을 반환
    public T pop() {
        return (T)stack_data.get(stack_data.size());
    }

    //    Stack의 top에 있는 item을 삭제하지않고 해당 item을 반환
    public T peek() {
        T tmp = (T)stack_data.get(stack_data.size());
        stack_data.add(tmp);
        return tmp;
    }

    //    Stack이 비어있으면 true를 반환 그렇지않으면 false를 반환
    public boolean empty() {
        if (stack_data.isEmpty())   return true;
        else                        return false;
    }

    //    해당 Object의 위치를 반환 Stack의 top 위치는 1, 해당 Object가 없으면 -1을 반환
    public int search(T target) {
        int pos = stack_data.indexOf(target);
        if(pos>0){
            //인덱스 변환 => 스택은 마지막이 1 이므로
            return stack_data.size()-pos+1;
        }else {
            System.out.println("No Object");
            return -1;
        }
    }

    public void print() {
        Object[] tmp = stack_data.toArray();
        System.out.println("___");
        for (Object e : tmp){
            if(e == null)   continue;
            System.out.println("|"+e+"|");
        }
        System.out.println("---");

    }
    public int size(){
        return stack_data.size();
    }
}
