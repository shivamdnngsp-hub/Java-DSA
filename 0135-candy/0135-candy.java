class Solution {
    public int candy(int[] ratings) {
     int sum = 1;
     int i = 1;
    while(i<ratings.length){
        if(ratings[i-1] ==ratings[i]){
            sum += 1;
            i++;
            continue;
        }
        int peak = 1;
        while(i<ratings.length && ratings[i-1]<ratings[i]){
            peak++;
            sum += peak;
            i++;
        }
        int down = 1;
        while(i<ratings.length && ratings[i-1]>ratings[i]){
            sum += down;
            down++;
            i++;
        }

     if(down+1>peak){
        sum += down - peak;
     }
    }

return sum;
        
    }
}