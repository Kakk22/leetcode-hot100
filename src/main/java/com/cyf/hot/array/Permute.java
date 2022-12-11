package com.cyf.hot.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * @author 陈一锋
 * @date 2022/12/11 10:50 上午
 */
public class Permute {
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
        if (depth == length) {
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
        int[] nums = {1, 2, 3};
        Permute solution = new Permute();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }

}
