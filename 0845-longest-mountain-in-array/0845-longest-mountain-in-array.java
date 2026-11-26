// do LIS first
class Solution {
    public int longestMountain(int[] arr) {
       int dp1[] = new int[arr.length];
       int dp2[] = new int[arr.length];

       for(int i = 0;i<arr.length;i++){
        dp1[i] = 1;
        if(i >0 && arr[i]>arr[i-1]){
            dp1[i] = 1 + dp1[i-1];
        }
       }

       for(int i = arr.length-1;i>=0;i--){
          dp2[i]= 1;
            if( i < arr.length-1 && arr[i]>arr[i+1]){
                dp2[i] = dp2[i+1] + 1;
        }
       }

    //eg  arr = {1,11,2,10,4,5,2,1}
    //    dp1 = {1,2 ,2,3,3,4,2,1};
    //    dp2 = {1,5 ,2,4,3,3,2,1};
    // so let say if i take 10 from arr as peak including 10 max inc length is 3 and max inc 
    // from other side including 10 is 4... 10 is xounted 2 times so max bionic length id 10 is 
    // peak is 3 + 4 -1 = 7
    int max  = 0;
    for(int i = 0;i<arr.length;i++){
        if(dp1[i]>1 && dp2[i]>1){// as if i index is peak there should elemts on both left and right side
          max = Math.max(max,dp1[i] + dp2[i] -1);
        }
        
    }
   
        return max;
    }
}