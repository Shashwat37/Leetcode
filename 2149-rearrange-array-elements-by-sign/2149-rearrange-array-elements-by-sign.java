class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> p = new ArrayList<Integer>();
        ArrayList<Integer> n = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
            n.add(nums[i]);
            else if(nums[i]>0)
            p.add(nums[i]);
        }
        int j=0;
        int i=0;
        while(i<nums.length)
        {
            nums[i]=p.get(j);
            i++;
            nums[i]=n.get(j);
            j++;
            i++;
        }
        return nums;
    }
}