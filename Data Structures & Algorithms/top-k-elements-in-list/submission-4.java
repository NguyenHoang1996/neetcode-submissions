class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var fre = new HashMap<Integer, Integer>();
        for (var num : nums) {
            fre.put(num, fre.getOrDefault(num, 0) + 1);
        }

        var pq = new PriorityQueue<Integer>((a, b) -> fre.get(b) - fre.get(a));
        for (var key : fre.keySet()) {
            pq.add(key);
        }
        var res = new int[k];
        for (var i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}
