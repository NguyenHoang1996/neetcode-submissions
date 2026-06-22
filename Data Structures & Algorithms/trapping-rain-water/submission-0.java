class Solution {
    public int trap(int[] height) {
        var premost = new int[height.length];
        var sufmost = new int[height.length];
        var max = 0;
        var result = 0;
        for (var i = 0; i < height.length; i++) {
            max = Math.max(height[i], max);
            premost[i] = max;
        }
        max = 0;
        for (var i = height.length - 1; i >= 0; i--) {
            max = Math.max(height[i], max);
            sufmost[i] = max;
        }

        for (var i = 0; i < height.length; i++) {
            var value = Math.min(premost[i], sufmost[i]) - height[i];
            value = (value >= 0) ? value: 0;
            System.out.println(value);
            result += value;
        }
        return result;
    }
}
