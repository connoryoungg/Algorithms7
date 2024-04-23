import org.graphstream.graph.*;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
//import static java.lang.Integer.parseInt;

public class GraphBuilder {
    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");

        String input = "[(V,2),(X,3),(A,4),(E,1),(T,4)]";
        Graph graph = buildGraph(input);

        graph.display();

    }

    public static Graph buildGraph(String s) {
        Graph graph = new MultiGraph("My Graph");
        String[] sarray = s.split("[\\W]+");
        String[] names = new String[sarray.length/2];
        int[] numbers = new int[sarray.length/2];
        String[] edges = new String[sarray.length/2];

        // number array
        for(int i = 1; i <= sarray.length; i++) {
            if(i % 2 == 0) {
                numbers[(i/2) - 1] = Integer.parseInt(sarray[i]);
            }
        }
        // node names array
        for(int i = 1; i < sarray.length; i++) {
            if(i % 2 == 1) {
                names[(i/2)] = sarray[i];
            }
        }
        // edges array
        for(int i = 0; i < numbers.length; i++) {
                edges[i] = names[i] + names[(i + numbers[i]) % numbers.length];
        }

        for(int i = 0; i < names.length; i++) {
                graph.addNode(names[i]);
        }

        for(int i = 0; i < edges.length; i++) {
            String s1 = String.valueOf(edges[i].charAt(0));
            String s2 = String.valueOf(edges[i].charAt(1));
            if(s1.equals(s2)) {
                continue;
            }

            Node node1 = graph.getNode(s1);
            Node node2 = graph.getNode(s2);
            //if(node1.hasEdgeBetween(node2)) {
            //    continue;
            //}
            graph.addEdge(edges[i], node1, node2);
        }

        return graph;
    }

    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + "\n");
        }
    }

}
