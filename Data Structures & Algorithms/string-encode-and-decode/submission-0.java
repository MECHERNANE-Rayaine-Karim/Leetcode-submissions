class Solution {

    public String encode(List<String> strs) {
        String encodedString = new String();
        for( String str : strs ){
            encodedString += str+".";
        }
        return encodedString;
    }

    public List<String> decode(String str) {
        char[] characters = str.toCharArray();
        List<String> decodedStrs = new ArrayList<>();
        String string = new String();
        for(int i = 0 ; i < characters.length ; i++ ){
            if( characters[i] == '.' ) {
                decodedStrs.add(string);
                string = new String();
            }
            else {
                string += characters[i];
            }
        }

        return decodedStrs;


    }
}
