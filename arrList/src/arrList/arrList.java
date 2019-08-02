package arrList;


import java.util.Arrays;

public class arrList<E> {

    //private E [] arr=new E[5];    //제네릭 특성상 배열불가. =자료형은 런타임에서 확정되기 때문
    //private Object [] arr=new Object[5];    //Object로 대체
    private Object[] arr;
    private int nowPos = 0;

    //  기본크기 5로 초기화
    public arrList() {
        arr = new Object[5];
    }

    //  size 요청시 해당 size로 초기화
    public arrList(int size) {
        arr = new Object[size];
    }

    //  Appends the specified element to the end of this list.
    public void add(E e) {
        if (nowPos == arr.length) {
            Object tmp[] = new Object[nowPos];
            System.arraycopy(arr, 0, tmp, 0, nowPos);
            arr = new Object[arr.length+10];
            System.arraycopy(tmp, 0, arr, 0, nowPos);
            arr[nowPos++] = (Object) e;
        } else {
            arr[nowPos++] = (Object) e;
        }
    }

    //  Inserts the specified element at the specified position in this list.
    public void add(int index, E element) {
        if (index > nowPos) {
            System.out.println("Out of Index\nNow Array's Size is " + nowPos + 1);
            return;
        } else if (index == nowPos) {
            add(element);
        } else {   //index<nowPos
            Object arr_front[] = new Object[index];
            Object arr_rear[] = new Object[nowPos - index + 1];

            //move front & rear
            arr_front = Arrays.copyOfRange(arr, 0, index);
            //print(arr_front);     //Just Dedugging
            arr_rear = Arrays.copyOfRange(arr, index, nowPos);
            //print(arr_rear);

            //init array
            arr = new Object[++nowPos];
            System.arraycopy(arr_front, 0, arr, 0, index);
            arr[index]=element;
            System.arraycopy(arr_rear, 0, arr, index+1, arr_rear.length);

        }
    }

    //Removes all of the elements from this list.
    public void clear() {
        arr = null;
        arr = new Object[5];
        nowPos=0;

    }

    //  Returns true if this list contains the specified element.
    public boolean contains(Object o) {
        for(Object e:arr){
            if(e==o)    return true;
        }
        return false;
    }

    //  Returns the element at the specified position in this list.
    public Object get(int index) {
        if (index > nowPos || index<0) {
            System.out.println("Out of Index\nNow Array's Size is " + nowPos + 1);
            return -1;

        } else if (index == nowPos) {
            Object tmp=arr[--nowPos];
            arr[nowPos]=null;
            return tmp;

        } else {   //index<nowPos
            Object tmp=arr[index];
            Object arr_front[] = new Object[index];
            Object arr_rear[] = new Object[nowPos - index];

            //move front & rear
            arr_front = Arrays.copyOfRange(arr, 0, index);
            //print(arr_front);     //Just Dedugging
            arr_rear = Arrays.copyOfRange(arr, index+1, nowPos);
            //print(arr_rear);

            //init array
            arr = new Object[--nowPos];
            System.arraycopy(arr_front, 0, arr, 0, index);
            System.arraycopy(arr_rear, 0, arr, index, arr_rear.length);

            return tmp;
        }

    }

    //  Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
    public int indexOf(Object o) {
        for(int a=0; a<nowPos;a++){
            if(arr[a]==o)    return a;
        }
        return -1;
    }

    //  Returns true if this list contains no elements.
    public boolean isEmpty() {
        for(Object e:arr){
            if(e!=null) return false;
        }
        return true;
    }

    //  Removes the element at the specified position in this list.
    public void remove(int index) {
        get(index);
    }

    //  Removes from this list all of the elements whose index is between fromIndex, inclusive, and toIndex, exclusive.
    public void removeRange(int fromIndex, int toIndex) {

        if(fromIndex>=toIndex || toIndex>nowPos || fromIndex<0) {
            System.out.println("Range is Invaild");

        }else if(toIndex==nowPos) {
            for(int a=fromIndex;a<nowPos;a++){  arr[a]=null;}
            nowPos=fromIndex;

        }else { // toIndex<nowPos
            Object arr_front[]= new Object[fromIndex];
            Object arr_rear[] = new Object[nowPos - toIndex];

            //move front & rear
            arr_front = Arrays.copyOfRange(arr, 0, fromIndex);
            //print(arr_front);     //Just Dedugging
            arr_rear = Arrays.copyOfRange(arr, toIndex, nowPos);
            //print(arr_rear);

            //init array
            nowPos=arr_front.length+arr_rear.length;
            //System.out.println(nowPos);
            arr = new Object[nowPos];
            System.arraycopy(arr_front, 0, arr, 0, fromIndex);
            System.arraycopy(arr_rear, 0, arr, fromIndex, arr_rear.length);
        }
    }

    //  Replaces the element at the specified position in this list with the specified element.
    public void set(int index, E element) {
        if(index>nowPos || index<0){
            System.out.println("Range is Invaild");
        }else {
            arr[index]=element;
        }
    }

    //  Returns the number of elements in this list.
    public int size() {
        return nowPos;
    }

    //  Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
    //public E subList(int fromIndex, int toIndex) {
    public Object subList(int fromIndex, int toIndex) {
        Object tmp[];

        if(fromIndex>=toIndex || toIndex>nowPos || fromIndex<0) {
            System.out.println("Range is Invaild");
            return -1;

        }else {
            return Arrays.copyOfRange(arr, 0, fromIndex);
        }
    }

    //  Returns an array containing all of the elements in this list in proper sequence (from first to last element).
    //public E toArray() {
    public Object[] toArray() {
        return arr;
    }

    public void print() {
        System.out.print("| ");
        for(Object e:arr){
            if(e==null) break;
            else System.out.print(e+" ");
        }
        //for (int a = 0; a < nowPos; a++) {  System.out.print(arr[a] + " ");}
        System.out.println("|");
    }

    private void print(Object e[]) {
        System.out.print(">>>| ");
        //for(Object e:arr){  System.out.print(e+" ");}
        for (int a = 0; a < e.length; a++) {
            System.out.print(e[a] + " ");
        }
        System.out.println("|");
    }

}
