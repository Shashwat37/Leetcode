class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0,high=0;
        for(int i=0;i<nums.length;i++)
        {
            high+=nums[i];
            low=Math.max(nums[i],low);
        }
        while(low<=high)
        {
            int partitions=1;
            int sum=0;
            int mid=low+(high-low)/2;
            for(int i=0;i<nums.length;i++)
            {
                if(sum+nums[i]<=mid)
                    sum+=nums[i];
                else{
                    sum=nums[i];
                    partitions++;
            }
        }
        if(partitions>k)
        {
            low=mid+1;
        }
        else
        {
            high=mid-1;
        }
    }
    return low;
    }
}