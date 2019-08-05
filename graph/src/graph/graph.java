package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class graph {
    //1. 인접리스트로 구현
    //2. 인접행렬로 구현

    private int n_node = 0, n_edge = 0;
    private Vector<List> adj_arr;    //인접리스트
    private int adj_metrix[][];        //인접행렬
    private String path = "D:\\Programming\\DataStructure\\graph\\";
    private BufferedReader bufferedReader;

    static boolean[] visit;




    public graph(String input) {
        path+=input;

        inputAdjArr();
        ArrtoMetrix();

        for(int a=1;a<=n_node;a++){
            dfs_adjMetrix(a);
            dfs_adjArr(a);
            System.out.println();
            bfs_adjMetrix(a);
            bfs_adjArr(a);
        }
    }


    private void inputAdjArr() {

        System.out.println("adj Arr");
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(path)));

            String str;
            String stmp[];


            n_node = Integer.valueOf(bufferedReader.readLine());        //8
            n_edge = Integer.valueOf(bufferedReader.readLine());        //13

            adj_arr=new Vector<List>(n_node);
            for(int a=0;a<8;a++)    adj_arr.add(new Vector());


            System.out.println(n_node + " " + n_edge);

            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
                stmp = str.split(" ");

                Vector<Integer> tmp_v = new Vector<>();

                for (int a = 1; a < stmp.length; a++) {
                    adj_arr.get(Integer.valueOf(stmp[0])-1).add(Integer.valueOf(stmp[a]));
                }

            }
            System.out.println();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        print_adjarr();

        System.out.println();
        System.out.println();

    }

    private void print_adjarr() {
        for(int a=0;a<n_node;a++){
            System.out.print((a+1)+": ");
            for(int b=0;b<adj_arr.get(a).size();b++){
                if(b==0) System.out.print("[ ");
                if(b%2 == 0 && b!=0) System.out.print("] -> [ ");
                System.out.print((Integer)adj_arr.get(a).get(b)+" ");
                if(b+1 == adj_arr.get(a).size()) System.out.print("]");
            }
            System.out.println();
        }
    }


    private void ArrtoMetrix() {
        System.out.println("adj Metrix");


        try {
            bufferedReader = new BufferedReader(new FileReader(new File(path)));
            String str;

            String stmp[];

            int n_cr = Integer.valueOf(bufferedReader.readLine());
            System.out.println(n_cr);
            adj_metrix = new int[n_cr][n_cr];
            System.out.println(bufferedReader.readLine());

            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);

                stmp = str.split(" ");

                for (int b = 1; b <= n_cr; b++) {
                    if (Integer.valueOf(stmp[1]) == b) adj_metrix[Integer.valueOf(stmp[0])-1][b - 1] = Integer.valueOf(stmp[2]);

                }
            }
            System.out.println();

            print_adjmetrix();

            System.out.println();
            System.out.println();

        } catch (Exception e) {
            System.out.println(e);
            print_adjmetrix();
        }
    }

    private void print_adjmetrix(){
        for (int e[] : adj_metrix) {
            for (int d : e) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }


    public void dfs_adjMetrix(int i){
        setVisit();
        System.out.println("DFS of adj Metrix");
        dfs_adjMetrix_module(i);
        System.out.println();
    }

    private void dfs_adjMetrix_module(int i) {
        visit[i-1] = true;
        System.out.print(i + " ");

        for (int j = 0; j < n_node; j++) {
            if (adj_metrix[i-1][j] > 0 && visit[j] == false) {
                dfs_adjMetrix_module(j+1);
            }
        }
    }


    public void dfs_adjArr(int i){
        setVisit();
        System.out.println("DFS of adj Array");
        dfs_adjArr_module(i);
        System.out.println();
    }


    private void dfs_adjArr_module(int i){
        visit[i-1]=true;
        System.out.print(i+" ");

        for(int a=0;a<adj_arr.get(i-1).size();a+=2){
            if(visit[(Integer)adj_arr.get(i-1).get(a)-1]==false){
                dfs_adjArr_module((Integer)adj_arr.get(i-1).get(a));
            }
        }
    }

    private void setVisit(){
        visit=null;
        visit=new boolean[n_node];
    }


    public void bfs_adjMetrix(int i){
        setVisit();
        System.out.println("BFS of adj Metrix");

        LinkedList visitqueue=new LinkedList();
        HashMap<Integer,Boolean>chkQueue=new HashMap<>();

        visit[i-1]=true;
        visitqueue.add(i);
        chkQueue.put(i,true);

        while (visitqueue.peek() !=null){
            int now= (Integer) visitqueue.poll();
            System.out.print(now+ " ");
            visit[now-1]=true;

            for(int a=0; a<n_node;a++){
                if(adj_metrix[now-1][a]>0 && visit[a]==false){
                    if(!chkQueue.containsKey(a+1)) {
                        visitqueue.add(a+1);
                        chkQueue.put(a+1,true);
                    }
                }
            }
        }
        System.out.println();
    }

    public void bfs_adjArr(int i){
        setVisit();
        System.out.println("BFS of adj Array");

        LinkedList visitqueue=new LinkedList();
        HashMap<Integer,Boolean>chkQueue=new HashMap<>();   //중복값 제거 https://manducku.tistory.com/24?category=683258

        visit[i-1]=true;
        visitqueue.add(i);
        chkQueue.put(i,true);

        while (visitqueue.peek() !=null){
            int now= (Integer) visitqueue.poll();
            System.out.print(now+ " ");
            visit[now-1]=true;

            for(int a=0;a<adj_arr.get(now-1).size();a+=2){
                int tmp = (Integer)adj_arr.get(now-1).get(a);
                if(visit[tmp-1]==false){
                    if(!chkQueue.containsKey(tmp)){
                        visitqueue.add(tmp);
                        chkQueue.put(tmp,true);
                    }
                }
            }
        }
        System.out.println();
    }
}

