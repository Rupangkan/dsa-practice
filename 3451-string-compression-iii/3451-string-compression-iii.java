class Solution {
    public String compressedString(String word) {
        int n = word.length(), count = 1;
        String str = "";

        for(int i = 0; i<n; i++) {
            if(count == 9) {
                str += count;
                str += word.charAt(i);
                count = 1;
            } else {
                if(i+1 < n && word.charAt(i) == word.charAt(i+1)) {
                    count++;
                } else {
                    str += count;
                    str += word.charAt(i);
                    count = 1;
                }
            }
        }
        return str;
    }
}