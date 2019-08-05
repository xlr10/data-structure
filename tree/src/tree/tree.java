package tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

//이진트리
public class tree {
    //1. 트리구현
    //2. 탐색 구현
    //3. 인접 배열, 행렬로 구현?

    private String path = "D:\\Programming\\DataStructure\\tree\\";
    private BufferedReader bufferedReader;
    private ArrayList <ArrayList>input_data;

    private node root;
    private Boolean n_node[];
    private String order="";
    private int height;

    public tree(){
    }

    public void make_tree(){
        root = new node(0);
        path+="input1.txt";
        input_tree();



        root.left_node=new node(1);
        root.right_node=new node(2);

        //key==1
        root.left_node.left_node=new node(3);
        root.left_node.right_node=new node(4);

        //key==2
        root.right_node.left_node=new node(5);
        root.right_node.right_node=new node(6);


        System.out.println("inorder Traersal");
        inOrderTraversal(root);
        System.out.println();
        preOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);
        System.out.println();
//                0
//            1        2
//        3   4        5   6
//        inoer: 3140526

        find_tree(root,4);
//        System.out.println();
//        print_tree();

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
            System.out.println();

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

    public void make_tree(node n){
        if(n!=null){
            inOrderTraversal(n.left_node);
            System.out.print(n.get_key()+" ");
            inOrderTraversal(n.right_node);
        }

    }

    public void print_tree(){

        inOrder_str(root);
        System.out.println(order);

        System.out.println();
        for(int a=0;a<height;a++){
            System.out.print(" ");
        }

        for(int a=0;a<order.length();a++){

        }



    }

    private void inOrder_str(node n){
        if(n!=null){
            inOrder_str(n.left_node);
            order+=n.get_key();
            inOrder_str(n.right_node);
        }
    }

    public void inOrderTraversal(node n){
        if(n!=null){
            inOrderTraversal(n.left_node);
            System.out.print(n.get_key()+" ");
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
