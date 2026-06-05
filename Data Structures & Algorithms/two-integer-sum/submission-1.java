class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> numsMap = new HashMap<>();
        Integer index;
        for( int i = 0 ; i < nums.length ; i++ ){
            index = numsMap.get(target-nums[i]);
            if( index != null ){
                result[0] = Integer.min(i,index);
                result[1] = Integer.max(i,index);
                break;
            }
            numsMap.put(nums[i],i);
        }
        return result;  
    }
}
