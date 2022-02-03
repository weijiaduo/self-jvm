package com.wjd.instructions.references;

import com.wjd.instructions.base.Index16Instruction;
import com.wjd.rtda.Frame;
import com.wjd.rtda.OperandStack;
import com.wjd.rtda.Slot;
import com.wjd.rtda.heap.Class;
import com.wjd.rtda.heap.ConstantPool;
import com.wjd.rtda.heap.cons.FieldRef;
import com.wjd.rtda.heap.member.Field;

/**
 * @since 2022/2/1
 */
public class GetStatic extends Index16Instruction {

    @Override
    public void execute(Frame frame) {
        ConstantPool cp = frame.getMethod().getClazz().getConstantPool();
        FieldRef fieldRef = (FieldRef) cp.getConstant(index);
        Field field = fieldRef.resolvedField();
        Class fieldClass = field.getClazz();
        if (!field.isStatic()) {
            throw new IncompatibleClassChangeError("putstatic field: " + field.getName());
        }

        String descriptor = field.getDescriptor();
        int slotId = field.getSlotId();
        Slot[] slots = fieldClass.getStaticVars();
        OperandStack stack = frame.getOperandStack();
        char d = descriptor.charAt(0);
        switch (d) {
            case 'Z':
            case 'B':
            case 'C':
            case 'S':
            case 'I':
                stack.pushInt(Slot.getInt(slots[slotId]));
                break;
            case 'F':
                stack.pushFloat(Slot.getFloat(slots[slotId]));
                break;
            case 'J':
                stack.pushLong(Slot.getLong(slots[slotId], slots[slotId + 1]));
                break;
            case 'D':
                stack.pushDouble(Slot.getDouble(slots[slotId], slots[slotId + 1]));
                break;
            case 'L':
            case '[':
                stack.pushRef(slots[slotId].getRef());
                break;
            default:
        }
    }
}
