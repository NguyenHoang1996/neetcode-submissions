class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        var maps = new HashMap<Character, Integer>();
        var schars = s.toCharArray();

        for (char ch : schars) {
            var value = (maps.containsKey(ch)) 
                ? maps.get(ch) + 1 
                : 1;
            
            maps.put(ch, value);
        }

        var tchars = t.toCharArray();
        for (char ch : tchars) {
            if (!maps.containsKey(ch)) {
                return false;
            }

            maps.put(ch, maps.get(ch) - 1);
        }

        for (char ch: maps.keySet()) {
            if (maps.get(ch) != 0) 
                return false;
        }

        return true;
    }
}
