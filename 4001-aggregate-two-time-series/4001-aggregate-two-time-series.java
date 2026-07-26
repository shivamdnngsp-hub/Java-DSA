class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        int i = 0;
        int j = 0;
        List<int []> l = new ArrayList<>();
        while(i<series1.length && j<series2.length){
            if(series1[i][0] == series2[j][0]){
                  l.add(new int[]{series1[i][0], series1[i][1] + series2[j][1]});
                  i++;
                  j++;
            }
            else if(series1[i][0]< series2[j][0]){
                l.add(new int[] {series1[i][0], series1[i][1] + series2[j][1]});
                i++;
            }else{
                l.add(new int[] {series2[j][0], series1[i][1] + series2[j][1]});
                j++;
            }

        }

        while(i<series1.length){
            l.add(series1[i]);
            i++;
        }

         while(j<series2.length){
            l.add(series2[j]);
            j++;
        }


    List<List<Integer>> ans= new ArrayList<>();
    for(int[] arr : l){
        List<Integer> temp = new ArrayList<>();
        for(int x : arr){
            temp.add(x);
        }
        ans.add(temp);
    }


return ans;
    }
}