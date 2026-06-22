class Solution {
    public int maxArea(int[] heights) {
        var left = 0;
        var right = heights.length - 1;
        var max = 0;

        while (left < right) {
            var h = Math.min(heights[left], heights[right]);
            var w = right - left;
            max = Math.max(max, h * w);
            if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
