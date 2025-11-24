package arrays.LargestSumArrySum0;

public class brute {
static int maxLen(int[] arr){
int maxLen  =0;
for(int i = 0;i< arr.length;i++){
    int sum = 0;
    for(int j = i;j< arr.length;j++){
        sum = sum + arr[j];
        if(sum == 0){
            if(maxLen < j-i+1){
                maxLen =j-i+1;
            }
        }
    }
}
    return maxLen;
}

    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLen(arr));
    }

}
