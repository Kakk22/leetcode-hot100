package com.cyf.hot.string;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**题目：20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * 
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例3：
 *
 * 输入：s = "(]"
 * 输出：false
 *
 * s = （{}）
 * 输出 true
 *
 * @author 陈一锋
 * @date 2022/11/17 9:51 下午
 */
public class IsValid {

    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("()"));
        System.out.println(new IsValid().isValid("()[]{}"));
        System.out.println(new IsValid().isValid("(]"));
    }

    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '('){
                deque.push(')');
            }else if (c == '['){
                deque.push(']');
            }else if (c == '{'){
                deque.push('}');
            }else if (deque.isEmpty() || deque.pop() != c){
                return false;
            }
        }
        return deque.isEmpty();
    }
}
