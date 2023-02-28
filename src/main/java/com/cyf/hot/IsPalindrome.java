package com.cyf.hot;

/**
 * @author 陈一锋
 * @date 2022/11/15 10:04 下午
 */
public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome bean = new IsPalindrome();
        System.out.println(bean.isPalindrome(-123));
        System.out.println(bean.isPalindrome(123));
        System.out.println(bean.isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        int ans = 0;
        int cur = x;
        while(cur > 0){
            ans = ans * 10 + cur % 10;
            cur = cur / 10;
        }

        return ans == x;
    }
}
