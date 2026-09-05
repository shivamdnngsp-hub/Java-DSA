class Solution {

    boolean helper(int index, int jump, int[] stones, HashMap<Integer, Integer> map, Boolean[][]dp){
        if (index == stones.length-1) {
            return true;
        }
        if(jump > stones.length) return false;
        if (dp[index][jump] != null) {
            return dp[index][jump];
        }
        for (int i = -1; i <= 1; i++) {
            int nextJump = jump + i;
            if (nextJump <= 0) {
                continue;
            }
            int nextPos = stones[index] + nextJump;
            if (map.containsKey(nextPos)) {
                int nextIndex = map.get(nextPos);
                if (helper(nextIndex, nextJump, stones, map, dp)) {
                    return dp[index][jump] = true;
                }
            }
        }
        return dp[index][jump] = false;
    }

    public boolean canCross(int[] stones) {
        int n = stones.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        Boolean[][] dp = new Boolean[n][n];
        return helper(0, 0, stones, map, dp);
    }
}