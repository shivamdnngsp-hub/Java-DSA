class Solution {

   public long noOfBouqusts(int[] bloomDay, int n,int m,int k){
   
   int Adjcount = 0;
   int bauquetCount = 0;
   for(int i = 0;i<bloomDay.length;i++){
     if(n>=bloomDay[i]){
        Adjcount++;

       if(Adjcount == k){
        bauquetCount++;
        Adjcount= 0;
       }

     }else{
        Adjcount = 0;
     }
   }
return bauquetCount;
   }



    public int minDays(int[] bloomDay, int m, int k) {

        if((long)m*k > bloomDay.length){
          return -1;
        }
        

        int max = Integer.MIN_VALUE;
        for(int i = 0;i<bloomDay.length;i++){
            if(max <= bloomDay[i]){
                max = bloomDay[i];
            }
        }
     int ans = max;
int low = 1;
int high = max;

while(low <= high){
    int mid = low + (high - low) / 2;

    long bouquets = noOfBouqusts(bloomDay, mid, m, k);

    if(bouquets >= m){
        ans = mid;          
        high = mid - 1;    
    } else {
        low = mid + 1;      
    }
}
    


    return ans;
    }
}
