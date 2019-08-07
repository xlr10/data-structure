package tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

//이진트리
public class tree {
    //1. 트리구현
    //2. 탐색 구현
    //3. 인접 배열, 행렬로 구현?

    File file_tmp= new File("");
    private String path = file_tmp.getAbsolutePath()+"\\tree\\";
    private BufferedReader bufferedReader;
    private ArrayList <ArrayList>input_data;

    private node root;
    private Boolean n_node[];
    private int height;
    private List<Integer> toList=new ArrayList<>();

    public tree(){
    }

    public void make_tree(){
        root = new node(0);
        path+="input1.txt";

//      input1.txt is..
//                0
//            1        2
//        3   4        5   6
//        inoer: 3140526

        input_tree();

        System.out.println();

        print_tree_inArr();


        System.out.println("inorder Traersal");
        inOrderTraversal(root);
        System.out.println();
        System.out.println();

        System.out.println("preorder Traersal");
        preOrderTraversal(root);
        System.out.println();
        System.out.println();

        System.out.println("postorder Traersal");
        postOrderTraversal(root);
        System.out.println();
        System.out.println();

        find_tree(root,4);
        System.out.println();
        System.out.println();

        print_tree_inNode();

    }


    private void input_tree(){
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(path)));
            String str;

            n_node=new Boolean[Integer.valueOf(bufferedReader.readLine())];

            height=Integer.valueOf(bufferedReader.readLine().substring(0,1));
            System.out.println("Tree's Height : "+height);

            input_data=new ArrayList();


            while ((str = bufferedReader.readLine()) != null) {
                ArrayList<Integer> tmp=new ArrayList<Integer>();
                String stmp[] = str.split(" ");

                for(int a=0; a<stmp.length;a++){
                    tmp.add(Integer.valueOf(stmp[a]));
                }
                System.out.println(tmp);
                input_data.add(tmp);
            }

            make_treetotxt();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void find_tree(node n, int key){
        if(n != null) {
            System.out.print("\nNow "+n.get_key());

            find_tree(n.left_node,key);
            if(n.get_key()==key) System.out.print(" Find! ");
            find_tree(n.right_node,key);
        }
    }

    public void make_treetotxt(){
        ArrayList<Integer> ai_tmp=new ArrayList<>();
        for(int a=0;a<height;a++){
            for(int b=0;b<input_data.size();b++){
                ai_tmp.add((Integer)input_data.get(a).get(b));
            }
        }
        Set s_tmp=new HashSet(ai_tmp);  //중복제거
        List l_tmp=new ArrayList(s_tmp);


        Queue<node> q_node=new ArrayDeque<>();

        for(int a=0, c=0;a<height;a++){
            for(int b=0;b<Math.pow(2,a);b++,c++){
                if(a==0) {
                    root = new node((Integer) l_tmp.get(c++));
                    q_node.offer(root);
                    break;
                }
                if(b%2==0){
                    node tmp=q_node.poll();
                    //System.out.println("poll>>>> "+ tmp.get_key()+"  c:"+c);
                    q_node.offer(tmp.left_node=new node(c));
                    q_node.offer(tmp.right_node=new node(c+1));
                    //System.out.println("now offer : "+c+", "+(c+1));
                }
            }
        }
    }


    public void print_tree_inArr(){
        //저장된 배열로 출력
        System.out.println("TXT에서 읽어 리스트에 저장된 값을 출력");
        ArrayList<Integer> ai_tmp=new ArrayList<>();
        for(int a=0;a<height;a++){
            for(int b=0;b<input_data.size();b++){
                //System.out.println(">>"+(Integer)input_data.get(a).get(b));
                ai_tmp.add((Integer)input_data.get(a).get(b));
            }
        }
        Set s_tmp=new HashSet(ai_tmp);  //중복제거
        List l_tmp=new ArrayList(s_tmp);

        for(int a=0, c=0;a<height;a++){
            for(int b=0;b<Math.pow(2,a);b++){
                System.out.print(l_tmp.get(c++));
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

    }

    public void print_tree_inNode(){
        //저장된 노드로 출력
        //...
        System.out.println();
        System.out.println("저장된 노드 탐색으로 트리 출력");

        inOrderToint(root);

        Set s_tmp=new HashSet(toList);
        List l_tmp=new ArrayList(s_tmp);

        for(int a=0, c=0;a<height;a++){
            for(int b=0;b<Math.pow(2,a);b++){
                System.out.print(l_tmp.get(c++));
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

    }

    private void inOrderToint(node n){
        if(n!=null){
            inOrderToint(n.left_node);
            toList.add(n.get_key());
            inOrderToint(n.right_node);
        }

    }

    public void inOrderTraversal(node n){
        if(n!=null){
            inOrderTraversal(n.left_node);
            System.out.print(n.get_key()+" ");
            //System.out.println(n.get_key()+","+(a++)+" ");
            inOrderTraversal(n.right_node);
        }

    }
    public void preOrderTraversal(node n){
        if(n!=null){
            System.out.print(n.get_key()+" ");
            inOrderTraversal(n.left_node);
            inOrderTraversal(n.right_node);
        }
    }
    public void postOrderTraversal(node n){
        if(n!=null){
            inOrderTraversal(n.left_node);
            inOrderTraversal(n.right_node);
            System.out.print(n.get_key()+" ");
        }
    }

}
