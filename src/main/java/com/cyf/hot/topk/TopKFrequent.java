package com.cyf.hot.topk;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * @author 陈一锋
 * @date 2023/1/17 8:02 下午
 */
public class TopKFrequent {

    public static void main(String[] args) {
        TopKFrequent bean = new TopKFrequent();
//        System.out.println(Arrays.toString(bean.topKFrequent(new int[]{1, 1, 1, 2, 2, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(bean.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            Integer i = map.get(num);
            if (i == null) {
                i = 0;
            }
            i++;
            map.put(num, i);
        }

        PriorityQueue<Data> queue = new PriorityQueue<>(Data::compareTo);

        map.forEach((val, count) -> {
            Data d = new Data(val, count);

            if (queue.size() == k) {
                if (queue.peek().getCount() < d.getCount()) {
                    queue.poll();
                    queue.add(d);
                }
            } else {
                queue.add(d);
            }
        });

        int[] ans = new int[k];
        int idx = 0;
        while (!queue.isEmpty()) {
            ans[idx++] = queue.poll().val;
        }
        return ans;
    }

    static class Data implements Comparable<Data> {
        private int val;
        private int count;

        public Data(int val, int count) {
            this.val = val;
            this.count = count;
        }

        public Integer getCount() {
            return count;
        }

        @Override
        public int compareTo(Data o) {
            return this.getCount().equals(o.getCount()) ? 0 : this.getCount() > o.getCount() ? 1 : -1;
        }
    }
}
