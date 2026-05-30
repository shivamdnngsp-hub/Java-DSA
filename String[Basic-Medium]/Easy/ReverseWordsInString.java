class Solution {

    public String word(String s, int start,int end) {
        StringBuilder sb = new StringBuilder();
    for(int i = start;i<= end;i++){
       sb.append(s.charAt(i));
    }
    return sb.toString();
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0)
                break;
            int j = i;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }

            sb.append(word(s,j+1,i));
            sb.append(" ");
            i = j;
        }

        return sb.toString().trim();
    }
}
