class Solution {
    public int[] productExceptSelf(int[] nums) {
        var prefix = new int[nums.length];
        var result = new int[nums.length];
        var pre = 1;
        var suf = 1;
        for (var i = 0; i < nums.length; i++) {
            prefix[i] = pre;
            pre *= nums[i];
        }

        for (var i = nums.length - 1; i >= 0; i--) {
            result[i] = prefix[i] * suf;
            suf *= nums[i];
        }

        return result;
    }
}
