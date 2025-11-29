public class brute {
    static int  maxProduct(int[] arr){
        int maxPro  = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length-1;i++){
            int product = 1;
            for(int j = i; j<arr.length;j++){
                product = product*arr[j];
                maxPro = Integer.max(product,maxPro);
            }
        }

        return maxPro;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        System.out.println(maxProduct(arr));
    }
}
