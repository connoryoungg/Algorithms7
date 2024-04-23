public class DirectedGraphChecker {

    public static boolean isDirectedGraph(int[][] matrix) {
        int n = matrix.length;

        // Check if the matrix is square
        for (int[] row : matrix) {
            if (row.length != n) {
                return false;
            }
        }

        // Check if each element is either 0 or 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0 && matrix[i][j] != 1) {
                    return false;
                }
            }
        }

        // Check if there are no self-loops
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] != 0) {
                return false;
            }
        }

        // Check if the graph is directed
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 0, 0},
                {1, 1, 1}
        };

        if (isDirectedGraph(matrix)) {
            System.out.println("The matrix represents a directed graph.");
        } else {
            System.out.println("The matrix does not represent a directed graph.");
        }
    }
}

