class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> charactersMap = new HashMap<>();
        for( int i = 0 ; i < s1.length() ; i++ ) {
            charactersMap.put(s1.charAt(i),charactersMap.getOrDefault(s1.charAt(i),0)+1);
        }
        int windowBeginning = 0;
        for( int i = 0 ; i < s2.length() ; i++ ) {
            if( charactersMap.containsKey( s2.charAt(i) ) ){
                charactersMap.put(s2.charAt(i),charactersMap.getOrDefault(s2.charAt(i),0)-1);
                charactersMap.remove(s2.charAt(i),0);
            }
            else{
                charactersMap.put(s2.charAt(windowBeginning),charactersMap.getOrDefault(s2.charAt(windowBeginning),0)+1);
                windowBeginning++;
                while( !charactersMap.containsKey( s2.charAt(i) ) && windowBeginning < s2.length()){
                    charactersMap.put(s2.charAt(windowBeginning),charactersMap.getOrDefault(s2.charAt(windowBeginning),0)+1);
                    windowBeginning++;
                }
                charactersMap.put(s2.charAt(i),charactersMap.getOrDefault(s2.charAt(i),0)-1);
                charactersMap.remove(s2.charAt(i),0);
            }
            if( charactersMap.size() == 0 ) return true;    
        }
        return false;
    }
}