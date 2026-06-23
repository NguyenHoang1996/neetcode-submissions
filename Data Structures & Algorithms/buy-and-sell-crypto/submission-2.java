class Solution {
    public int maxProfit(int[] prices) {
        var n = prices.length;
        var gaps = new int[n - 1];
        for (var i = 0; i < n - 1; i++) {
            gaps[i] = prices[i + 1] - prices[i];
            System.out.println(gaps[i]);
        }
        var max = 0;
        var result = 0;
        var left = -1;
        // -9 4 1 1 -6
        for (var right = 0; right < gaps.length; right++) {
            if (gaps[right] > 0 && left == -1) {
                left = right;
                System.out.println(gaps[right]);
            }

            if (left >= 0) {
                max = max + gaps[right];
                System.out.println(max);
            }
            result = Math.max(result, max);
        }
        return result;
    }
}
