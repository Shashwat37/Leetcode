class NumArray {
    int[] tree;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;

        if (n == 0) {
            return;
        }

        tree = new int[4 * n];
        build(nums, 0, 0, n - 1);
    }

    public void build(int[] nums, int node, int l, int r) {
        if (l == r) {
            tree[node] = nums[l];
            return;
        }

        int mid = l + (r - l) / 2;

        build(nums, 2 * node + 1, l, mid);
        build(nums, 2 * node + 2, mid + 1, r);

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public void update(int index, int val) {
        update(0, 0, n - 1, index, val);
    }

    public void update(int node, int l, int r, int index, int val) {
        if (l == r) {
            tree[node] = val;
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(2 * node + 1, l, mid, index, val);
        } else {
            update(2 * node + 2, mid + 1, r, index, val);
        }

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    public int query(int node, int l, int r, int left, int right) {
        if (right < l || r < left) {
            return 0;
        }

        if (left <= l && r <= right) {
            return tree[node];
        }

        int mid = l + (r - l) / 2;

        int a = query(2 * node + 1, l, mid, left, right);
        int b = query(2 * node + 2, mid + 1, r, left, right);

        return a + b;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */