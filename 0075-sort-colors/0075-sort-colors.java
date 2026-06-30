class Solution {
    public void sortColors(int[] nums) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        ArrayList<Integer> w = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> f = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            r.add(nums[i]);
            else if(nums[i]==1)
            w.add(nums[i]);
            else if(nums[i]==2)
            b.add(nums[i]);
        }
        f.addAll(r);
        f.addAll(w);
        f.addAll(b);
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=f.get(i);
        }
    }
}