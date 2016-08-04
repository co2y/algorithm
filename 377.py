class Solution(object):
    def combinationSum4(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        dp = [0]* (target+1)
        for i in range(1,target+1):
            for num in nums:
                if num > i:
                    break
                elif num == i:
                    dp[i] += 1
                else:
                    dp[i] = dp[i]+dp[i-num]
        
        return dp[target]
        
        
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] res = new int[target + 1];
        for (int i = 1; i < res.length; i++) {
	    for (int num : nums) {
	        if (num > i)
		    break;
		else if (num == i)
		    res[i] += 1;
		else
		    res[i] += res[i-num];
	    }
	}
        return res[target];
    }
}
#但是如果target很大，浪费超多memory
#以下是memory optimization search

public class Solution {
    HashMap<Integer, Integer> hashmap;
	
	public int combinationSum4(int[] nums, int target)
	{
		int len=nums.length;
		Arrays.sort(nums);
		hashmap=new HashMap<>(len);
		search(nums, target);
		return hashmap.get(target);
	}
	
	public int search(int[] nums,int target)
	{
		if(hashmap.containsKey(target))
			return hashmap.get(target);
		
		int index=Arrays.binarySearch(nums, target);
		boolean exist=index>=0;
		if(index<0)
			index=-(index+1);
		
		int sum=(exist?1:0);
		
		for(int i=index-1;i>=0;i--)
		{
			int dis=target-nums[i];
			sum+=search(nums, dis);
		}
		
		hashmap.put(target, sum);
		return sum;
	}
}