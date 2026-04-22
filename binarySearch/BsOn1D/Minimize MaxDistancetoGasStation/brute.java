class Solution {
    public double minimiseMaxDistance(int[] arr, int k) {
        int[] howMany = new int[arr.length - 1];
        for(int gasSt = 0;gasSt<k;gasSt++){
            int maxIndex = -1;double maxValue = -1;
              for(int i = 0;i<arr.length-1;i++){
                double diff = arr[i+1] - arr[i];
                double sectionDis = diff / (howMany[i] + 1);
                if(maxValue <=  sectionDis){
                    maxValue = sectionDis;
                  maxIndex = i;
                }
              }
           howMany[maxIndex]++;
        }

     double maxDiff = -1;
     for(int i = 0;i<arr.length-1;i++){
        double diff = arr[i+1] - arr[i];
        double sectionDis =diff / (howMany[i] + 1);
        if(sectionDis>maxDiff){
            maxDiff = sectionDis;
        }
     }
 


return maxDiff;


    }
}
