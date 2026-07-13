class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> l = new ArrayList<>();
         
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
         l.add(intervals[i]);
         i++;
        }

        while(i<intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        l.add(newInterval);
        
        while(i<intervals.length){
          l.add(intervals[i]);
          i++;
        }

       
 return l.toArray(new int[l.size()][]);
        
    }
}