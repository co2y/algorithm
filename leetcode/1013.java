class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int a : A) sum+=a;
        
        if (sum % 3 != 0) return false;
        
        int target = sum / 3;
        int n = A.length;
        int left = 0;
        int right = n - 1;
        int leftSum = 0;
        int rightSum = 0;
        while (left < right) {
            if (leftSum != target) {
                leftSum += A[left];
                left++;
            }
            
            if (rightSum != target) {
                rightSum += A[right];
                right--;
            }
            // System.out.println(leftSum + " " + rightSum);
            if (leftSum == target && rightSum == target) return true;
        }
        
        return false;
        
    }
}