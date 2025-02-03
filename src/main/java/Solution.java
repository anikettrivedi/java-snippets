class Solution {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int result;

        // iterate over all indexes
        for (int i = 1; i < n; i++) {

        }
        return lengthOfLISEndingAtIndex(nums, n-1);
    }

    private static int lengthOfLISEndingAtIndex(int[] nums, int index) {
        // base case
        if (index == 0) {
            return 1;
        }

        // create variable to store lis length
        int lisLength = 1;

        // iterate over all indexes < index
        for (int i = 0; i < index; i++) {
            if (nums[index] > nums[i]) {
                lisLength = Math.max(lisLength, 1 + lengthOfLISEndingAtIndex(nums, i));
            }
        }

        return lisLength;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));
    }
}