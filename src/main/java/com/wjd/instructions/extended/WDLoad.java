package com.wjd.instructions.extended;

import com.wjd.instructions.base.Index16Instruction;
import com.wjd.instructions.loads.LoadUtil;
import com.wjd.rtda.Frame;

/**
 * 把指定位置的本地变量推入栈顶
 *
 * @since 2021/12/1
 */
public class WDLoad extends Index16Instruction {

    @Override
    public void execute(Frame frame) {
        LoadUtil.dload(frame, index);
    }

}
