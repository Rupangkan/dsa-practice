class Solution {

    static class Node {
        int r;
        int c;
        int[][] board;
        int steps;

        Node(int a, int b, int[][] board, int s) {
            r = a;
            c = b;
            this.board = deepCopy(board);
            steps = s;
        }
    }

    static void swap(int[][] board, int x1, int y1, int x2, int y2) {
        int temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    static int[][] deepCopy(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            copy[i] = board[i].clone();
        }
        return copy;
    }

    int solve(int r, int c, int n, int m, int[][] board) {
        int[] dr = {0, 1, -1, 0};
        int[] dc = {1, 0, 0, -1};

        int[][] target = {{1, 2, 3}, {4, 5, 0}};

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c, board, 0));
        Set<String> visited = new HashSet<>();
        visited.add(Arrays.deepToString(board));

        while(!q.isEmpty()) {
            Node curr = q.poll();
            int row = curr.r;
            int col = curr.c;
            int[][] state = curr.board;
            int steps = curr.steps;

            if(Arrays.deepEquals(state, target)) return steps;

            for(int i = 0; i<4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if(newRow >= 0 && newRow < 2 && newCol >= 0 && newCol < 3) {
                    for(int[] arr: state) {
                        System.out.println(Arrays.toString(arr));
                    }
                    int[][] newB = deepCopy(state);
                    swap(newB, row, col, newRow, newCol);
                    String boardStr = Arrays.deepToString(newB);
                    if(!visited.contains(boardStr)) {
                        q.offer(new Node(newRow, newCol, newB, steps + 1));
                        visited.add(boardStr);
                    }
                }
            }
        }
        return -1;
    }

    public int slidingPuzzle(int[][] board) {
        // List<int[][]> ans = new ArrayList<>();
        int n = board.length, m = board[0].length;
        int r = 0, c = 0;

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(board[i][j] == 0) {
                    r = i;
                    c = j;
                    break;
                }
            }
        }
        return solve(r, c, n, m, board);
    }
}