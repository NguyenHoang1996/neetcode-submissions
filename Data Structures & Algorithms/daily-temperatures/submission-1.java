class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        var stack = new Stack<Integer>();
        var output = new int[temperatures.length];
        for (var i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                var pos = stack.pop();
                output[pos] = i - pos;
            }

            stack.push(i);
        }
        return output;
    }
}
