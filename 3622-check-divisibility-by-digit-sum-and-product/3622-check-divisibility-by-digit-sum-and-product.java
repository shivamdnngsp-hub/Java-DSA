class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int sum = 0;
        int mul = 1;
        while(num>0){
            int ld = num% 10;
            sum += ld;
            mul *= ld;
            num = num/10;
        }
    
return (n%(sum + mul)== 0) ? true : false;

    }
}