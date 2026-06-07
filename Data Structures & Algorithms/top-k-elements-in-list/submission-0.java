class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> occurencesMap = new HashMap();
        for( int i = 0 ; i < nums.length ; i++ ) {
            occurencesMap.put(nums[i],occurencesMap.getOrDefault(nums[i],0)+1);
        }
        return  occurencesMap.entrySet()
        .stream()
        .sorted(Map.Entry.<Integer, Integer>comparingByValue()
        .thenComparing(Map.Entry.comparingByKey())
        .reversed()) 
        .mapToInt(Map.Entry::getKey)
        .limit(k)
        .toArray();
    }
}