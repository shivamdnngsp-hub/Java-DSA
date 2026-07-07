class Solution {
    public long sumAndMultiply(int n) {
        long y = 0;
        long num = n;
        while(num>0){
            long ld = num%10;
           if(ld != 0){
               y  = (long)y*10 + ld;
           }
            num = num/10;
        }

        long x = 0;
        num = y;
        while(num>0){
          long ld = num%10;
           if(ld != 0){
               x  = (long)x*10+ ld;
           }
           num = num/10;
        }
         num = x;
        long sum = 0;
        while(num>0){
            long ld = num%10;
            sum += ld;
            num = num/10;
        }


        return  (long)sum*x;
    }
}