class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if( position.length <= 1 ) return position.length;
        double[] timeToTarget = new double[position.length];
        double carsTime;
        int fleet = 1;
        Map<Integer,Double> carsMap = new HashMap<>();
        for( int i = 0 ; i < position.length ; i++ ){
            timeToTarget[i] = (double) (target-position[i])/speed[i];
            carsMap.put(position[i],timeToTarget[i]);
        }
        Arrays.sort(position);
        for (int i = 0; i < position.length / 2; i++) {
            int temp = position[i];
            position[i] = position[position.length - 1 - i];
            position[position.length - 1 - i] = temp;
        }
        carsTime = carsMap.get(position[0]);
        for( int i = 1 ; i < position.length ; i++ ) {
            
            if( carsMap.get(position[i]) > carsTime ){
                fleet++;
                carsTime = carsMap.get(position[i]);
            }
            
        }
        return fleet;
    }
}
