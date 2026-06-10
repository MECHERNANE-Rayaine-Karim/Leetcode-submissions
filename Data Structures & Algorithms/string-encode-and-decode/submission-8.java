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
        List<String> decodedStrs = new ArrayList<>();
        String string = new String();
        int i = 0;
        int stringFinalChar;
        int slashIndex;
        int stringSize;
        while ( i < str.length() ){
            string = new String();
            slashIndex = str.indexOf('/',i);
            stringSize = Integer.parseInt(str.substring(i,slashIndex));
            i = slashIndex + 1;
            stringFinalChar = stringSize  + slashIndex;
            for( ; i <= stringFinalChar ; i++ ) {
                    string += str.charAt(i);
            }
            decodedStrs.add(string);
        }

        return decodedStrs;
    }
}
