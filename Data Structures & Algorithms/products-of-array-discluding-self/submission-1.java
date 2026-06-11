class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answers = new int[nums.length];
        int right = 1;
        int left = 1;
        answers[0] = left;
        for( int i = 1; i < nums.length ; i++ ) {
            left *= nums[i-1];
            answers[i] = left;
        }
        for( int i =  nums.length -2 ; i >= 0 ; i-- ) {
            right *= nums[i+1];
            answers[i] *= right; 
        }
        return answers;
    }


    
}