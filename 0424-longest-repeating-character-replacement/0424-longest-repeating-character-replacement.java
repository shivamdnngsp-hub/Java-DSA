class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> mpp = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxFreq = 0;
        int max = 0;
        while (j < s.length() && i<=j) {
            mpp.put(s.charAt(j), mpp.getOrDefault(s.charAt(j), 0) + 1);
            maxFreq = Math.max(maxFreq, mpp.get(s.charAt(j)));

            while ((j - i + 1) - maxFreq > k) {
                mpp.put(s.charAt(i), mpp.get(s.charAt(i)) - 1);
                if (mpp.get(s.charAt(i)) == 0) {
                    mpp.remove(s.charAt(i));
                }
                i++;
            }

            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}