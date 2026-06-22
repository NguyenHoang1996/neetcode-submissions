class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        var maps = new HashMap<String, List<Integer>>();
        var results = new ArrayList();
        if (nums[0] > 0)
            return results;

        for (var i = 0; i < nums.length - 2; i++) {
            var sum = -nums[i];
            var left = i + 1;
            var right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] < sum) {
                    left++;
                    continue;
                } else if (nums[left] + nums[right] > sum) {
                    right--;
                    continue;
                }
                // nums[left] + nums[right] == sum
                maps.putIfAbsent(nums[i] + "," + nums[left] + "," + nums[right],
                    Arrays.asList(nums[i], nums[left], nums[right]));
                left++;
            }
        }

        for (var key: maps.keySet()) { 
            results.add(maps.get(key));
        }
        return results;
    }
}
