class Solution {
    public int minimumPushes(String word) {
        int count = 0;
        int add = 1;
        int min = 0;
       for(int i = 0;i<word.length();i++){
           if(count == 8){
              add++;
              count = 0;
         
           }
           count++;
           min += add;
       }

return min;

    }
}