class Solution {
    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return "";
        }

        var result = new StringBuilder();
        var index = new StringBuilder();
        var message = new StringBuilder();
        message.append("#");
        for (var items : strs) {
            index.append(items.length()).append(",");
            message.append(items);
        }
        index.deleteCharAt(index.length() - 1); // remove the last ","
        result.append(index).append(message);
        return result.toString();
    }

    public List<String> decode(String str) {
        if (str.equalsIgnoreCase("")) {
            return new ArrayList<>();
        }
        var result = new ArrayList<String>();
        var delimiters = ",";
        var parts = str.split("#", 2);
        var indexes = parts[0].split(delimiters);
        var encode = parts[1];

        var leftPivot = 0;
        for (var index : indexes) {
            var capacity = Integer.parseInt(index);
            var rightPivot = leftPivot + capacity;
            result.add(encode.substring(leftPivot, rightPivot));
            leftPivot = rightPivot;
        }
        return result;
    }
}
