class Solution {
    public int maxScore(int[] cardPoints, int k) {
     int sum = 0;
     int max = 0;
     for(int i = 0;i<k;i++){
        sum  += cardPoints[i];
     }
     max = sum;
      int rightPointer = cardPoints.length-1;
     for(int i = k-1;i>=0;i--){
        sum = sum - cardPoints[i] + cardPoints[rightPointer];
        max = Math.max(sum,max);
        rightPointer--;
     }


return max;

    }
}