class Solution {

    public String encode(List<String> strs) {
        String encodedString = new String();
        int stringSize;
        for( String str : strs ){
            stringSize = str.length();
            encodedString += stringSize+"/" + str;
        }
        return encodedString;
    }

    public List<String> decode(String str) {
        char[] characters = str.toCharArray();
        List<String> decodedStrs = new ArrayList<>();
        String string = new String();
        int i = 0;
        int stringFinalChar;
        int stringSize;
        int power;
        while ( i < characters.length ){
            string = new String();
            power = -1;
            stringSize = 0;
            for( int k = i ; characters[k] != '/'; k++ ) power++;
            for( int g = power ; g >= 0 ; g-- ) {
                stringSize += (characters[i] - '0')*Math.pow(10,g);
                i++;
            }
            //i++;
            stringFinalChar = stringSize  + i;
            i++;
            for( ; i <= stringFinalChar ; i++ ) {
                    string += characters[i];
            }
            decodedStrs.add(string);
        }

        return decodedStrs;
    }
}
