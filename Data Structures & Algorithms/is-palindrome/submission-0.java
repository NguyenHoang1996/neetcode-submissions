class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 1)
            return true;
        var compare = new StringBuilder();
        for (var ch : s.toCharArray()) {
            if (isPrintable(ch)) {
                compare.append(ch);
            }
        }
        var trans = compare.toString().toLowerCase();
        var left = 0;
        var right = trans.length() - 1;
        while (left < right) {
            var valLeft = trans.charAt(left);
            var valRight = trans.charAt(right);
            if (valLeft != valRight) {
                return false;
            }
            left = left + 1;
            right = right - 1;
        }
        return true;
    }

    private static boolean isPrintable(char ch) {
        if ('a' <= ch && ch <= 'z') {
            return true;
        }
        if ('A' <= ch && ch <= 'Z') {
            return true;
        }
        if ('0' <= ch && ch <= '9') {
            return true;
        }
        return false;
    }
}
