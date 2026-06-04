class Solution {
    public boolean isAnagram(String s, String t) {
         if( s.length() == t.length() ) {
            Map<Character,Integer> charactersMaps = new HashMap<>();
            Map<Character,Integer> charactersMapt = new HashMap<>();
            int count = 0;
            for( int i = 0 ; i < s.length() ; i++ ){
                count = charactersMaps.getOrDefault(s.charAt(i),0);
                charactersMaps.put(s.charAt(i),count+1);
            }
            
            for( int i = 0 ; i < s.length() ; i++ ){
                count = charactersMapt.getOrDefault(t.charAt(i),0);
                charactersMapt.put(t.charAt(i),count+1);
            }
            return charactersMaps.equals(charactersMapt);
         }
         return false;
    }
    
    
}
