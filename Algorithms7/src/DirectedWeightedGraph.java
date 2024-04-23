import java.util.ArrayList;
import java.util.List;


public class DirectedWeightedGraph {

    private static final int INF = Integer.MAX_VALUE;

    public static void printSimplePaths(int[][] graph, int u, int w) {
        List<Integer> path = new ArrayList<>();
        path.add(u);
        dfs(graph, path, u, w, 0);
    }

    private static void dfs(int[][] graph, List<Integer> path, int u, int w, int length) {
        if (length == 5) {
            System.out.println("Path: " + path);
            return;
        }

        if (length >= 5) {
            return;
        }

        for (int v = 0; v < graph.length; v++) {
            if (graph[u][v] != INF) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(v);
                dfs(graph, newPath, v, w, length + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {INF, 1, INF, 1, INF},
                {1, INF, 1, INF, 1},
                {INF, INF, 1, INF, 1},
                {1, INF, 1, INF, INF},
                {INF, INF, INF, 1, INF}
        };

        int u = 0; // Start vertex
        int w = 4; // End vertex

        printSimplePaths(graph, u, w);
    }
}
