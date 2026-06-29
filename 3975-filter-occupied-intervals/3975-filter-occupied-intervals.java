class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        Arrays.sort(occupiedIntervals, ((a, b) -> Integer.compare(a[0], b[0])));
        List<int[]> l = new ArrayList<>();

        for (int[] interval : occupiedIntervals) {
            if (l.isEmpty() || l.get(l.size() - 1)[1] + 1 < interval[0]) {
                l.add(interval);
            } else {
                l.get(l.size() - 1)[1] = Math.max(l.get(l.size() - 1)[1], interval[1]);
            }
        }
        List<int[]> l2 = new ArrayList<>();
        
        for(int[] interval : l){
            int[] arr = new int[2];
            if(freeStart<=  interval[0] && freeEnd >= interval[1]){
                continue;
            }else if(freeStart <= interval[0] && freeEnd < interval[1] && freeEnd >= interval[0]){
                arr[0] = freeEnd +1;
                arr[1] = interval[1];
                l2.add(arr);
            }else if(freeStart> interval[0] && freeEnd >= interval[1] && freeStart<= interval[1]){
                 arr[0] = interval[0];
                arr[1] = freeStart-1;
                l2.add(arr);
            }else if(freeStart > interval[0] && freeEnd < interval[1]){
                int[] arr1 = {interval[0],freeStart-1};
                int[] arr2 = {freeEnd +1,interval[1]};
                l2.add(arr1);
                l2.add(arr2);
            }else{
                arr[0] = interval[0];
                arr[1] = interval[1];
                l2.add(arr);
            }
        }


        List<List<Integer>> ans = new ArrayList<>();

        for (int[] arr : l2) {
            List<Integer> list = new ArrayList<>();
            for (int num : arr) {
                list.add(num);
            }
            ans.add(list);
        }
        return ans;

    }
}