package ex0;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class NodeData implements node_data{

    // characteristice

    private static int idCounter = 0;
    private int key;
    private String info;
    private int Tag;
    private LinkedHashMap<Integer , node_data> neighbors;
    private int distance=0;



    // constructor

    public NodeData(){
        key=idCounter++;
        neighbors = new  LinkedHashMap<Integer , node_data>();
        info="";
        Tag=-1;
    }

    public NodeData (node_data other){
        this.info=other.getInfo();
        this.key=other.getKey();
        this.Tag=other.getTag();
        for(node_data i:other.getNi()){
            this.neighbors.put(i.getKey(),i);
        }
    }
    // function

    @Override
    public int getKey() {
        return key;
    }

    @Override
    public Collection<node_data> getNi() {
        return neighbors.values();
    }

    @Override
    public boolean hasNi(int key) {
        return neighbors.containsKey(key);
    }

    @Override
    public void addNi(node_data t) {
        neighbors.put(t.getKey(),t);
    }

    @Override
    public void removeNode(node_data node) {
        neighbors.remove(node.getKey());
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void setInfo(String s) {
        info=s;
    }

    @Override
    public int getTag() {
        return Tag;
    }

    @Override
    public void setTag(int t) {
        Tag=t;
    }



    @Override
    public int getDist() {
       return this.distance;
    }
    @Override
    public void setDist(int d) {
        this.distance=d;
    }



    public static void main(String[] args) {
        node_data a=new NodeData();
        node_data b=new NodeData();
        node_data c=new NodeData();
        node_data d=new NodeData();
        System.out.println(a.getKey());
        System.out.println(b.getKey());
        System.out.println(c.getKey());
        System.out.println(d.getKey());

        a.addNi(b);
        a.addNi(d);
        a.addNi(c);
        System.out.println(a.hasNi(1));
        System.out.println(a.hasNi(2));
        System.out.println(a.hasNi(4));
        a.removeNode(b);
        System.out.println(a.hasNi(1));

    }
}
