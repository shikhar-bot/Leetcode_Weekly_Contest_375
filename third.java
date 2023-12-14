class Solution {
    public long countSubarrays(int[] nums, int k) {
        long n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            max = Math.max(nums[i], max);
        }
        int i = 0, j = 0;
        long count = 0, ans = 0;
        while (j < n) {
            if (nums[j] == max) {
                count++;
            }
            if (count >= k) {
                while (count >= k) {
                    ans += n - j;
                    if (nums[i] == max) {
                        count--;
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}
