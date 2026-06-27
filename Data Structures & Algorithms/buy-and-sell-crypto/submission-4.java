class Solution {
    public int maxProfit(int[] prices) {
     var formerMin = 101;
     var max = 0;

     for (var price: prices) {
        if (price < formerMin) {
            formerMin = price;
        } else {
            max = Math.max(max, price - formerMin);
        }
     }
     return max;
    }
}
