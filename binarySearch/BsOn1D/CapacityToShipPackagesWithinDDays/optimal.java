class Solution {
 
    public int countDays(int[] weights, int w) {
        int days = 1;
        int load = 0;

        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > w) {
                days++;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
     
        int minWeight = Integer.MIN_VALUE;
        for (int i = 0; i < weights.length; i++) {
            minWeight = Math.max(minWeight, weights[i]);
        }

        int maxWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            maxWeight += weights[i];
        }
   
       int ans = maxWeight;
       int low = minWeight;
       int high = maxWeight;
       while(low<= high){
       int mid = low + (high-low)/2;
       int countDays = countDays(weights,mid);

       if(countDays<= days){
        ans = mid;
        high = mid - 1;
       }else{
        low = mid +1;
       }



       }

        return ans;
    }
}
