package interpreter.bytecode;

import interpreter.VirtualMachine;

/**
 *just commit
 */
public class ArgsCode extends ByteCode  {
    private int n;

    public void init(String[] args) {
        n = Integer.parseInt(args[1]);
    }

    public void execute(VirtualMachine vm) {
        vm.initStackFrame(n);
    }
}
