class Solution {
    public int lengthOfLongestSubstring(String s) {
        var map = new HashMap<Character, Integer>();
        var max = 0;
        var l = 0;

        for (var r = 0; r < s.length(); r++) {
            var ch = s.charAt(r);

            if (map.containsKey(ch)) {
                l = Math.max(l, map.get(ch) + 1);
            }
            max = Math.max(max, r - l + 1);
            map.put(ch, r);
        }
        return max;
    }
}
