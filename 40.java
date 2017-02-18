public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, candidates, 0, target, new ArrayList<Integer>());
        return ans;

    }

    private void dfs(int index, int[] candidates, int sum, int target, List<Integer> path) {
        if (sum == target) {
            ans.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = index; i < candidates.length; ++i) {
            if (i > index && candidates[i] == candidates[i-1])
                continue;
            if (sum + candidates[i] > target) {
                return;
            }

            path.add(candidates[i]);
            dfs(i + 1, candidates, sum + candidates[i], target, path);
            path.remove(path.size() - 1);
        }

    }
}
