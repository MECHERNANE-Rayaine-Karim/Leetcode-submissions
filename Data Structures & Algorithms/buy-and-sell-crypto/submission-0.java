class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int previousBuyingPrice = prices[0];
        for( int sellingDay = 1 ; sellingDay < prices.length ; sellingDay++ ) {
            int buyingPrice = minPrice(prices ,sellingDay, previousBuyingPrice);
            previousBuyingPrice = buyingPrice;
            maxProfit = Integer.max(maxProfit,prices[sellingDay] - buyingPrice);   
        }
        return maxProfit;
    }

    public int minPrice(int[] prices , int sellingDay, int previousMinPrice ){
        if( prices[sellingDay-1] < previousMinPrice ) return prices[sellingDay-1];
        return previousMinPrice;
    }
}