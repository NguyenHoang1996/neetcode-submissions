class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        var n = nums.length;
        var res = new int[n - k + 1];
        // init pq
        var pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (var i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (var i = 0; i < n - k + 1; i++) {
            res[i] = pq.peek();

            pq.remove(nums[i]);
            var next = (i + k < n) ? i + k : n - 1;
            pq.add(nums[next]);
        }

        return res;
    }
}
