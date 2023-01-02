package com.cyf.hot.topk;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * @author 陈一锋
 * @date 2023/1/2 4:01 下午
 */
public class GetLeastNumbers {

    public static void main(String[] args) {
        GetLeastNumbers bean = new GetLeastNumbers();
        System.out.println(Arrays.toString(bean.getLeastNumbers(new int[]{3, 2, 1}, 2)));
        System.out.println(Arrays.toString(bean.getLeastNumbers(new int[]{0,1,2,1}, 1)));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 大堆  默认构造函数是小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k) {
                queue.add(arr[i]);
            } else {
                if (!queue.isEmpty() && queue.peek() > arr[i]) {
                    queue.poll();
                    queue.add(arr[i]);
                }
            }
        }

        int[] ans = new int[k];
        int i = 0;
        for (Integer n : queue) {
            ans[i++] = n;
        }
        return ans;
    }
}
