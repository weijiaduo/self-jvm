package com.wjd.instructions.constants;

import com.wjd.rtda.stack.Frame;

/**
 * 把 int -1 推入栈顶
 *
 * @since 2021/12/1
 */
public class IConstM1 extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        frame.getOpStack().pushInt(-1);
    }

}
