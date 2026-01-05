public class random {
    static int squareRoot(int n, int m) {


int low = 1;
int high = m;

while(low<=high){

int mid = low + (high-low)/2;
int midNthPower = 1;

for(int i = 1;i<=n;i++){
    midNthPower = midNthPower *mid;
}

if(midNthPower ==m ){
    return mid;
}
else if(midNthPower >m){
    high = mid-1;
}
else low = mid+1;

}

        return -1;
    }

    public static void main(String[] args) {
       int m= 27;
       int n = 3;
        System.out.println(squareRoot(n,m));
    }
}
