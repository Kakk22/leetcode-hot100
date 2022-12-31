package com.cyf.hot.math;

/**
 * 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：false
 *
 * @author 陈一锋
 * @date 2022/12/31 1:15 下午
 */
public class IsHappy {

    public static void main(String[] args) {
        System.out.println(new IsHappy().isHappy(2));
        System.out.println(new IsHappy().isHappy(19));
    }

    public boolean isHappy(int n) {
        int count = 0;
        while (n != 1) {
            n = sumEach(n);
            count++;
            if (count > 20) {
                return false;
            }
        }
        return true;
    }

    private int sumEach(int n) {
        int sum = 0;
        while (n != 0) {
            sum += Math.pow((n % 10), 2);
            n /= 10;
        }
        return sum;
    }
}
