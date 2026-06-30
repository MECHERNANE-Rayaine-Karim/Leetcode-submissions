class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length() ) return "";
        Map<Character,Integer> charachtersMap = new HashMap<>();
        Map<Character,Integer> answerMap = new HashMap<>();
        String finalAnswer = new String("");
        int need = t.length();
        int have = 0;
        int startedAt = 0;
        int occur = 0;
        for( int i = 0 ; i < t.length() ; i++ ) {
            charachtersMap.put(t.charAt(i),charachtersMap.getOrDefault(t.charAt(i),0)+1);
        }
        
        int left = 0;
        int bestLeft = 0;
        int bestLength = 0;
        int length = 0;
        System.out.println(need);
        for( int right = 0 ; right < s.length() ; right++ ) {
            length++;
            if( charachtersMap.containsKey(s.charAt(right)) ) {
                occur = answerMap.getOrDefault(s.charAt(right),0);
                answerMap.put(s.charAt(right),occur+1);
                if( occur < charachtersMap.getOrDefault(s.charAt(right),0) ) have++;
                if( have == need  ){
                    
                    if( length <= bestLength || bestLength == 0 ) {
                        bestLeft = left;
                        bestLength = length;
                        if( bestLength == t.length() ) return s.substring(bestLeft,bestLeft+bestLength);
                    }
                    while( left <= right ) {
                        if(charachtersMap.containsKey(s.charAt(left))) {
                            occur = answerMap.getOrDefault(s.charAt(left),0);
                            answerMap.put(s.charAt(left),occur-1);
                            if( occur-1 >= charachtersMap.getOrDefault(s.charAt(left),0) ) {
                                left++;
                                length--;
                            }
                            else {
                                left++;
                                length--;
                                have--;
                                break;
                            }
                            if( length <= bestLength || bestLength == 0 ) {
                                bestLeft = left;
                                bestLength = length;
                                if( bestLength == t.length() ) return s.substring(bestLeft,bestLeft+bestLength);
                            } 
                        }
                        else {
                            left++;
                            length--;
                            if( length <= bestLength || bestLength == 0 ) {
                                bestLeft = left;
                                bestLength = length;
                                if( bestLength == t.length() ) return s.substring(bestLeft,bestLeft+bestLength);
                            }
                        }
                    }
                }
            }
        }

        return s.substring(bestLeft,bestLeft+bestLength);
    }

}


