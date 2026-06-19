class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        int lenght = 0;
        int maxLenght = 0;
        Map<Character,Integer> charactersMap = new HashMap<>();   
        int left = 0;
        for( int i = 0 ; i < s.length() ; i++ ) {
            if( charactersMap.containsKey(s.charAt(i)) && charactersMap.get(s.charAt(i)) >= left   ) {
                maxLenght = Integer.max(lenght,maxLenght);
                left = charactersMap.get(s.charAt(i))+1;
                lenght = i - left;
            }
            charactersMap.put(s.charAt(i),i);
            lenght++;
            maxLenght = Integer.max(lenght,maxLenght);
        }
        maxLenght = Integer.max(lenght,maxLenght);
        return maxLenght;    
    }

}
