package com.cyf.hot.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 全排列 II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * @author 陈一锋
 * @date 2022/12/11 10:50 上午
 */
public class PermuteII {
    Set<String> set = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        if (length == 0) {
            return res;
        }

        boolean[] select = new boolean[length];
        dfs(nums, 0, length, res, new ArrayList<>(), select);

        return res;
    }

    public void dfs(int[] nums, int depth, int length, List<List<Integer>> res, List<Integer> path, boolean[] select) {
        if (depth == length && set.add(path.toString())) {
            //叶子节点
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //在递归过程中没被选择过
            if (!select[i]) {
                path.add(nums[i]);
                select[i] = true;

                dfs(nums, depth+1, length, res, path, select);

                //重置状态没被选择
                select[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        PermuteII solution = new PermuteII();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }

}
