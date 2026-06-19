class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // tricky
        if (numbers.length == 2 && target == numbers[0] + numbers[1]) {
            return new int[]{1, 2};
        }

        var maps = new HashMap<Integer, Integer>();
        for (var i = 0; i < numbers.length; i++) {
            var key = numbers[i];
            var value = i;
            if (maps.containsKey(key)) {
                var former = maps.get(key) + 1;
                return new int[]{former, i + 1};
            } else {
                key = target - numbers[i];
                maps.put(key, value);
            }
        }
        return new int[2];
    }
}
