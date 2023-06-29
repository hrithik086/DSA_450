/*
 * question link - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * explanation video link - https://www.youtube.com/watch?v=34WE6kwq49U&ab_channel=AnujBhaiya
 */

public class BestTimeToBuyAndSellStock {

    public static void main(String args[]){
        int arr[]={7,1,5,3,6,4};
        BestTimeToBuyAndSellStock b=new BestTimeToBuyAndSellStock();
        System.out.println(b.maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        int maxSell=0;
        int maxDiff=0;

        maxSell=prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            if(prices[i]<maxSell){
                maxDiff=Math.max(maxDiff,(maxSell-prices[i]));
            }
            else{
                maxSell=prices[i];
            }
        }

        return maxDiff;
    }
}
