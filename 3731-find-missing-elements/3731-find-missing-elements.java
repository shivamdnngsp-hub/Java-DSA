class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> l = new ArrayList<>();
         int smallest = nums[0];
         int largest = nums[nums.length -1];
        int i = smallest;
        int j = 0;
        while(j<nums.length){
            if(nums[j] !=i){
                l.add(i);
             i++;
            }else{
               i++;
            j++;
            }
            
        }
        return l;
    }
}