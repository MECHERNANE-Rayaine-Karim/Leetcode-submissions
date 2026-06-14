class Solution {
    public int longestConsecutive(int[] nums) {
        int maxConsecutiveNumbers = 0;
        Set<Integer> numbersSet = new HashSet<>();
        for( int num : nums ) {
            numbersSet.add(num);
        }
        for( int num : numbersSet ) {
            if( numbersSet.contains(num-1) ) continue;
            int nextNumber = num+1;
            int consecutiveNumbers = 1;
            while(numbersSet.contains(nextNumber)) {
                consecutiveNumbers++;
                nextNumber++;
            }
            maxConsecutiveNumbers = Math.max(consecutiveNumbers,maxConsecutiveNumbers);
        }
        return maxConsecutiveNumbers;
    }
}