class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int C = matrix[0].length;
        int high = matrix.length * C - 1;

        while (low <= high){

            int mid = low + (high-low) / 2;
            int row = mid / C;
            int col = mid % C;
            int value = matrix[row][col];

            if(value == target){
                return true;
            }
            else if(value > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
        
    }
}