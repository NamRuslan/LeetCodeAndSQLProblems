package leetcode;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockII {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }

            int minPrice = prices[0];
            int profit = 0;
            int result = 0;

            for (int i : prices) {

                minPrice = Math.min(minPrice, i);

                if (i - minPrice >= profit) {
                    profit = i - minPrice;

                } else {
                    result += profit;
                    profit = 0;
                    minPrice = i;
                }

            }

            return result + profit;
        }
    }
}
