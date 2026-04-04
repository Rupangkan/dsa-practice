class Solution {

    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;

        int len = encodedText.length();
        int cols = len / rows;

        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < cols; i++) {
            int r = 0, c = i;
            while (r < rows && c < cols) {
                sb.append(encodedText.charAt(r * cols + c));
                r++;
                c++;
            }
        }

        int k = sb.length() - 1;
        while (k >= 0 && sb.charAt(k) == ' ') k--;

        return sb.substring(0, k + 1);
    }
}