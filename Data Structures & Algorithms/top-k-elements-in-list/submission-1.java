class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> occurencesMap = new HashMap();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (key1, key2) -> occurencesMap.get(key1) - occurencesMap.get(key2)
        );
        for( int i = 0 ; i < nums.length ; i++ ) {
            occurencesMap.put(nums[i],occurencesMap.getOrDefault(nums[i],0)+1);
        }
        for( Map.Entry<Integer,Integer> entry : occurencesMap.entrySet() ) {
            if( minHeap.size() < k ) {
                minHeap.add(entry.getKey());
            } 
            else{
                if( entry.getValue() > occurencesMap.get(minHeap.peek()) ) {
                    minHeap.poll();
                    minHeap.add(entry.getKey());
                }
            } 
            
        }
        return minHeap.stream().mapToInt(Integer::intValue).toArray();
        
    }
}