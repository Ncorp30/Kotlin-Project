package i_introduction._8_Smart_Casts;

import util.JavaCode;

public class JavaCode8 extends JavaCode {
    public int eval(Expr expr) {
        int result = 0;
        java.util.ArrayDeque<Expr> stack = new java.util.ArrayDeque<>();
        stack.push(expr);

        while (!stack.isEmpty()) {
            Expr current = stack.pop();
            if (current instanceof Num num) {
                result += num.getValue();
            } else if (current instanceof Sum sum) {
                stack.push(sum.getRight());
                stack.push(sum.getLeft());
            } else {
                throw new IllegalArgumentException("Unknown expression");
            }
        }

        return result;
    }
}