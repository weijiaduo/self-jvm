package com.wjd.instructions.stores;

import com.wjd.instructions.constants.NoOperandsInstruction;
import com.wjd.rtda.stack.Frame;
import com.wjd.rtda.heap.HeapObject;

/**
 * 按索引给数组元素赋值
 *
 * @since 2021/12/1
 */
public class CAStore extends NoOperandsInstruction {

    @Override
    public void execute(Frame frame) {
        int val = frame.getOperandStack().popInt();
        int index = frame.getOperandStack().popInt();
        HeapObject arrayObject = frame.getOperandStack().popRef();
        if (arrayObject == null) {
            throw new NullPointerException("CAStore");
        }
        if (index < 0 || index > arrayObject.getArrayLength()) {
            throw new ArrayIndexOutOfBoundsException("CAStore");
        }
        arrayObject.getChars()[index] = (char) val;
    }

}
