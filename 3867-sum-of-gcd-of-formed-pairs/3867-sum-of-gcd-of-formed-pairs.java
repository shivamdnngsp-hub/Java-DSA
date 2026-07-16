class Solution {

  long gcd(long a,long b){
    while(b != 0){
        long temp = b;
       b = a%b;
       a = temp;
    }
    return a;
  }



    public long gcdSum(int[] nums) {

     long[] arr = new long[nums.length];

      int max = Integer.MIN_VALUE;

     for(int k = 0;k<nums.length;k++){
        max = Math.max(max,nums[k]);
        arr[k] = gcd((long)nums[k],(long)max);
     }

        Arrays.sort(arr);
        int i = 0;
        int j = nums.length-1;
        long sum = 0;
        while(i<j){
            sum += (long)gcd(arr[i],arr[j]);
            i++;
            j--;
        }
        return sum;
    }
}