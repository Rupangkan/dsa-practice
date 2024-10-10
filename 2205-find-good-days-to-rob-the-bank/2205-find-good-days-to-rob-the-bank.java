class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] nonInc = new int[n];
        int[] nonDec = new int[n];
        List<Integer> list = new ArrayList<>();

        int count = 0;
        // nonInc[0] = 1;
        for(int i = 1; i<n; i++) {
            if(security[i] <= security[i-1]) {
                count++;
                nonInc[i] = count;
            }
            else {
                count = 0;
                nonInc[i] = count;
            }
        }

        count = 0;
        // nonDec[n-1] = 1;
        for(int i = n-2; i>=0; i--) {
            if(security[i] <= security[i+1]) {
                count++;
                nonDec[i] = count;
            }
            else {
                count = 0;
                nonDec[i] = count;
            }
        }

        System.out.println(Arrays.toString(nonInc));
        System.out.println(Arrays.toString(nonDec));

        for(int i = time; i<n-time; i++) {
            if(nonDec[i] >= time && nonInc[i] >= time) list.add(i);
        }
        return list;
    }
}