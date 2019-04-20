class NumArray {
    
    private static class SegmentTreeNode {
        int l,r;
        int k;
        SegmentTreeNode left, right;
        SegmentTreeNode(int l, int r, int k) {
            this.l = l;
            this.r = r;
            this.k = k;
        }
    }
    
    private int query(SegmentTreeNode node, int l, int r) {
        
        if (l > r || node == null || l > node.r || r < node.l) {
            return 0;
        }
        
        if (l <= node.l && r >= node.r) {
            
            return node.k;
        }
        
        return query(node.left, l, r) + query(node.right, l, r);
    }
    
    private void update(SegmentTreeNode node, int l, int r, int k) {
        
        if (l > r || node == null || l > node.r || r < node.l) {
            return;
        }
        
        if (l <= node.l && r >= node.r) {
            node.k = k;
            return;
        }
        
        update(node.left, l, r, k);
        update(node.right, l, r, k);
        node.k = node.left.k + node.right.k;
    }
    
    private SegmentTreeNode root;
    
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTreeNode ret = new SegmentTreeNode(start, end, 0);
            if (start == end) {
                ret.k = nums[start];
            } else {
                int mid = start  + (end - start) / 2;             
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.k = ret.left.k + ret.right.k;
            }         
            return ret;
        }
    }
    
    public void update(int i, int val) {
        update(root, i, i, val);
    }
    
    public int sumRange(int i, int j) {
        return query(root, i, j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */