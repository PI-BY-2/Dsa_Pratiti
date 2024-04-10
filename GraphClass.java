import java.util.ArrayList;

import org.w3c.dom.Node;


class GraphClass {
    public static void main(String[] args) {
    
        Graph graph = new Graph(5);

        graph.print();
    }

    private Graph graph = new Graph(5);

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
    
}
class Graph{
	ArrayList<Node> nodes = new ArrayList<Node>();
	int[][] matrix;
	
	Graph(int size){
        matrix = new int[size][size];
    }
	
	void addNode(Node node) {
        nodes.add(node);
    }

    void addEdge(Node node1, Node node2) {
        int index1 = nodes.indexOf(node1);
        int index2 = nodes.indexOf(node2);
        matrix[index1][index2] = 1;
        matrix[index2][index1] = 1;
    }

    public Boolean chkEdge(Node node1, Node node2) {
        int index1 = nodes.indexOf(node1);
        int index2 = nodes.indexOf(node2);
        return matrix[index1][index2] == 1;
    }

    public void print(){
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.size(); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}