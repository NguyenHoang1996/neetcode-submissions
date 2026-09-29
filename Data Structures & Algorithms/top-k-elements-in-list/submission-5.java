class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var maps = new HashMap<Integer, Integer>();
        for (var num : nums) {
            maps.put(num, maps.getOrDefault(num, 0) + 1);
        }

        var pq = new PriorityQueue<Integer>((a, b) -> maps.get(b) - maps.get(a));
        for (var key: maps.keySet()) {
            pq.add(key);
        }

        var outcome = new int[k];
        for (var i = 0; i < k; i++) {
            outcome[i] = pq.poll();
        }

        return outcome;
    }
}
