class Solution {


    public String smallestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }

         if(s.length()%2 == 0){
            char[] c1 = s.substring(0,s.length()/2).toCharArray();
            Arrays.sort(c1);
            StringBuilder sb  = new StringBuilder();
            for(char c : c1){
                sb.append(c);
            }
            for(int i = c1.length-1;i>=0;i--){
                sb.append(c1[i]);
            }
            return sb.toString();
         }

         char middle = s.charAt(s.length()/2);
         
         char[] ch1 = s.substring(0,s.length()/2).toCharArray();
         Arrays.sort(ch1);
          StringBuilder sbh = new StringBuilder();
          for(char c: ch1){
                sbh.append(c);
            }
            sbh.append(middle);

             for(int i = ch1.length-1;i>=0;i--){
                sbh.append(ch1[i]);
            }

return sbh.toString();
    }
}