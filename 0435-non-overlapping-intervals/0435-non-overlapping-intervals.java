class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> l = new ArrayList<>();
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        for(int [] interval : intervals){
            if(l.isEmpty() || l.get(l.size()-1)[1] <= interval[0]){
                l.add(interval);
            }else{
                l.get(l.size()-1)[1] = Math.min(interval[1], l.get(l.size()-1)[1]);
            }
        }

        return intervals.length - l.size();
        
    }
}