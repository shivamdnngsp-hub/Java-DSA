class Solution {
    public int missingInteger(int[] nums) {
        
        int i = 0;
        int num = nums[0];
        int sum = 0;
        while(i<nums.length){
         if((num+ i) == nums[i]){
            sum += nums[i];
            i++;
         }else{
            break;
         }
        }

        List<Integer> l = new ArrayList<>();
        for(int k = 0;k<nums.length;k++){
            l.add(nums[k]);
        }

        while(i<nums.length){
            if(!l.contains(sum)){
                return sum;
            }else{
                sum++;
            }
            i++;
        }
return l.contains(sum) ? sum +1 : sum;
        
    }
}