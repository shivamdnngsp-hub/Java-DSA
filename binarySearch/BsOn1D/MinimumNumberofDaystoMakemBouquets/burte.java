class Solution {

   public boolean possible(int[] bloomDay, int n,int m,int k){
   
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
return bauquetCount >=m;
   }



    public int minDays(int[] bloomDay, int m, int k) {

        if(m*k > bloomDay.length){
          return -1;
        }
        

        int max = Integer.MIN_VALUE;
        for(int i = 0;i<bloomDay.length;i++){
            if(max <= bloomDay[i]){
                max = bloomDay[i];
            }
        }
     
     for(int i = 1;i<= max;i++){
       if(possible(bloomDay,i,m,k) == true){
        return i;
       }
     }
    return -1;
    }
}
