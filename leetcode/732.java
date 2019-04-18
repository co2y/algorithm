class MyCalendarThree {
    
    private static class SegmentTreeNode {
        int l, r;
        int k, lazy;
        SegmentTreeNode left, right;
        
        SegmentTreeNode(int l, int r, int k) {
            this.l = l;
            this.r = r;
            this.k = k;
        }
    }
    
    private void normalize(SegmentTreeNode node) {
        if (node.lazy > 0) {
            node.k += node.lazy;
        }
        
        if (node.l < node.r) {
            if (node.left == null || node.right == null) {
                int mid = node.l + (node.r - node.l) / 2;
                node.left = new SegmentTreeNode(node.l, mid, node.k);
                node.right = new SegmentTreeNode(mid, node.r, node.k);
            } else if (node.lazy > 0) {
                node.left.lazy += node.lazy;
                node.right.lazy += node.lazy;
            }
        }
        
        
        node.lazy = 0;
    }
    
    private int query(SegmentTreeNode node, int i, int j) {
        normalize(node);
        
        if (node == null || i >= node.r || j <= node.l) {
            return 0;
        }
        
        if (i <= node.l && j >= node.r) {
            return node.k;
        }
        
        return Math.max(query(node.left, i, j), query(node.right, i, j));
    }
    
    private void update(SegmentTreeNode node, int i, int j, int val) {
        normalize(node);
        
        if (node == null || i >= node.r || j <= node.l) {
            return;
        }
        
        if (i <= node.l && j >= node.r) {
            node.lazy = val;
            normalize(node);
            return;
        }
        
        update(node.left, i, j, val);
        update(node.right, i, j, val);
        
        node.k = Math.max(node.left.k, node.right.k);
    }

    private SegmentTreeNode root;
    
    public MyCalendarThree() {
        root = new SegmentTreeNode(1, 1000000000, 0);    
    }
    
    public int book(int start, int end) {
        update(root, start, end, 1);
        return query(root, 1, 1000000000);
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */