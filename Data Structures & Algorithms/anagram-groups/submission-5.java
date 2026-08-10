class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var maps = new HashMap<String, List<String>>();
        for (var item : strs) {
            var existing = maps.getOrDefault(getKey(item), new ArrayList());
            existing.add(item);
            maps.put(getKey(item), existing);
        }
        var res = new ArrayList<List<String>>();
        for (var key : maps.keySet()) {
            res.add(maps.get(key));
        }
        return res;
    }

    private static String getKey(String item) {
        var key = new StringBuilder();
        var arr = new int[26];
        for (var chars : item.toCharArray()) {
            arr[chars - 'a'] += 1;
        }

        for (var i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                key.append(i).append('-').append(arr[i]);
                key.append(':');
            }
        }
        return key.toString();
    }
}
