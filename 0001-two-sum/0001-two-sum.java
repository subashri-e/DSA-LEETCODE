class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            int more=target-a;
             if (h.containsKey(more)) { 
                return new int[]{h.get(more), i}; 
            }
            h.put(a, i); 
        }
        return new int[]{-1, -1}; 
    }
}