class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int left = 0; 
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        ArrayList<Integer> ans = new ArrayList<>();
        int count = 0;
        while (left <= right && top <= bottom) {
            System.out.println(count);
            count++;

            if (left == right) {
                for (int j = top; j <= bottom; j++)
                    ans.add(matrix[j][left]);
                break;
            } else if (top == bottom) {
                for (int j = left; j <= right; j++)
                    ans.add(matrix[top][j]);
                break;
            }

            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }

            for (int i = top + 1; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }

            for (int i = right - 1; i >= left; i--) {
                ans.add(matrix[bottom][i]);
            }

            for (int i = bottom - 1; i > top; i--) {
                ans.add(matrix[i][left]);
            }

            top++;
            bottom--;
            left++;
            right--;


        }

        return ans;
    }
}
