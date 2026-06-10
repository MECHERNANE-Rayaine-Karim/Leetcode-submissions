class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for( String str : strs ) {
            encodedString.append( str.length() + "/" + str );
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrs = new ArrayList<>();
        String string = new String();
        int i = 0;
        int stringFinalChar;
        int slashIndex;
        int stringSize;
        while ( i < str.length() ) {
            slashIndex = str.indexOf('/',i);
            stringSize = Integer.parseInt(str.substring(i,slashIndex));
            i = slashIndex + 1;
            stringFinalChar = stringSize  + slashIndex;
            string = str.substring(i,stringFinalChar+1);
            i = stringFinalChar + 1;
            decodedStrs.add(string);
        }
        return decodedStrs;
    }
}
