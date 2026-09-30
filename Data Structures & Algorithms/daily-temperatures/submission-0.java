class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        var output = new int[temperatures.length];
        var stack = new Stack<Integer>();

        for (var i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty() || temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                var pos = stack.pop();
                output[pos] = i - pos;
            }

            stack.push(i);
        }
        return output;
    }
}
