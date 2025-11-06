class Vertex {
    public int vertexId;
    public boolean offline = false;
    public int powerGridId = -1;
    public Vertex() {}
    public Vertex(int id) { this.vertexId = id; }
}

class Graph {
    private Map<Integer, List<Integer>> adj;
    private Map<Integer, Vertex> vertices;

    public Graph() {
        adj = new HashMap<>();
        vertices = new HashMap<>();
    }

    public void addVertex(int id, Vertex value) {
        vertices.put(id, value);
        adj.put(id, new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public Vertex getVertexValue(int id) { return vertices.get(id); }

    public List<Integer> getConnectedVertices(int id) { return adj.get(id); }
}

class Solution {

    private void traverse(Vertex u, int gridId, PriorityQueue<Integer> grid, Graph g) {
        u.powerGridId = gridId;
        grid.add(u.vertexId);
        for (int vid : g.getConnectedVertices(u.vertexId)) {
            Vertex v = g.getVertexValue(vid);
            if (v.powerGridId == -1) traverse(v, gridId, grid, g);
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        Graph g = new Graph();
        for (int i = 0; i < c; i++) g.addVertex(i + 1, new Vertex(i + 1));
        for (int[] e : connections) g.addEdge(e[0], e[1]);

        List<PriorityQueue<Integer>> grids = new ArrayList<>();
        for (int i = 1, id = 0; i <= c; i++) {
            Vertex v = g.getVertexValue(i);
            if (v.powerGridId == -1) {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                traverse(v, id, pq, g);
                grids.add(pq);
                id++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int op = q[0], x = q[1];
            if (op == 1) {
                Vertex v = g.getVertexValue(x);
                if (!v.offline) ans.add(x);
                else {
                    PriorityQueue<Integer> pq = grids.get(v.powerGridId);
                    while (!pq.isEmpty() && g.getVertexValue(pq.peek()).offline) pq.poll();
                    ans.add(pq.isEmpty() ? -1 : pq.peek());
                }
            } else g.getVertexValue(x).offline = true;
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
