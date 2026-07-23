class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int upperBound = piles[0];
        for( int i = 1 ; i < piles.length ; i++ ){
            if( upperBound < piles[i] ) upperBound = piles[i];
        }
        int lowerBound = 1;
        int possiblePace = 0;
        int minimumPace = upperBound;
        while( lowerBound <= upperBound ){
            int neededHours = 0;
            possiblePace = (lowerBound+upperBound)/2;
            for(  int i = 0 ; i < piles.length ; i++  ) {
                neededHours += (piles[i] + possiblePace - 1) / possiblePace;
                if( neededHours > h ) {
                    lowerBound = possiblePace+1;
                    break;
                }
            }
            if( neededHours <= h ) {
                minimumPace = Integer.min(minimumPace,possiblePace);
                upperBound = possiblePace-1;
            }

        }
        return minimumPace;
    }
}
