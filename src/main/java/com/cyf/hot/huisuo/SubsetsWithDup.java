package com.cyf.hot.huisuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**90. 子集 II
 * 
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * @author 陈一锋
 * @date 2023/1/6 9:52 下午
 */
public class SubsetsWithDup {

    public static void main(String[] args) {
//        SubsetsWithDup bean = new SubsetsWithDup();
//        System.out.println(bean.subsetsWithDup(new int[]{1, 2, 2}));

        System.out.println(21 % 10);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dsf(ans,new ArrayList<>(),0,nums);
        return ans;
    }

    public void dsf(List<List<Integer>> ans,List<Integer> path,int idx,int[] nums){
        ans.add(new ArrayList<>(path));

        for(int i = idx;i<nums.length;i++){
            if(i > idx && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            dsf(ans,path,i+1,nums);
            path.remove(path.size()-1);
        }
    }
}
