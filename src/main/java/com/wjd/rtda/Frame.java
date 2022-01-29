package com.wjd.rtda;

/**
 * 栈帧
 */
public class Frame {

    /** 指向下一个栈帧 */
    private Frame lower;
    /** 所属线程 */
    Thread thread;
    /** 局部变量表 */
    private LocalVars localVars;
    /** 操作数栈 */
    private OperandStack operandStack;
    /** 下一条执行的指令索引 */
    private int nextPc;

    public Frame(Thread thread, int maxLocals, int maxStack) {
        this.thread = thread;
        localVars = new LocalVars(maxLocals);
        operandStack = new OperandStack(maxStack);
    }

    public Thread getThread() {
        return thread;
    }

    public Frame getLower() {
        return lower;
    }

    public void setLower(Frame lower) {
        this.lower = lower;
    }

    public LocalVars getLocalVars() {
        return localVars;
    }

    public OperandStack getOperandStack() {
        return operandStack;
    }

    public int getNextPc() {
        return nextPc;
    }

    public void setNextPc(int nextPc) {
        this.nextPc = nextPc;
    }

    @Override
    public String toString() {
        return "Frame{" +
                "localVars=" + localVars +
                ", operandStack=" + operandStack +
                ", nextPc=" + nextPc +
                '}';
    }
}
