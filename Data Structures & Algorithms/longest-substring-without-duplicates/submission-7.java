class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        var maps = new HashMap<Character, Integer>();
        var arr = s.toCharArray();
        var max = 0;
        var left = 0;

        for (var i = 0; i < arr.length; i++) {
            if (maps.containsKey(arr[i])) {
                left = Math.max(left, maps.get(arr[i]) + 1);
            }
            max = Math.max(max, i - left + 1);
            maps.put(arr[i], i);
        }
        return max;
    }
}
