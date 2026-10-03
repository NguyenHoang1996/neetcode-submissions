class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        var maps = new HashMap<Integer, Integer>();
        for (var num : nums) {
            var val = maps.getOrDefault(num, 0) + 1;
            maps.put(num + 1, val);
        }
        var outcome = 0;
        for (var key : maps.keySet()) {
            outcome = Math.max(maps.get(key), outcome);
        }

        return outcome;
    }
}
