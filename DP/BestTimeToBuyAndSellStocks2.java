/*
 * Question link - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 * Explanation video link - https://www.youtube.com/watch?v=pTQB9wbIpfU&ab_channel=Pepcoding
 */

public class BestTimeToBuyAndSellStocks2{
    public static void main(String args[]){
        int prices[]={1,3,2,8,4,9};
        int fee=2;
        System.out.println(maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee) {

        int matr[][]=new int[prices.length][2];
        int initialBalance,initialStockBalance;
        int afterSellBalance,afterBuyStockBalance;
        
        //0 index represents my balance with one stock with me
        //1 index represents my balace with no stocks with me (concider this as you wallet)
        //no stocks means the stock which i might have bought earlier i have sold them and this is the balance after selling
        //here i have initialized the first row of the table i buyied 1 stock initially
        matr[0][0]=0-prices[0];
        matr[0][1]=0;

        for(int i=1;i<prices.length;i++){
            //now here i have four option for each day
            //hold the old stock here. hold means neither we buy new stock nor we sell old stock here
            initialStockBalance=matr[i-1][0];
            initialBalance=matr[i-1][1];

            //Forget about the old stock buy a new stock with balance amount you have in your wallet
            //this means you sold all your all stock before this day and now you are buying a new stock from the balance you have
            //-ve value represents we are havin a loan of that value
            afterBuyStockBalance=initialBalance-prices[i];


            //sell the old stock here forget about the old wallet balance here
            //this means rather than selling stock before this day you will sell the stock you hell till now here.
            afterSellBalance=initialStockBalance+prices[i]-fee;

            matr[i][0]=Math.max(initialStockBalance,afterBuyStockBalance);
            matr[i][1]=Math.max(initialBalance,afterSellBalance);
        }

        return matr[prices.length-1][1];

    }
}