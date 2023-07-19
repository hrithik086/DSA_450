/*
 * Question link - https://practice.geeksforgeeks.org/problems/buy-and-sell-a-share-at-most-twice/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
 * Explanation video link - https://www.youtube.com/watch?v=wuzTpONbd-0&ab_channel=Pepcoding
 * 
 * Geeks for geeks showing 50% accuracy
 */

public class BuyAndSellStockAtMost2Transactions {
    public static void main(String args[]){
        int price[]={10 ,22 ,5 ,75 ,65 ,80};
        System.out.println(maxProfit(price.length, price));
    }

    public static int maxProfit(int n, int[] price) {
        
        int profit[][]=new int[2][price.length];
        int maxSellPrice=price[price.length-1];
        int minBuyPrice=price[0];
        int maxProfitIfSoldTillHereOrInPast=0;
        int maxProfitIfBoughtHereOrInFuture=0;
        int maxProfitForTwoTransactions;
        
        //iterating the stock price and updating the profit array.
        for(int i=0,j=price.length-1;i<price.length && j>=0 ; i++,j--){
            //calculation of max profit if sold till here or sold in the past
            if(price[i]>=minBuyPrice){
                maxProfitIfSoldTillHereOrInPast=Math.max(maxProfitIfSoldTillHereOrInPast, (price[i]-minBuyPrice));
            }
            else{
                minBuyPrice=price[i];
            }
            profit[0][i]=maxProfitIfSoldTillHereOrInPast;
            
            //calculation of max profit if bought from here and sold in the future
            //or else bought in the future and sold in the future
            if(price[j]<=maxSellPrice){
                maxProfitIfBoughtHereOrInFuture=Math.max(maxProfitIfBoughtHereOrInFuture, (maxSellPrice-price[j]));
            }
            else{
                maxSellPrice=price[j];
            }
            profit[1][j]=maxProfitIfBoughtHereOrInFuture;
        }
        
        //iterating the profit array and claculating the maxSum of two segments.
        maxProfitForTwoTransactions=0;
        for(int i=0;i<price.length; i++){
            maxProfitForTwoTransactions=Math.max(maxProfitForTwoTransactions, (profit[0][i]+profit[1][i]));
        }
        
        return maxProfitForTwoTransactions;
        
    }
}
