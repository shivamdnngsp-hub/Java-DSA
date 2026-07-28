class Solution {
    public String smallestPalindrome(String s) {
    
    int[] arr = new int[26];
    for(int i = 0;i<s.length();i++){
        arr[s.charAt(i)-'a']++;
    }

    StringBuilder sb = new StringBuilder();
    char extra = '#';
    for(int i = 0;i<26;i++){
        if(arr[i] == 0) continue;
        else if(arr[i]%2 == 0){
            for(int j = 1;j<=arr[i]/2;j++){
                sb.append((char)('a' + i));
            }
        }else{
             extra = (char)('a' + i);
            for(int j = 1;j<=(arr[i]-1)/2;j++){
                sb.append((char)('a' + i));
            }
        }
    }

    int l = sb.length();
    if(extra != '#'){
       sb.append(extra);
    }

    for(int i = l-1; i>= 0;i--){
        sb.append(sb.charAt(i));
    }

return sb.toString();

    }
}