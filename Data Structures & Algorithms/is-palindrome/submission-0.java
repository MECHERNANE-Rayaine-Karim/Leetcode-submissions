class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        int right = s.length()-1;
        int left = 0;
        for( ; left <= right ; left++ , right-- ) {
            if( s.charAt(left) != s.charAt(right) ) return false;
        }
        return true;
    }
}
