class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
long mod = 1_000_000_007L;
int[] sum = new int[n];
int[] nonZeroCt = new int[n];
long[] prefix = new long[n];

int digitSum = 0;
int count = 0;
long num = 0;

for (int i = 0; i < n; i++) {
    int d = s.charAt(i) - '0';
    digitSum += d;
    sum[i] = digitSum;
    if (d != 0) {
        count++;
    }
    nonZeroCt[i] = count;
    if (d != 0) {
        num = (num * 10 + d)%mod;
    }
    prefix[i] = num;
}


long[] pow = new long[s.length()+ 1];
pow[0] = 1;
for (int i = 1; i <= n; i++) {
    pow[i] = (1L * pow[i - 1] * 10)%mod;
}


        int[] ans = new int[queries.length];
        for(int i = 0;i<queries.length;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int nonZeroCount = nonZeroCt[r] - (l != 0 ? nonZeroCt[l - 1] : 0);
             int sumOfDigits = sum[r] -(l != 0 ? sum[l-1]: 0);
             long number;
            if(l == 0){
                number  = prefix[r];
            }else{
                  number = (prefix[r]- (prefix[l - 1] * pow[nonZeroCount]) % mod + mod) % mod;
            }
            ans[i] = (int)((number * sumOfDigits) % mod);
        }
     return ans;  
    }
}