class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int i = 0;
        int j = 0;
        while(j<s.length()){
            char c = s.charAt(j);
            if(c == 'a'){
                aCount++;
            }else if(c == 'b'){
                bCount++;
            }else{
                cCount++;
            }

            while(aCount != 0 && bCount!= 0 && cCount != 0 && i<=j){
                char ch = s.charAt(i);
                count += s.length() -j;
                if(ch == 'a'){
                    aCount--;
                }else if(ch == 'b'){
                bCount--;
               }else{
                cCount--;
               }
               i++;
            }

            j++;
        }

        return count;
    }
}