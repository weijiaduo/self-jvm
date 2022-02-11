package com.wjd.instructions.constants;

import com.wjd.instructions.base.Index8Instruction;
import com.wjd.rtda.Frame;
import com.wjd.rtda.OperandStack;
import com.wjd.rtda.heap.ConstantPool;
import com.wjd.rtda.heap.HeapObject;
import com.wjd.rtda.heap.StringPool;
import com.wjd.rtda.heap.cons.Constant;
import com.wjd.rtda.heap.cons.FloatConstant;
import com.wjd.rtda.heap.cons.IntegerConstant;
import com.wjd.rtda.heap.cons.StringConstant;

/**
 * @since 2022/2/2
 */
public class IDC extends Index8Instruction {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.getOperandStack();
        ConstantPool cp = frame.getMethod().getClazz().getConstantPool();
        Constant constant = cp.getConstant(index);
        if(constant instanceof IntegerConstant) {
            stack.pushInt(((IntegerConstant) constant).value());
        } else if (constant instanceof FloatConstant) {
            stack.pushFloat(((FloatConstant) constant).value());
        } else if (constant instanceof StringConstant) {
            String string = ((StringConstant) constant).value();
            HeapObject stringObj = StringPool.getJString(frame.getMethod().getClazz().getLoader(), string);
            stack.pushRef(stringObj);
        } else {
            System.out.println("Unsupported Type: " + constant);
        }
    }
}
