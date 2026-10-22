class Solution {
    public int maxProfit(int[] prices) {
        int hasStock = -prices[0];
        int justSold = 0;
        int rest = 0;

        for(int i = 1; i < prices.length; i++){
            int newHasStock = Math.max(hasStock, rest - prices[i]);
            int newJustSold = hasStock + prices[i];
            int newRest = Math.max(rest, justSold);
            hasStock = newHasStock;
            justSold = newJustSold;
            rest = newRest;
        }
        return Math.max(justSold, rest);
    }
}