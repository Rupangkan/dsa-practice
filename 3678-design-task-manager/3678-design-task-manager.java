class TaskManager {
    private PriorityQueue<int[]> pq;
    private Map<Integer,Integer> pr,own;

    public TaskManager(List<List<Integer>> t){
        pq=new PriorityQueue<>((a,b)->a[0]==b[0]?b[1]-a[1]:b[0]-a[0]);
        pr=new HashMap<>();
        own=new HashMap<>();
        for(List<Integer>x:t) add(x.get(0),x.get(1),x.get(2));
    }

    public void add(int u,int id,int p){
        pq.add(new int[]{p,id});
        pr.put(id,p);
        own.put(id,u);
    }

    public void edit(int id,int np){
        pq.add(new int[]{np,id});
        pr.put(id,np);
    }

    public void rmv(int id){
        pr.put(id,-1);
    }

    public int execTop(){
        while(!pq.isEmpty()){
            int[]x=pq.poll();
            int p=x[0],id=x[1];
            if(pr.getOrDefault(id,-2)==p){
                pr.put(id,-1);
                return own.getOrDefault(id,-1);
            }
        }
        return -1;
    }
}
