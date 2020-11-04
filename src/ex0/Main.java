package ex0;

public class Main {


    public static void main(String[] args)
    {

        node_data a = new NodeData();
        node_data b = new NodeData();
        node_data c = new NodeData();

        a.setInfo("this is a");
        b.setInfo("this is b");
        c.setInfo("this is c");

        graph g = new Graph_DS();
        g.addNode(a);
        g.addNode(b);
        g.addNode(c);


        g.connect(a.getKey() ,b.getKey());
//        g.connect(c.getKey() ,b.getKey());

        graph_algorithms algo=new Graph_Algo();
        algo.init(g);
        graph g1 = algo.copy();

        System.out.println(g1.nodeSize());
        System.out.println(g1.edgeSize());

        System.out.println(algo.isConnected());
    }
}
