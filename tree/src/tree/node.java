package tree;

public class node {
    private int key;
    public node left_node;
    public node right_node;

    public node(int key) {
        this.key = key;
        this.left_node = null;
        this.right_node = null;
    }
    public int get_key(){
        return this.key;
    }

}
