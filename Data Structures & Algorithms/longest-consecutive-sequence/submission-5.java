class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        var maps = new HashMap<Integer, Integer>();
        for (var num : nums) {
            if (!maps.containsKey(num)) {
                maps.putIfAbsent(num + 1, 1);
                continue;
            }
            maps.put(num + 1, maps.get(num) + 1);
            maps.remove(num);
        }
        var res = 0;
        for (var key : maps.keySet()) {
            res = Math.max(res, maps.get(key));
        }

        return res;
    }
}
