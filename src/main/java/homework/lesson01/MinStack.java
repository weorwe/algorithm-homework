package homework.lesson01;

import java.util.Stack;

/**
 * leetcode 155 最新栈
 * <p>
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 解题思路：使用双栈实现，一个栈存储数据，另一个是存储最小值。先进行比较后存储最小值stack中
 * <p>
 * | 5 | 3 | 1 | 4 | 2 |
 * | 5 | 3 | 1 | 1 | 1 |
 * <p>
 * 细节事项：
 * 1：双栈必须保持一直
 * 2：null stack 和 异常stack
 */
public class MinStack<T extends Comparable<T>> {

    private Stack<T> stack = new Stack<>();

    private Stack<T> minStack = new Stack<>();


    public void push(T t) {
        T pushT = t;
        if (!minStack.isEmpty()) {
            pushT =t.compareTo(minStack.peek())< 0? t:minStack.peek();
        }
        minStack.push(pushT);
        stack.push(t);
    }

    public T pop() {
        T pop = stack.pop();
        minStack.pop();
        return pop;
    }

    public T top() {
        T peek = stack.peek();
        return peek;
    }

    public T getMin() {
        return minStack.peek();
    }


    public int getSize() {
        return stack.size();
    }

    public int getMinSize() {
        return minStack.size();
    }

    /**
     * 代码测试
     *
     * @param args
     */
    public static void main(String[] args) {
        MinStack<Integer> integerMinStack = new MinStack<>();
        integerMinStack.push(5);
        integerMinStack.push(3);
        integerMinStack.push(1);
        integerMinStack.push(4);
        integerMinStack.push(2);

        Integer min = integerMinStack.getMin();
        System.out.println(min);
        Integer pop = integerMinStack.pop();

        while (pop != null) {
            if (integerMinStack.getSize() > 0) {
                min = integerMinStack.getMin();
                System.out.println(min);
                pop = integerMinStack.pop();
            } else {
                break;
            }
        }
    }
}
