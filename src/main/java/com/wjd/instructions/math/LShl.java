package com.wjd.instructions.math;

import com.wjd.instructions.constants.NoOperandsInstruction;
import com.wjd.rtda.stack.Frame;

/**
 * 左移
 * @since 2021/12/5
 */
public class LShl extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        // 注意位移操作数是一个int类型的
        int val1 = frame.getOpStack().popInt();
        long val2 = frame.getOpStack().popLong();
        long val = val2 << (val1 & 0x3f);
        frame.getOpStack().pushLong(val);
    }
}
