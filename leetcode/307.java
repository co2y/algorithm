public class NumArray {

    class SegmentTreeNode {
        public int start, end;
        public SegmentTreeNode left, right;
        public int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
        }
    }

    SegmentTreeNode root = null;

    public NumArray(int[] nums) {
        root = build(nums, 0, nums.length-1);
    }

    public SegmentTreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if (start == end) {
                ret.sum = nums[start];
            } else {

                int mid = start + ((end - start) >> 1);
                System.out.println("start: "+ start + " mid: "+mid+" end: "+end);
                ret.left = build(nums, start, mid);
                ret.right = build(nums, mid+1, end);
                ret.sum = ret.left.sum+ ret.right.sum;
            }
            return ret;
        }
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    public void update(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                update(root.left, pos, val);
            } else {
                update(root.right, pos ,val);
            }
            root.sum = root.left.sum + root.right.sum;
        }

    }

    public int sumRange(int i, int j) {
        return query(root, i, j);
    }

    public int query(SegmentTreeNode root, int start ,int end) {
        if (root.start == start && root.end == end) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return query(root.left, start, end);
            } else if (start > mid) {
                return query(root.right, start, end);
            } else {
                return query(root.left, start, mid) + query(root.right, mid+1, end);
            }
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
