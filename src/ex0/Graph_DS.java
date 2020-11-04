package ex0;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Graph_DS implements graph {
    private LinkedHashMap<Integer, node_data> vertexs;
    private int mc;
    private int edgeSize;

    public Graph_DS() {
        vertexs = new LinkedHashMap<Integer, node_data>();
        mc = 0;
        edgeSize = 0;
    }

    public Graph_DS(graph other) {
        this.mc = other.getMC();
        this.edgeSize = other.edgeSize();
        LinkedHashMap<Integer,node_data> gr = new LinkedHashMap<Integer,node_data>();
        for(node_data n :other.getV()){
            gr.put(n.getKey(), n);
        }
        this.vertexs=gr;
    }

    @Override
    public node_data getNode(int key) {
        return vertexs.get(key);
    }

    @Override
    public boolean hasEdge(int node1, int node2)
    {
        return vertexs.get(node1).hasNi(node2);
    }

    @Override
    public void addNode(node_data n)
    {
        vertexs.put(n.getKey(),n);
        mc++;
    }

    @Override
    public void connect(int node1, int node2) {

        if (node1 != node2 && !hasEdge(node1,node2)&& getNode(node1) != null && getNode(node2) != null){
            getNode(node1).addNi(getNode(node2));
        getNode(node2).addNi(getNode(node1));
        mc++;
        edgeSize++;
    }
    }

    @Override
    public Collection<node_data> getV()
    {
        return vertexs.values();
    }

    @Override
    public Collection<node_data> getV(int node_id)
    {
        return getNode(node_id).getNi();
    }

    @Override
    public node_data removeNode(int key)
    {
        if(vertexs.containsValue(getNode(key))== true)
        {
            Iterator<node_data> i = getV(key).iterator();
            while(i.hasNext()){
                i.next().removeNode(getNode(key));
                edgeSize--;
                mc++;
            }
        }
        mc++;
        return vertexs.remove(key);
    }

    @Override
    public void removeEdge(int node1, int node2)
    {
        if (getNode(node1) != null && getNode(node2) != null && hasEdge(node1, node2))
        {
            getNode(node1).removeNode(getNode(node2));
            getNode(node2).removeNode(getNode(node1));
            mc++;
            edgeSize--;
        }
    }
    @Override
    public int nodeSize()

    {
        return vertexs.size();
    }

    @Override
    public int edgeSize()
    {
        return edgeSize;
    }

    @Override
    public int getMC()

    {
        return mc;
    }
}
