class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var maps = new HashMap<String, List<String>>();
        for (var str : strs) {
            var chArr = new char[26];
            for (var ch : str.toCharArray()) {
                chArr[ch - 'a']++;
            }

            var keyStrB = new StringBuilder();
            for (var ch : chArr) {
                keyStrB.append(ch).append('#');
            }

            var key = keyStrB.toString();
            var value = maps.getOrDefault(key, new ArrayList());
            value.add(str);

            maps.put(key, value);
        }

        var outcome = new ArrayList<List<String>>();
        for (var key : maps.keySet()) {
            outcome.add(maps.get(key));
        }

        return outcome;
    }
}
