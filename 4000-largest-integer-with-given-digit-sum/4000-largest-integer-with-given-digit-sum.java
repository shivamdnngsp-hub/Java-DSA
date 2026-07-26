class Solution {
    int dsum(int i){
        int sum = 0;
        while(i>0){
           sum += i%10;
           i /= 10;
        }
        return sum;
    }
    public int largestInteger(int n, int s) {
        if(9*n<s){
            return -1;
        }
        int st = 9;
        for(int i = 1;i<n;i++){
            st  = 9+st*10;
        }
        

        for(int i = st;i>=0;i--){
           int sum = dsum(i);
            if(sum == s){
                return i;
            }
        }

return st;
    }
}