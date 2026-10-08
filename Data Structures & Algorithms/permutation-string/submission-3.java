class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        if (s1.length() == 1 && s2.length() == 1 && s1.equals(s2))
            return true;

        var shorter = s1;
        var longer = s2;

        var shortArr = new int[26];
        for (var ch : shorter.toCharArray()) {
            shortArr[ch - 'a']++;
        }

        var shortKey = toKey(shortArr);

        var compareArr = new int[26];
        for (var i = 0; i < shorter.length(); i++) {
            compareArr[longer.charAt(i) - 'a']++;
        }
        System.out.println("++++++++++++==================+++++++++++++");
        for (var i = 0; i + shorter.length() - 1 < longer.length(); i++) {
            if (i > 0) {
                compareArr[longer.charAt(i + shorter.length() - 1) - 'a']++; // right
                compareArr[longer.charAt(i - 1) - 'a']--; // left
            }

            var key = toKey(compareArr);
            if (key.equals(shortKey))
                return true;
        }
        return false;
    }

    private static String toKey(int[] arr) {
        var out = new StringBuilder();
        for (var item : arr) {
            out.append(item).append("#");
        }
        System.out.println(out.toString());
        return out.toString();
    }
}
