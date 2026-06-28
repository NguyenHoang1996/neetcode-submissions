class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        var top = 0;
        var down = matrix.length - 1;
        var left = 0;
        var right = matrix[0].length - 1;
        while (top <= down) {
            var midVer = top + (down - top) / 2; // |
            if (target < matrix[midVer][left] ) {
                down = midVer - 1;
                continue;
            }

            if (matrix[midVer][right] < target) {
                top = midVer + 1;
                continue;
            }
            while (left <= right) {
                var mid = left + (right - left) / 2; // __
                if (matrix[midVer][mid] == target)
                    return true;

                if (matrix[midVer][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
