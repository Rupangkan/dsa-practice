class Solution {
    public int maxFrequencyElements(int[] a) {
        int[] f=new int[100];
        for(int x:a)f[x-1]++;
        Arrays.sort(f);
        int i=99,res=f[99];
        while(i>0&&f[i]==f[i-1])res+=f[i--];
        return res;
    }
}
