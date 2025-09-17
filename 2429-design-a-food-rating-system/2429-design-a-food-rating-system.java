class FoodRatings {
    private Map<String,Integer> fr=new HashMap<>();
    private Map<String,String> fc=new HashMap<>();
    private Map<String,TreeSet<Pair<Integer,String>>> cm=new HashMap<>();

    public FoodRatings(String[] f,String[] c,int[] r){
        for(int i=0;i<f.length;i++){
            fr.put(f[i],r[i]);
            fc.put(f[i],c[i]);
            cm.computeIfAbsent(c[i],k->new TreeSet<>((a,b)->a.getKey().equals(b.getKey())?a.getValue().compareTo(b.getValue()):a.getKey()-b.getKey()))
              .add(new Pair(-r[i],f[i]));
        }
    }

    public void changeRating(String food,int nr){
        String c=fc.get(food);
        TreeSet<Pair<Integer,String>> s=cm.get(c);
        s.remove(new Pair(-fr.get(food),food));
        fr.put(food,nr);
        s.add(new Pair(-nr,food));
    }

    public String highestRated(String c){
        return cm.get(c).first().getValue();
    }
}
