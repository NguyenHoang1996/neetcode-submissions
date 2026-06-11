class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> transformMaps = new HashMap();
        for (String item: strs) {
            var key = toKey(item);
            transformMaps.putIfAbsent(key, new ArrayList<>());
            transformMaps.get(key).add(item);
        }

        return new ArrayList(transformMaps.values());
    }
    private static String toKey(String item) {
        int[] count = new int[26];
        for (char c : item.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int n : count) {
            sb.append(n).append('#');
        }
        return sb.toString();
    }
}
