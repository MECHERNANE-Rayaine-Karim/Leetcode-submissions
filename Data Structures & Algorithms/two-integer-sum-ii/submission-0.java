class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length -1;
        int sum;
        while( left < right )
        {
            sum = numbers[left] + numbers[right];
            if( sum == target ) break;
            else if( sum < target ) left++;
            else right--;
        }
        result[0] = left+1;
        result[1] = right+1;
        return result;
    }
}
