class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var maps = new HashMap<String, List<String>>();
        for (var item : strs) {
            var itemArr = item.toCharArray();
            Arrays.sort(itemArr);
            var key = new String(itemArr);

            var existing = maps.getOrDefault(key, new ArrayList());
            existing.add(item);
            maps.put(key, existing);
        }
        var res = new ArrayList<List<String>>();
        for (var key : maps.keySet()) {
            res.add(maps.get(key));
        }
        return res;
    }

}
