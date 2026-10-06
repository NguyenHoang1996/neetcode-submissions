class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        var stack = new Stack<Integer>();
        var len = temperatures.length;
        var outcome = new int[len];
        for (var i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                var pos = stack.pop();
                outcome[pos] = i - pos;
            }
            stack.add(i);
        }
        
        return outcome;
    }
}
