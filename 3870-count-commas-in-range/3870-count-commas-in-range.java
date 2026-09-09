class Solution {
    int digit(int n){
    int count = 0;
       while(n>0){
        n = n/10;
        count++;
       }
       return count;
    }

    public int countCommas(int n) {
        int count = 0;
        for(int i = 1000;i<=n;i++){
            count += (digit(i)-1)/3;
        }
        return count;
    }
}