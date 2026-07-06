class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
     Arrays.sort(intervals, (a, b) -> {
    if (a[0] == b[0]) {
        return Integer.compare(b[1], a[1]); 
    }
    return Integer.compare(a[0], b[0]);
});


      if(intervals.length ==1){
        return 1;
      }
      int prevStart = intervals[0][0];
      int prevEnd = intervals[0][1];
      int count = 1;
    
      for(int i = 1;i<intervals.length;i++){
          if(prevStart<=intervals[i][0] && prevEnd>=intervals[i][1]){
          }else{
            prevStart = intervals[i][0];
            prevEnd = intervals[i][1];
            count++;
          }
      }
        return count;
        
    }
}