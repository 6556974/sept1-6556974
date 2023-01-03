/**
 * 策略模式-------上下文类.
 */
package operation;

public class Context {
    /**
     * 用来确定上下文的变量
     */
    private final Operation operation;

    /**
     * 构造函数
     *
     * @param operation 关联上下文
     */
    public Context(Operation operation) {
        this.operation = operation;
    }

    /**
     * 调用Operation类定义的抽象类copeWithCommand();
     */
    public Object getResult() {
        return operation.copeWithCommand();
    }
}

