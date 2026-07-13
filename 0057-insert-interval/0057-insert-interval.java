class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> l = new ArrayList<>();
        if(newInterval.length == 0){
           return intervals;
        }
        if(intervals.length == 0){
            return new int[][] {newInterval};
        }



        boolean used = false;
        //  if(newInterval[0]<= intervals[0][0]){
        //     l.add(newInterval);
        //     used = true;
        //  }

         int i = 0;
         while(i<intervals.length){
                if(!used){
                    if(newInterval[1]<intervals[i][0]){
                        used = true;
                        l.add(newInterval);
                    }

                   else if(newInterval[0]<= intervals[i][1]){
                    intervals[i][1] = Math.max(intervals[i][1],newInterval[1]);
                    intervals[i][0] = Math.min(intervals[i][0],newInterval[0]);
                    used = true;
                    l.add(intervals[i]);
                    
                   }




                }
                
                    if(l.isEmpty() || l.get(l.size()-1)[1]< intervals[i][0]){
                        l.add(intervals[i]);
                    }else{
                        l.get(l.size()-1)[1] = Math.max(l.get(l.size()-1)[1] , intervals[i][1]);
                    }
                

            i++;
         }
if(!used){
    l.add(newInterval);
}
         
         return l.toArray(new int[l.size()][]);

        
    }
}