package homework.lesson01;

import java.util.Stack;

/**
 * leetcode 150  逆波兰表达式求值
 * <p>
 * 根据 逆波兰表示法，求表达式的值。
 * <p>
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解题思路：
 * 1：从左至右扫描表达式
 * 2： 遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶的两个数，用运算符对它们做相应的计算（次顶元素op 栈顶元素 ），并将结果入栈
 *
 */
public class Solution_150 {

    public Long evalRPN(String[] tokens) {
        Stack<Long> stack =new Stack<>();
        for (String token : tokens) {
            if (token.equalsIgnoreCase("+") || token.equalsIgnoreCase("-")
                    || token.equalsIgnoreCase("*" ) || token.equalsIgnoreCase("/")){
                Long popB = stack.peek();
                stack.pop();
                Long popA = stack.peek();
                stack.pop();
                stack.push(calc(popA,popB,token));
            } else {
                stack.push(Long.parseLong(token));
            }
        }
        return stack.peek();
    }

    public Long calc(Long a,Long b,String op){
        if (op.equalsIgnoreCase("+")) return a + b;
        if (op.equalsIgnoreCase("-")) return a - b;
        if (op.equalsIgnoreCase("*")) return a * b;
        if (op.equalsIgnoreCase("/")) return a / b;
        return 0L;
    }



}
