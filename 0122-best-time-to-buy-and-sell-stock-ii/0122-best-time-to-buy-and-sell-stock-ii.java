class Solution {
    public int maxProfit(int[] prices) {
        int noStock = 0;
        int hasStock = -prices[0];

        for(int i = 1; i < prices.length; i++){
            int newNoStock = Math.max(noStock, hasStock + prices[i]);
            int newHasStock = Math.max(hasStock, noStock - prices[i]);

            noStock = newNoStock;
            hasStock = newHasStock;
        }
        return noStock;
    }
}