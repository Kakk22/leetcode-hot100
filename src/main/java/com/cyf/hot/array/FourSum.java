package com.cyf.hot.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 四数之和
 * <p>
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d< n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *
 * @author 陈一锋
 * @date 2023/1/18 8:03 下午
 */
public class FourSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString("  hello world  ".split(" ")));
        String s = "  hello world  ";
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = ss.length - 1;i>=0;i--){
            String val = ss[i];
            if(val.equals("")){
                continue;
            }
            if (i != ss.length-1){
                sb.append(" ");
            }
            sb.append(val);
        }
        System.out.println(sb.toString());
//        System.out.println(new FourSum().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, target, nums, 0, new ArrayList<>(), 0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, int target, int[] nums, int idx, List<Integer> path, int sum) {
        if (path.size() == 4 && sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (path.size() == 4) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }


            path.add(nums[i]);
            dfs(ans, target, nums, idx + 1, path, sum + nums[i]);
            path.remove(path.size() - 1);
            sum = sum - nums[i];
        }
    }
}
