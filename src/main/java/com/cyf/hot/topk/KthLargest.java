package com.cyf.hot.topk;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 * <p>
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * <p>
 * 请实现 KthLargest类：
 * <p>
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *
 * @author 陈一锋
 * @date 2022/10/21 8:34 下午
 */
public class KthLargest {
    private int k;
    private PriorityQueue<Integer> q;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<Integer>(k);
        for (int i : nums) {
            add(i);
        }
    }

    /**
     * 思路:维护一个容量为k的最小堆,则第k大的刚好是堆顶的元素
     * 新加入元素 比堆顶元素大 则堆顶元素移除 加入元素
     * 如果比堆顶元素小 则丢弃
     *
     */
    public int add(int val) {
        if (q.size() < k) {
            q.offer(val);
        } else if (q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }

}
