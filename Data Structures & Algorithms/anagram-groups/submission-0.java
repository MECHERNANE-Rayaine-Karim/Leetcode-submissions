class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> angramsMap = new HashMap<>();
        for( String str : strs ){
            char[] sortedCharacters = str.toCharArray();
            Arrays.sort(sortedCharacters);
            String sortedString  = new String(sortedCharacters);
            angramsMap.computeIfAbsent(sortedString,k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(angramsMap.values());
    }
}