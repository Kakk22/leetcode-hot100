package com.cyf.hot.tree;

import java.beans.beancontext.BeanContext;

/**
 * @author 陈一锋
 * @date 2022/10/7 2:50 下午
 */
public class VerifyPostorder {
    public static void main(String[] args) {
//        int[] postorder = new int[]{1, 3, 2, 6, 5};
//        System.out.println(new VerifyPostorder().verifyPostorder(postorder));
//
//        int[] postorder_01 = new int[]{1,6,3,2,5};
//        System.out.println(new VerifyPostorder().verifyPostorder(postorder_01));
//
//        int[] postorder_02 = new int[]{1,2,5,10,6,9,4,3};
//        System.out.println(new VerifyPostorder().verifyPostorder(postorder_02));

        int[] postorder_03 = new int[]{4, 6, 7, 5};
        System.out.println(new VerifyPostorder().verifyPostorder(postorder_03));
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return false;
        }
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int rootVal = postorder[end];

        int index = end;
        for (int i = 0; i < end; i++) {
            if (postorder[i] > rootVal) {
                index = i;
                break;
            }
        }

        for (int i = index; i < end; i++) {
            if (postorder[i] < rootVal) {
                return false;
            }
        }
        return verifyPostorder(postorder, start, index - 1) && verifyPostorder(postorder, index, end - 1);

    }
}
