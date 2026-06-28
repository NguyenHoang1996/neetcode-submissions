class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        var rows = matrix.length; // 3
        var cols = matrix[0].length; // 4
        var left = 0;
        var right = rows * cols - 1;

        while (left <= right) {
            var mid = (left + right) / 2;
            var row = mid / cols;
            var col = mid % cols;
            var value = matrix[row][col];
            System.out.println("matrix[" + row + "][" + col + "] = " + matrix[row][col]);
            if (value == target)
                return true;

            if (target < value) {
                right = mid - 1;
                System.out.println("right = " + right);
            } else {
                left = mid + 1;
                System.out.println("left = " + left);
            }
        }
        return false;
    }
}
