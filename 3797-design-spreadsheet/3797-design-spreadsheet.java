class Spreadsheet {
    Map<String,Integer> mp=new HashMap<>();
    public Spreadsheet(int r){}
    public void setCell(String c,int v){
        mp.put(c,v);
    }
    public void resetCell(String c){
        mp.put(c,0);
    }
    public int getValue(String f){
        f=f.substring(1);
        for(int i=0;i<f.length();i++){
            if(f.charAt(i)=='+'){
                String a=f.substring(0,i),b=f.substring(i+1);
                int x=Character.isUpperCase(a.charAt(0))?mp.getOrDefault(a,0):Integer.parseInt(a);
                int y=Character.isUpperCase(b.charAt(0))?mp.getOrDefault(b,0):Integer.parseInt(b);
                return x+y;
            }
        }
        return 0;
    }
}


/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */