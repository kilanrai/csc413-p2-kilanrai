package interpreter.bytecode;
import interpreter.VirtualMachine;

public class ArgsCode extends ByteCode  {//just for commit
    private int n;
    public void init(String[] args) {
        n = Integer.parseInt(args[1]);
    }
    public void execute(VirtualMachine vm) {
        vm.initStackFrame(n);
    }
}

