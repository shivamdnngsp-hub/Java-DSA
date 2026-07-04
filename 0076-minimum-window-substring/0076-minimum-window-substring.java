class Solution {
    public String minWindow(String s, String t) {
        int i = 0;
        int j = 0;
        int[] hash = new int[256];

        for (int k = 0; k < t.length(); k++) {
            hash[t.charAt(k)]++;
        }
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        while (j < s.length()) {
            char c = s.charAt(j);
            if (hash[c] > 0) {
                count++;
            }
            hash[c]--;

            while (count == t.length()) {
                if (j - i + 1 < minLength) {
                    minLength = j - i + 1;
                    startIndex = i;
                }

                hash[s.charAt(i)]++;
                if (hash[s.charAt(i)] > 0) {
                    count--;
                }
                i++;
            }

            j++;
        }
        if(minLength == Integer.MAX_VALUE ){
            return "";
        }
     return s.substring(startIndex, startIndex + minLength);

    }
}