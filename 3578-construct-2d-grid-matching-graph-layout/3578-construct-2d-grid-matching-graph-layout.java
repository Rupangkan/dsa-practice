class Solution {

    class Pair {
        int x;
        int d;

        Pair() {}

        Pair(int i, int y) {
            x = i;
            d = y;
        }
    }

    public int[] bfs(ArrayList<ArrayList<Integer>> graph, int n, int start, int end, int[][] ans, int i) {
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        q.add(new Pair(start, 0));
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        visited[start] = true;
        // ans[i][0] = start;
        int j = 0;
        Pair temp = new Pair();

        while(!q.isEmpty()) {
            Pair p = q.poll();
            // if(p.x == end) temp = new Pair(p.x, p.d + 1);
            for(int point: graph.get(p.x)) {
                if(visited[point] == false) {
                    visited[point] = true;
                    parent[point] = p.x;
                    q.add(new Pair(point, p.d + 1));
             
                }
            }
        }
        int dest = end;
        while(dest != -1) {
            arr.add(dest);
            dest = parent[dest];
        }
        Collections.reverse(arr);
        // for(int k = 0; k<arr.size(); k++) {
        //     ans[0][k] = arr.get(k);
        // }
        int[] intArray = arr.stream().mapToInt(m -> m).toArray();
        return intArray;
    }

    public int[][] constructGridLayout(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            int x = edge[0];
            int y = edge[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        int min = 3;
        int minValue = n + 1;
        List<Integer> corners = new ArrayList<>();
        List<Integer> corners1d = new ArrayList<>();

        for(int i = 0; i<graph.size(); i++) {
            if(graph.get(i).size() < min) {
                min = graph.get(i).size();
                minValue = graph.get(i).get(0);
            }
            if(graph.get(i).size() == 2) corners.add(i);
            if(graph.get(i).size() == 1) corners1d.add(i);
        }

        if(corners1d.size() == 2) {
            int[][] ans = new int[1][n];
            ans[0] = bfs(graph, n, corners1d.get(0), corners1d.get(1), ans, 0);
            return ans;
        }

        // int minVal
        // bfs(graph, n, 0, n-1, new int[1][n], 0);
        // Pair p = new Pair(n, Integer.MAX_VALUE);
        int[][] paths = {
            bfs(graph, n, corners.get(0), corners.get(1), new int[1][n], 0),
            bfs(graph, n, corners.get(0), corners.get(2), new int[1][n], 0),
            bfs(graph, n, corners.get(0), corners.get(3), new int[1][n], 0),
        };
        int minPath = paths[0].length;
        for(int i = 0; i<paths.length; i++) {
            for(int j = 0; j<paths[i].length; j++) {
                System.out.print(paths[i][j] + " ");
            }
            System.out.println();
        }
        int[] minValuePath = paths[0];
        for(int i = 1; i<3; i++) {
            if(paths[i].length <= minPath) {
                minPath = paths[i].length;
                minValuePath = paths[i];
            }
        }
        // System.out.println("Corners: " + corners.size() + " Start: " + corners.get(0) +" Min: " + p.x + " Dist: " + p.d);
        int c = minPath;
        int r = n/c;
        // // int minValue = p.d;
        System.out.println("Row: " + r + " Col: " + c);

        int[][] ans =  new int[r][c];

        ans[0] = minValuePath;

        for(int i = 0; i<r-1; i++) {
            for(int j = 0; j<c; j++) {
                Set<Integer> neighbors = new HashSet<>();
                if(i > 0) neighbors.add(ans[i-1][j]);
                if(j > 0) neighbors.add(ans[i][j-1]);
                if(j + 1 < c) neighbors.add(ans[i][j+1]);

                int curr = ans[i][j];
                for(int point: graph.get(curr)) {
                    if(!neighbors.contains(point)) {
                        ans[i+1][j] = point;
                        break;
                    }
                }
            }
        }
        
        return ans;
        // return new int[0][0];
    }
}