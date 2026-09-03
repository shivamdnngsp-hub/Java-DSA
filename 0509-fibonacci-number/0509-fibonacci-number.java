class Solution {

    public int fib(int n) {
        if(n<=1){
            return n;
        }
        int prev1 = 1;
        int prev2 = 0;
        int curi = 0;
        for(int i =2;i<=n;i++){
            curi = prev1 + prev2;
            prev2 = prev1;
            prev1 = curi;
        }
        return curi;
    }
}