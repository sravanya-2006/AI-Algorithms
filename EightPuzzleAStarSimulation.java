import java.util.*;

class Node {
    int[][] state;
    int g, h, f;
    Node parent;
    String move;   // Move taken to reach this node

    Node(int[][] s, int g, Node parent, String move) {
        this.state = s;
        this.g = g;
        this.parent = parent;
        this.move = move;
        this.h = heuristic(s);
        this.f = this.g + this.h;
    }

    // Manhattan Distance Heuristic
    static int heuristic(int[][] s) {
        int dist = 0;
        int[][] goal = {
            {1,2,3},
            {4,5,6},
            {7,8,0}
        };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int val = s[i][j];
                if (val != 0) {
                    for (int r = 0; r < 3; r++) {
                        for (int c = 0; c < 3; c++) {
                            if (goal[r][c] == val) {
                                dist += Math.abs(i - r) + Math.abs(j - c);
                            }
                        }
                    }
                }
            }
        }
        return dist;
    }

    boolean isSame(int[][] s) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (state[i][j] != s[i][j])
                    return false;
        return true;
    }
}

public class EightPuzzleAStarSimulation {

    static int[][] goal = {
        {1,2,3},
        {4,5,6},
        {7,8,0}
    };

    static void printState(int[][] s) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(s[i][j] + " ");
            System.out.println();
        }
    }

    static boolean isGoal(int[][] s) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (s[i][j] != goal[i][j])
                    return false;
        return true;
    }

    static int[] findZero(int[][] s) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (s[i][j] == 0)
                    return new int[]{i, j};
        return null;
    }

    static int[][] copyState(int[][] s) {
        int[][] n = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                n[i][j] = s[i][j];
        return n;
    }

    static boolean contains(List<Node> list, int[][] s) {
        for (Node n : list)
            if (n.isSame(s))
                return true;
        return false;
    }

    // Print Open List
    static void printOpenList(PriorityQueue<Node> open) {
        System.out.println("\nOpen List:");
        for (Node n : open) {
            System.out.println("g=" + n.g + " h=" + n.h + " f=" + n.f);
            printState(n.state);
            System.out.println();
        }
    }

    // Print Closed List
    static void printClosedList(List<Node> closed) {
        System.out.println("\nClosed List:");
        for (Node n : closed) {
            printState(n.state);
            System.out.println();
        }
    }

    // Print solution path
    static void printPath(Node node) {
        if (node == null)
            return;
        printPath(node.parent);
        if (node.move != null)
            System.out.println("Move: " + node.move);
        printState(node.state);
        System.out.println();
    }

    public static void main(String[] args) {

        int[][] start = {
            {1,2,3},
            {4,0,6},
            {7,5,8}
        };

        PriorityQueue<Node> open = new PriorityQueue<>(Comparator.comparingInt(n -> n.f));
        List<Node> closed = new ArrayList<>();

        Node startNode = new Node(start, 0, null, null);
        open.add(startNode);

        while (!open.isEmpty()) {

            Node current = open.poll();

            System.out.println("\n-----------------------------------");
            System.out.println("Expanding Node (g=" + current.g +
                               ", h=" + current.h +
                               ", f=" + current.f + "):");
            printState(current.state);

            if (isGoal(current.state)) {
                System.out.println("\nGoal Reached Successfully!");
                System.out.println("\nFinal Solution Path:\n");
                printPath(current);
                return;
            }

            closed.add(current);

            int[] pos = findZero(current.state);
            int x = pos[0], y = pos[1];

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            String[] moves = {"Up", "Down", "Left", "Right"};

            // Generate children
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {

                    int[][] newState = copyState(current.state);

                    // swap
                    newState[x][y] = newState[nx][ny];
                    newState[nx][ny] = 0;

                    if (!contains(closed, newState)) {
                        Node child = new Node(newState, current.g + 1, current, moves[k]);
                        open.add(child);

                        System.out.println("\nGenerated by Move: " + moves[k]);
                        System.out.println("g=" + child.g + " h=" + child.h + " f=" + child.f);
                        printState(child.state);
                    }
                }
            }

            printOpenList(open);
            printClosedList(closed);
        }

        System.out.println("No solution found.");
    }
}
