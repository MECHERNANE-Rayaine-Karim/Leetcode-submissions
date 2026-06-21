class Solution {
    public int characterReplacement(String s, int k) {
        int biggestWindow = 1;
        Map<Character,Integer> charactersMap = new HashMap<>();
        int left = 0;
        charactersMap.put(s.charAt(left),1);
        for( int right = 1 ; right < s.length() ; right++ ){
            charactersMap.put(s.charAt(right),charactersMap.getOrDefault(s.charAt(right),0)+1);
            int mostFrequent = Collections.max(charactersMap.values());
            int windowSize = right-left + 1;
            if( windowSize - mostFrequent <= k ) {
                    biggestWindow = Integer.max(biggestWindow,windowSize);
            }
            else {
                charactersMap.put(s.charAt(left),charactersMap.getOrDefault(s.charAt(left),0)-1);
                left++;
            }
        }
        return biggestWindow;

    }

    
}

