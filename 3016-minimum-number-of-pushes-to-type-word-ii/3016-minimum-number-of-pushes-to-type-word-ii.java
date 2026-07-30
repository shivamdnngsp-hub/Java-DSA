class Solution {
    public int minimumPushes(String word) {
     int[] arr = new int[26];
      for(char c : word.toCharArray()){
        arr[c - 'a']++;
      }
      Arrays.sort(arr);

      int count = 0;
      int min = 0;
      int add = 1;

      for(int i = arr.length-1;i>=0;i--){
        if(arr[i] == 0) continue;
         if(count == 8){
            add++;
            count = 0;
         }
         count++;
         min += add*arr[i];
      }

      return min;

    }
}