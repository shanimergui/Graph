package ex0;

import java.util.*;

public class Graph_Algo implements graph_algorithms {
    private graph gr;

    public Graph_Algo() {
        gr = new Graph_DS();

    }


    //תכונות
    //בנאים
    //פונקציות


    @Override
    public void init(graph g) {
        this.gr = g;
    }

    @Override
    public graph copy() {

        graph g1 = new Graph_DS(gr);
        return g1;
    }

    /**
     * fdksjlfdsklfdslkfhncjzxhfdsfsdjhfdkjhf
     * paramtr
     *
     * @return bollean
     */
    @Override
    public boolean isConnected() {
        boolean first = false;
        if (gr.nodeSize() == 0 || gr.nodeSize() == 1) {
            return true;
        } else {
            for (node_data i : gr.getV()) {
                if (first != true) {
                    first = true;
                    bfs(i);
                }
                if (i.getTag() == -1) return false;
            }
        }
        for (node_data i : gr.getV()) {
            i.setTag(-1);
        }
        return true;
    }

    @Override
    public int shortestPathDist(int src, int dest) {
        LinkedList<node_data> queue = new LinkedList<node_data>();
        gr.getNode(src).setTag(1);
        queue.add(gr.getNode(src));

        while (queue.size() != 0) {
            node_data poll = queue.poll();
            for (node_data i : poll.getNi()) {
                if (i.getTag() == -1) {
                    i.setTag(1);
                    i.setDist(poll.getDist() + 1);
                    queue.add(i);
                    if (i == gr.getNode(dest)) {
                        for (node_data j : gr.getV()) {
                            j.setTag(-1);
                        }
                        return i.getDist();
                    }
                }

            }
        }
        return -1;
    }

    /**
     * fixxxxxxxxxxxxxxxxxf
     * @param src - start node
     * @param dest - end (target) node
     * @return List - path
     */
    @Override
    public List<node_data> shortestPath(int src, int dest) {
        LinkedList<node_data> queue = new LinkedList<node_data>();
        gr.getNode(src).setTag(1);
        queue.add(gr.getNode(src));

        Map<node_data, node_data> parentNodes = new HashMap<>();

        while (queue.size() != 0) {
            node_data poll = queue.poll();
            for (node_data i : poll.getNi()) {
                if (i.getTag() == -1) {
                    i.setTag(1);
                    parentNodes.put(i,poll);
                    queue.add(i);
                    if (i == gr.getNode(dest)) {
                        for (node_data j : gr.getV()) {
                            j.setTag(-1);
                        }
                        Stack<node_data> path = new Stack<>();
                        List<node_data> pathrevers = new ArrayList<>();
                        node_data node = gr.getNode(dest);
                        while(node != null) {
                            path.add(node);
                            node = parentNodes.get(node);
                        }
                        while(path.size()!=0)
                            pathrevers.add(path.pop());
                        return pathrevers;
                    }
                }

            }
        }

        return null;
    }


    private void bfs(node_data s) {
        Queue<node_data> q = new LinkedList<>();
        s.setTag(1);
        q.add(s);
        while (!q.isEmpty()) {
            s = q.poll();
            for (node_data i : s.getNi()) {
                if (i.getTag() == -1) {
                    i.setTag(1);
                    q.add(i);
                }
            }
        }
    }


        public static void main (String[]args){
            node_data a = new NodeData();
            node_data b = new NodeData();
            node_data c = new NodeData();
            node_data d = new NodeData();
            node_data e = new NodeData();
            graph g = new Graph_DS();
            g.addNode(a);
            g.addNode(b);
            g.addNode(c);
            g.addNode(d);
            g.addNode(e);
            g.connect(a.getKey(), b.getKey());
            g.connect(a.getKey(), c.getKey());
            g.connect(c.getKey(), b.getKey());
            g.connect(c.getKey(), d.getKey());

            graph_algorithms algo = new Graph_Algo();
            algo.init(g);
           List<node_data> l= algo.shortestPath(a.getKey(), d.getKey());
for(node_data i:l){
    System.out.println(i.getKey());
}
        }

    }