package com.cyf.hot;

import org.omg.CORBA.IRObject;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 陈一锋
 * @date 2021/10/9 11:46 下午
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
//        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
//        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
//        System.out.println(findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
//        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(findMedianSortedArrays(new int[]{2}, new int[]{}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int num : nums1) {
            q1.add(num);
        }
        for (int num : nums2) {
            q2.add(num);
        }
        int[] mer = new int[total];
        for (int i = 0; i < total; i++) {
            if (q1.peek() == null) {
                mer[i] = q2.poll();
            } else if (q2.peek() == null) {
                mer[i] = q1.poll();
            } else if (q1.peek() > q2.peek()) {
                mer[i] = q2.poll();
            } else {
                mer[i] = q1.poll();
            }
        }

        boolean b = mer.length % 2 == 0;
        if (b) {
            int mi = mer.length / 2;
            return ((double) (mer[mi - 1] + mer[mi])) / 2;
        } else {
            return mer[mer.length / 2];
        }
    }
}
