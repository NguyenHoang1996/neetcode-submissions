class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var maps = new HashMap<Integer, Integer>();
        for (int item : nums) {
            var value = (maps.containsKey(item)) ? maps.get(item) + 1 : 1;
            maps.put(item, value);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> maps.get(b) - maps.get(a));
        for (int key: maps.keySet()) {
            maxHeap.add(key);
        }

        var result = new int[k];
        for (int i = 0; i < k; i++){
            result[i] = maxHeap.poll();
        }

        return result;
    }
}
