class RangeModule {
    
    private static class SegmentTreeNode {
        int l, r;
        boolean k, lazy;
        SegmentTreeNode left, right;
        
        SegmentTreeNode (int l, int r, boolean k) {
            this.l = l;
            this.r = r;
            this.k = k;
        }
    }
    
    private void normalize(SegmentTreeNode node) {  
        if (node.l < node.r) {
            if (node.left == null || node.right == null) {
                int mid = node.l + (node.r - node.l) / 2;
                node.left = new SegmentTreeNode(node.l, mid, node.k);
                node.right = new SegmentTreeNode(mid, node.r, node.k);
            } else if (node.lazy) {
                node.left.k = node.k;
                node.left.lazy = true;
                node.right.k = node.k;
                node.right.lazy = true;
            }
        }
        
        node.lazy = false;
    }

    private void update(SegmentTreeNode node, int i, int j, boolean val) {
        
        normalize(node);
        
        if (i > j || node == null || i >= node.r || j <= node.l) {
            return;
        }
        
        if (i <= node.l && j >= node.r) {
            node.lazy = true;
            node.k = val;
            normalize(node);
            return;
        }
        
        update(node.left, i, j, val);
        update(node.right, i, j ,val);
        node.k = node.left.k && node.right.k;
    }
    
    private boolean query(SegmentTreeNode node, int i, int j) {
        normalize(node);
        
        if (i > j || node == null || i >= node.r || j <= node.l) {
            return true;
        }
        
        if (i <= node.l && j >= node.r) {
            return node.k;
        }
        
        return query(node.left, i, j) && query(node.right, i, j);
    }
    
    private SegmentTreeNode root;
    
    public RangeModule() {
        root = new SegmentTreeNode(0, 1000_000_000, false);
    }
    
    public void addRange(int left, int right) {
        update(root, left, right, true);
    }
    
    public boolean queryRange(int left, int right) {
        return query(root, left, right);
    }
    
    public void removeRange(int left, int right) {
        update(root, left, right, false);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */