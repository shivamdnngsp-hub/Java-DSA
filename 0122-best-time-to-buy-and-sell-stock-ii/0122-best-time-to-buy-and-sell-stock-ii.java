

class Solution {
    public int maxProfit(int[] prices) {
        

         int curprofitbuy = 0;
         int curprofitsell = prices[prices.length -1];
        int nextbuy = 0;// if i can buy last index max profit will be 0
        int nextsell = prices[prices.length -1]; // if i can sell last index max porfit wil be this
        

        for(int i = prices.length-2;i>=0;i--){
            int profit = 0;
            for(int buy = 0;buy<=1;buy++){
            if(buy == 1){
              profit = Math.max(-prices[i] + nextsell,nextbuy);
              curprofitbuy = profit;
            }else{
              profit = Math.max(prices[i] + nextbuy,nextsell);
              curprofitsell = profit;
            }
            nextbuy = curprofitbuy;
            nextsell =  curprofitsell;
            }
        }

        return nextbuy;
    }
}