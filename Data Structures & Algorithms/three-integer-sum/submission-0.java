class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> resultList = new ArrayList<>();
        for( int i = 0 ; i < length-2 ; i++ ){
            if( i > 0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = length-1;
            while( left < right ) {
                int sum = nums[i] + nums[left] + nums[right];
                if( sum == 0 ) {
                    List<Integer> combinationList = new ArrayList<>();
                    combinationList.add(nums[i]);
                    combinationList.add(nums[left]);
                    combinationList.add(nums[right]);
                    resultList.add(combinationList);
                    left++;
                    while( nums[left-1] == nums[left] && left < right ) left++;
                    right--;
                    while( nums[right] == nums[right+1] && left < right ) right--;
                }
                else if( sum < 0 ) left++;
                else right--;
            
            }
        }  
        return resultList; 
    }
}