class Solution {
    public boolean isAnagram(String s, String t) {
         if( s.length() == t.length() ) {
            Map<Character,Integer> charactersMap = new HashMap<>();
            for( int i = 0 ; i < t.length() ; i++ ){
                charactersMap.put(s.charAt(i),charactersMap.getOrDefault(s.charAt(i),0)+1);
                charactersMap.put(t.charAt(i),charactersMap.getOrDefault(t.charAt(i),0)-1);
            }
            
            for( int occurences : charactersMap.values()){
                if( occurences != 0 ) return false;
            }
            return true;
         }
         return false;
    }
    
    
}