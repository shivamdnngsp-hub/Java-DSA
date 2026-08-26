class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int i = 0;
        int j = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while(j<s.length()){

           if(s.charAt(j) == '1'){
            count++;
           }

            while(count>k && i<=j){
            if(s.charAt(i) == '1'){
                count--;
            }
            i++;
           }
           while (count == k && s.charAt(i) == '0') {
               i++;
              }
          

           if(count == k){
            if(sb.length() == 0){
              sb.append(s.substring(i,j+1));
            }
            else if(s.substring(i,j+1).length() <sb.length()){
                sb.setLength(0);
               sb.append(s.substring(i,j+1));
            }else if(s.substring(i,j+1).length() == sb.length()){
                
                if(s.substring(i,j+1).compareTo(sb.toString())<0){
                   sb.setLength(0);
                    sb.append(s.substring(i,j+1));
                }
            }
           }


           j++;
        }
        return sb.toString();
    }
}