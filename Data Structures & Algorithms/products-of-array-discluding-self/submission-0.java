class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answers = new int[nums.length];
        int[] rightProducts = new int[nums.length];
        int right = 1;
        int left = 1;
        rightProducts[nums.length-1] = right;
        for( int i = nums.length-2 ; i >= 0 ; i-- ){
            right *= nums[i+1];
            rightProducts[i] = right;
        }
        answers[0] = left*rightProducts[0];
        for( int i = 1 ; i < nums.length; i++ ) {
            left *= nums[i-1];
            answers[i] = left*rightProducts[i];
        }
        return answers;
    }


    
}
