class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) return nums.length;

        Arrays.sort(nums);
        var max = 0;
        var count = 1;
        for (var i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
                max = Math.max(max, count);
                continue;
            }

            if (nums[i] == nums[i - 1]) {
                max = Math.max(max, count);
                continue;
            }

            if (nums[i] != nums[i - 1] + 1) {
                count = 1;
                max = Math.max(max, count);
                continue;
            }
        }

        return max;
    }
}
