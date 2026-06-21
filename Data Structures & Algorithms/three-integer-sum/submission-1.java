class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // var maps = new HashMap<String, List<Integer>>();
        // var results = new ArrayList();
        // for (var i = 0; i < nums.length - 2; i++) {
        //     for (var j = 1; j < nums.length - 1; j++) {
        //         for (var k = 2; k < nums.length; k++) {
        //             if (i == j || j == k || k ==i)
        //                 continue;

        //             if (nums[i] + nums[j] + nums[k] == 0) {
        //                 var list = Arrays.asList(nums[i], nums[j], nums[k]);
        //                 Collections.sort(list);
        //                 var key = list.get(0) + "," + list.get(1) + "," + list.get(2);
        //                 maps.put(key, Arrays.asList(nums[i], nums[j], nums[k]));
        //             }
        //         }
        //     }
        // }
        // return results;
        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array to handle duplicates and enable two pointers
        Arrays.sort(nums);

        // Step 2: Iterate through the array to fix the first element
        for (int i = 0; i < nums.length - 2; i++) {
            // Optimization: If the smallest fixed element is positive,
            // no three elements can sum up to 0.
            if (nums[i] > 0) {
                break;
            }

            // Step 3: Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 4: Initialize two pointers
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Valid triplet found
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Move pointers inward and skip duplicate values to prevent redundancy
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    // Sum is too small, move left pointer rightward to get a larger value
                    left++;
                } else {
                    // Sum is too big, move right pointer leftward to get a smaller value
                    right--;
                }
            }
        }

        return result;
    }
}
