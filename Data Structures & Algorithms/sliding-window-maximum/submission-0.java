class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        if( k == 1 || nums.length < 2) return nums;
        int[] answer = new int[nums.length-k+1];
        deque.addFirst(0);
        for( int i = 1 ; i < k ; i++ ){
            if( nums[i] <= nums[deque.peekLast()] ) {
                deque.addLast(i);
            }
            else{
                while( !deque.isEmpty() && nums[i] > nums[deque.peekLast()] ){
                    deque.removeLast();
                }
                deque.addLast(i);
            }
        }
        answer[0] = nums[deque.peekFirst()];
        
        for( int i = 1 ; i <= nums.length-k ; i++ ){
            helperMethod(i,i+k-1,nums,deque);
            answer[i] = nums[deque.peekFirst()];
        }
        return answer;
    }

    public void helperMethod( int currentIndex , int addedIndex , int[] nums ,Deque<Integer> deque ){
        while( !deque.isEmpty() && deque.peekFirst() < currentIndex ) {
            deque.removeFirst();
        }
        while( !deque.isEmpty() && nums[addedIndex] > nums[deque.peekLast()] ){
            deque.removeLast();
        }
        deque.addLast(addedIndex);
    }
    
}