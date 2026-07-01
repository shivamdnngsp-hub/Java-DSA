class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> freq = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while(j< fruits.length){
            freq.put(fruits[j],freq.getOrDefault(fruits[j],0) +1);
            while(freq.size()>2 && i< fruits.length){
                freq.put(fruits[i],freq.get(fruits[i])-1);
                if(freq.get(fruits[i]) == 0){
                    freq.remove(fruits[i]);
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
               j++;
        }

     return max;
    }
}