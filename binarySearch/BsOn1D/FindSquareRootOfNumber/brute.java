public class random {
    static int squareRoot(int x) {

int ans = 1;
        for(int i =1;i<= x;i++){
            if(i*i<=x){
                ans = i;
            }
            else break;
        }
        return ans;
    }

    public static void main(String[] args) {
       int x = 36;
        System.out.println(squareRoot((x)));
    }
}
