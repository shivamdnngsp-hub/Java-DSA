class Solution {
    double digitp(int n){
        double product = 1;
        while(n> 0){
            int ld = n%10;
            product  = product * ld;
            n  = n/10;
        }
        return product;
    }




    public int smallestNumber(int n, int t) {
        int number = n;
        while(digitp(number)%t != 0){
            number++;
        }
        return number;
    }
}